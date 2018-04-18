package com.lendreimbursement.demo.bean.enums;

/**
 * 汇总类型
 *
 * @Author: [caiwenxian]
 * @Date: [2018-04-03 16:26]
 * @Description: [ ]
 * @Version: [1.0.0]
 */
public enum CollectType {

    /**
     * 日汇总
     */
    DAY(1),

    /**
     * 周汇总
     */
    WEEK(2),

    /**
     * 月汇总
     */
    MONTH(3),

    /**
     * 季度汇总
     */
    QUART(4),

    /**
     * 年汇总
     */
    YEAR(5),

    /**
     * 累计汇总
     */
    ALL(6);

    private int value;

    CollectType(int value) {
        this.value = value;
    }
}
