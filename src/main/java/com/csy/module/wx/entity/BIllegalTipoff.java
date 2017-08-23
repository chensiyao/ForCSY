package com.csy.module.wx.entity;

import java.util.Date;

public class BIllegalTipoff {
    private String id;

    private String fkWxOpenid;

    private String plateNumber;

    private String longitude;

    private String latitude;

    private String illegalPosition;

    private String illegalAct;

    private String illegalImages;

    private Date occurrenceTime;

    private String status;

    private String name;

    private String idcard;

    private String phone;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getFkWxOpenid() {
        return fkWxOpenid;
    }

    public void setFkWxOpenid(String fkWxOpenid) {
        this.fkWxOpenid = fkWxOpenid == null ? null : fkWxOpenid.trim();
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber == null ? null : plateNumber.trim();
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude == null ? null : longitude.trim();
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude == null ? null : latitude.trim();
    }

    public String getIllegalPosition() {
        return illegalPosition;
    }

    public void setIllegalPosition(String illegalPosition) {
        this.illegalPosition = illegalPosition == null ? null : illegalPosition.trim();
    }

    public String getIllegalAct() {
        return illegalAct;
    }

    public void setIllegalAct(String illegalAct) {
        this.illegalAct = illegalAct == null ? null : illegalAct.trim();
    }

    public String getIllegalImages() {
        return illegalImages;
    }

    public void setIllegalImages(String illegalImages) {
        this.illegalImages = illegalImages == null ? null : illegalImages.trim();
    }

    public Date getOccurrenceTime() {
        return occurrenceTime;
    }

    public void setOccurrenceTime(Date occurrenceTime) {
        this.occurrenceTime = occurrenceTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }
}