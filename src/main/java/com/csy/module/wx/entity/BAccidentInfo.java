package com.csy.module.wx.entity;

import java.util.Date;

public class BAccidentInfo {
    private String id;

    private String fkWxOpenid;

    private Date occurrenceTime;

    private String longitude;

    private String latitude;

    private String duty;

    private String liveImage;

    private String liveVoice;

    private Date uploadTime;

    private String description;

    private String imgreuploadIndex;

    private String imgreuploadedIndex;

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

    public Date getOccurrenceTime() {
        return occurrenceTime;
    }

    public void setOccurrenceTime(Date occurrenceTime) {
        this.occurrenceTime = occurrenceTime;
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

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty == null ? null : duty.trim();
    }

    public String getLiveImage() {
        return liveImage;
    }

    public void setLiveImage(String liveImage) {
        this.liveImage = liveImage == null ? null : liveImage.trim();
    }

    public String getLiveVoice() {
        return liveVoice;
    }

    public void setLiveVoice(String liveVoice) {
        this.liveVoice = liveVoice == null ? null : liveVoice.trim();
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getImgreuploadIndex() {
        return imgreuploadIndex;
    }

    public void setImgreuploadIndex(String imgreuploadIndex) {
        this.imgreuploadIndex = imgreuploadIndex == null ? null : imgreuploadIndex.trim();
    }

    public String getImgreuploadedIndex() {
        return imgreuploadedIndex;
    }

    public void setImgreuploadedIndex(String imgreuploadedIndex) {
        this.imgreuploadedIndex = imgreuploadedIndex == null ? null : imgreuploadedIndex.trim();
    }
}