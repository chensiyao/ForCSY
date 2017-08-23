package com.csy.module.wx.entity;

import java.util.ArrayList;
import java.util.List;

public class BQjMenuExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BQjMenuExample() {
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

        public Criteria andXhIsNull() {
            addCriterion("XH is null");
            return (Criteria) this;
        }

        public Criteria andXhIsNotNull() {
            addCriterion("XH is not null");
            return (Criteria) this;
        }

        public Criteria andXhEqualTo(String value) {
            addCriterion("XH =", value, "xh");
            return (Criteria) this;
        }

        public Criteria andXhNotEqualTo(String value) {
            addCriterion("XH <>", value, "xh");
            return (Criteria) this;
        }

        public Criteria andXhGreaterThan(String value) {
            addCriterion("XH >", value, "xh");
            return (Criteria) this;
        }

        public Criteria andXhGreaterThanOrEqualTo(String value) {
            addCriterion("XH >=", value, "xh");
            return (Criteria) this;
        }

        public Criteria andXhLessThan(String value) {
            addCriterion("XH <", value, "xh");
            return (Criteria) this;
        }

        public Criteria andXhLessThanOrEqualTo(String value) {
            addCriterion("XH <=", value, "xh");
            return (Criteria) this;
        }

        public Criteria andXhLike(String value) {
            addCriterion("XH like", value, "xh");
            return (Criteria) this;
        }

        public Criteria andXhNotLike(String value) {
            addCriterion("XH not like", value, "xh");
            return (Criteria) this;
        }

        public Criteria andXhIn(List<String> values) {
            addCriterion("XH in", values, "xh");
            return (Criteria) this;
        }

        public Criteria andXhNotIn(List<String> values) {
            addCriterion("XH not in", values, "xh");
            return (Criteria) this;
        }

        public Criteria andXhBetween(String value1, String value2) {
            addCriterion("XH between", value1, value2, "xh");
            return (Criteria) this;
        }

        public Criteria andXhNotBetween(String value1, String value2) {
            addCriterion("XH not between", value1, value2, "xh");
            return (Criteria) this;
        }

        public Criteria andFjdIsNull() {
            addCriterion("FJD is null");
            return (Criteria) this;
        }

        public Criteria andFjdIsNotNull() {
            addCriterion("FJD is not null");
            return (Criteria) this;
        }

        public Criteria andFjdEqualTo(String value) {
            addCriterion("FJD =", value, "fjd");
            return (Criteria) this;
        }

        public Criteria andFjdNotEqualTo(String value) {
            addCriterion("FJD <>", value, "fjd");
            return (Criteria) this;
        }

        public Criteria andFjdGreaterThan(String value) {
            addCriterion("FJD >", value, "fjd");
            return (Criteria) this;
        }

        public Criteria andFjdGreaterThanOrEqualTo(String value) {
            addCriterion("FJD >=", value, "fjd");
            return (Criteria) this;
        }

        public Criteria andFjdLessThan(String value) {
            addCriterion("FJD <", value, "fjd");
            return (Criteria) this;
        }

        public Criteria andFjdLessThanOrEqualTo(String value) {
            addCriterion("FJD <=", value, "fjd");
            return (Criteria) this;
        }

        public Criteria andFjdLike(String value) {
            addCriterion("FJD like", value, "fjd");
            return (Criteria) this;
        }

        public Criteria andFjdNotLike(String value) {
            addCriterion("FJD not like", value, "fjd");
            return (Criteria) this;
        }

        public Criteria andFjdIn(List<String> values) {
            addCriterion("FJD in", values, "fjd");
            return (Criteria) this;
        }

        public Criteria andFjdNotIn(List<String> values) {
            addCriterion("FJD not in", values, "fjd");
            return (Criteria) this;
        }

        public Criteria andFjdBetween(String value1, String value2) {
            addCriterion("FJD between", value1, value2, "fjd");
            return (Criteria) this;
        }

