package com.lendreimbursement.demo.controller;

import com.lendreimbursement.demo.bean.common.ActResult;
import com.lendreimbursement.demo.bean.common.Result;
import com.lendreimbursement.demo.bean.dto.LendDTO;
import com.lendreimbursement.demo.bean.po.AuditingPO;
import com.lendreimbursement.demo.bean.po.IdPO;
import com.lendreimbursement.demo.bean.po.LendPO;
import com.lendreimbursement.demo.bean.po.MailingPO;
import com.lendreimbursement.demo.bean.vo.PageVO;
import com.lendreimbursement.demo.exception.ActException;
import com.lendreimbursement.demo.exception.SerException;
import com.lendreimbursement.demo.service.ILendService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 借款管理
 *
 * @Author: [caiwenxian]
 * @Date: [2018-03-30 14:07]
 * @Description: [ ]
 * @Version: [1.0.0]
 */

@RestController
@RequestMapping("/lend")
@CrossOrigin
public class LendController {


    @Autowired
    private ILendService lendService;

    /**
     * 根据id获取单个对象
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "根据id获取单个对象", notes = "")
    @GetMapping("/v1/getOne/{id}")
    public Result getLend(@PathVariable String id) throws ActException {
        try {
            LendPO po = lendService.getLend(id);
            return new ActResult("success", po);
        } catch (Exception e) {
            throw new ActException(e.getMessage());
        }

    }

    /**
     * 保存单个对象
     *
     * @param po
     * @return
     */
    @ApiOperation(value = "保存单个对象", notes = "")
    @PostMapping("/v1/saveOne")
    public Result saveLend(@RequestBody LendPO po) throws SerException {
        lendService.saveLend(po);
        return new ActResult("success");
    }

    /**
     * 删除单个对象
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "删除单个对象", notes = "")
    @DeleteMapping("/v1/deleteOne/{id}")
    public Result deleteOne(@PathVariable String id) throws SerException {
        lendService.deleteLend(id);
        return new ActResult("success");
    }

    /**
     * 批量删除
     *
     * @param list
     * @return
     */
    @ApiOperation(value = "批量删除", notes = "")
    @PostMapping("/v1/deleteBatch")
    public Result deleteBatch(@RequestBody List<IdPO> list) throws SerException {
        String[] array = new String[list.size()];
        for (int i = 0; i < list.size(); i ++) {
            array[i] = list.get(i).getId();
        }
        lendService.deleteLend(array);
        return new ActResult("success");
    }

    /**
     * 编辑
     *
     * @param po
     * @return
     * @throws ActException
     */
    @ApiOperation(value = "编辑", notes = "")
    @PutMapping("/v1/update")
    public Result update(@RequestBody LendPO po) throws IOException, SerException {
        lendService.updateLend(po, "");
        return new ActResult("success");
    }

    /**
     * 待审核列表
     *
     * @param
     * @return class
     * @version v1
     */
    @ApiOperation(value = "获取待审核列表", notes = "")
    @GetMapping("/v1/waitAudit/{page}")
    public Result listAuditLend(@PathVariable Integer page) throws ActException {
        LendDTO dto = new LendDTO();
        dto.setPage(page);
        dto.setNowProgress("待审核");
        PageVO pageVO = lendService.listLend(dto);
        return ActResult.initialize(pageVO);
    }

    /**
     * 待审核 审核
     *
     * @param po
     * @return
     */
    @ApiOperation(value = "待审核 审核", notes = "")
    @PutMapping("/v1/waitAuditedExamine")
    public Result waitAuditedExamine(@RequestBody LendPO po) throws IOException, SerException {
        /*LendPO lendPO = new LendPO();
        lendPO.setId(id);
        List audit = new ArrayList();
        audit.add(po);
        lendPO.setAuditings(audit);*/
        lendService.updateLend(po, "审核");
        return new ActResult();
    }

    /**
     * 待分析列表
     *
     * @param page
     * @return
     */
    @ApiOperation(value = "待分析列表", notes = "")
    @GetMapping("/v1/waitAnalysis/{page}")
    public Result waitAnalysis(@PathVariable Integer page) {
        LendDTO dto = new LendDTO();
        dto.setPage(page);
        dto.setNowProgress("待分析");
        return new ActResult("success", lendService.listLend(dto));
    }

