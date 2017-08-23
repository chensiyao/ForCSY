package com.csy.module.wx.entity;

public class BAccidentDriver {
    private String id;

    private String fkDriverId;

    private String duty;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getFkDriverId() {
        return fkDriverId;
    }

    public void setFkDriverId(String fkDriverId) {
        this.fkDriverId = fkDriverId == null ? null : fkDriverId.trim();
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty == null ? null : duty.trim();
    }
}