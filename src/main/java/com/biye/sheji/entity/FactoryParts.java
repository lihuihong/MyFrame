package com.biye.sheji.entity;

import java.io.Serializable;

public class FactoryParts implements Serializable {
    private Integer paetsId;

    private Integer equId;

    private String paetsName;

    private static final long serialVersionUID = 1L;

    public Integer getPaetsId() {
        return paetsId;
    }

    public void setPaetsId(Integer paetsId) {
        this.paetsId = paetsId;
    }

    public Integer getEquId() {
        return equId;
    }

    public void setEquId(Integer equId) {
        this.equId = equId;
    }

    public String getPaetsName() {
        return paetsName;
    }

    public void setPaetsName(String paetsName) {
        this.paetsName = paetsName == null ? null : paetsName.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", paetsId=").append(paetsId);
        sb.append(", equId=").append(equId);
        sb.append(", paetsName=").append(paetsName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}