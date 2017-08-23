package com.csy.module.wx.entity;

public class BDriverInfo {
    private String id;

    private String name;

    private String idcard;

    private String vehiclelicense;

    private String hphm;

    private String idcardimage;

    private String vehiclelicenseimage;

    private String contact;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
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

    public String getVehiclelicense() {
        return vehiclelicense;
    }

    public void setVehiclelicense(String vehiclelicense) {
        this.vehiclelicense = vehiclelicense == null ? null : vehiclelicense.trim();
    }

    public String getHphm() {
        return hphm;
    }

    public void setHphm(String hphm) {
        this.hphm = hphm == null ? null : hphm.trim();
    }

    public String getIdcardimage() {
        return idcardimage;
    }

    public void setIdcardimage(String idcardimage) {
        this.idcardimage = idcardimage == null ? null : idcardimage.trim();
    }

    public String getVehiclelicenseimage() {
        return vehiclelicenseimage;
    }

    public void setVehiclelicenseimage(String vehiclelicenseimage) {
        this.vehiclelicenseimage = vehiclelicenseimage == null ? null : vehiclelicenseimage.trim();
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact == null ? null : contact.trim();
    }
}