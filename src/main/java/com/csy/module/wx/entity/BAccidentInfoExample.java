package com.csy.module.wx.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BAccidentInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BAccidentInfoExample() {
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

        public Criteria andDutyIsNull() {
            addCriterion("duty is null");
            return (Criteria) this;
        }

        public Criteria andDutyIsNotNull() {
            addCriterion("duty is not null");
            return (Criteria) this;
        }

        public Criteria andDutyEqualTo(String value) {
            addCriterion("duty =", value, "duty");
            return (Criteria) this;
        }

        public Criteria andDutyNotEqualTo(String value) {
            addCriterion("duty <>", value, "duty");
            return (Criteria) this;
        }

        public Criteria andDutyGreaterThan(String value) {
            addCriterion("duty >", value, "duty");
            return (Criteria) this;
        }

        public Criteria andDutyGreaterThanOrEqualTo(String value) {
            addCriterion("duty >=", value, "duty");
            return (Criteria) this;
        }

        public Criteria andDutyLessThan(String value) {
            addCriterion("duty <", value, "duty");
            return (Criteria) this;
        }

        public Criteria andDutyLessThanOrEqualTo(String value) {
            addCriterion("duty <=", value, "duty");
            return (Criteria) this;
        }

        public Criteria andDutyLike(String value) {
            addCriterion("duty like", value, "duty");
            return (Criteria) this;
        }

        public Criteria andDutyNotLike(String value) {
            addCriterion("duty not like", value, "duty");
            return (Criteria) this;
        }

        public Criteria andDutyIn(List<String> values) {
            addCriterion("duty in", values, "duty");
            return (Criteria) this;
        }

        public Criteria andDutyNotIn(List<String> values) {
            addCriterion("duty not in", values, "duty");
            return (Criteria) this;
        }

        public Criteria andDutyBetween(String value1, String value2) {
            addCriterion("duty between", value1, value2, "duty");
            return (Criteria) this;
        }

        public Criteria andDutyNotBetween(String value1, String value2) {
            addCriterion("duty not between", value1, value2, "duty");
            return (Criteria) this;
        }

        public Criteria andLiveImageIsNull() {
            addCriterion("live_image is null");
            return (Criteria) this;
        }

        public Criteria andLiveImageIsNotNull() {
            addCriterion("live_image is not null");
            return (Criteria) this;
        }

        public Criteria andLiveImageEqualTo(String value) {
            addCriterion("live_image =", value, "liveImage");
            return (Criteria) this;
        }

        public Criteria andLiveImageNotEqualTo(String value) {
            addCriterion("live_image <>", value, "liveImage");
            return (Criteria) this;
        }

        public Criteria andLiveImageGreaterThan(String value) {
            addCriterion("live_image >", value, "liveImage");
            return (Criteria) this;
        }

        public Criteria andLiveImageGreaterThanOrEqualTo(String value) {
            addCriterion("live_image >=", value, "liveImage");
            return (Criteria) this;
        }

        public Criteria andLiveImageLessThan(String value) {
            addCriterion("live_image <", value, "liveImage");
            return (Criteria) this;
        }

        public Criteria andLiveImageLessThanOrEqualTo(String value) {
            addCriterion("live_image <=", value, "liveImage");
            return (Criteria) this;
        }

        public Criteria andLiveImageLike(String value) {
            addCriterion("live_image like", value, "liveImage");
            return (Criteria) this;
        }

        public Criteria andLiveImageNotLike(String value) {
            addCriterion("live_image not like", value, "liveImage");
            return (Criteria) this;
        }

        public Criteria andLiveImageIn(List<String> values) {
            addCriterion("live_image in", values, "liveImage");
            return (Criteria) this;
        }

        public Criteria andLiveImageNotIn(List<String> values) {
            addCriterion("live_image not in", values, "liveImage");
            return (Criteria) this;
        }

        public Criteria andLiveImageBetween(String value1, String value2) {
            addCriterion("live_image between", value1, value2, "liveImage");
            return (Criteria) this;
        }

        public Criteria andLiveImageNotBetween(String value1, String value2) {
            addCriterion("live_image not between", value1, value2, "liveImage");
            return (Criteria) this;
        }

        public Criteria andLiveVoiceIsNull() {
            addCriterion("live_voice is null");
            return (Criteria) this;
        }

        public Criteria andLiveVoiceIsNotNull() {
            addCriterion("live_voice is not null");
            return (Criteria) this;
        }

        public Criteria andLiveVoiceEqualTo(String value) {
            addCriterion("live_voice =", value, "liveVoice");
            return (Criteria) this;
        }

        public Criteria andLiveVoiceNotEqualTo(String value) {
            addCriterion("live_voice <>", value, "liveVoice");
            return (Criteria) this;
        }

        public Criteria andLiveVoiceGreaterThan(String value) {
            addCriterion("live_voice >", value, "liveVoice");
            return (Criteria) this;
        }

        public Criteria andLiveVoiceGreaterThanOrEqualTo(String value) {
            addCriterion("live_voice >=", value, "liveVoice");
            return (Criteria) this;
        }

        public Criteria andLiveVoiceLessThan(String value) {
            addCriterion("live_voice <", value, "liveVoice");
            return (Criteria) this;
        }

        public Criteria andLiveVoiceLessThanOrEqualTo(String value) {
            addCriterion("live_voice <=", value, "liveVoice");
            return (Criteria) this;
        }

        public Criteria andLiveVoiceLike(String value) {
            addCriterion("live_voice like", value, "liveVoice");
            return (Criteria) this;
        }

        public Criteria andLiveVoiceNotLike(String value) {
            addCriterion("live_voice not like", value, "liveVoice");
            return (Criteria) this;
        }

        public Criteria andLiveVoiceIn(List<String> values) {
            addCriterion("live_voice in", values, "liveVoice");
            return (Criteria) this;
        }

        public Criteria andLiveVoiceNotIn(List<String> values) {
            addCriterion("live_voice not in", values, "liveVoice");
            return (Criteria) this;
        }

        public Criteria andLiveVoiceBetween(String value1, String value2) {
            addCriterion("live_voice between", value1, value2, "liveVoice");
            return (Criteria) this;
        }

        public Criteria andLiveVoiceNotBetween(String value1, String value2) {
            addCriterion("live_voice not between", value1, value2, "liveVoice");
            return (Criteria) this;
        }

        public Criteria andUploadTimeIsNull() {
            addCriterion("upload_time is null");
            return (Criteria) this;
        }

        public Criteria andUploadTimeIsNotNull() {
            addCriterion("upload_time is not null");
            return (Criteria) this;
        }

        public Criteria andUploadTimeEqualTo(Date value) {
            addCriterion("upload_time =", value, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeNotEqualTo(Date value) {
            addCriterion("upload_time <>", value, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeGreaterThan(Date value) {
            addCriterion("upload_time >", value, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("upload_time >=", value, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeLessThan(Date value) {
            addCriterion("upload_time <", value, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeLessThanOrEqualTo(Date value) {
            addCriterion("upload_time <=", value, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeIn(List<Date> values) {
            addCriterion("upload_time in", values, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeNotIn(List<Date> values) {
            addCriterion("upload_time not in", values, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeBetween(Date value1, Date value2) {
            addCriterion("upload_time between", value1, value2, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeNotBetween(Date value1, Date value2) {
            addCriterion("upload_time not between", value1, value2, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andImgreuploadIndexIsNull() {
            addCriterion("imgReUpload_index is null");
            return (Criteria) this;
        }

        public Criteria andImgreuploadIndexIsNotNull() {
            addCriterion("imgReUpload_index is not null");
            return (Criteria) this;
        }

        public Criteria andImgreuploadIndexEqualTo(String value) {
            addCriterion("imgReUpload_index =", value, "imgreuploadIndex");
            return (Criteria) this;
        }

        public Criteria andImgreuploadIndexNotEqualTo(String value) {
            addCriterion("imgReUpload_index <>", value, "imgreuploadIndex");
            return (Criteria) this;
        }

        public Criteria andImgreuploadIndexGreaterThan(String value) {
            addCriterion("imgReUpload_index >", value, "imgreuploadIndex");
            return (Criteria) this;
        }

        public Criteria andImgreuploadIndexGreaterThanOrEqualTo(String value) {
            addCriterion("imgReUpload_index >=", value, "imgreuploadIndex");
            return (Criteria) this;
        }

        public Criteria andImgreuploadIndexLessThan(String value) {
            addCriterion("imgReUpload_index <", value, "imgreuploadIndex");
            return (Criteria) this;
        }

        public Criteria andImgreuploadIndexLessThanOrEqualTo(String value) {
            addCriterion("imgReUpload_index <=", value, "imgreuploadIndex");
            return (Criteria) this;
        }

        public Criteria andImgreuploadIndexLike(String value) {
            addCriterion("imgReUpload_index like", value, "imgreuploadIndex");
            return (Criteria) this;
        }

        public Criteria andImgreuploadIndexNotLike(String value) {
            addCriterion("imgReUpload_index not like", value, "imgreuploadIndex");
            return (Criteria) this;
        }

        public Criteria andImgreuploadIndexIn(List<String> values) {
            addCriterion("imgReUpload_index in", values, "imgreuploadIndex");
            return (Criteria) this;
        }

        public Criteria andImgreuploadIndexNotIn(List<String> values) {
            addCriterion("imgReUpload_index not in", values, "imgreuploadIndex");
            return (Criteria) this;
        }

        public Criteria andImgreuploadIndexBetween(String value1, String value2) {
            addCriterion("imgReUpload_index between", value1, value2, "imgreuploadIndex");
            return (Criteria) this;
        }

        public Criteria andImgreuploadIndexNotBetween(String value1, String value2) {
            addCriterion("imgReUpload_index not between", value1, value2, "imgreuploadIndex");
            return (Criteria) this;
        }

        public Criteria andImgreuploadedIndexIsNull() {
            addCriterion("imgReUploaded_index is null");
            return (Criteria) this;
        }

        public Criteria andImgreuploadedIndexIsNotNull() {
            addCriterion("imgReUploaded_index is not null");
            return (Criteria) this;
        }

        public Criteria andImgreuploadedIndexEqualTo(String value) {
            addCriterion("imgReUploaded_index =", value, "imgreuploadedIndex");
            return (Criteria) this;
        }

        public Criteria andImgreuploadedIndexNotEqualTo(String value) {
            addCriterion("imgReUploaded_index <>", value, "imgreuploadedIndex");
            return (Criteria) this;
        }

        public Criteria andImgreuploadedIndexGreaterThan(String value) {
            addCriterion("imgReUploaded_index >", value, "imgreuploadedIndex");
            return (Criteria) this;
        }

        public Criteria andImgreuploadedIndexGreaterThanOrEqualTo(String value) {
            addCriterion("imgReUploaded_index >=", value, "imgreuploadedIndex");
            return (Criteria) this;
        }

        public Criteria andImgreuploadedIndexLessThan(String value) {
            addCriterion("imgReUploaded_index <", value, "imgreuploadedIndex");
            return (Criteria) this;
        }

        public Criteria andImgreuploadedIndexLessThanOrEqualTo(String value) {
            addCriterion("imgReUploaded_index <=", value, "imgreuploadedIndex");
            return (Criteria) this;
        }

        public Criteria andImgreuploadedIndexLike(String value) {
            addCriterion("imgReUploaded_index like", value, "imgreuploadedIndex");
            return (Criteria) this;
        }

        public Criteria andImgreuploadedIndexNotLike(String value) {
            addCriterion("imgReUploaded_index not like", value, "imgreuploadedIndex");
            return (Criteria) this;
        }

        public Criteria andImgreuploadedIndexIn(List<String> values) {
            addCriterion("imgReUploaded_index in", values, "imgreuploadedIndex");
            return (Criteria) this;
        }

        public Criteria andImgreuploadedIndexNotIn(List<String> values) {
            addCriterion("imgReUploaded_index not in", values, "imgreuploadedIndex");
            return (Criteria) this;
        }

        public Criteria andImgreuploadedIndexBetween(String value1, String value2) {
            addCriterion("imgReUploaded_index between", value1, value2, "imgreuploadedIndex");
            return (Criteria) this;
        }

        public Criteria andImgreuploadedIndexNotBetween(String value1, String value2) {
            addCriterion("imgReUploaded_index not between", value1, value2, "imgreuploadedIndex");
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