package com.biye.sheji.entity;

import java.io.Serializable;

public class FactoryEqu implements Serializable {
    private Integer equId;

    private String equName;

    private String equMark;

    private String equIspass;

    private String equIsok;

    private String equConsu;

    private static final long serialVersionUID = 1L;

    public Integer getEquId() {
        return equId;
    }

    public void setEquId(Integer equId) {
        this.equId = equId;
    }

    public String getEquName() {
        return equName;
    }

    public void setEquName(String equName) {
        this.equName = equName == null ? null : equName.trim();
    }

    public String getEquMark() {
        return equMark;
    }

    public void setEquMark(String equMark) {
        this.equMark = equMark == null ? null : equMark.trim();
    }

    public String getEquIspass() {
        return equIspass;
    }

    public void setEquIspass(String equIspass) {
        this.equIspass = equIspass == null ? null : equIspass.trim();
    }

    public String getEquIsok() {
        return equIsok;
    }

    public void setEquIsok(String equIsok) {
        this.equIsok = equIsok == null ? null : equIsok.trim();
    }

    public String getEquConsu() {
        return equConsu;
    }

    public void setEquConsu(String equConsu) {
        this.equConsu = equConsu == null ? null : equConsu.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", equId=").append(equId);
        sb.append(", equName=").append(equName);
        sb.append(", equMark=").append(equMark);
        sb.append(", equIspass=").append(equIspass);
        sb.append(", equIsok=").append(equIsok);
        sb.append(", equConsu=").append(equConsu);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}