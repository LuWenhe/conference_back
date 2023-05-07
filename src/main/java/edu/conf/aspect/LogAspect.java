package edu.conf.aspect;

import com.alibaba.fastjson.JSON;
import edu.conf.annotation.LogAnnotation;
import edu.conf.utils.HttpContextUtils;
import edu.conf.utils.IPUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

@Slf4j
@Component
@Aspect
public class LogAspect {

    // 定义切点, 注解加在哪里哪里就是切点
    @Pointcut("@annotation(edu.conf.annotation.LogAnnotation)")
    public void declarePointCut() {}

    // 定义环绕通知
    @Around("declarePointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        long beginTime = System.currentTimeMillis();
        // 调用业务方法
        Object result = joinPoint.proceed();
        // 执行时长(毫秒)
        long time = System.currentTimeMillis() - beginTime;
        // 保存日志
        saveLog(joinPoint, time);
        return result;
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
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        log.info("ip:{}", IPUtils.getIpAddr(request));
        log.info("execute time:{} ms", time);
    }

}
