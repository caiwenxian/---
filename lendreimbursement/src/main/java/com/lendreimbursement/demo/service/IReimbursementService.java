package com.lendreimbursement.demo.service;

import com.lendreimbursement.demo.bean.dto.ReimbursementDTO;
import com.lendreimbursement.demo.bean.po.ReimbursementPO;
import com.lendreimbursement.demo.bean.vo.PageVO;
import com.lendreimbursement.demo.exception.SerException;

import java.io.IOException;

/**
 * 报销业务
 *
 * @Author: [caiwenxian]
 * @Date: [2018-04-02 15:12]
 * @Description: [ ]
 * @Version: [1.0.0]
 */
public interface IReimbursementService {

    /**
     * 保存单个
     *
     * @param
     * @return class
     * @version v1
     */
    void saveReimbursement(ReimbursementPO po) throws IOException, SerException;

    /**
     * 获取列表
     *
     * @param
     * @return class
     * @version v1
     */
    PageVO listReimbursement(ReimbursementDTO dto);

    /**
     * 更新单个
     *
     * @param
     * @return class
     * @version v1
     */
    void updateReimbursement(ReimbursementPO po, String type) throws IOException, SerException;

    /**
     * 删除单个
     *
     * @param
     * @return class
     * @version v1
     */
    void deleteReimbursement(String id) throws SerException;

    /**
     * 批量删除
     *
     * @param
     * @return class
     * @version v1
     */
    void deleteReimbursement(String[] ids) throws SerException;

    /**
     * 获取单个
     *
     * @param
     * @return class
     * @version v1
     */
    ReimbursementPO getReimbursementById(String id) throws SerException;
}
