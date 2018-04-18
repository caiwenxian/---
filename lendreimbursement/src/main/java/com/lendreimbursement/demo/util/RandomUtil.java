package com.lendreimbursement.demo.util;

import java.util.UUID;

/**
 * @Author: [caiwenxian]
 * @Date: [2018-03-30 15:58]
 * @Description: [ ]
 * @Version: [1.0.0]
 */
public class RandomUtil {

    public static String randomId() {
        return System.currentTimeMillis() + UUID.randomUUID().toString();
    }
}
