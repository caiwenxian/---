package com.lendreimbursement.demo.service.impl;

import com.lendreimbursement.demo.dao.ILendCollectDao;
import com.lendreimbursement.demo.service.ILendCollectService;
import com.lendreimbursement.demo.service.ILendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: [caiwenxian]
 * @Date: [2018-04-03 16:31]
 * @Description: [ ]
 * @Version: [1.0.0]
 */

@Service
public class LendCollectServiceImpl implements ILendCollectService {

    @Autowired
    ILendCollectDao lendCollectDao;
}
