package com.luna.manage.pojo;

import java.util.ArrayList;
import java.util.List;

public class CantsPoJoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CantsPoJoExample() {
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

        public Criteria andCantCodeIsNull() {
            addCriterion("cant_code is null");
            return (Criteria) this;
        }

        public Criteria andCantCodeIsNotNull() {
            addCriterion("cant_code is not null");
            return (Criteria) this;
        }

        public Criteria andCantCodeEqualTo(String value) {
            addCriterion("cant_code =", value, "cantCode");
            return (Criteria) this;
        }

        public Criteria andCantCodeNotEqualTo(String value) {
            addCriterion("cant_code <>", value, "cantCode");
            return (Criteria) this;
        }

        public Criteria andCantCodeGreaterThan(String value) {
            addCriterion("cant_code >", value, "cantCode");
            return (Criteria) this;
        }

        public Criteria andCantCodeGreaterThanOrEqualTo(String value) {
            addCriterion("cant_code >=", value, "cantCode");
            return (Criteria) this;
        }

        public Criteria andCantCodeLessThan(String value) {
            addCriterion("cant_code <", value, "cantCode");
            return (Criteria) this;
        }

        public Criteria andCantCodeLessThanOrEqualTo(String value) {
            addCriterion("cant_code <=", value, "cantCode");
            return (Criteria) this;
        }

        public Criteria andCantCodeLike(String value) {
            addCriterion("cant_code like", value, "cantCode");
            return (Criteria) this;
        }

        public Criteria andCantCodeNotLike(String value) {
            addCriterion("cant_code not like", value, "cantCode");
            return (Criteria) this;
        }

        public Criteria andCantCodeIn(List<String> values) {
            addCriterion("cant_code in", values, "cantCode");
            return (Criteria) this;
        }

        public Criteria andCantCodeNotIn(List<String> values) {
            addCriterion("cant_code not in", values, "cantCode");
            return (Criteria) this;
        }

        public Criteria andCantCodeBetween(String value1, String value2) {
            addCriterion("cant_code between", value1, value2, "cantCode");
            return (Criteria) this;
        }

        public Criteria andCantCodeNotBetween(String value1, String value2) {
            addCriterion("cant_code not between", value1, value2, "cantCode");
            return (Criteria) this;
        }

        public Criteria andCantNameIsNull() {
            addCriterion("cant_name is null");
            return (Criteria) this;
        }

        public Criteria andCantNameIsNotNull() {
            addCriterion("cant_name is not null");
            return (Criteria) this;
        }

        public Criteria andCantNameEqualTo(String value) {
            addCriterion("cant_name =", value, "cantName");
            return (Criteria) this;
        }

        public Criteria andCantNameNotEqualTo(String value) {
            addCriterion("cant_name <>", value, "cantName");
            return (Criteria) this;
        }

        public Criteria andCantNameGreaterThan(String value) {
            addCriterion("cant_name >", value, "cantName");
            return (Criteria) this;
        }

        public Criteria andCantNameGreaterThanOrEqualTo(String value) {
            addCriterion("cant_name >=", value, "cantName");
            return (Criteria) this;
        }

        public Criteria andCantNameLessThan(String value) {
            addCriterion("cant_name <", value, "cantName");
            return (Criteria) this;
        }

        public Criteria andCantNameLessThanOrEqualTo(String value) {
            addCriterion("cant_name <=", value, "cantName");
            return (Criteria) this;
        }

        public Criteria andCantNameLike(String value) {
            addCriterion("cant_name like", value, "cantName");
            return (Criteria) this;
        }

        public Criteria andCantNameNotLike(String value) {
            addCriterion("cant_name not like", value, "cantName");
            return (Criteria) this;
        }

        public Criteria andCantNameIn(List<String> values) {
            addCriterion("cant_name in", values, "cantName");
            return (Criteria) this;
        }

        public Criteria andCantNameNotIn(List<String> values) {
            addCriterion("cant_name not in", values, "cantName");
            return (Criteria) this;
        }

        public Criteria andCantNameBetween(String value1, String value2) {
            addCriterion("cant_name between", value1, value2, "cantName");
            return (Criteria) this;
        }

        public Criteria andCantNameNotBetween(String value1, String value2) {
            addCriterion("cant_name not between", value1, value2, "cantName");
            return (Criteria) this;
        }

        public Criteria andShortNameIsNull() {
            addCriterion("short_name is null");
            return (Criteria) this;
        }

        public Criteria andShortNameIsNotNull() {
            addCriterion("short_name is not null");
            return (Criteria) this;
        }

