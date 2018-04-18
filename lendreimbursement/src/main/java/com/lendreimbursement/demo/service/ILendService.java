package com.lendreimbursement.demo.service;

import com.lendreimbursement.demo.bean.dto.LendAnalysisDTO;
import com.lendreimbursement.demo.bean.dto.LendDTO;
import com.lendreimbursement.demo.bean.po.LendPO;
import com.lendreimbursement.demo.bean.vo.PageVO;
import com.lendreimbursement.demo.exception.SerException;

import java.io.IOException;

/**
 * 借款
 *
 * @Author: [caiwenxian]
 * @Date: [2018-04-02 09:32]
 * @Description: [ ]
 * @Version: [1.0.0]
 */
public interface ILendService {

    /**
     * 获取单个借款
     *
     * @param
     * @return class
     * @version v1
     */
    LendPO getLend(String id) throws SerException;

    /**
     * 获取借款列表
     *
     * @param
     * @return class
     * @version v1
     */
    PageVO listLend(LendDTO dto);

    /**
     * 保存单个借款
     *
     * @param
     * @return class
     * @version v1
     */
    void saveLend(LendPO po) throws SerException;

    /**
     * 更新单个借款(更新附加属性)
     *
     * @param
     * @return class
     * @version v1
     */
    void updateLend(LendPO po, String type) throws IOException, SerException;

    /**
     * 更新单个借款(不更新附加属性)
     *
     * @param
     * @return class
     * @version v1
     */
    void updateLend(LendPO po) throws IOException, SerException;

    /**
     * 删除单个借款
     *
     * @param
     * @return class
     * @version v1
     */
    void deleteLend(String id) throws SerException;

    /**
     * 批量删除借款
     *
     * @param
     * @return class
     * @version v1
     */
    void deleteLend(String[] ids) throws SerException;

    /**
     * 获取借款意见
     *
     * @param
     * @return class
     * @version v1
     */
    PageVO<LendPO> getAnalysisLend(LendAnalysisDTO dto);
}
