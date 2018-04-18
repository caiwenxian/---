package com.lendreimbursement.demo.exception;

/**
 * 业务检测异常
 *
 * @Author: [liguiqin]
 * @Date: [2016-11-23 15:47]
 * @Description: []
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
public class SerException extends Exception {

    private static final long serialVersionUID = 6229315095728639413L;

    public static final String NOT_FOUND = "实体不存在";

    public static final String PARAMS_MISS = "参数丢失";

    public SerException() {
        super();
    }

    public SerException(String message) {
        super(message);
    }
}