        public Criteria andFjdNotBetween(String value1, String value2) {
            addCriterion("FJD not between", value1, value2, "fjd");
            return (Criteria) this;
        }

        public Criteria andJdywmIsNull() {
            addCriterion("JDYWM is null");
            return (Criteria) this;
        }

        public Criteria andJdywmIsNotNull() {
            addCriterion("JDYWM is not null");
            return (Criteria) this;
        }

        public Criteria andJdywmEqualTo(String value) {
            addCriterion("JDYWM =", value, "jdywm");
            return (Criteria) this;
        }

        public Criteria andJdywmNotEqualTo(String value) {
            addCriterion("JDYWM <>", value, "jdywm");
            return (Criteria) this;
        }

        public Criteria andJdywmGreaterThan(String value) {
            addCriterion("JDYWM >", value, "jdywm");
            return (Criteria) this;
        }

        public Criteria andJdywmGreaterThanOrEqualTo(String value) {
            addCriterion("JDYWM >=", value, "jdywm");
            return (Criteria) this;
        }

        public Criteria andJdywmLessThan(String value) {
            addCriterion("JDYWM <", value, "jdywm");
            return (Criteria) this;
        }

        public Criteria andJdywmLessThanOrEqualTo(String value) {
            addCriterion("JDYWM <=", value, "jdywm");
            return (Criteria) this;
        }

        public Criteria andJdywmLike(String value) {
            addCriterion("JDYWM like", value, "jdywm");
            return (Criteria) this;
        }

        public Criteria andJdywmNotLike(String value) {
            addCriterion("JDYWM not like", value, "jdywm");
            return (Criteria) this;
        }

        public Criteria andJdywmIn(List<String> values) {
            addCriterion("JDYWM in", values, "jdywm");
            return (Criteria) this;
        }

        public Criteria andJdywmNotIn(List<String> values) {
            addCriterion("JDYWM not in", values, "jdywm");
            return (Criteria) this;
        }

        public Criteria andJdywmBetween(String value1, String value2) {
            addCriterion("JDYWM between", value1, value2, "jdywm");
            return (Criteria) this;
        }

        public Criteria andJdywmNotBetween(String value1, String value2) {
            addCriterion("JDYWM not between", value1, value2, "jdywm");
            return (Criteria) this;
        }

        public Criteria andJdzwmIsNull() {
            addCriterion("JDZWM is null");
            return (Criteria) this;
        }

        public Criteria andJdzwmIsNotNull() {
            addCriterion("JDZWM is not null");
            return (Criteria) this;
        }

        public Criteria andJdzwmEqualTo(String value) {
            addCriterion("JDZWM =", value, "jdzwm");
            return (Criteria) this;
        }

        public Criteria andJdzwmNotEqualTo(String value) {
            addCriterion("JDZWM <>", value, "jdzwm");
            return (Criteria) this;
        }

        public Criteria andJdzwmGreaterThan(String value) {
            addCriterion("JDZWM >", value, "jdzwm");
            return (Criteria) this;
        }

        public Criteria andJdzwmGreaterThanOrEqualTo(String value) {
            addCriterion("JDZWM >=", value, "jdzwm");
            return (Criteria) this;
        }

        public Criteria andJdzwmLessThan(String value) {
            addCriterion("JDZWM <", value, "jdzwm");
            return (Criteria) this;
        }

        public Criteria andJdzwmLessThanOrEqualTo(String value) {
            addCriterion("JDZWM <=", value, "jdzwm");
            return (Criteria) this;
        }

        public Criteria andJdzwmLike(String value) {
            addCriterion("JDZWM like", value, "jdzwm");
            return (Criteria) this;
        }

        public Criteria andJdzwmNotLike(String value) {
            addCriterion("JDZWM not like", value, "jdzwm");
            return (Criteria) this;
        }

