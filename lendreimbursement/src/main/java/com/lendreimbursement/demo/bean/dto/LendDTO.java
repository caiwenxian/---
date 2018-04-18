package com.lendreimbursement.demo.bean.dto;

import javax.validation.constraints.NotEmpty;

/**
 * @Author: [caiwenxian]
 * @Date: [2018-04-02 09:26]
 * @Description: [ ]
 * @Version: [1.0.0]
 */
public class LendDTO extends BaseDTO{


    /** 进度状态（‘待审核’、‘待分析’...） */
    private String nowProgress;

    public String getNowProgress() {
        return nowProgress;
    }

    public void setNowProgress(String nowProgress) {
        this.nowProgress = nowProgress;
    }
}
