package edu.conf.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class RedisServiceTest {

    @Resource
    private RedisService redisService;

    @Test
    void testRedis() {
        boolean b = redisService.setString("home", "Hello World", 60*60);
        System.out.println(b);
    }

    @Test
    void getRedis() {
        Object obj = redisService.getValueByString("home");
        System.out.println(obj);
    }

}
