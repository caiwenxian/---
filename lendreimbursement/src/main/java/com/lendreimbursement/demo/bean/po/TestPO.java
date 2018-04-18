package com.lendreimbursement.demo.bean.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @Author: [caiwenxian]
 * @Date: [2018-03-30 14:44]
 * @Description: [ ]
 * @Version: [1.0.0]
 */

@Entity()
@Table(name = "lendreimbursement_test")
public class TestPO extends BasePO{

    @Column(name = "name")
    private String name;

    public TestPO() {
    }

    public TestPO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
