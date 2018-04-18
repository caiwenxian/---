package com.lendreimbursement.demo.service.impl;

import com.lendreimbursement.demo.bean.dto.ReimbursementDTO;
import com.lendreimbursement.demo.bean.po.ReimbursementPO;
import com.lendreimbursement.demo.bean.vo.PageVO;
import com.lendreimbursement.demo.dao.IReimbursementDao;
import com.lendreimbursement.demo.exception.SerException;
import com.lendreimbursement.demo.service.IReimbursementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: [caiwenxian]
 * @Date: [2018-04-02 15:13]
 * @Description: [ ]
 * @Version: [1.0.0]
 */

@Service
public class ReimbursementServiceImpl implements IReimbursementService {

    @Autowired
    IReimbursementDao reimbursementDao;
    private EntityManager entityManager;

    @Transactional(rollbackFor = {SerException.class})
    @Override
    public void saveReimbursement(ReimbursementPO po) throws IOException, SerException {
        po.setNowProgress("待审核");
        reimbursementDao.save(po);
    }

    @Override
    public PageVO listReimbursement(ReimbursementDTO dto) {
        Pageable pageable = new PageRequest(dto.getPage(), dto.getLimit());
        Specification<ReimbursementPO> spec = new Specification<ReimbursementPO>() {
            @Override
            public Predicate toPredicate(Root<ReimbursementPO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                if ("待分析".equals(dto.getNowProgress())) {
                    Path<String> name = root.get("needAnalysis");
                    Predicate p = cb.equal(name, false);
                    return p;
                }
                Path<String> name = root.get("nowProgress");
                Predicate p = cb.equal(name, dto.getNowProgress());
                return p;
            }
        };

        Page<ReimbursementPO> page = reimbursementDao.findAll(spec, pageable);
        return new PageVO(page.getContent(), page.getTotalElements());
    }

    @Transactional(rollbackFor = {SerException.class})
    @Override
    public void updateReimbursement(ReimbursementPO reimbursement, String type) throws IOException, SerException {

        ReimbursementPO po = reimbursementDao.getOne(reimbursement.getId());
        if (po == null) {
            throw new SerException(SerException.NOT_FOUND);
        }

        int i = 0;
        if (reimbursement.getReimbursementAuditing() != null) {
            i = reimbursement.getReimbursementAuditing().size() - 1;
        }
        if ("审核".equals(type)) {
            if (reimbursement.getReimbursementAuditing().get(i).isPass()) {
                reimbursement.setNowProgress("待核对");
            } else {
                reimbursement.setLastProgress("待核对");
                reimbursement.setNowProgress("有误记录");
            }
        } else if ("分析".equals(type)) {

        } else if ("核对".equals(type)) {
            System.out.println("核对if----" + reimbursement);
            if (reimbursement.getReimbursementAuditing().get(i).isPass()) {
                reimbursement.setLastProgress(reimbursement.getNowProgress());
                reimbursement.setNowProgress("待付款");
            } else {
                reimbursement.setLastProgress(reimbursement.getNowProgress());
                reimbursement.setNowProgress("有误记录");
            }

        } else if ("付款".equals(type)) {
            if (reimbursement.getReimbursementAuditing().get(i).isPass()) {
                reimbursement.setLastProgress(reimbursement.getNowProgress());
                reimbursement.setNowProgress("已完成");
            } else {
                reimbursement.setLastProgress(reimbursement.getNowProgress());
                reimbursement.setNowProgress("有误记录");
            }
        } else if ("已完成".equals(type)) {

        } else if ("有误记录".equals(type)) {
            reimbursement.setNowProgress(reimbursement.getLastProgress());
        }

        reimbursementDao.save(reimbursement);

    }

    @Transactional(rollbackFor = {SerException.class})
    @Override
    public void deleteReimbursement(String id) throws SerException {
        try {
            reimbursementDao.deleteById(id);
        } catch (Exception e) {
            throw new SerException(SerException.NOT_FOUND);
        }

    }

    @Transactional(rollbackFor = {SerException.class})
    @Override
    public void deleteReimbursement(String[] ids) throws SerException {
        if (ids == null || ids.length < 1) {
            throw new SerException(SerException.PARAMS_MISS);
        }
        List<ReimbursementPO> pos = new ArrayList<>();
        for (String id : ids) {
            ReimbursementPO po = new ReimbursementPO();
            po.setId(id);
            pos.add(po);
        }
        reimbursementDao.deleteInBatch(pos);
    }

    @Override
    public ReimbursementPO getReimbursementById(String id) throws SerException {

        return reimbursementDao.getOne(id);
    }
}
