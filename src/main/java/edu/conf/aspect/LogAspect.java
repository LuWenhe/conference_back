package edu.conf.aspect;

import cn.hutool.core.util.IdUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import edu.conf.annotation.LogAnnotation;
import edu.conf.dto.RequestLogDTO;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Component
@Aspect
public class LogAspect {

    @Resource
    private HttpServletRequest request;

    private final String REQUEST_ID_KEY = "request_unique_id";

    // 定义切点, 注解加在哪里哪里就是切点
    @Pointcut("@annotation(edu.conf.annotation.LogAnnotation)")
    public void declarePointCut() {}

    // 前置通知
    @Before("declarePointCut()")
    public void doBeforeAdvice(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        printRequestLog(methodSignature, joinPoint.getArgs());
    }

    // 异常通知
    @AfterThrowing(value = "declarePointCut()", throwing = "ex")
    public void doAfterThrowingAdvice(Throwable ex) {
        printExceptionLog(ex);
    }

    // 记录日志的方法
    private void saveLog(ProceedingJoinPoint joinPoint, long time) {
        //获取连接点的方法签名对象
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        // 得到注解类
        LogAnnotation logAnnotation = method.getAnnotation(LogAnnotation.class);
        // 得到操作名称
        log.info("operator:{}", logAnnotation.operator());

        // 获取类名和方法名
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        log.info("request method:{}", className + "." + methodName);

        // 获取请求的参数
        Object[] args = joinPoint.getArgs();

        String params = JSON.toJSONString(args[0]);
        log.info("params:{}", params);

        // 获取request设置的ip地址
//        log.info("ip:{}", IPUtils.getIpAddr(request));
        log.info("execute time:{} ms", time);
    }

    // 打印请求日志
    public void printRequestLog(MethodSignature methodSignature, Object[] argObs) {
        Method method = methodSignature.getMethod();
        // 得到注解类
        LogAnnotation logAnnotation = method.getAnnotation(LogAnnotation.class);
        RequestLogDTO logVo = new RequestLogDTO();

        // 设置请求唯一ID
        logVo.setId(IdUtil.fastUUID());
        request.setAttribute(REQUEST_ID_KEY, logVo.getId());

        logVo.setOperator(logAnnotation.operator());
        logVo.setUri(request.getRequestURI());
        logVo.setName(request.getMethod());
        List<Object> args = Lists.newArrayList();

        // 过滤掉一些不能转为json字符串的参数
        Arrays.stream(argObs).forEach(e -> {
            if (e instanceof MultipartFile || e instanceof HttpServletRequest
                    || e instanceof HttpServletResponse || e instanceof BindingResult) {
                return;
            }

            args.add(e);
        });

        logVo.setArgs(args.toArray());
        logVo.setPath(methodSignature.getDeclaringTypeName() + "." + method.getName());
        logVo.setReferer(request.getHeader("referer"));
        logVo.setRemoteAddr(request.getRemoteAddr());
        logVo.setUserAgent(request.getHeader("user-agent"));

        log.info(JSON.toJSONString(logVo));
    }

    // 打印异常日志
    public void printExceptionLog(Throwable ex) {
        JSONObject logVo = new JSONObject();
        logVo.put("id", request.getAttribute(REQUEST_ID_KEY));
        log.error(JSON.toJSONString(logVo), ex);
    }

}
