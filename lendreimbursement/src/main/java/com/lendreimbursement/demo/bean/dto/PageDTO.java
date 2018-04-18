package com.lendreimbursement.demo.bean.dto;

import java.io.Serializable;

/**
 * @Author: [caiwenxian]
 * @Date: [2018-03-30 16:47]
 * @Description: [ ]
 * @Version: [1.0.0]
 */
public abstract class PageDTO implements Serializable {
    /**
     * 每显示数量
     */
    protected Integer limit = 10;
    /**
     * 当前页
     */
    protected Integer page = 1;

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getPage() {
        return (this.page - 1) >= 0 ? (this.page - 1) : 0;
    }

    public void setPage(Integer page) {
        this.page = page;
    }
}
