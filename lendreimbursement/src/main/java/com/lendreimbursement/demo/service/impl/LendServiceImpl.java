package com.lendreimbursement.demo.service.impl;

import com.lendreimbursement.demo.bean.dto.LendAnalysisDTO;
import com.lendreimbursement.demo.bean.dto.LendDTO;
import com.lendreimbursement.demo.bean.po.AuditingPO;
import com.lendreimbursement.demo.bean.po.LendPO;
import com.lendreimbursement.demo.bean.vo.PageVO;
import com.lendreimbursement.demo.dao.ILendDao;
import com.lendreimbursement.demo.exception.SerException;
import com.lendreimbursement.demo.service.ILendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @Author: [caiwenxian]
 * @Date: [2018-04-02 09:39]
 * @Description: [ ]
 * @Version: [1.0.0]
 */

@Service
public class LendServiceImpl implements ILendService{

    @Autowired
    ILendDao lendDao;
    private EntityManager entityManager;

    @Override
    public LendPO getLend(String id) throws SerException {

        Optional<LendPO> po = lendDao.findById(id);
        if (po == null) {
            throw new SerException(SerException.NOT_FOUND);
        }
        return po.get();
    }

    @Override
    public PageVO<LendPO> listLend(LendDTO dto) {
        Pageable pageable = new PageRequest(dto.getPage() , dto.getLimit());
        Specification<LendPO> spec = new Specification<LendPO>() {
            @Override
            public Predicate toPredicate(Root<LendPO> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                if ("待分析".equals(dto.getNowProgress())) {
                    Path<String> name = root.get("needAnalysis");
                    Predicate p = cb.equal(name, true);
                    return p;
                }
                Path<String> name = root.get("nowProgress");
                Predicate p = cb.equal(name, dto.getNowProgress());
                return p;
            }
        };

        Page<LendPO> page = lendDao.findAll(spec, pageable);
        return new PageVO(page.getContent(), page.getTotalElements());
    }

    @Transactional(rollbackFor = {SerException.class})
    @Override
    public void saveLend(LendPO po) throws SerException {
        po.setFillTime(LocalDate.now().toString());
        po.setNeedAnalysis(true);
        po.setNowProgress("待审核");
        lendDao.save(po);

//        throw new SerException("error");
    }

