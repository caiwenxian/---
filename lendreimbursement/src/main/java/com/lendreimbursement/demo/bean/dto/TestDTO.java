package com.lendreimbursement.demo.bean.dto;

/**
 * @Author: [caiwenxian]
 * @Date: [2018-03-30 16:46]
 * @Description: [ ]
 * @Version: [1.0.0]
 */
public class TestDTO extends BaseDTO{

    private String name;

    public TestDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
