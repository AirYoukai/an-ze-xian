package com.anzexian.demo.entity;

import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.List;

public class UserLoginExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserLoginExample() {
        oredCriteria = new ArrayList<>();
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
            criteria = new ArrayList<>();
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIsNull() {
            addCriterion("is_deleted is null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIsNotNull() {
            addCriterion("is_deleted is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedEqualTo(Boolean value) {
            addCriterion("is_deleted =", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotEqualTo(Boolean value) {
            addCriterion("is_deleted <>", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThan(Boolean value) {
            addCriterion("is_deleted >", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_deleted >=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThan(Boolean value) {
            addCriterion("is_deleted <", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThanOrEqualTo(Boolean value) {
            addCriterion("is_deleted <=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIn(List<Boolean> values) {
            addCriterion("is_deleted in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotIn(List<Boolean> values) {
            addCriterion("is_deleted not in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedBetween(Boolean value1, Boolean value2) {
            addCriterion("is_deleted between", value1, value2, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_deleted not between", value1, value2, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(LocalDateTime value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(LocalDateTime value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(LocalDateTime value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(LocalDateTime value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(LocalDateTime value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(LocalDateTime value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<LocalDateTime> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<LocalDateTime> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andLoginCodeIsNull() {
            addCriterion("login_code is null");
            return (Criteria) this;
        }

        public Criteria andLoginCodeIsNotNull() {
            addCriterion("login_code is not null");
            return (Criteria) this;
        }

        public Criteria andLoginCodeEqualTo(String value) {
            addCriterion("login_code =", value, "loginCode");
            return (Criteria) this;
        }

        public Criteria andLoginCodeNotEqualTo(String value) {
            addCriterion("login_code <>", value, "loginCode");
            return (Criteria) this;
        }

        public Criteria andLoginCodeGreaterThan(String value) {
            addCriterion("login_code >", value, "loginCode");
            return (Criteria) this;
        }

        public Criteria andLoginCodeGreaterThanOrEqualTo(String value) {
            addCriterion("login_code >=", value, "loginCode");
            return (Criteria) this;
        }

        public Criteria andLoginCodeLessThan(String value) {
            addCriterion("login_code <", value, "loginCode");
            return (Criteria) this;
        }

        public Criteria andLoginCodeLessThanOrEqualTo(String value) {
            addCriterion("login_code <=", value, "loginCode");
            return (Criteria) this;
        }

        public Criteria andLoginCodeLike(String value) {
            addCriterion("login_code like", value, "loginCode");
            return (Criteria) this;
        }

        public Criteria andLoginCodeNotLike(String value) {
            addCriterion("login_code not like", value, "loginCode");
            return (Criteria) this;
        }

        public Criteria andLoginCodeIn(List<String> values) {
            addCriterion("login_code in", values, "loginCode");
            return (Criteria) this;
        }

        public Criteria andLoginCodeNotIn(List<String> values) {
            addCriterion("login_code not in", values, "loginCode");
            return (Criteria) this;
        }

        public Criteria andLoginCodeBetween(String value1, String value2) {
            addCriterion("login_code between", value1, value2, "loginCode");
            return (Criteria) this;
        }

        public Criteria andLoginCodeNotBetween(String value1, String value2) {
            addCriterion("login_code not between", value1, value2, "loginCode");
            return (Criteria) this;
        }

        public Criteria andScannerIdIsNull() {
            addCriterion("scanner_id is null");
            return (Criteria) this;
        }

        public Criteria andScannerIdIsNotNull() {
            addCriterion("scanner_id is not null");
            return (Criteria) this;
        }

        public Criteria andScannerIdEqualTo(Integer value) {
            addCriterion("scanner_id =", value, "scannerId");
            return (Criteria) this;
        }

        public Criteria andScannerIdNotEqualTo(Integer value) {
            addCriterion("scanner_id <>", value, "scannerId");
            return (Criteria) this;
        }

        public Criteria andScannerIdGreaterThan(Integer value) {
            addCriterion("scanner_id >", value, "scannerId");
            return (Criteria) this;
        }

        public Criteria andScannerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("scanner_id >=", value, "scannerId");
            return (Criteria) this;
        }

        public Criteria andScannerIdLessThan(Integer value) {
            addCriterion("scanner_id <", value, "scannerId");
            return (Criteria) this;
        }

        public Criteria andScannerIdLessThanOrEqualTo(Integer value) {
            addCriterion("scanner_id <=", value, "scannerId");
            return (Criteria) this;
        }

        public Criteria andScannerIdIn(List<Integer> values) {
            addCriterion("scanner_id in", values, "scannerId");
            return (Criteria) this;
        }

        public Criteria andScannerIdNotIn(List<Integer> values) {
            addCriterion("scanner_id not in", values, "scannerId");
            return (Criteria) this;
        }

        public Criteria andScannerIdBetween(Integer value1, Integer value2) {
            addCriterion("scanner_id between", value1, value2, "scannerId");
            return (Criteria) this;
        }

        public Criteria andScannerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("scanner_id not between", value1, value2, "scannerId");
            return (Criteria) this;
        }

        public Criteria andHasloginIsNull() {
            addCriterion("hasLogin is null");
            return (Criteria) this;
        }

        public Criteria andHasloginIsNotNull() {
            addCriterion("hasLogin is not null");
            return (Criteria) this;
        }

        public Criteria andHasloginEqualTo(Boolean value) {
            addCriterion("hasLogin =", value, "haslogin");
            return (Criteria) this;
        }

        public Criteria andHasloginNotEqualTo(Boolean value) {
            addCriterion("hasLogin <>", value, "haslogin");
            return (Criteria) this;
        }

        public Criteria andHasloginGreaterThan(Boolean value) {
            addCriterion("hasLogin >", value, "haslogin");
            return (Criteria) this;
        }

        public Criteria andHasloginGreaterThanOrEqualTo(Boolean value) {
            addCriterion("hasLogin >=", value, "haslogin");
            return (Criteria) this;
        }

        public Criteria andHasloginLessThan(Boolean value) {
            addCriterion("hasLogin <", value, "haslogin");
            return (Criteria) this;
        }

        public Criteria andHasloginLessThanOrEqualTo(Boolean value) {
            addCriterion("hasLogin <=", value, "haslogin");
            return (Criteria) this;
        }

        public Criteria andHasloginIn(List<Boolean> values) {
            addCriterion("hasLogin in", values, "haslogin");
            return (Criteria) this;
        }

        public Criteria andHasloginNotIn(List<Boolean> values) {
            addCriterion("hasLogin not in", values, "haslogin");
            return (Criteria) this;
        }

        public Criteria andHasloginBetween(Boolean value1, Boolean value2) {
            addCriterion("hasLogin between", value1, value2, "haslogin");
            return (Criteria) this;
        }

        public Criteria andHasloginNotBetween(Boolean value1, Boolean value2) {
            addCriterion("hasLogin not between", value1, value2, "haslogin");
            return (Criteria) this;
        }

        public Criteria andIsScannedIsNull() {
            addCriterion("is_scanned is null");
            return (Criteria) this;
        }

        public Criteria andIsScannedIsNotNull() {
            addCriterion("is_scanned is not null");
            return (Criteria) this;
        }

        public Criteria andIsScannedEqualTo(Boolean value) {
            addCriterion("is_scanned =", value, "isScanned");
            return (Criteria) this;
        }

        public Criteria andIsScannedNotEqualTo(Boolean value) {
            addCriterion("is_scanned <>", value, "isScanned");
            return (Criteria) this;
        }

        public Criteria andIsScannedGreaterThan(Boolean value) {
            addCriterion("is_scanned >", value, "isScanned");
            return (Criteria) this;
        }

        public Criteria andIsScannedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_scanned >=", value, "isScanned");
            return (Criteria) this;
        }

        public Criteria andIsScannedLessThan(Boolean value) {
            addCriterion("is_scanned <", value, "isScanned");
            return (Criteria) this;
        }

        public Criteria andIsScannedLessThanOrEqualTo(Boolean value) {
            addCriterion("is_scanned <=", value, "isScanned");
            return (Criteria) this;
        }

        public Criteria andIsScannedIn(List<Boolean> values) {
            addCriterion("is_scanned in", values, "isScanned");
            return (Criteria) this;
        }

        public Criteria andIsScannedNotIn(List<Boolean> values) {
            addCriterion("is_scanned not in", values, "isScanned");
            return (Criteria) this;
        }

        public Criteria andIsScannedBetween(Boolean value1, Boolean value2) {
            addCriterion("is_scanned between", value1, value2, "isScanned");
            return (Criteria) this;
        }

        public Criteria andIsScannedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_scanned not between", value1, value2, "isScanned");
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