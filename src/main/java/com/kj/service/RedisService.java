package com.kj.service;

public interface RedisService {

    boolean setString(String key, Object value, long timeout);

    Object getValueByString(String key);

}
