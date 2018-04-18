package com.lendreimbursement.demo.controller;

import com.lendreimbursement.demo.bean.common.ActResult;
import com.lendreimbursement.demo.bean.common.Result;
import com.lendreimbursement.demo.bean.dto.ReimbursementDTO;
import com.lendreimbursement.demo.bean.po.IdPO;
import com.lendreimbursement.demo.bean.po.ReimbursementAuditingPO;
import com.lendreimbursement.demo.bean.po.ReimbursementMailingPO;
import com.lendreimbursement.demo.bean.po.ReimbursementPO;
import com.lendreimbursement.demo.exception.SerException;
import com.lendreimbursement.demo.service.IReimbursementService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.POST;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: [caiwenxian]
 * @Date: [2018-04-02 15:24]
 * @Description: [ ]
 * @Version: [1.0.0]
 */

@RestController
@RequestMapping("/reimbursement")
public class ReimbursementController {

    @Autowired
    IReimbursementService reimbursementService;

    /**
     * 报销添加
     *
     * @param po
     * @return
     */
    @ApiOperation(value = "报销添加", notes = "")
    @PostMapping("/v1/saveOne")
    public Result reimbursementAdd( ReimbursementPO po) throws IOException, SerException {
        reimbursementService.saveReimbursement(po);
        return new ActResult("success");
    }

    /**
     * 根据id获取单个对象
     *
     * @param id
     * @return
     * @throws SerException
     */
    @ApiOperation(value = "根据id获取单个对象", notes = "")
    @GetMapping("/v1/getOneReimbursement/{id}")
    public Result getReimbursementById(@PathVariable String id) throws SerException {
        return new ActResult("success", reimbursementService.getReimbursementById(id));
    }

    /**
     * 报销删除
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "报销删除", notes = "")
    @DeleteMapping("/v1/deleteOne/{id}")
    public Result reimbursementAdd(@PathVariable String id) throws IOException, SerException {
        reimbursementService.deleteReimbursement(id);
        return new ActResult("success");
    }


    /**
     * 批量删除报销
     *
     * @param list
     * @return
     */
    @ApiOperation(value = "报销删除", notes = "")
    @PostMapping("/v1/deleteBatch")
    public Result reimbursementAdd(@RequestBody List<IdPO> list) throws IOException, SerException {
        String[] array = new String[list.size()];
        for (int i = 0; i < list.size(); i ++) {
            array[i] = list.get(i).getId();
        }
        reimbursementService.deleteReimbursement(array);
        return new ActResult("success");
    }

    /**
     * 编辑
     */
    @ApiOperation(value = "编辑", notes = "")
    @PutMapping("/v1/update")
    public Result update(@RequestBody ReimbursementPO po) throws IOException, SerException {
        reimbursementService.updateReimbursement(po, "");
        return new ActResult("success");
    }

    /**
     * 报销列表
     *
     * @param page
     * @return
     */
    @ApiOperation(value = "报销列表", notes = "")
    @GetMapping("/v1/reimbursement/{page}")
    public Result getReimbursementPage(@PathVariable Integer page) {
        ReimbursementDTO dto = new ReimbursementDTO();
        dto.setPage(page);
        dto.setNowProgress("待审核");
        return new ActResult("success", reimbursementService.listReimbursement(dto));
    }

    /**
     * 报销审核 审核
     *
     * @param po
     * @return
     */
    @ApiOperation(value = "报销审核 审核", notes = "")
    @PutMapping("/v1/examine")
    public Result examine(@RequestBody ReimbursementPO po) throws IOException, SerException {
        reimbursementService.updateReimbursement(po, "审核");
        return new ActResult("success");
    }

    /**
     * 报销编辑
     *
     * @param po
     * @return
     */
    @ApiOperation(value = "报销编辑", notes = "")
    @PutMapping("/v1/reimbursement")
    public Result reimbursementEdit(@RequestBody ReimbursementPO po) throws IOException, SerException {
        reimbursementService.updateReimbursement(po, "");
        return new ActResult("success");
    }

    /**
     * 待分析列表
     *
     * @param page
     * @return
     */
    @ApiOperation(value = "待分析列表", notes = "")
    @GetMapping("/v1/waitForAnalysis/{page}")
    public Result getWaitForAnalysis(@PathVariable Integer page) {
        ReimbursementDTO dto = new ReimbursementDTO();
        dto.setPage(page);
        dto.setNowProgress("待分析");
        return new ActResult("success", reimbursementService.listReimbursement(dto));
    }