        public Criteria andJdzwmIn(List<String> values) {
            addCriterion("JDZWM in", values, "jdzwm");
            return (Criteria) this;
        }

        public Criteria andJdzwmNotIn(List<String> values) {
            addCriterion("JDZWM not in", values, "jdzwm");
            return (Criteria) this;
        }

        public Criteria andJdzwmBetween(String value1, String value2) {
            addCriterion("JDZWM between", value1, value2, "jdzwm");
            return (Criteria) this;
        }

        public Criteria andJdzwmNotBetween(String value1, String value2) {
            addCriterion("JDZWM not between", value1, value2, "jdzwm");
            return (Criteria) this;
        }

        public Criteria andJdzwmqcIsNull() {
            addCriterion("JDZWMQC is null");
            return (Criteria) this;
        }

        public Criteria andJdzwmqcIsNotNull() {
            addCriterion("JDZWMQC is not null");
            return (Criteria) this;
        }

        public Criteria andJdzwmqcEqualTo(String value) {
            addCriterion("JDZWMQC =", value, "jdzwmqc");
            return (Criteria) this;
        }

        public Criteria andJdzwmqcNotEqualTo(String value) {
            addCriterion("JDZWMQC <>", value, "jdzwmqc");
            return (Criteria) this;
        }

        public Criteria andJdzwmqcGreaterThan(String value) {
            addCriterion("JDZWMQC >", value, "jdzwmqc");
            return (Criteria) this;
        }

        public Criteria andJdzwmqcGreaterThanOrEqualTo(String value) {
            addCriterion("JDZWMQC >=", value, "jdzwmqc");
            return (Criteria) this;
        }

        public Criteria andJdzwmqcLessThan(String value) {
            addCriterion("JDZWMQC <", value, "jdzwmqc");
            return (Criteria) this;
        }

        public Criteria andJdzwmqcLessThanOrEqualTo(String value) {
            addCriterion("JDZWMQC <=", value, "jdzwmqc");
            return (Criteria) this;
        }

        public Criteria andJdzwmqcLike(String value) {
            addCriterion("JDZWMQC like", value, "jdzwmqc");
            return (Criteria) this;
        }

        public Criteria andJdzwmqcNotLike(String value) {
            addCriterion("JDZWMQC not like", value, "jdzwmqc");
            return (Criteria) this;
        }

        public Criteria andJdzwmqcIn(List<String> values) {
            addCriterion("JDZWMQC in", values, "jdzwmqc");
            return (Criteria) this;
        }

        public Criteria andJdzwmqcNotIn(List<String> values) {
            addCriterion("JDZWMQC not in", values, "jdzwmqc");
            return (Criteria) this;
        }

        public Criteria andJdzwmqcBetween(String value1, String value2) {
            addCriterion("JDZWMQC between", value1, value2, "jdzwmqc");
            return (Criteria) this;
        }

        public Criteria andJdzwmqcNotBetween(String value1, String value2) {
            addCriterion("JDZWMQC not between", value1, value2, "jdzwmqc");
            return (Criteria) this;
        }

        public Criteria andJdjbIsNull() {
            addCriterion("JDJB is null");
            return (Criteria) this;
        }

        public Criteria andJdjbIsNotNull() {
            addCriterion("JDJB is not null");
            return (Criteria) this;
        }

        public Criteria andJdjbEqualTo(Integer value) {
            addCriterion("JDJB =", value, "jdjb");
            return (Criteria) this;
        }

        public Criteria andJdjbNotEqualTo(Integer value) {
            addCriterion("JDJB <>", value, "jdjb");
            return (Criteria) this;
        }

        public Criteria andJdjbGreaterThan(Integer value) {
            addCriterion("JDJB >", value, "jdjb");
            return (Criteria) this;
        }

        public Criteria andJdjbGreaterThanOrEqualTo(Integer value) {
            addCriterion("JDJB >=", value, "jdjb");
            return (Criteria) this;
        }

