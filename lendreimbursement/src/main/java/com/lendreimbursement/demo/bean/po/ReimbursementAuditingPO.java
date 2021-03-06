package com.lendreimbursement.demo.bean.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @Author: [caiwenxian]
 * @Date: [2018-04-02 15:01]
 * @Description: [ ]
 * @Version: [1.0.0]
 */
@Entity
@Table(name = "lendreimbursement_reimbursement_auditing")
public class ReimbursementAuditingPO extends BasePO {

    /**
     * 职位名称
     */
    @Column(name = "position", nullable = false, columnDefinition = "VARCHAR(255)   COMMENT '职位名称'")
    private String position;

    /**
     * 审核人
     */
    @Column(name = "auditor", nullable = false, columnDefinition = "VARCHAR(255)   COMMENT '审核人'")
    private String auditor;

    /**
     * 审核人编号
     */
    @Column(name = "auditorNum", nullable = false, columnDefinition = "VARCHAR(255)   COMMENT '审核人编号'")
    private String auditorNum;

    /**
     * 审核意见
     */
    @Column(name = "opinion", nullable = false, columnDefinition = "VARCHAR(255)   COMMENT '审核意见'")
    private String opinion;

    /**
     * 审核时间
     */
    @Column(name = "time", nullable = false, columnDefinition = "VARCHAR(255)   COMMENT '审核时间'")
    private String time;

    /**
     * 是否通过
     */
    @Column(name = "pass", nullable = false, columnDefinition = "VARCHAR(255)   COMMENT '是否通过'")
    private boolean pass;

    /**
     * 报销金额
     */
    @Column(name = "reimbursement", nullable = false, columnDefinition = "VARCHAR(255)   COMMENT '报销金额'")
    private double reimbursement;

    /**
     * 回退金额
     */
    @Column(name = "sendBack", nullable = false, columnDefinition = "VARCHAR(255)   COMMENT '回退金额'")
    private double sendBack;

    /**
     * 借款金额
     */
    @Column(name = "borrowMoney", nullable = false, columnDefinition = "VARCHAR(255)   COMMENT '借款金额'")
    private double borrowMoney;

    /**
     * 归还日期
     */
    @Column(name = "returnDate", nullable = false, columnDefinition = "VARCHAR(255)   COMMENT '归还日期'")
    private String returnDate;

    /**
     * 归还方式
     */
    @Column(name = "restitution", nullable = false, columnDefinition = "VARCHAR(255)   COMMENT '归还方式'")
    private String restitution;

    /**
     * 归还账户
     */
    @Column(name = "account", nullable = false, columnDefinition = "VARCHAR(255)   COMMENT '归还账户'")
    private String account;

    /**
     * 审核人模块
     */
    @Column(name = "auditorModule", nullable = false, columnDefinition = "VARCHAR(255)   COMMENT '审核人模块'")
    private String auditorModule;

    /**
     * 核对情况
     */
    @Column(name = "verification", nullable = false, columnDefinition = "VARCHAR(255)   COMMENT '核对情况'")
    private String verification;

    /**
     * 收票日期
     */
    @Column(name = "ticketDate", columnDefinition = "VARCHAR(255)   COMMENT '收票日期'")
    private String ticketDate;

    @Column(name = "ticketcollector", columnDefinition = "VARCHAR(255)   COMMENT '收票人'")
    private String ticketcollector;

    @Column(name = "dateOfReceipt", columnDefinition = "VARCHAR(255)   COMMENT '收票日期'")
    private String dateOfReceipt;

    @Column(name = "invoiceSituation", columnDefinition = "VARCHAR(255)   COMMENT '发票情况'")
    private String invoiceSituation;

    @Column(name = "receiveDocuments", columnDefinition = "VARCHAR(255)   COMMENT '是否收到单据'")
    private String receiveDocuments;

    @Column(name = "accountCheck", columnDefinition = "VARCHAR(255)   COMMENT '帐务核对是否通过'")
    private String accountCheck;

    private String auditing;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getAuditor() {
        return auditor;
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor;
    }

    public String getAuditorNum() {
        return auditorNum;
    }

    public void setAuditorNum(String auditorNum) {
        this.auditorNum = auditorNum;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isPass() {
        return pass;
    }

    public void setPass(boolean pass) {
        this.pass = pass;
    }

    public double getReimbursement() {
        return reimbursement;
    }

    public void setReimbursement(double reimbursement) {
        this.reimbursement = reimbursement;
    }

    public double getSendBack() {
        return sendBack;
    }

    public void setSendBack(double sendBack) {
        this.sendBack = sendBack;
    }

    public double getBorrowMoney() {
        return borrowMoney;
    }

    public void setBorrowMoney(double borrowMoney) {
        this.borrowMoney = borrowMoney;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String getRestitution() {
        return restitution;
    }

    public void setRestitution(String restitution) {
        this.restitution = restitution;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAuditorModule() {
        return auditorModule;
    }

    public void setAuditorModule(String auditorModule) {
        this.auditorModule = auditorModule;
    }

    public String getVerification() {
        return verification;
    }

    public void setVerification(String verification) {
        this.verification = verification;
    }

    public String getTicketDate() {
        return ticketDate;
    }

    public void setTicketDate(String ticketDate) {
        this.ticketDate = ticketDate;
    }

    public String getTicketcollector() {
        return ticketcollector;
    }

    public void setTicketcollector(String ticketcollector) {
        this.ticketcollector = ticketcollector;
    }

    public String getDateOfReceipt() {
        return dateOfReceipt;
    }

    public void setDateOfReceipt(String dateOfReceipt) {
        this.dateOfReceipt = dateOfReceipt;
    }

    public String getInvoiceSituation() {
        return invoiceSituation;
    }

    public void setInvoiceSituation(String invoiceSituation) {
        this.invoiceSituation = invoiceSituation;
    }

    public String getReceiveDocuments() {
        return receiveDocuments;
    }

    public void setReceiveDocuments(String receiveDocuments) {
        this.receiveDocuments = receiveDocuments;
    }

    public String getAccountCheck() {
        return accountCheck;
    }

    public void setAccountCheck(String accountCheck) {
        this.accountCheck = accountCheck;
    }

    public String getAuditing() {
        return auditing;
    }

    public void setAuditing(String auditing) {
        this.auditing = auditing;
    }



    @Override
    public String toString() {
        return "AuditingByReim{" +
                "position='" + position + '\'' +
                ", auditor='" + auditor + '\'' +
                ", opinion='" + opinion + '\'' +
                ", time='" + time + '\'' +
                ", pass=" + pass +
                ", reimbursement=" + reimbursement +
                ", sendBack=" + sendBack +
                ", borrowMoney=" + borrowMoney +
                ", returnDate='" + returnDate + '\'' +
                ", restitution='" + restitution + '\'' +
                ", account='" + account + '\'' +
                ", auditorModule='" + auditorModule + '\'' +
                ", verification='" + verification + '\'' +
                ", ticketDate='" + ticketDate + '\'' +
                ", auditing='" + auditing + '\'' +
                '}';
    }
}