    /**
     * 待核对列表
     *
     * @param page
     * @return
     */
    @ApiOperation(value = "待核对列表", notes = "")
    @GetMapping("/v1/waitForCheck/{page}")
    public Result getWaitForCheck(@PathVariable Integer page) {
        ReimbursementDTO dto = new ReimbursementDTO();
        dto.setPage(page);
        dto.setNowProgress("待核对");
        return new ActResult("success", reimbursementService.listReimbursement(dto));
    }

    /**
     * 待付款列表
     *
     * @param page
     * @return
     */
    @ApiOperation(value = "待付款列表", notes = "")
    @GetMapping("/v1/waitForPayment/{page}")
    public Result getWaitForPayment(@PathVariable Integer page) {
        ReimbursementDTO dto = new ReimbursementDTO();
        dto.setPage(page);
        dto.setNowProgress("待付款");
        return new ActResult("success", reimbursementService.listReimbursement(dto));
    }

    /**
     * 已完成列表
     *
     * @param page
     * @return
     */
    @ApiOperation(value = "已完成列表", notes = "")
    @GetMapping("/v1/completed/{page}")
    public Result getCompleted(@PathVariable Integer page) {
        ReimbursementDTO dto = new ReimbursementDTO();
        dto.setPage(page);
        dto.setNowProgress("已完成");
        return new ActResult("success", reimbursementService.listReimbursement(dto));
    }

    /**
     * 有误记录列表
     *
     * @param page
     * @return
     */
    @ApiOperation(value = "有误记录列表", notes = "")
    @GetMapping("/v1/errorRecord/{page}")
    public Result getErrorRecord(@PathVariable Integer page) {
        ReimbursementDTO dto = new ReimbursementDTO();
        dto.setPage(page);
        dto.setNowProgress("有误记录");
        return new ActResult("success", reimbursementService.listReimbursement(dto));
    }

    /**
     * 待核对 核对
     *
     * @param po
     * @return
     * @throws IOException
     * @throws SerException
     */
    @ApiOperation(value = "待核对 核对", notes = "")
    @PutMapping("/v1/waitForCheck")
    public Result waitForCheckEdit(@RequestBody ReimbursementPO po) throws IOException, SerException {
        reimbursementService.updateReimbursement(po, "核对");
        return new ActResult("success");
    }

    /**
     * 待付款 付款
     *
     * @param po
     * @return
     */
    @ApiOperation(value = "待付款 付款", notes = "")
    @PutMapping("/v1/waitForPayment")
    public Result waitForPaymentEdit(@RequestBody ReimbursementPO po) throws IOException, SerException {
        reimbursementService.updateReimbursement(po, "付款");
        return new ActResult("success");
    }

    /**
     * 寄件信息添加
     *
     * @param po
     * @return
     */
    @ApiOperation(value = "寄件信息添加", notes = "")
    @PutMapping("/v1/mailingInformation")
    public Result mailingInformation(@RequestBody ReimbursementPO po) throws IOException, SerException {
        /*ReimbursementPO reimbursementPO = new ReimbursementPO();
        reimbursementPO.setId(id);
        Set set = new HashSet<>();
        set.add(po);
        reimbursementPO.setReimbursementMailing(set);*/
        reimbursementService.updateReimbursement(po, "");
        return new ActResult("success");
    }

    /**
     * 有误记录 重新编辑
     */
    @ApiOperation(value = "有误记录 重新编辑", notes = "")
    @PutMapping("/v1/errorRecord")
    public Result errorRecord(@RequestBody ReimbursementPO po) throws IOException, SerException {
        reimbursementService.updateReimbursement(po, "有误记录");
        return new ActResult("success");
    }

    /**
     * 状态冻结
     *
     * @param po
     * @return
     */
    @ApiOperation(value = "状态冻结", notes = "")
    @PutMapping("/v1/status")
    public Result status(@RequestBody ReimbursementPO po) throws IOException, SerException {
        reimbursementService.updateReimbursement(po, "");
        return new ActResult("success");
    }

    /**
     * 待分析 分析
     * @param po
     * @return
     */
    @ApiOperation(value = "待分析 分析", notes = "")
    @PutMapping("/v1/waitForAnalysis")
    public Result waitForAnalysis(@RequestBody ReimbursementPO po) throws IOException, SerException {
        /*ReimbursementPO reimbursementPO = new ReimbursementPO();
        reimbursementPO.setId(id);
        List<ReimbursementAuditingPO> pos = new ArrayList<>();
        pos.add(po);
        reimbursementPO.setReimbursementAuditing(pos);*/
        reimbursementService.updateReimbursement(po, "分析");
        return new ActResult("success");
    }

}