        public Criteria andJdjbLessThan(Integer value) {
            addCriterion("JDJB <", value, "jdjb");
            return (Criteria) this;
        }

        public Criteria andJdjbLessThanOrEqualTo(Integer value) {
            addCriterion("JDJB <=", value, "jdjb");
            return (Criteria) this;
        }

        public Criteria andJdjbIn(List<Integer> values) {
            addCriterion("JDJB in", values, "jdjb");
            return (Criteria) this;
        }

        public Criteria andJdjbNotIn(List<Integer> values) {
            addCriterion("JDJB not in", values, "jdjb");
            return (Criteria) this;
        }

        public Criteria andJdjbBetween(Integer value1, Integer value2) {
            addCriterion("JDJB between", value1, value2, "jdjb");
            return (Criteria) this;
        }

        public Criteria andJdjbNotBetween(Integer value1, Integer value2) {
            addCriterion("JDJB not between", value1, value2, "jdjb");
            return (Criteria) this;
        }

        public Criteria andSfxsIsNull() {
            addCriterion("SFXS is null");
            return (Criteria) this;
        }

        public Criteria andSfxsIsNotNull() {
            addCriterion("SFXS is not null");
            return (Criteria) this;
        }

        public Criteria andSfxsEqualTo(Integer value) {
            addCriterion("SFXS =", value, "sfxs");
            return (Criteria) this;
        }

        public Criteria andSfxsNotEqualTo(Integer value) {
            addCriterion("SFXS <>", value, "sfxs");
            return (Criteria) this;
        }

        public Criteria andSfxsGreaterThan(Integer value) {
            addCriterion("SFXS >", value, "sfxs");
            return (Criteria) this;
        }

        public Criteria andSfxsGreaterThanOrEqualTo(Integer value) {
            addCriterion("SFXS >=", value, "sfxs");
            return (Criteria) this;
        }

        public Criteria andSfxsLessThan(Integer value) {
            addCriterion("SFXS <", value, "sfxs");
            return (Criteria) this;
        }

        public Criteria andSfxsLessThanOrEqualTo(Integer value) {
            addCriterion("SFXS <=", value, "sfxs");
            return (Criteria) this;
        }

        public Criteria andSfxsIn(List<Integer> values) {
            addCriterion("SFXS in", values, "sfxs");
            return (Criteria) this;
        }

        public Criteria andSfxsNotIn(List<Integer> values) {
            addCriterion("SFXS not in", values, "sfxs");
            return (Criteria) this;
        }

        public Criteria andSfxsBetween(Integer value1, Integer value2) {
            addCriterion("SFXS between", value1, value2, "sfxs");
            return (Criteria) this;
        }

        public Criteria andSfxsNotBetween(Integer value1, Integer value2) {
            addCriterion("SFXS not between", value1, value2, "sfxs");
            return (Criteria) this;
        }

        public Criteria andSfxtsyIsNull() {
            addCriterion("SFXTSY is null");
            return (Criteria) this;
        }

        public Criteria andSfxtsyIsNotNull() {
            addCriterion("SFXTSY is not null");
            return (Criteria) this;
        }

        public Criteria andSfxtsyEqualTo(Integer value) {
            addCriterion("SFXTSY =", value, "sfxtsy");
            return (Criteria) this;
        }

        public Criteria andSfxtsyNotEqualTo(Integer value) {
            addCriterion("SFXTSY <>", value, "sfxtsy");
            return (Criteria) this;
        }

        public Criteria andSfxtsyGreaterThan(Integer value) {
            addCriterion("SFXTSY >", value, "sfxtsy");
            return (Criteria) this;
        }

        public Criteria andSfxtsyGreaterThanOrEqualTo(Integer value) {
            addCriterion("SFXTSY >=", value, "sfxtsy");
            return (Criteria) this;
        }

