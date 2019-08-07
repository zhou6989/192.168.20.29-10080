package cn.com.itcast.recon.dao.model.entity;

import java.math.BigDecimal;
import java.util.Date;

public class OuterBillDo {
    private Long id;

    private Date reconDate;

    private String reconStatus;

    private BigDecimal amount;

    private String tradeStatus;

    private String outerBillNo;

    private String outerNo;

    private Date createTime;

    private Date modifyTime;

    private String remark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getReconDate() {
        return reconDate;
    }

    public void setReconDate(Date reconDate) {
        this.reconDate = reconDate;
    }

    public String getReconStatus() {
        return reconStatus;
    }

    public void setReconStatus(String reconStatus) {
        this.reconStatus = reconStatus == null ? null : reconStatus.trim();
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getTradeStatus() {
        return tradeStatus;
    }

    public void setTradeStatus(String tradeStatus) {
        this.tradeStatus = tradeStatus == null ? null : tradeStatus.trim();
    }

    public String getOuterBillNo() {
        return outerBillNo;
    }

    public void setOuterBillNo(String outerBillNo) {
        this.outerBillNo = outerBillNo == null ? null : outerBillNo.trim();
    }

    public String getOuterNo() {
        return outerNo;
    }

    public void setOuterNo(String outerNo) {
        this.outerNo = outerNo == null ? null : outerNo.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}