    /**
     * 待分析 分析
     *
     * @param po
     * @return
     * @throws IOException
     * @throws SerException
     */
    @ApiOperation(value = "待分析 分析", notes = "")
//    @ApiImplicitParam(name = "AuditingPO", value = "待分析 分析", required = true, dataType = "AuditingPO")
    @PutMapping("/v1/waitAnalysis")
    public Result waitForAnalysis(@RequestBody LendPO po) throws IOException, SerException {
        /*LendPO lendPO = new LendPO();
        lendPO.setId(id);
        List audit = new ArrayList();
        audit.add(po);
        lendPO.setAuditings(audit);*/
        lendService.updateLend(po, "待分析");
        return new ActResult("success");
    }

    /**
     * 待付款列表
     *
     * @param page
     * @return
     */
    @ApiOperation(value = "待付款列表", notes = "")
    @GetMapping("/v1/waitPayment/{page}")
    public Result waitForPayment(@PathVariable Integer page) {

        LendDTO dto = new LendDTO();
        dto.setPage(page);
        dto.setNowProgress("待付款");
        return new ActResult("success", lendService.listLend(dto));
    }

    /**
     * 待付款 付款
     *
     * @param po
     * @return
     */
    @ApiOperation(value = "待付款 付款", notes = "")
//    @ApiImplicitParam(name = "LendPO", value = "待付款 付款", required = true, dataType = "LendPO")
    @PutMapping("/v1/waitPaymentEdit")
    public Result waitForPaymentEdit(@RequestBody LendPO po) throws IOException, SerException {

        lendService.updateLend(po, "付款");
        return new ActResult("success");
    }

    /**
     * 待确认列表
     *
     * @param page
     * @return
     */
    @ApiOperation(value = "待确认列表", notes = "")
    @GetMapping("/v1/waitConfirm/{page}")
    public Result waitConfirm(@PathVariable Integer page) {
        LendDTO dto = new LendDTO();
        dto.setPage(page);
        dto.setNowProgress("待确认");
        return new ActResult("success", lendService.listLend(dto));
    }

    /**
     * 待确认 确认收款
     * @param po
     * @return
     */
    @ApiOperation(value = "待确认 确认收款", notes = "")
//    @ApiImplicitParam(name = "LendPO", value = "待确认 确认收款", required = true, dataType = "LendPO")
    @PutMapping("/v1/waitConfirmEdit")
    public Result waitConfirmEdit(@RequestBody LendPO po) throws IOException, SerException {

        lendService.updateLend(po, "确认收款");
        return new ActResult("success");
    }

    /**
     * 待还款列表
     *
     * @param )
     * @return
     */
    @ApiOperation(value = "待还款列表", notes = "")
    @GetMapping("/v1/waitRepayment/{page}")
    public Result waitRepayment(@PathVariable Integer page) {
        LendDTO dto = new LendDTO();
        dto.setPage(page);
        dto.setNowProgress("待还款");
        return new ActResult("success", lendService.listLend(dto));
    }

    /**
     * 待还款  还款
     * @param po
     * @return
     * @throws IOException
     * @throws SerException
     */
    @ApiOperation(value = "待还款 还款", notes = "")
//    @ApiImplicitParam(name = "LendPO", value = "待还款  还款", required = true, dataType = "LendPO")
    @PutMapping("/v1/waitRepayment")
    public Result waitRepayment(@RequestBody LendPO po) throws IOException, SerException {
        lendService.updateLend(po, "还款");
        return new ActResult("success");
    }

    /**
     * 待核对列表
     *
     * @param page
     * @return
     */
    @ApiOperation(value = "待核对列表", notes = "")
    @GetMapping("/v1/waitCheck/{page}")
    public Result waitCheck(@PathVariable Integer page) {
        LendDTO dto = new LendDTO();
        dto.setPage(page);
        dto.setNowProgress("待核对");
        return new ActResult("success", lendService.listLend(dto));
    }

    /**
     * 待核对 核对
     * @param po
     * @return
     */
    @ApiOperation(value = "待核对 核对", notes = "")
//    @ApiImplicitParam(name = "LendPO", value = "待核对 核对", required = true, dataType = "LendPO")
    @PutMapping("/v1/waitCheck")
    public Result waitCheck(@RequestBody LendPO po) throws IOException, SerException {
        lendService.updateLend(po, "核对");
        return new ActResult("success");
    }

