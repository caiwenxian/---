package com.lendreimbursement.demo.service;

import com.lendreimbursement.demo.bean.po.TestPO;
import com.lendreimbursement.demo.exception.SerException;

import java.util.List;

/**
 * @Author: [caiwenxian]
 * @Date: [2018-03-30 14:49]
 * @Description: [ ]
 * @Version: [1.0.0]
 */

public interface ITestService {

    void add(TestPO po) throws SerException;

    void delete(String id) throws SerException;

    List<TestPO> get() throws SerException;
}
