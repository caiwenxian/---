package com.lendreimbursement.demo.dao;

import com.lendreimbursement.demo.bean.dto.BaseDTO;
import com.lendreimbursement.demo.bean.po.TestPO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @Author: [caiwenxian]
 * @Date: [2018-03-30 14:47]
 * @Description: [ ]
 * @Version: [1.0.0]
 */
public interface ITestDao extends JpaRepository<TestPO, String> {



    Page<TestPO> findAll(Specification<TestPO> spec, Pageable pageable);
//    List<TestPO> findAllByName

}
