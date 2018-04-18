package com.lendreimbursement.demo.service.impl;

import com.lendreimbursement.demo.bean.po.TestPO;
import com.lendreimbursement.demo.dao.ITestDao;
import com.lendreimbursement.demo.exception.SerException;
import com.lendreimbursement.demo.service.ITestService;
import com.lendreimbursement.demo.util.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.List;

/**
 * @Author: [caiwenxian]
 * @Date: [2018-03-30 14:50]
 * @Description: [ ]
 * @Version: [1.0.0]
 */
//@CacheConfig(cacheNames = "testCache")
@Service("testServiceImpl")
public class TestServiceImpl implements ITestService {

    @Autowired
    ITestDao testDao;


    @Override
    @CacheEvict(value = "test")
    public void add(TestPO po) throws SerException {
        po.setId(RandomUtil.randomId());
        testDao.save(po);


    }

    @Override
    @CacheEvict(value = "test")
    public void delete(String id) throws SerException {
        testDao.deleteById(id);
    }

    @Override
    @Cacheable(value = "test")
    public List<TestPO> get() throws SerException {
        Pageable pageable = new PageRequest(0, 10); //page从0开始
        Specification<TestPO> spec = new Specification<TestPO>() {
            @Override
            public Predicate toPredicate(Root<TestPO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                Path<String> name = root.get("name");
                Predicate p = cb.like(name, "%" + "zhangsan" + "%");
//                Predicate p = cb.and(p1, p2);
                return p;
            }
        };

        Page<TestPO> page = testDao.findAll(spec, pageable);
        List<TestPO> list = page.getContent();
        return list;
    }
}
