package com.lendreimbursement.demo.dao;

import com.lendreimbursement.demo.bean.po.ReimbursementPO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: [caiwenxian]
 * @Date: [2018-04-02 15:06]
 * @Description: [ ]
 * @Version: [1.0.0]
 */
public interface IReimbursementDao extends JpaRepository<ReimbursementPO, String> {

    Page<ReimbursementPO> findAll(Specification<ReimbursementPO> spec, Pageable pageable);

}
