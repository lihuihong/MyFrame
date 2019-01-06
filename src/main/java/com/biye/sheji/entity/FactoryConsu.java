package com.biye.sheji.entity;

import java.io.Serializable;

public class FactoryConsu implements Serializable {
    private Integer consuId;

    private String consuName;

    private static final long serialVersionUID = 1L;

    public Integer getConsuId() {
        return consuId;
    }

    public void setConsuId(Integer consuId) {
        this.consuId = consuId;
    }

    public String getConsuName() {
        return consuName;
    }

    public void setConsuName(String consuName) {
        this.consuName = consuName == null ? null : consuName.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", consuId=").append(consuId);
        sb.append(", consuName=").append(consuName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}