        public Criteria andSfxtsyLessThan(Integer value) {
            addCriterion("SFXTSY <", value, "sfxtsy");
            return (Criteria) this;
        }

        public Criteria andSfxtsyLessThanOrEqualTo(Integer value) {
            addCriterion("SFXTSY <=", value, "sfxtsy");
            return (Criteria) this;
        }

        public Criteria andSfxtsyIn(List<Integer> values) {
            addCriterion("SFXTSY in", values, "sfxtsy");
            return (Criteria) this;
        }

        public Criteria andSfxtsyNotIn(List<Integer> values) {
            addCriterion("SFXTSY not in", values, "sfxtsy");
            return (Criteria) this;
        }

        public Criteria andSfxtsyBetween(Integer value1, Integer value2) {
            addCriterion("SFXTSY between", value1, value2, "sfxtsy");
            return (Criteria) this;
        }

        public Criteria andSfxtsyNotBetween(Integer value1, Integer value2) {
            addCriterion("SFXTSY not between", value1, value2, "sfxtsy");
            return (Criteria) this;
        }

        public Criteria andSfmksyIsNull() {
            addCriterion("SFMKSY is null");
            return (Criteria) this;
        }

        public Criteria andSfmksyIsNotNull() {
            addCriterion("SFMKSY is not null");
            return (Criteria) this;
        }

        public Criteria andSfmksyEqualTo(Integer value) {
            addCriterion("SFMKSY =", value, "sfmksy");
            return (Criteria) this;
        }

        public Criteria andSfmksyNotEqualTo(Integer value) {
            addCriterion("SFMKSY <>", value, "sfmksy");
            return (Criteria) this;
        }

        public Criteria andSfmksyGreaterThan(Integer value) {
            addCriterion("SFMKSY >", value, "sfmksy");
            return (Criteria) this;
        }

        public Criteria andSfmksyGreaterThanOrEqualTo(Integer value) {
            addCriterion("SFMKSY >=", value, "sfmksy");
            return (Criteria) this;
        }

        public Criteria andSfmksyLessThan(Integer value) {
            addCriterion("SFMKSY <", value, "sfmksy");
            return (Criteria) this;
        }

        public Criteria andSfmksyLessThanOrEqualTo(Integer value) {
            addCriterion("SFMKSY <=", value, "sfmksy");
            return (Criteria) this;
        }

        public Criteria andSfmksyIn(List<Integer> values) {
            addCriterion("SFMKSY in", values, "sfmksy");
            return (Criteria) this;
        }

        public Criteria andSfmksyNotIn(List<Integer> values) {
            addCriterion("SFMKSY not in", values, "sfmksy");
            return (Criteria) this;
        }

        public Criteria andSfmksyBetween(Integer value1, Integer value2) {
            addCriterion("SFMKSY between", value1, value2, "sfmksy");
            return (Criteria) this;
        }

        public Criteria andSfmksyNotBetween(Integer value1, Integer value2) {
            addCriterion("SFMKSY not between", value1, value2, "sfmksy");
            return (Criteria) this;
        }

        public Criteria andXssxIsNull() {
            addCriterion("XSSX is null");
            return (Criteria) this;
        }

        public Criteria andXssxIsNotNull() {
            addCriterion("XSSX is not null");
            return (Criteria) this;
        }

        public Criteria andXssxEqualTo(Integer value) {
            addCriterion("XSSX =", value, "xssx");
            return (Criteria) this;
        }

        public Criteria andXssxNotEqualTo(Integer value) {
            addCriterion("XSSX <>", value, "xssx");
            return (Criteria) this;
        }

        public Criteria andXssxGreaterThan(Integer value) {
            addCriterion("XSSX >", value, "xssx");
            return (Criteria) this;
        }

        public Criteria andXssxGreaterThanOrEqualTo(Integer value) {
            addCriterion("XSSX >=", value, "xssx");
            return (Criteria) this;
        }

