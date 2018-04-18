package com.lendreimbursement.demo.dao;

import com.lendreimbursement.demo.bean.po.LendPO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: [caiwenxian]
 * @Date: [2018-04-03 16:31]
 * @Description: [ ]
 * @Version: [1.0.0]
 */
public interface ILendCollectDao extends JpaRepository<LendPO, String> {
}