    @Transactional(rollbackFor = {SerException.class})
    @Override
    public void updateLend(LendPO po, String type) throws IOException, SerException {

        LendPO entity = lendDao.findById(po.getId()).get();
        if (entity == null) {
            throw new SerException(SerException.NOT_FOUND);
        }

        /*if ("审核".equals(type)) {
            int i = po.getAuditings().size();
            AuditingPO auditing = po.getAuditings().get(i - 1);
            if (auditing != null) {
                po.getAuditings().get(i - 1).setTime(LocalDate.now().toString());
            }
            if (entity.getAuditings().size() > 0) { //更新audit
                for (AuditingPO auditingPO : entity.getAuditings()) {
                    if (auditingPO.getId().equals(auditing.getId())) {
                        auditingPO.setTime(LocalDate.now().toString());
                        if (auditing.getOpinion() != null) {
                            auditingPO.setOpinion(auditing.getOpinion());
                        }
                            auditingPO.setPass(auditing.getPass());
                    }
                }
            } else {//新增audit
                entity.setAuditings(po.getAuditings());
            }

//            auditing.setAuditor(po.getUser());
            if (auditing.getPass()) {
                entity.setLastProgress(po.getNowProgress());
                entity.setNowProgress("待付款");
            } else {
                entity.setLastProgress(po.getNowProgress());
                entity.setNowProgress("有误记录");
            }

        } else if ("付款".equals(type)) {
            entity.setLastProgress(po.getNowProgress());
            entity.setNowProgress("待确认");
        } else if ("确认收款".equals(type)) {
            entity.setLastProgress(po.getNowProgress());
            entity.setNowProgress("待还款");
        } else if ("还款".equals(type)) {
            entity.setLastProgress(po.getNowProgress());
            entity.setNowProgress("待核对");
        } else if ("核对".equals(type)) {
            entity.setLastProgress(po.getNowProgress());
            entity.setNowProgress("已完成");
        } else if ("待审核".equals(type)) {
            entity.setNowProgress("已完成");
        } else if ("待分析".equals(type)) {
            entity.setNeedAnalysis(false);

        } else if ("有误编辑".equals(type)) {
            entity.setNowProgress(po.getLastProgress());
        }*/
//        entityManager.merge(po);
        if ("审核".equals(type)) {
            int i = po.getAuditings().size();
            AuditingPO auditing = po.getAuditings().get(i - 1);
            auditing.setTime(LocalDate.now().toString());
            auditing.setAuditor(po.getUser());
            if (auditing.getPass()) {
                po.setLastProgress(po.getNowProgress());
                po.setNowProgress("待付款");
            } else {
                po.setLastProgress(po.getNowProgress());
                po.setNowProgress("有误记录");
            }

        } else if ("付款".equals(type)) {
            po.setLastProgress(po.getNowProgress());
            po.setNowProgress("待确认");
        } else if ("确认收款".equals(type)) {
            po.setLastProgress(po.getNowProgress());
            po.setNowProgress("待还款");
        } else if ("还款".equals(type)) {
            po.setLastProgress(po.getNowProgress());
            po.setNowProgress("待核对");
        } else if ("核对".equals(type)) {
            int i = po.getAuditings().size();
            AuditingPO auditing = po.getAuditings().get(i - 1);
            auditing.setTime(LocalDate.now().toString());
            auditing.setAuditor(po.getUser());
            if (auditing.getPass()) {
                po.setLastProgress(po.getNowProgress());
                po.setNowProgress("已完成");
            } else {
                po.setLastProgress(po.getNowProgress());
                po.setNowProgress("有误记录");
            }

        } else if ("待审核".equals(type)) {
            po.setNowProgress("已完成");
        } else if ("待分析".equals(type)) {
            po.setNeedAnalysis(false);

        } else if ("有误编辑".equals(type)) {
            po.setNowProgress(po.getLastProgress());
        }
        lendDao.save(po);
    }

    @Transactional(rollbackFor = {SerException.class})
    @Override
    public void updateLend(LendPO po) throws IOException, SerException {
        LendPO entity = lendDao.findById(po.getId()).get();
        if (entity == null) {
            throw new SerException(SerException.NOT_FOUND);
        }
        entity.setEstimateTime(po.getEstimateTime());
        entity.setBorrower(po.getBorrower());
        entity.setCharge(po.getCharge());
        entity.setParticipants(po.getParticipants());
        entity.setArea(po.getArea());
        entity.setProject(po.getProject());
        entity.setProjectName(po.getProjectName());
        entity.setWayOfBorrowing(po.getWayOfBorrowing());
        entity.setClassA(po.getClassA());
        entity.setClassB(po.getClassB());
        entity.setClassC(po.getClassC());
        entity.setWriteUp(po.isWriteUp());
        entity.setReason(po.getReason());
        entity.setMoney(po.getMoney());
        entity.setInvoice(po.isInvoice());
        entity.setNoInvoice(po.getNoInvoice());
        entity.setReadyMoney(po.isReadyMoney());
        entity.setLink(po.getLink());
        entity.setRemarks(po.getRemarks());

        lendDao.save(entity);
    }

    @Transactional(rollbackFor = {SerException.class})
    @Override
    public void deleteLend(String id) throws SerException {
        lendDao.deleteById(id);
    }


    @Transactional(rollbackFor = {SerException.class})
    @Override
    public void deleteLend(String[] ids) throws SerException {
        if (ids == null || ids.length < 1) {
            throw new SerException(SerException.PARAMS_MISS);
        }
        List<LendPO> pos = new ArrayList<>();
        for (String id : ids) {
            LendPO po = new LendPO();
            po.setId(id);
            pos.add(po);
        }
        lendDao.deleteInBatch(pos);
    }

    @Override
    public PageVO<LendPO> getAnalysisLend(LendAnalysisDTO dto) {
        return null;
    }
}
