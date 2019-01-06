package com.biye.sheji.entity;

import java.io.Serializable;
import java.util.Date;

public class FactoryRepair implements Serializable {
    private Integer repairId;

    private Integer equId;

    private Integer paetsId;

    private Integer userId;

    private String repairMark;

    private String repairIspass;

    private Date repairStartTime;

    private Date repairEndTime;

    private static final long serialVersionUID = 1L;

    public Integer getRepairId() {
        return repairId;
    }

    public void setRepairId(Integer repairId) {
        this.repairId = repairId;
    }

    public Integer getEquId() {
        return equId;
    }

    public void setEquId(Integer equId) {
        this.equId = equId;
    }

    public Integer getPaetsId() {
        return paetsId;
    }

    public void setPaetsId(Integer paetsId) {
        this.paetsId = paetsId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getRepairMark() {
        return repairMark;
    }

    public void setRepairMark(String repairMark) {
        this.repairMark = repairMark == null ? null : repairMark.trim();
    }

    public String getRepairIspass() {
        return repairIspass;
    }

    public void setRepairIspass(String repairIspass) {
        this.repairIspass = repairIspass == null ? null : repairIspass.trim();
    }

    public Date getRepairStartTime() {
        return repairStartTime;
    }

    public void setRepairStartTime(Date repairStartTime) {
        this.repairStartTime = repairStartTime;
    }

    public Date getRepairEndTime() {
        return repairEndTime;
    }

    public void setRepairEndTime(Date repairEndTime) {
        this.repairEndTime = repairEndTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", repairId=").append(repairId);
        sb.append(", equId=").append(equId);
        sb.append(", paetsId=").append(paetsId);
        sb.append(", userId=").append(userId);
        sb.append(", repairMark=").append(repairMark);
        sb.append(", repairIspass=").append(repairIspass);
        sb.append(", repairStartTime=").append(repairStartTime);
        sb.append(", repairEndTime=").append(repairEndTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}