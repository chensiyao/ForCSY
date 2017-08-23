package com.csy.module.wx.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BIllegalTipoffExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BIllegalTipoffExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andFkWxOpenidIsNull() {
            addCriterion("fk_wx_openid is null");
            return (Criteria) this;
        }

        public Criteria andFkWxOpenidIsNotNull() {
            addCriterion("fk_wx_openid is not null");
            return (Criteria) this;
        }

        public Criteria andFkWxOpenidEqualTo(String value) {
            addCriterion("fk_wx_openid =", value, "fkWxOpenid");
            return (Criteria) this;
        }

        public Criteria andFkWxOpenidNotEqualTo(String value) {
            addCriterion("fk_wx_openid <>", value, "fkWxOpenid");
            return (Criteria) this;
        }

        public Criteria andFkWxOpenidGreaterThan(String value) {
            addCriterion("fk_wx_openid >", value, "fkWxOpenid");
            return (Criteria) this;
        }

        public Criteria andFkWxOpenidGreaterThanOrEqualTo(String value) {
            addCriterion("fk_wx_openid >=", value, "fkWxOpenid");
            return (Criteria) this;
        }

        public Criteria andFkWxOpenidLessThan(String value) {
            addCriterion("fk_wx_openid <", value, "fkWxOpenid");
            return (Criteria) this;
        }

        public Criteria andFkWxOpenidLessThanOrEqualTo(String value) {
            addCriterion("fk_wx_openid <=", value, "fkWxOpenid");
            return (Criteria) this;
        }

        public Criteria andFkWxOpenidLike(String value) {
            addCriterion("fk_wx_openid like", value, "fkWxOpenid");
            return (Criteria) this;
        }

        public Criteria andFkWxOpenidNotLike(String value) {
            addCriterion("fk_wx_openid not like", value, "fkWxOpenid");
            return (Criteria) this;
        }

        public Criteria andFkWxOpenidIn(List<String> values) {
            addCriterion("fk_wx_openid in", values, "fkWxOpenid");
            return (Criteria) this;
        }

        public Criteria andFkWxOpenidNotIn(List<String> values) {
            addCriterion("fk_wx_openid not in", values, "fkWxOpenid");
            return (Criteria) this;
        }

        public Criteria andFkWxOpenidBetween(String value1, String value2) {
            addCriterion("fk_wx_openid between", value1, value2, "fkWxOpenid");
            return (Criteria) this;
        }

        public Criteria andFkWxOpenidNotBetween(String value1, String value2) {
            addCriterion("fk_wx_openid not between", value1, value2, "fkWxOpenid");
            return (Criteria) this;
        }

        public Criteria andPlateNumberIsNull() {
            addCriterion("plate_number is null");
            return (Criteria) this;
        }

        public Criteria andPlateNumberIsNotNull() {
            addCriterion("plate_number is not null");
            return (Criteria) this;
        }

        public Criteria andPlateNumberEqualTo(String value) {
            addCriterion("plate_number =", value, "plateNumber");
            return (Criteria) this;
        }

        public Criteria andPlateNumberNotEqualTo(String value) {
            addCriterion("plate_number <>", value, "plateNumber");
            return (Criteria) this;
        }

        public Criteria andPlateNumberGreaterThan(String value) {
            addCriterion("plate_number >", value, "plateNumber");
            return (Criteria) this;
        }

        public Criteria andPlateNumberGreaterThanOrEqualTo(String value) {
            addCriterion("plate_number >=", value, "plateNumber");
            return (Criteria) this;
        }

        public Criteria andPlateNumberLessThan(String value) {
            addCriterion("plate_number <", value, "plateNumber");
            return (Criteria) this;
        }

        public Criteria andPlateNumberLessThanOrEqualTo(String value) {
            addCriterion("plate_number <=", value, "plateNumber");
            return (Criteria) this;
        }

        public Criteria andPlateNumberLike(String value) {
            addCriterion("plate_number like", value, "plateNumber");
            return (Criteria) this;
        }

        public Criteria andPlateNumberNotLike(String value) {
            addCriterion("plate_number not like", value, "plateNumber");
            return (Criteria) this;
        }

        public Criteria andPlateNumberIn(List<String> values) {
            addCriterion("plate_number in", values, "plateNumber");
            return (Criteria) this;
        }

        public Criteria andPlateNumberNotIn(List<String> values) {
            addCriterion("plate_number not in", values, "plateNumber");
            return (Criteria) this;
        }

        public Criteria andPlateNumberBetween(String value1, String value2) {
            addCriterion("plate_number between", value1, value2, "plateNumber");
            return (Criteria) this;
        }

        public Criteria andPlateNumberNotBetween(String value1, String value2) {
            addCriterion("plate_number not between", value1, value2, "plateNumber");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNull() {
            addCriterion("longitude is null");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNotNull() {
            addCriterion("longitude is not null");
            return (Criteria) this;
        }

        public Criteria andLongitudeEqualTo(String value) {
            addCriterion("longitude =", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotEqualTo(String value) {
            addCriterion("longitude <>", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThan(String value) {
            addCriterion("longitude >", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThanOrEqualTo(String value) {
            addCriterion("longitude >=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThan(String value) {
            addCriterion("longitude <", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThanOrEqualTo(String value) {
            addCriterion("longitude <=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLike(String value) {
            addCriterion("longitude like", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotLike(String value) {
            addCriterion("longitude not like", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeIn(List<String> values) {
            addCriterion("longitude in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotIn(List<String> values) {
            addCriterion("longitude not in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeBetween(String value1, String value2) {
            addCriterion("longitude between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotBetween(String value1, String value2) {
            addCriterion("longitude not between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNull() {
            addCriterion("latitude is null");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNotNull() {
            addCriterion("latitude is not null");
            return (Criteria) this;
        }

        public Criteria andLatitudeEqualTo(String value) {
            addCriterion("latitude =", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotEqualTo(String value) {
            addCriterion("latitude <>", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThan(String value) {
            addCriterion("latitude >", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThanOrEqualTo(String value) {
            addCriterion("latitude >=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThan(String value) {
            addCriterion("latitude <", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThanOrEqualTo(String value) {
            addCriterion("latitude <=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLike(String value) {
            addCriterion("latitude like", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotLike(String value) {
            addCriterion("latitude not like", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIn(List<String> values) {
            addCriterion("latitude in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotIn(List<String> values) {
            addCriterion("latitude not in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeBetween(String value1, String value2) {
            addCriterion("latitude between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotBetween(String value1, String value2) {
            addCriterion("latitude not between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andIllegalPositionIsNull() {
            addCriterion("illegal_position is null");
            return (Criteria) this;
        }

        public Criteria andIllegalPositionIsNotNull() {
            addCriterion("illegal_position is not null");
            return (Criteria) this;
        }

        public Criteria andIllegalPositionEqualTo(String value) {
            addCriterion("illegal_position =", value, "illegalPosition");
            return (Criteria) this;
        }

        public Criteria andIllegalPositionNotEqualTo(String value) {
            addCriterion("illegal_position <>", value, "illegalPosition");
            return (Criteria) this;
        }

        public Criteria andIllegalPositionGreaterThan(String value) {
            addCriterion("illegal_position >", value, "illegalPosition");
            return (Criteria) this;
        }

        public Criteria andIllegalPositionGreaterThanOrEqualTo(String value) {
            addCriterion("illegal_position >=", value, "illegalPosition");
            return (Criteria) this;
        }

        public Criteria andIllegalPositionLessThan(String value) {
            addCriterion("illegal_position <", value, "illegalPosition");
            return (Criteria) this;
        }

        public Criteria andIllegalPositionLessThanOrEqualTo(String value) {
            addCriterion("illegal_position <=", value, "illegalPosition");
            return (Criteria) this;
        }

        public Criteria andIllegalPositionLike(String value) {
            addCriterion("illegal_position like", value, "illegalPosition");
            return (Criteria) this;
        }

        public Criteria andIllegalPositionNotLike(String value) {
            addCriterion("illegal_position not like", value, "illegalPosition");
            return (Criteria) this;
        }

        public Criteria andIllegalPositionIn(List<String> values) {
            addCriterion("illegal_position in", values, "illegalPosition");
            return (Criteria) this;
        }

        public Criteria andIllegalPositionNotIn(List<String> values) {
            addCriterion("illegal_position not in", values, "illegalPosition");
            return (Criteria) this;
        }

        public Criteria andIllegalPositionBetween(String value1, String value2) {
            addCriterion("illegal_position between", value1, value2, "illegalPosition");
            return (Criteria) this;
        }

        public Criteria andIllegalPositionNotBetween(String value1, String value2) {
            addCriterion("illegal_position not between", value1, value2, "illegalPosition");
            return (Criteria) this;
        }

        public Criteria andIllegalActIsNull() {
            addCriterion("illegal_act is null");
            return (Criteria) this;
        }

        public Criteria andIllegalActIsNotNull() {
            addCriterion("illegal_act is not null");
            return (Criteria) this;
        }

        public Criteria andIllegalActEqualTo(String value) {
            addCriterion("illegal_act =", value, "illegalAct");
            return (Criteria) this;
        }

        public Criteria andIllegalActNotEqualTo(String value) {
            addCriterion("illegal_act <>", value, "illegalAct");
            return (Criteria) this;
        }

        public Criteria andIllegalActGreaterThan(String value) {
            addCriterion("illegal_act >", value, "illegalAct");
            return (Criteria) this;
        }

        public Criteria andIllegalActGreaterThanOrEqualTo(String value) {
            addCriterion("illegal_act >=", value, "illegalAct");
            return (Criteria) this;
        }

        public Criteria andIllegalActLessThan(String value) {
            addCriterion("illegal_act <", value, "illegalAct");
            return (Criteria) this;
        }

        public Criteria andIllegalActLessThanOrEqualTo(String value) {
            addCriterion("illegal_act <=", value, "illegalAct");
            return (Criteria) this;
        }

        public Criteria andIllegalActLike(String value) {
            addCriterion("illegal_act like", value, "illegalAct");
            return (Criteria) this;
        }

        public Criteria andIllegalActNotLike(String value) {
            addCriterion("illegal_act not like", value, "illegalAct");
            return (Criteria) this;
        }

        public Criteria andIllegalActIn(List<String> values) {
            addCriterion("illegal_act in", values, "illegalAct");
            return (Criteria) this;
        }

        public Criteria andIllegalActNotIn(List<String> values) {
            addCriterion("illegal_act not in", values, "illegalAct");
            return (Criteria) this;
        }

        public Criteria andIllegalActBetween(String value1, String value2) {
            addCriterion("illegal_act between", value1, value2, "illegalAct");
            return (Criteria) this;
        }

        public Criteria andIllegalActNotBetween(String value1, String value2) {
            addCriterion("illegal_act not between", value1, value2, "illegalAct");
            return (Criteria) this;
        }

        public Criteria andIllegalImagesIsNull() {
            addCriterion("illegal_images is null");
            return (Criteria) this;
        }

        public Criteria andIllegalImagesIsNotNull() {
            addCriterion("illegal_images is not null");
            return (Criteria) this;
        }

        public Criteria andIllegalImagesEqualTo(String value) {
            addCriterion("illegal_images =", value, "illegalImages");
            return (Criteria) this;
        }

        public Criteria andIllegalImagesNotEqualTo(String value) {
            addCriterion("illegal_images <>", value, "illegalImages");
            return (Criteria) this;
        }

        public Criteria andIllegalImagesGreaterThan(String value) {
            addCriterion("illegal_images >", value, "illegalImages");
            return (Criteria) this;
        }

        public Criteria andIllegalImagesGreaterThanOrEqualTo(String value) {
            addCriterion("illegal_images >=", value, "illegalImages");
            return (Criteria) this;
        }

        public Criteria andIllegalImagesLessThan(String value) {
            addCriterion("illegal_images <", value, "illegalImages");
            return (Criteria) this;
        }

        public Criteria andIllegalImagesLessThanOrEqualTo(String value) {
            addCriterion("illegal_images <=", value, "illegalImages");
            return (Criteria) this;
        }

        public Criteria andIllegalImagesLike(String value) {
            addCriterion("illegal_images like", value, "illegalImages");
            return (Criteria) this;
        }

        public Criteria andIllegalImagesNotLike(String value) {
            addCriterion("illegal_images not like", value, "illegalImages");
            return (Criteria) this;
        }

        public Criteria andIllegalImagesIn(List<String> values) {
            addCriterion("illegal_images in", values, "illegalImages");
            return (Criteria) this;
        }

        public Criteria andIllegalImagesNotIn(List<String> values) {
            addCriterion("illegal_images not in", values, "illegalImages");
            return (Criteria) this;
        }

        public Criteria andIllegalImagesBetween(String value1, String value2) {
            addCriterion("illegal_images between", value1, value2, "illegalImages");
            return (Criteria) this;
        }

        public Criteria andIllegalImagesNotBetween(String value1, String value2) {
            addCriterion("illegal_images not between", value1, value2, "illegalImages");
            return (Criteria) this;
        }

        public Criteria andOccurrenceTimeIsNull() {
            addCriterion("occurrence_time is null");
            return (Criteria) this;
        }

        public Criteria andOccurrenceTimeIsNotNull() {
            addCriterion("occurrence_time is not null");
            return (Criteria) this;
        }

        public Criteria andOccurrenceTimeEqualTo(Date value) {
            addCriterion("occurrence_time =", value, "occurrenceTime");
            return (Criteria) this;
        }

        public Criteria andOccurrenceTimeNotEqualTo(Date value) {
            addCriterion("occurrence_time <>", value, "occurrenceTime");
            return (Criteria) this;
        }

        public Criteria andOccurrenceTimeGreaterThan(Date value) {
            addCriterion("occurrence_time >", value, "occurrenceTime");
            return (Criteria) this;
        }

        public Criteria andOccurrenceTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("occurrence_time >=", value, "occurrenceTime");
            return (Criteria) this;
        }

        public Criteria andOccurrenceTimeLessThan(Date value) {
            addCriterion("occurrence_time <", value, "occurrenceTime");
            return (Criteria) this;
        }

        public Criteria andOccurrenceTimeLessThanOrEqualTo(Date value) {
            addCriterion("occurrence_time <=", value, "occurrenceTime");
            return (Criteria) this;
        }

        public Criteria andOccurrenceTimeIn(List<Date> values) {
            addCriterion("occurrence_time in", values, "occurrenceTime");
            return (Criteria) this;
        }

        public Criteria andOccurrenceTimeNotIn(List<Date> values) {
            addCriterion("occurrence_time not in", values, "occurrenceTime");
            return (Criteria) this;
        }

        public Criteria andOccurrenceTimeBetween(Date value1, Date value2) {
            addCriterion("occurrence_time between", value1, value2, "occurrenceTime");
            return (Criteria) this;
        }

        public Criteria andOccurrenceTimeNotBetween(Date value1, Date value2) {
            addCriterion("occurrence_time not between", value1, value2, "occurrenceTime");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andIdcardIsNull() {
            addCriterion("idcard is null");
            return (Criteria) this;
        }

        public Criteria andIdcardIsNotNull() {
            addCriterion("idcard is not null");
            return (Criteria) this;
        }

        public Criteria andIdcardEqualTo(String value) {
            addCriterion("idcard =", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardNotEqualTo(String value) {
            addCriterion("idcard <>", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardGreaterThan(String value) {
            addCriterion("idcard >", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardGreaterThanOrEqualTo(String value) {
            addCriterion("idcard >=", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardLessThan(String value) {
            addCriterion("idcard <", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardLessThanOrEqualTo(String value) {
            addCriterion("idcard <=", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardLike(String value) {
            addCriterion("idcard like", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardNotLike(String value) {
            addCriterion("idcard not like", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardIn(List<String> values) {
            addCriterion("idcard in", values, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardNotIn(List<String> values) {
            addCriterion("idcard not in", values, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardBetween(String value1, String value2) {
            addCriterion("idcard between", value1, value2, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardNotBetween(String value1, String value2) {
            addCriterion("idcard not between", value1, value2, "idcard");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}