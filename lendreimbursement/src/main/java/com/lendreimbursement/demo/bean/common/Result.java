package com.lendreimbursement.demo.bean.common;

/**
 * @Author: [caiwenxian]
 * @Date: [2018-03-30 14:12]
 * @Description: [ ]
 * @Version: [1.0.0]
 */
public interface Result {

    /**
     * 消息码
     */
    int getCode();

    /**
     * 错误消息
     */
    String getMsg();

    /**
     * 返回数据
     */
    Object getData();
}
