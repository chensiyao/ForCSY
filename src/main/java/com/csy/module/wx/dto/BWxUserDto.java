package com.csy.module.wx.dto;

import com.csy.module.wx.entity.BWxUser;

public class BWxUserDto{
	private String openid;

    private String nickname;

    private Byte sex;

    private String province;

    private String city;

    private String country;

    private String headimgurl;

    private String[] privilege;

    private String unionid;

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public String getHeadimgurl() {
        return headimgurl;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl == null ? null : headimgurl.trim();
    }

    public String[] getPrivilege() {
        return privilege;
    }

    public void setPrivilege(String[] privilege) {
        this.privilege = privilege;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid == null ? null : unionid.trim();
    }

    public BWxUser parseToBWxUser(){
    	BWxUser bWxUser = new BWxUser();
    	bWxUser.setCity(city);
    	bWxUser.setCountry(country);
    	bWxUser.setHeadimgurl(headimgurl);
    	bWxUser.setNickname(nickname);
    	bWxUser.setOpenid(openid);
    	bWxUser.setPrivilege(privilege == null? privilege.toString():null);
    	bWxUser.setProvince(province);
    	bWxUser.setSex(sex);
    	bWxUser.setUnionid(unionid);
    	return bWxUser;
    }
}
