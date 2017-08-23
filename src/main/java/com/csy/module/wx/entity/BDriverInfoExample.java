package com.csy.module.wx.entity;

import java.util.ArrayList;
import java.util.List;

public class BDriverInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BDriverInfoExample() {
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
            addCriterion("IDCard is null");
            return (Criteria) this;
        }

        public Criteria andIdcardIsNotNull() {
            addCriterion("IDCard is not null");
            return (Criteria) this;
        }

        public Criteria andIdcardEqualTo(String value) {
            addCriterion("IDCard =", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardNotEqualTo(String value) {
            addCriterion("IDCard <>", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardGreaterThan(String value) {
            addCriterion("IDCard >", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardGreaterThanOrEqualTo(String value) {
            addCriterion("IDCard >=", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardLessThan(String value) {
            addCriterion("IDCard <", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardLessThanOrEqualTo(String value) {
            addCriterion("IDCard <=", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardLike(String value) {
            addCriterion("IDCard like", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardNotLike(String value) {
            addCriterion("IDCard not like", value, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardIn(List<String> values) {
            addCriterion("IDCard in", values, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardNotIn(List<String> values) {
            addCriterion("IDCard not in", values, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardBetween(String value1, String value2) {
            addCriterion("IDCard between", value1, value2, "idcard");
            return (Criteria) this;
        }

        public Criteria andIdcardNotBetween(String value1, String value2) {
            addCriterion("IDCard not between", value1, value2, "idcard");
            return (Criteria) this;
        }

        public Criteria andVehiclelicenseIsNull() {
            addCriterion("vehicleLicense is null");
            return (Criteria) this;
        }

        public Criteria andVehiclelicenseIsNotNull() {
            addCriterion("vehicleLicense is not null");
            return (Criteria) this;
        }

        public Criteria andVehiclelicenseEqualTo(String value) {
            addCriterion("vehicleLicense =", value, "vehiclelicense");
            return (Criteria) this;
        }

        public Criteria andVehiclelicenseNotEqualTo(String value) {
            addCriterion("vehicleLicense <>", value, "vehiclelicense");
            return (Criteria) this;
        }

        public Criteria andVehiclelicenseGreaterThan(String value) {
            addCriterion("vehicleLicense >", value, "vehiclelicense");
            return (Criteria) this;
        }

        public Criteria andVehiclelicenseGreaterThanOrEqualTo(String value) {
            addCriterion("vehicleLicense >=", value, "vehiclelicense");
            return (Criteria) this;
        }

        public Criteria andVehiclelicenseLessThan(String value) {
            addCriterion("vehicleLicense <", value, "vehiclelicense");
            return (Criteria) this;
        }

        public Criteria andVehiclelicenseLessThanOrEqualTo(String value) {
            addCriterion("vehicleLicense <=", value, "vehiclelicense");
            return (Criteria) this;
        }

        public Criteria andVehiclelicenseLike(String value) {
            addCriterion("vehicleLicense like", value, "vehiclelicense");
            return (Criteria) this;
        }

        public Criteria andVehiclelicenseNotLike(String value) {
            addCriterion("vehicleLicense not like", value, "vehiclelicense");
            return (Criteria) this;
        }

        public Criteria andVehiclelicenseIn(List<String> values) {
            addCriterion("vehicleLicense in", values, "vehiclelicense");
            return (Criteria) this;
        }

        public Criteria andVehiclelicenseNotIn(List<String> values) {
            addCriterion("vehicleLicense not in", values, "vehiclelicense");
            return (Criteria) this;
        }

        public Criteria andVehiclelicenseBetween(String value1, String value2) {
            addCriterion("vehicleLicense between", value1, value2, "vehiclelicense");
            return (Criteria) this;
        }

        public Criteria andVehiclelicenseNotBetween(String value1, String value2) {
            addCriterion("vehicleLicense not between", value1, value2, "vehiclelicense");
            return (Criteria) this;
        }

        public Criteria andHphmIsNull() {
            addCriterion("hphm is null");
            return (Criteria) this;
        }

        public Criteria andHphmIsNotNull() {
            addCriterion("hphm is not null");
            return (Criteria) this;
        }

        public Criteria andHphmEqualTo(String value) {
            addCriterion("hphm =", value, "hphm");
            return (Criteria) this;
        }

        public Criteria andHphmNotEqualTo(String value) {
            addCriterion("hphm <>", value, "hphm");
            return (Criteria) this;
        }

        public Criteria andHphmGreaterThan(String value) {
            addCriterion("hphm >", value, "hphm");
            return (Criteria) this;
        }

        public Criteria andHphmGreaterThanOrEqualTo(String value) {
            addCriterion("hphm >=", value, "hphm");
            return (Criteria) this;
        }

        public Criteria andHphmLessThan(String value) {
            addCriterion("hphm <", value, "hphm");
            return (Criteria) this;
        }

        public Criteria andHphmLessThanOrEqualTo(String value) {
            addCriterion("hphm <=", value, "hphm");
            return (Criteria) this;
        }

        public Criteria andHphmLike(String value) {
            addCriterion("hphm like", value, "hphm");
            return (Criteria) this;
        }

        public Criteria andHphmNotLike(String value) {
            addCriterion("hphm not like", value, "hphm");
            return (Criteria) this;
        }

        public Criteria andHphmIn(List<String> values) {
            addCriterion("hphm in", values, "hphm");
            return (Criteria) this;
        }

        public Criteria andHphmNotIn(List<String> values) {
            addCriterion("hphm not in", values, "hphm");
            return (Criteria) this;
        }

        public Criteria andHphmBetween(String value1, String value2) {
            addCriterion("hphm between", value1, value2, "hphm");
            return (Criteria) this;
        }

        public Criteria andHphmNotBetween(String value1, String value2) {
            addCriterion("hphm not between", value1, value2, "hphm");
            return (Criteria) this;
        }

        public Criteria andIdcardimageIsNull() {
            addCriterion("IDCardImage is null");
            return (Criteria) this;
        }

        public Criteria andIdcardimageIsNotNull() {
            addCriterion("IDCardImage is not null");
            return (Criteria) this;
        }

        public Criteria andIdcardimageEqualTo(String value) {
            addCriterion("IDCardImage =", value, "idcardimage");
            return (Criteria) this;
        }

        public Criteria andIdcardimageNotEqualTo(String value) {
            addCriterion("IDCardImage <>", value, "idcardimage");
            return (Criteria) this;
        }

        public Criteria andIdcardimageGreaterThan(String value) {
            addCriterion("IDCardImage >", value, "idcardimage");
            return (Criteria) this;
        }

        public Criteria andIdcardimageGreaterThanOrEqualTo(String value) {
            addCriterion("IDCardImage >=", value, "idcardimage");
            return (Criteria) this;
        }

        public Criteria andIdcardimageLessThan(String value) {
            addCriterion("IDCardImage <", value, "idcardimage");
            return (Criteria) this;
        }

        public Criteria andIdcardimageLessThanOrEqualTo(String value) {
            addCriterion("IDCardImage <=", value, "idcardimage");
            return (Criteria) this;
        }

        public Criteria andIdcardimageLike(String value) {
            addCriterion("IDCardImage like", value, "idcardimage");
            return (Criteria) this;
        }

        public Criteria andIdcardimageNotLike(String value) {
            addCriterion("IDCardImage not like", value, "idcardimage");
            return (Criteria) this;
        }

        public Criteria andIdcardimageIn(List<String> values) {
            addCriterion("IDCardImage in", values, "idcardimage");
            return (Criteria) this;
        }

        public Criteria andIdcardimageNotIn(List<String> values) {
            addCriterion("IDCardImage not in", values, "idcardimage");
            return (Criteria) this;
        }

        public Criteria andIdcardimageBetween(String value1, String value2) {
            addCriterion("IDCardImage between", value1, value2, "idcardimage");
            return (Criteria) this;
        }

        public Criteria andIdcardimageNotBetween(String value1, String value2) {
            addCriterion("IDCardImage not between", value1, value2, "idcardimage");
            return (Criteria) this;
        }

        public Criteria andVehiclelicenseimageIsNull() {
            addCriterion("vehicleLicenseImage is null");
            return (Criteria) this;
        }

        public Criteria andVehiclelicenseimageIsNotNull() {
            addCriterion("vehicleLicenseImage is not null");
            return (Criteria) this;
        }

        public Criteria andVehiclelicenseimageEqualTo(String value) {
            addCriterion("vehicleLicenseImage =", value, "vehiclelicenseimage");
            return (Criteria) this;
        }

        public Criteria andVehiclelicenseimageNotEqualTo(String value) {
            addCriterion("vehicleLicenseImage <>", value, "vehiclelicenseimage");
            return (Criteria) this;
        }

        public Criteria andVehiclelicenseimageGreaterThan(String value) {
            addCriterion("vehicleLicenseImage >", value, "vehiclelicenseimage");
            return (Criteria) this;
        }

        public Criteria andVehiclelicenseimageGreaterThanOrEqualTo(String value) {
            addCriterion("vehicleLicenseImage >=", value, "vehiclelicenseimage");
            return (Criteria) this;
        }

        public Criteria andVehiclelicenseimageLessThan(String value) {
            addCriterion("vehicleLicenseImage <", value, "vehiclelicenseimage");
            return (Criteria) this;
        }

        public Criteria andVehiclelicenseimageLessThanOrEqualTo(String value) {
            addCriterion("vehicleLicenseImage <=", value, "vehiclelicenseimage");
            return (Criteria) this;
        }

        public Criteria andVehiclelicenseimageLike(String value) {
            addCriterion("vehicleLicenseImage like", value, "vehiclelicenseimage");
            return (Criteria) this;
        }

        public Criteria andVehiclelicenseimageNotLike(String value) {
            addCriterion("vehicleLicenseImage not like", value, "vehiclelicenseimage");
            return (Criteria) this;
        }

        public Criteria andVehiclelicenseimageIn(List<String> values) {
            addCriterion("vehicleLicenseImage in", values, "vehiclelicenseimage");
            return (Criteria) this;
        }

        public Criteria andVehiclelicenseimageNotIn(List<String> values) {
            addCriterion("vehicleLicenseImage not in", values, "vehiclelicenseimage");
            return (Criteria) this;
        }

        public Criteria andVehiclelicenseimageBetween(String value1, String value2) {
            addCriterion("vehicleLicenseImage between", value1, value2, "vehiclelicenseimage");
            return (Criteria) this;
        }

        public Criteria andVehiclelicenseimageNotBetween(String value1, String value2) {
            addCriterion("vehicleLicenseImage not between", value1, value2, "vehiclelicenseimage");
            return (Criteria) this;
        }

        public Criteria andContactIsNull() {
            addCriterion("contact is null");
            return (Criteria) this;
        }

        public Criteria andContactIsNotNull() {
            addCriterion("contact is not null");
            return (Criteria) this;
        }

        public Criteria andContactEqualTo(String value) {
            addCriterion("contact =", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotEqualTo(String value) {
            addCriterion("contact <>", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactGreaterThan(String value) {
            addCriterion("contact >", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactGreaterThanOrEqualTo(String value) {
            addCriterion("contact >=", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactLessThan(String value) {
            addCriterion("contact <", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactLessThanOrEqualTo(String value) {
            addCriterion("contact <=", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactLike(String value) {
            addCriterion("contact like", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotLike(String value) {
            addCriterion("contact not like", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactIn(List<String> values) {
            addCriterion("contact in", values, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotIn(List<String> values) {
            addCriterion("contact not in", values, "contact");
            return (Criteria) this;
        }

        public Criteria andContactBetween(String value1, String value2) {
            addCriterion("contact between", value1, value2, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotBetween(String value1, String value2) {
            addCriterion("contact not between", value1, value2, "contact");
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