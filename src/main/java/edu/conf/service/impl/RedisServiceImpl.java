package edu.conf.service.impl;

import edu.conf.service.RedisService;
import edu.conf.utils.RedisUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RedisServiceImpl implements RedisService {

    @Resource
    private RedisUtil redisUtil;

    @Override
    public boolean setString(String key, Object value, long timeout) {
        return redisUtil.set(key, value, timeout);
    }

    @Override
    public Object getValueByString(String key) {
        return redisUtil.get(key);
    }

}