    /**
     * 已完成列表
     *
     * @return
     */
    @ApiOperation(value = "已完成列表", notes = "")
    @GetMapping("/v1/Completed/{page}")
    public Result Completed(@PathVariable Integer page) {

        LendDTO dto = new LendDTO();
        dto.setPage(page);
        dto.setNowProgress("已完成");
        return new ActResult("success", lendService.listLend(dto));
    }

    /**
     * 有误记录列表
     * @return
     */
    @ApiOperation(value = "有误记录列表", notes = "")
    @GetMapping("/v1/errorRecord/{page}")
    public Result errorRecord(@PathVariable Integer page) {
        LendDTO dto = new LendDTO();
        dto.setPage(page);
        dto.setNowProgress("有误记录");
        return new ActResult("success", lendService.listLend(dto));
    }

    /**
     * 有误记录编辑
     *
     * @param po
     * @return
     * @throws ActException
     */
    @ApiOperation(value = "有误记录编辑", notes = "")
    @PutMapping("/v1/errorRecord")
    public Result errorRecord(@RequestBody LendPO po) throws IOException, SerException {
        lendService.updateLend(po, "有误编辑");
        return new ActResult("success");
    }

    /**
     * 寄件信息 添加
     * @param po
     * @return
     */
    @ApiOperation(value = "寄件信息 添加", notes = "")
//    @ApiImplicitParam(name = "LendPO", value = "寄件信息 添加", required = true, dataType = "LendPO")
    @PutMapping("/v1/mailingInformation")
    public Result mailingInformation(@RequestBody LendPO po) throws IOException, SerException {
        /*LendPO lendPO = new LendPO();
        lendPO.setId(id);
        Set set = new HashSet();
        set.add(po);
        lendPO.setMailings(set);*/
        lendService.updateLend(po, "");
        return new ActResult("success");
    }

    /**
     * 上传附件
     *
     * @des 审核项目签订与立项
     * @version v1
     */
    @ApiOperation(value = "上传附件", notes = "")
    @PostMapping("v1/uploadFile/{id}")
    public Result uploadFile(@PathVariable String id, HttpServletRequest request) throws ActException {
        /*try {
            //跟前端约定好 ，文件路径是列表id
            // /id/....
            String paths = "/lendreimbursement/loan/" + id;
            List<InputStream> inputStreams = getInputStreams(request, paths);
            fileAPI.upload(inputStreams);
            return new ActResult("upload success");
        } catch (SerException e) {
            throw new ActException(e.getMessage());
        }*/
        return new ActResult("success");
    }

    /**
     * 文件附件列表
     *
     * @param id 签订与立项id
     * @return class FileVO
     * @version v1
     */
    @ApiOperation(value = "文件爱呢附件列表", notes = "")
    @GetMapping("v1/listFile/{id}")
    public Result list(@PathVariable String id, HttpServletRequest request) throws ActException {
        /*try {
            //跟前端约定好 ，文件路径是列表id
            // /businessproject/id/....
            String path = "/lendreimbursement/loan/" + id;
            FileInfo fileInfo = new FileInfo();
            fileInfo.setPath(path);
            Object storageToken = request.getAttribute("storageToken");
            fileInfo.setStorageToken(storageToken.toString());
            List<FileVO> files = BeanTransform.copyProperties(fileAPI.list(fileInfo), FileVO.class);
            return ActResult.initialize(files);
        } catch (SerException e) {
            throw new ActException(e.getMessage());
        }*/
        return new ActResult("success");
    }

    /**
     * 文件下载
     *
     * @param path 文件信息路径
     * @version v1
     */
    @ApiOperation(value = "文件下载", notes = "")
    @GetMapping("v1/downloadFile")
    public Result download(@RequestParam String path, HttpServletRequest request, HttpServletResponse response) throws ActException {
       /* try {
            //该文件的路径
            Object storageToken = request.getAttribute("storageToken");
            FileInfo fileInfo = new FileInfo();
            fileInfo.setPath(path);
            fileInfo.setStorageToken(storageToken.toString());
            String filename = StringUtils.substringAfterLast(fileInfo.getPath(), "/");
            byte[] buffer = fileAPI.download(fileInfo);
            writeOutFile(response, buffer, filename);
            return new ActResult("download success");
        } catch (Exception e) {
            throw new ActException(e.getMessage());
        }*/
        return new ActResult("success");

    }
}