        public Criteria andXssxLessThan(Integer value) {
            addCriterion("XSSX <", value, "xssx");
            return (Criteria) this;
        }

        public Criteria andXssxLessThanOrEqualTo(Integer value) {
            addCriterion("XSSX <=", value, "xssx");
            return (Criteria) this;
        }

        public Criteria andXssxIn(List<Integer> values) {
            addCriterion("XSSX in", values, "xssx");
            return (Criteria) this;
        }

        public Criteria andXssxNotIn(List<Integer> values) {
            addCriterion("XSSX not in", values, "xssx");
            return (Criteria) this;
        }

        public Criteria andXssxBetween(Integer value1, Integer value2) {
            addCriterion("XSSX between", value1, value2, "xssx");
            return (Criteria) this;
        }

        public Criteria andXssxNotBetween(Integer value1, Integer value2) {
            addCriterion("XSSX not between", value1, value2, "xssx");
            return (Criteria) this;
        }

        public Criteria andYlzd1IsNull() {
            addCriterion("YLZD1 is null");
            return (Criteria) this;
        }

        public Criteria andYlzd1IsNotNull() {
            addCriterion("YLZD1 is not null");
            return (Criteria) this;
        }

        public Criteria andYlzd1EqualTo(String value) {
            addCriterion("YLZD1 =", value, "ylzd1");
            return (Criteria) this;
        }

        public Criteria andYlzd1NotEqualTo(String value) {
            addCriterion("YLZD1 <>", value, "ylzd1");
            return (Criteria) this;
        }

        public Criteria andYlzd1GreaterThan(String value) {
            addCriterion("YLZD1 >", value, "ylzd1");
            return (Criteria) this;
        }

        public Criteria andYlzd1GreaterThanOrEqualTo(String value) {
            addCriterion("YLZD1 >=", value, "ylzd1");
            return (Criteria) this;
        }

        public Criteria andYlzd1LessThan(String value) {
            addCriterion("YLZD1 <", value, "ylzd1");
            return (Criteria) this;
        }

        public Criteria andYlzd1LessThanOrEqualTo(String value) {
            addCriterion("YLZD1 <=", value, "ylzd1");
            return (Criteria) this;
        }

        public Criteria andYlzd1Like(String value) {
            addCriterion("YLZD1 like", value, "ylzd1");
            return (Criteria) this;
        }

        public Criteria andYlzd1NotLike(String value) {
            addCriterion("YLZD1 not like", value, "ylzd1");
            return (Criteria) this;
        }

        public Criteria andYlzd1In(List<String> values) {
            addCriterion("YLZD1 in", values, "ylzd1");
            return (Criteria) this;
        }

        public Criteria andYlzd1NotIn(List<String> values) {
            addCriterion("YLZD1 not in", values, "ylzd1");
            return (Criteria) this;
        }

        public Criteria andYlzd1Between(String value1, String value2) {
            addCriterion("YLZD1 between", value1, value2, "ylzd1");
            return (Criteria) this;
        }

        public Criteria andYlzd1NotBetween(String value1, String value2) {
            addCriterion("YLZD1 not between", value1, value2, "ylzd1");
            return (Criteria) this;
        }

        public Criteria andYlzd2IsNull() {
            addCriterion("YLZD2 is null");
            return (Criteria) this;
        }

        public Criteria andYlzd2IsNotNull() {
            addCriterion("YLZD2 is not null");
            return (Criteria) this;
        }

        public Criteria andYlzd2EqualTo(String value) {
            addCriterion("YLZD2 =", value, "ylzd2");
            return (Criteria) this;
        }

        public Criteria andYlzd2NotEqualTo(String value) {
            addCriterion("YLZD2 <>", value, "ylzd2");
            return (Criteria) this;
        }

        public Criteria andYlzd2GreaterThan(String value) {
            addCriterion("YLZD2 >", value, "ylzd2");
            return (Criteria) this;
        }

