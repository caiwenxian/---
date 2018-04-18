package com.lendreimbursement.demo.controller;

import com.lendreimbursement.demo.bean.po.TestPO;
import com.lendreimbursement.demo.bean.common.ActResult;
import com.lendreimbursement.demo.bean.common.Result;
import com.lendreimbursement.demo.exception.ActException;
import com.lendreimbursement.demo.exception.SerException;
import com.lendreimbursement.demo.service.ITestService;
import com.lendreimbursement.demo.service.redis.RedisService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: [caiwenxian]
 * @Date: [2018-03-30 14:55]
 * @Description: [ ]
 * @Version: [1.0.0]
 */

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private ITestService testService;

    @GetMapping("")
    public Result test() throws ActException {
        try {
            testService.add(new TestPO("zhangsan"));
        } catch (SerException e) {
            e.printStackTrace();
        }
        return new ActResult("success");
    }

    @Autowired
    RedisService redisService;

    @GetMapping("/redis")
    public void reids() {
        redisService.set("key", "value");
        System.out.println(redisService.get("key"));
    }

    @GetMapping("/userRedis")
    public Result userRedis() throws SerException {
        List list = testService.get();


        return ActResult.initialize(list);
    }

    @GetMapping("/delete/{id}")
    public Result delete(@PathVariable String id) throws SerException {
        testService.delete(id);
        return ActResult.initialize(null);
    }
}
