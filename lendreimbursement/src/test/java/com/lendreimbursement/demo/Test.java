package com.lendreimbursement.demo;

import com.lendreimbursement.demo.service.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: [caiwenxian]
 * @Date: [2018-04-07 10:26]
 * @Description: [ ]
 * @Version: [1.0.0]
 */
@Component
public class Test {

    RedisService redisService = new RedisService();

    @org.junit.Test
    public void reids() {
        redisService.set("key", "value");
        System.out.println(redisService.get("key"));
    }

}