        public Criteria andShortNameEqualTo(String value) {
            addCriterion("short_name =", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameNotEqualTo(String value) {
            addCriterion("short_name <>", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameGreaterThan(String value) {
            addCriterion("short_name >", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameGreaterThanOrEqualTo(String value) {
            addCriterion("short_name >=", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameLessThan(String value) {
            addCriterion("short_name <", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameLessThanOrEqualTo(String value) {
            addCriterion("short_name <=", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameLike(String value) {
            addCriterion("short_name like", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameNotLike(String value) {
            addCriterion("short_name not like", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameIn(List<String> values) {
            addCriterion("short_name in", values, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameNotIn(List<String> values) {
            addCriterion("short_name not in", values, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameBetween(String value1, String value2) {
            addCriterion("short_name between", value1, value2, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameNotBetween(String value1, String value2) {
            addCriterion("short_name not between", value1, value2, "shortName");
            return (Criteria) this;
        }

        public Criteria andCantTypeIsNull() {
            addCriterion("cant_type is null");
            return (Criteria) this;
        }

        public Criteria andCantTypeIsNotNull() {
            addCriterion("cant_type is not null");
            return (Criteria) this;
        }

        public Criteria andCantTypeEqualTo(String value) {
            addCriterion("cant_type =", value, "cantType");
            return (Criteria) this;
        }

        public Criteria andCantTypeNotEqualTo(String value) {
            addCriterion("cant_type <>", value, "cantType");
            return (Criteria) this;
        }

        public Criteria andCantTypeGreaterThan(String value) {
            addCriterion("cant_type >", value, "cantType");
            return (Criteria) this;
        }

        public Criteria andCantTypeGreaterThanOrEqualTo(String value) {
            addCriterion("cant_type >=", value, "cantType");
            return (Criteria) this;
        }

        public Criteria andCantTypeLessThan(String value) {
            addCriterion("cant_type <", value, "cantType");
            return (Criteria) this;
        }

        public Criteria andCantTypeLessThanOrEqualTo(String value) {
            addCriterion("cant_type <=", value, "cantType");
            return (Criteria) this;
        }

        public Criteria andCantTypeLike(String value) {
            addCriterion("cant_type like", value, "cantType");
            return (Criteria) this;
        }

        public Criteria andCantTypeNotLike(String value) {
            addCriterion("cant_type not like", value, "cantType");
            return (Criteria) this;
        }

        public Criteria andCantTypeIn(List<String> values) {
            addCriterion("cant_type in", values, "cantType");
            return (Criteria) this;
        }

        public Criteria andCantTypeNotIn(List<String> values) {
            addCriterion("cant_type not in", values, "cantType");
            return (Criteria) this;
        }

        public Criteria andCantTypeBetween(String value1, String value2) {
            addCriterion("cant_type between", value1, value2, "cantType");
            return (Criteria) this;
        }

        public Criteria andCantTypeNotBetween(String value1, String value2) {
            addCriterion("cant_type not between", value1, value2, "cantType");
            return (Criteria) this;
        }

        public Criteria andSuperCodeIsNull() {
            addCriterion("super_code is null");
            return (Criteria) this;
        }

        public Criteria andSuperCodeIsNotNull() {
            addCriterion("super_code is not null");
            return (Criteria) this;
        }

        public Criteria andSuperCodeEqualTo(String value) {
            addCriterion("super_code =", value, "superCode");
            return (Criteria) this;
        }

        public Criteria andSuperCodeNotEqualTo(String value) {
            addCriterion("super_code <>", value, "superCode");
            return (Criteria) this;
        }

        public Criteria andSuperCodeGreaterThan(String value) {
            addCriterion("super_code >", value, "superCode");
            return (Criteria) this;
        }

        public Criteria andSuperCodeGreaterThanOrEqualTo(String value) {
            addCriterion("super_code >=", value, "superCode");
            return (Criteria) this;
        }

        public Criteria andSuperCodeLessThan(String value) {
            addCriterion("super_code <", value, "superCode");
            return (Criteria) this;
        }

        public Criteria andSuperCodeLessThanOrEqualTo(String value) {
            addCriterion("super_code <=", value, "superCode");
            return (Criteria) this;
        }

        public Criteria andSuperCodeLike(String value) {
            addCriterion("super_code like", value, "superCode");
            return (Criteria) this;
        }

        public Criteria andSuperCodeNotLike(String value) {
            addCriterion("super_code not like", value, "superCode");
            return (Criteria) this;
        }

        public Criteria andSuperCodeIn(List<String> values) {
            addCriterion("super_code in", values, "superCode");
            return (Criteria) this;
        }

        public Criteria andSuperCodeNotIn(List<String> values) {
            addCriterion("super_code not in", values, "superCode");
            return (Criteria) this;
        }

        public Criteria andSuperCodeBetween(String value1, String value2) {
            addCriterion("super_code between", value1, value2, "superCode");
            return (Criteria) this;
        }

        public Criteria andSuperCodeNotBetween(String value1, String value2) {
            addCriterion("super_code not between", value1, value2, "superCode");
            return (Criteria) this;
        }

        public Criteria andCountryCodeIsNull() {
            addCriterion("country_code is null");
            return (Criteria) this;
        }

        public Criteria andCountryCodeIsNotNull() {
            addCriterion("country_code is not null");
            return (Criteria) this;
        }

        public Criteria andCountryCodeEqualTo(String value) {
            addCriterion("country_code =", value, "countryCode");
            return (Criteria) this;
        }

        public Criteria andCountryCodeNotEqualTo(String value) {
            addCriterion("country_code <>", value, "countryCode");
            return (Criteria) this;
        }

        public Criteria andCountryCodeGreaterThan(String value) {
            addCriterion("country_code >", value, "countryCode");
            return (Criteria) this;
        }

        public Criteria andCountryCodeGreaterThanOrEqualTo(String value) {
            addCriterion("country_code >=", value, "countryCode");
            return (Criteria) this;
        }

        public Criteria andCountryCodeLessThan(String value) {
            addCriterion("country_code <", value, "countryCode");
            return (Criteria) this;
        }

        public Criteria andCountryCodeLessThanOrEqualTo(String value) {
            addCriterion("country_code <=", value, "countryCode");
            return (Criteria) this;
        }

        public Criteria andCountryCodeLike(String value) {
            addCriterion("country_code like", value, "countryCode");
            return (Criteria) this;
        }

        public Criteria andCountryCodeNotLike(String value) {
            addCriterion("country_code not like", value, "countryCode");
            return (Criteria) this;
        }

        public Criteria andCountryCodeIn(List<String> values) {
            addCriterion("country_code in", values, "countryCode");
            return (Criteria) this;
        }

        public Criteria andCountryCodeNotIn(List<String> values) {
            addCriterion("country_code not in", values, "countryCode");
            return (Criteria) this;
        }

        public Criteria andCountryCodeBetween(String value1, String value2) {
            addCriterion("country_code between", value1, value2, "countryCode");
            return (Criteria) this;
        }

        public Criteria andCountryCodeNotBetween(String value1, String value2) {
            addCriterion("country_code not between", value1, value2, "countryCode");
            return (Criteria) this;
        }

        public Criteria andCantNoteIsNull() {
            addCriterion("cant_note is null");
            return (Criteria) this;
        }

        public Criteria andCantNoteIsNotNull() {
            addCriterion("cant_note is not null");
            return (Criteria) this;
        }

        public Criteria andCantNoteEqualTo(String value) {
            addCriterion("cant_note =", value, "cantNote");
            return (Criteria) this;
        }

        public Criteria andCantNoteNotEqualTo(String value) {
            addCriterion("cant_note <>", value, "cantNote");
            return (Criteria) this;
        }

        public Criteria andCantNoteGreaterThan(String value) {
            addCriterion("cant_note >", value, "cantNote");
            return (Criteria) this;
        }

        public Criteria andCantNoteGreaterThanOrEqualTo(String value) {
            addCriterion("cant_note >=", value, "cantNote");
            return (Criteria) this;
        }

        public Criteria andCantNoteLessThan(String value) {
            addCriterion("cant_note <", value, "cantNote");
            return (Criteria) this;
        }

        public Criteria andCantNoteLessThanOrEqualTo(String value) {
            addCriterion("cant_note <=", value, "cantNote");
            return (Criteria) this;
        }

        public Criteria andCantNoteLike(String value) {
            addCriterion("cant_note like", value, "cantNote");
            return (Criteria) this;
        }

        public Criteria andCantNoteNotLike(String value) {
            addCriterion("cant_note not like", value, "cantNote");
            return (Criteria) this;
        }

        public Criteria andCantNoteIn(List<String> values) {
            addCriterion("cant_note in", values, "cantNote");
            return (Criteria) this;
        }

        public Criteria andCantNoteNotIn(List<String> values) {
            addCriterion("cant_note not in", values, "cantNote");
            return (Criteria) this;
        }

        public Criteria andCantNoteBetween(String value1, String value2) {
            addCriterion("cant_note between", value1, value2, "cantNote");
            return (Criteria) this;
        }

        public Criteria andCantNoteNotBetween(String value1, String value2) {
            addCriterion("cant_note not between", value1, value2, "cantNote");
            return (Criteria) this;
        }

        public Criteria andInUseIsNull() {
            addCriterion("in_use is null");
            return (Criteria) this;
        }

        public Criteria andInUseIsNotNull() {
            addCriterion("in_use is not null");
            return (Criteria) this;
        }

        public Criteria andInUseEqualTo(String value) {
            addCriterion("in_use =", value, "inUse");
            return (Criteria) this;
        }

        public Criteria andInUseNotEqualTo(String value) {
            addCriterion("in_use <>", value, "inUse");
            return (Criteria) this;
        }

        public Criteria andInUseGreaterThan(String value) {
            addCriterion("in_use >", value, "inUse");
            return (Criteria) this;
        }

        public Criteria andInUseGreaterThanOrEqualTo(String value) {
            addCriterion("in_use >=", value, "inUse");
            return (Criteria) this;
        }

        public Criteria andInUseLessThan(String value) {
            addCriterion("in_use <", value, "inUse");
            return (Criteria) this;
        }

        public Criteria andInUseLessThanOrEqualTo(String value) {
            addCriterion("in_use <=", value, "inUse");
            return (Criteria) this;
        }

        public Criteria andInUseLike(String value) {
            addCriterion("in_use like", value, "inUse");
            return (Criteria) this;
        }

        public Criteria andInUseNotLike(String value) {
            addCriterion("in_use not like", value, "inUse");
            return (Criteria) this;
        }

        public Criteria andInUseIn(List<String> values) {
            addCriterion("in_use in", values, "inUse");
            return (Criteria) this;
        }

        public Criteria andInUseNotIn(List<String> values) {
            addCriterion("in_use not in", values, "inUse");
            return (Criteria) this;
        }

        public Criteria andInUseBetween(String value1, String value2) {
            addCriterion("in_use between", value1, value2, "inUse");
            return (Criteria) this;
        }

        public Criteria andInUseNotBetween(String value1, String value2) {
            addCriterion("in_use not between", value1, value2, "inUse");
            return (Criteria) this;
        }

        public Criteria andFUscodeIsNull() {
            addCriterion("f_uscode is null");
            return (Criteria) this;
        }

        public Criteria andFUscodeIsNotNull() {
            addCriterion("f_uscode is not null");
            return (Criteria) this;
        }

        public Criteria andFUscodeEqualTo(String value) {
            addCriterion("f_uscode =", value, "fUscode");
            return (Criteria) this;
        }

        public Criteria andFUscodeNotEqualTo(String value) {
            addCriterion("f_uscode <>", value, "fUscode");
            return (Criteria) this;
        }

        public Criteria andFUscodeGreaterThan(String value) {
            addCriterion("f_uscode >", value, "fUscode");
            return (Criteria) this;
        }

        public Criteria andFUscodeGreaterThanOrEqualTo(String value) {
            addCriterion("f_uscode >=", value, "fUscode");
            return (Criteria) this;
        }

        public Criteria andFUscodeLessThan(String value) {
            addCriterion("f_uscode <", value, "fUscode");
            return (Criteria) this;
        }

        public Criteria andFUscodeLessThanOrEqualTo(String value) {
            addCriterion("f_uscode <=", value, "fUscode");
            return (Criteria) this;
        }

        public Criteria andFUscodeLike(String value) {
            addCriterion("f_uscode like", value, "fUscode");
            return (Criteria) this;
        }

        public Criteria andFUscodeNotLike(String value) {
            addCriterion("f_uscode not like", value, "fUscode");
            return (Criteria) this;
        }

        public Criteria andFUscodeIn(List<String> values) {
            addCriterion("f_uscode in", values, "fUscode");
            return (Criteria) this;
        }

        public Criteria andFUscodeNotIn(List<String> values) {
            addCriterion("f_uscode not in", values, "fUscode");
            return (Criteria) this;
        }

        public Criteria andFUscodeBetween(String value1, String value2) {
            addCriterion("f_uscode between", value1, value2, "fUscode");
            return (Criteria) this;
        }

        public Criteria andFUscodeNotBetween(String value1, String value2) {
            addCriterion("f_uscode not between", value1, value2, "fUscode");
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