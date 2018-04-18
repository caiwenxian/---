package com.lendreimbursement.demo.dao;

import com.lendreimbursement.demo.bean.po.LendPO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: [caiwenxian]
 * @Date: [2018-04-02 09:31]
 * @Description: [ ]
 * @Version: [1.0.0]
 */
public interface ILendDao extends JpaRepository<LendPO, String> {

    Page<LendPO> findAll(Specification<LendPO> spec, Pageable pageable);

    @Override
    List<LendPO> findAllById(Iterable<String> iterable);


}