        public Criteria andYlzd2GreaterThanOrEqualTo(String value) {
            addCriterion("YLZD2 >=", value, "ylzd2");
            return (Criteria) this;
        }

        public Criteria andYlzd2LessThan(String value) {
            addCriterion("YLZD2 <", value, "ylzd2");
            return (Criteria) this;
        }

        public Criteria andYlzd2LessThanOrEqualTo(String value) {
            addCriterion("YLZD2 <=", value, "ylzd2");
            return (Criteria) this;
        }

        public Criteria andYlzd2Like(String value) {
            addCriterion("YLZD2 like", value, "ylzd2");
            return (Criteria) this;
        }

        public Criteria andYlzd2NotLike(String value) {
            addCriterion("YLZD2 not like", value, "ylzd2");
            return (Criteria) this;
        }

        public Criteria andYlzd2In(List<String> values) {
            addCriterion("YLZD2 in", values, "ylzd2");
            return (Criteria) this;
        }

        public Criteria andYlzd2NotIn(List<String> values) {
            addCriterion("YLZD2 not in", values, "ylzd2");
            return (Criteria) this;
        }

        public Criteria andYlzd2Between(String value1, String value2) {
            addCriterion("YLZD2 between", value1, value2, "ylzd2");
            return (Criteria) this;
        }

        public Criteria andYlzd2NotBetween(String value1, String value2) {
            addCriterion("YLZD2 not between", value1, value2, "ylzd2");
            return (Criteria) this;
        }

        public Criteria andYlzd3IsNull() {
            addCriterion("YLZD3 is null");
            return (Criteria) this;
        }

        public Criteria andYlzd3IsNotNull() {
            addCriterion("YLZD3 is not null");
            return (Criteria) this;
        }

        public Criteria andYlzd3EqualTo(String value) {
            addCriterion("YLZD3 =", value, "ylzd3");
            return (Criteria) this;
        }

        public Criteria andYlzd3NotEqualTo(String value) {
            addCriterion("YLZD3 <>", value, "ylzd3");
            return (Criteria) this;
        }

        public Criteria andYlzd3GreaterThan(String value) {
            addCriterion("YLZD3 >", value, "ylzd3");
            return (Criteria) this;
        }

        public Criteria andYlzd3GreaterThanOrEqualTo(String value) {
            addCriterion("YLZD3 >=", value, "ylzd3");
            return (Criteria) this;
        }

        public Criteria andYlzd3LessThan(String value) {
            addCriterion("YLZD3 <", value, "ylzd3");
            return (Criteria) this;
        }

        public Criteria andYlzd3LessThanOrEqualTo(String value) {
            addCriterion("YLZD3 <=", value, "ylzd3");
            return (Criteria) this;
        }

        public Criteria andYlzd3Like(String value) {
            addCriterion("YLZD3 like", value, "ylzd3");
            return (Criteria) this;
        }

        public Criteria andYlzd3NotLike(String value) {
            addCriterion("YLZD3 not like", value, "ylzd3");
            return (Criteria) this;
        }

        public Criteria andYlzd3In(List<String> values) {
            addCriterion("YLZD3 in", values, "ylzd3");
            return (Criteria) this;
        }

        public Criteria andYlzd3NotIn(List<String> values) {
            addCriterion("YLZD3 not in", values, "ylzd3");
            return (Criteria) this;
        }

        public Criteria andYlzd3Between(String value1, String value2) {
            addCriterion("YLZD3 between", value1, value2, "ylzd3");
            return (Criteria) this;
        }

        public Criteria andYlzd3NotBetween(String value1, String value2) {
            addCriterion("YLZD3 not between", value1, value2, "ylzd3");
            return (Criteria) this;
        }

        public Criteria andSftcIsNull() {
            addCriterion("SFTC is null");
            return (Criteria) this;
        }

        public Criteria andSftcIsNotNull() {
            addCriterion("SFTC is not null");
            return (Criteria) this;
        }

        public Criteria andSftcEqualTo(Integer value) {
            addCriterion("SFTC =", value, "sftc");
            return (Criteria) this;
        }

        public Criteria andSftcNotEqualTo(Integer value) {
            addCriterion("SFTC <>", value, "sftc");
            return (Criteria) this;
        }

        public Criteria andSftcGreaterThan(Integer value) {
            addCriterion("SFTC >", value, "sftc");
            return (Criteria) this;
        }

        public Criteria andSftcGreaterThanOrEqualTo(Integer value) {
            addCriterion("SFTC >=", value, "sftc");
            return (Criteria) this;
        }

        public Criteria andSftcLessThan(Integer value) {
            addCriterion("SFTC <", value, "sftc");
            return (Criteria) this;
        }

        public Criteria andSftcLessThanOrEqualTo(Integer value) {
            addCriterion("SFTC <=", value, "sftc");
            return (Criteria) this;
        }

        public Criteria andSftcIn(List<Integer> values) {
            addCriterion("SFTC in", values, "sftc");
            return (Criteria) this;
        }

        public Criteria andSftcNotIn(List<Integer> values) {
            addCriterion("SFTC not in", values, "sftc");
            return (Criteria) this;
        }

        public Criteria andSftcBetween(Integer value1, Integer value2) {
            addCriterion("SFTC between", value1, value2, "sftc");
            return (Criteria) this;
        }

        public Criteria andSftcNotBetween(Integer value1, Integer value2) {
            addCriterion("SFTC not between", value1, value2, "sftc");
            return (Criteria) this;
        }

        public Criteria andLjymmcIsNull() {
            addCriterion("LJYMMC is null");
            return (Criteria) this;
        }

        public Criteria andLjymmcIsNotNull() {
            addCriterion("LJYMMC is not null");
            return (Criteria) this;
        }

        public Criteria andLjymmcEqualTo(String value) {
            addCriterion("LJYMMC =", value, "ljymmc");
            return (Criteria) this;
        }

        public Criteria andLjymmcNotEqualTo(String value) {
            addCriterion("LJYMMC <>", value, "ljymmc");
            return (Criteria) this;
        }

        public Criteria andLjymmcGreaterThan(String value) {
            addCriterion("LJYMMC >", value, "ljymmc");
            return (Criteria) this;
        }

        public Criteria andLjymmcGreaterThanOrEqualTo(String value) {
            addCriterion("LJYMMC >=", value, "ljymmc");
            return (Criteria) this;
        }

        public Criteria andLjymmcLessThan(String value) {
            addCriterion("LJYMMC <", value, "ljymmc");
            return (Criteria) this;
        }

        public Criteria andLjymmcLessThanOrEqualTo(String value) {
            addCriterion("LJYMMC <=", value, "ljymmc");
            return (Criteria) this;
        }

        public Criteria andLjymmcLike(String value) {
            addCriterion("LJYMMC like", value, "ljymmc");
            return (Criteria) this;
        }

        public Criteria andLjymmcNotLike(String value) {
            addCriterion("LJYMMC not like", value, "ljymmc");
            return (Criteria) this;
        }

        public Criteria andLjymmcIn(List<String> values) {
            addCriterion("LJYMMC in", values, "ljymmc");
            return (Criteria) this;
        }

        public Criteria andLjymmcNotIn(List<String> values) {
            addCriterion("LJYMMC not in", values, "ljymmc");
            return (Criteria) this;
        }

        public Criteria andLjymmcBetween(String value1, String value2) {
            addCriterion("LJYMMC between", value1, value2, "ljymmc");
            return (Criteria) this;
        }

        public Criteria andLjymmcNotBetween(String value1, String value2) {
            addCriterion("LJYMMC not between", value1, value2, "ljymmc");
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