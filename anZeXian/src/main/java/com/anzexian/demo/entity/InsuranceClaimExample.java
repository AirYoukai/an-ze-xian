package com.anzexian.demo.entity;

import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.List;

public class InsuranceClaimExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public InsuranceClaimExample() {
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

        public Criteria andStatusManagerIsNull() {
            addCriterion("status_manager is null");
            return (Criteria) this;
        }

        public Criteria andStatusManagerIsNotNull() {
            addCriterion("status_manager is not null");
            return (Criteria) this;
        }

        public Criteria andStatusManagerEqualTo(String value) {
            addCriterion("status_manager =", value, "statusManager");
            return (Criteria) this;
        }

        public Criteria andStatusManagerNotEqualTo(String value) {
            addCriterion("status_manager <>", value, "statusManager");
            return (Criteria) this;
        }

        public Criteria andStatusManagerGreaterThan(String value) {
            addCriterion("status_manager >", value, "statusManager");
            return (Criteria) this;
        }

        public Criteria andStatusManagerGreaterThanOrEqualTo(String value) {
            addCriterion("status_manager >=", value, "statusManager");
            return (Criteria) this;
        }

        public Criteria andStatusManagerLessThan(String value) {
            addCriterion("status_manager <", value, "statusManager");
            return (Criteria) this;
        }

        public Criteria andStatusManagerLessThanOrEqualTo(String value) {
            addCriterion("status_manager <=", value, "statusManager");
            return (Criteria) this;
        }

        public Criteria andStatusManagerLike(String value) {
            addCriterion("status_manager like", value, "statusManager");
            return (Criteria) this;
        }

        public Criteria andStatusManagerNotLike(String value) {
            addCriterion("status_manager not like", value, "statusManager");
            return (Criteria) this;
        }

        public Criteria andStatusManagerIn(List<String> values) {
            addCriterion("status_manager in", values, "statusManager");
            return (Criteria) this;
        }

        public Criteria andStatusManagerNotIn(List<String> values) {
            addCriterion("status_manager not in", values, "statusManager");
            return (Criteria) this;
        }

        public Criteria andStatusManagerBetween(String value1, String value2) {
            addCriterion("status_manager between", value1, value2, "statusManager");
            return (Criteria) this;
        }

        public Criteria andStatusManagerNotBetween(String value1, String value2) {
            addCriterion("status_manager not between", value1, value2, "statusManager");
            return (Criteria) this;
        }

        public Criteria andStatusStaffIsNull() {
            addCriterion("status_staff is null");
            return (Criteria) this;
        }

        public Criteria andStatusStaffIsNotNull() {
            addCriterion("status_staff is not null");
            return (Criteria) this;
        }

        public Criteria andStatusStaffEqualTo(String value) {
            addCriterion("status_staff =", value, "statusStaff");
            return (Criteria) this;
        }

        public Criteria andStatusStaffNotEqualTo(String value) {
            addCriterion("status_staff <>", value, "statusStaff");
            return (Criteria) this;
        }

        public Criteria andStatusStaffGreaterThan(String value) {
            addCriterion("status_staff >", value, "statusStaff");
            return (Criteria) this;
        }

        public Criteria andStatusStaffGreaterThanOrEqualTo(String value) {
            addCriterion("status_staff >=", value, "statusStaff");
            return (Criteria) this;
        }

        public Criteria andStatusStaffLessThan(String value) {
            addCriterion("status_staff <", value, "statusStaff");
            return (Criteria) this;
        }

        public Criteria andStatusStaffLessThanOrEqualTo(String value) {
            addCriterion("status_staff <=", value, "statusStaff");
            return (Criteria) this;
        }

        public Criteria andStatusStaffLike(String value) {
            addCriterion("status_staff like", value, "statusStaff");
            return (Criteria) this;
        }

        public Criteria andStatusStaffNotLike(String value) {
            addCriterion("status_staff not like", value, "statusStaff");
            return (Criteria) this;
        }

        public Criteria andStatusStaffIn(List<String> values) {
            addCriterion("status_staff in", values, "statusStaff");
            return (Criteria) this;
        }

        public Criteria andStatusStaffNotIn(List<String> values) {
            addCriterion("status_staff not in", values, "statusStaff");
            return (Criteria) this;
        }

        public Criteria andStatusStaffBetween(String value1, String value2) {
            addCriterion("status_staff between", value1, value2, "statusStaff");
            return (Criteria) this;
        }

        public Criteria andStatusStaffNotBetween(String value1, String value2) {
            addCriterion("status_staff not between", value1, value2, "statusStaff");
            return (Criteria) this;
        }

        public Criteria andWxpayIdIsNull() {
            addCriterion("wxpay_id is null");
            return (Criteria) this;
        }

        public Criteria andWxpayIdIsNotNull() {
            addCriterion("wxpay_id is not null");
            return (Criteria) this;
        }

        public Criteria andWxpayIdEqualTo(Integer value) {
            addCriterion("wxpay_id =", value, "wxpayId");
            return (Criteria) this;
        }

        public Criteria andWxpayIdNotEqualTo(Integer value) {
            addCriterion("wxpay_id <>", value, "wxpayId");
            return (Criteria) this;
        }

        public Criteria andWxpayIdGreaterThan(Integer value) {
            addCriterion("wxpay_id >", value, "wxpayId");
            return (Criteria) this;
        }

        public Criteria andWxpayIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("wxpay_id >=", value, "wxpayId");
            return (Criteria) this;
        }

        public Criteria andWxpayIdLessThan(Integer value) {
            addCriterion("wxpay_id <", value, "wxpayId");
            return (Criteria) this;
        }

        public Criteria andWxpayIdLessThanOrEqualTo(Integer value) {
            addCriterion("wxpay_id <=", value, "wxpayId");
            return (Criteria) this;
        }

        public Criteria andWxpayIdIn(List<Integer> values) {
            addCriterion("wxpay_id in", values, "wxpayId");
            return (Criteria) this;
        }

        public Criteria andWxpayIdNotIn(List<Integer> values) {
            addCriterion("wxpay_id not in", values, "wxpayId");
            return (Criteria) this;
        }

        public Criteria andWxpayIdBetween(Integer value1, Integer value2) {
            addCriterion("wxpay_id between", value1, value2, "wxpayId");
            return (Criteria) this;
        }

        public Criteria andWxpayIdNotBetween(Integer value1, Integer value2) {
            addCriterion("wxpay_id not between", value1, value2, "wxpayId");
            return (Criteria) this;
        }

        public Criteria andClaimantIdIsNull() {
            addCriterion("claimant_id is null");
            return (Criteria) this;
        }

        public Criteria andClaimantIdIsNotNull() {
            addCriterion("claimant_id is not null");
            return (Criteria) this;
        }

        public Criteria andClaimantIdEqualTo(Integer value) {
            addCriterion("claimant_id =", value, "claimantId");
            return (Criteria) this;
        }

        public Criteria andClaimantIdNotEqualTo(Integer value) {
            addCriterion("claimant_id <>", value, "claimantId");
            return (Criteria) this;
        }

        public Criteria andClaimantIdGreaterThan(Integer value) {
            addCriterion("claimant_id >", value, "claimantId");
            return (Criteria) this;
        }

        public Criteria andClaimantIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("claimant_id >=", value, "claimantId");
            return (Criteria) this;
        }

        public Criteria andClaimantIdLessThan(Integer value) {
            addCriterion("claimant_id <", value, "claimantId");
            return (Criteria) this;
        }

        public Criteria andClaimantIdLessThanOrEqualTo(Integer value) {
            addCriterion("claimant_id <=", value, "claimantId");
            return (Criteria) this;
        }

        public Criteria andClaimantIdIn(List<Integer> values) {
            addCriterion("claimant_id in", values, "claimantId");
            return (Criteria) this;
        }

        public Criteria andClaimantIdNotIn(List<Integer> values) {
            addCriterion("claimant_id not in", values, "claimantId");
            return (Criteria) this;
        }

        public Criteria andClaimantIdBetween(Integer value1, Integer value2) {
            addCriterion("claimant_id between", value1, value2, "claimantId");
            return (Criteria) this;
        }

        public Criteria andClaimantIdNotBetween(Integer value1, Integer value2) {
            addCriterion("claimant_id not between", value1, value2, "claimantId");
            return (Criteria) this;
        }

        public Criteria andPayerIdIsNull() {
            addCriterion("payer_id is null");
            return (Criteria) this;
        }

        public Criteria andPayerIdIsNotNull() {
            addCriterion("payer_id is not null");
            return (Criteria) this;
        }

        public Criteria andPayerIdEqualTo(Integer value) {
            addCriterion("payer_id =", value, "payerId");
            return (Criteria) this;
        }

        public Criteria andPayerIdNotEqualTo(Integer value) {
            addCriterion("payer_id <>", value, "payerId");
            return (Criteria) this;
        }

        public Criteria andPayerIdGreaterThan(Integer value) {
            addCriterion("payer_id >", value, "payerId");
            return (Criteria) this;
        }

        public Criteria andPayerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("payer_id >=", value, "payerId");
            return (Criteria) this;
        }

        public Criteria andPayerIdLessThan(Integer value) {
            addCriterion("payer_id <", value, "payerId");
            return (Criteria) this;
        }

        public Criteria andPayerIdLessThanOrEqualTo(Integer value) {
            addCriterion("payer_id <=", value, "payerId");
            return (Criteria) this;
        }

        public Criteria andPayerIdIn(List<Integer> values) {
            addCriterion("payer_id in", values, "payerId");
            return (Criteria) this;
        }

        public Criteria andPayerIdNotIn(List<Integer> values) {
            addCriterion("payer_id not in", values, "payerId");
            return (Criteria) this;
        }

        public Criteria andPayerIdBetween(Integer value1, Integer value2) {
            addCriterion("payer_id between", value1, value2, "payerId");
            return (Criteria) this;
        }

        public Criteria andPayerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("payer_id not between", value1, value2, "payerId");
            return (Criteria) this;
        }

        public Criteria andReviewManagerIdIsNull() {
            addCriterion("review_manager_id is null");
            return (Criteria) this;
        }

        public Criteria andReviewManagerIdIsNotNull() {
            addCriterion("review_manager_id is not null");
            return (Criteria) this;
        }

        public Criteria andReviewManagerIdEqualTo(Integer value) {
            addCriterion("review_manager_id =", value, "reviewManagerId");
            return (Criteria) this;
        }

        public Criteria andReviewManagerIdNotEqualTo(Integer value) {
            addCriterion("review_manager_id <>", value, "reviewManagerId");
            return (Criteria) this;
        }

        public Criteria andReviewManagerIdGreaterThan(Integer value) {
            addCriterion("review_manager_id >", value, "reviewManagerId");
            return (Criteria) this;
        }

        public Criteria andReviewManagerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("review_manager_id >=", value, "reviewManagerId");
            return (Criteria) this;
        }

        public Criteria andReviewManagerIdLessThan(Integer value) {
            addCriterion("review_manager_id <", value, "reviewManagerId");
            return (Criteria) this;
        }

        public Criteria andReviewManagerIdLessThanOrEqualTo(Integer value) {
            addCriterion("review_manager_id <=", value, "reviewManagerId");
            return (Criteria) this;
        }

        public Criteria andReviewManagerIdIn(List<Integer> values) {
            addCriterion("review_manager_id in", values, "reviewManagerId");
            return (Criteria) this;
        }

        public Criteria andReviewManagerIdNotIn(List<Integer> values) {
            addCriterion("review_manager_id not in", values, "reviewManagerId");
            return (Criteria) this;
        }

        public Criteria andReviewManagerIdBetween(Integer value1, Integer value2) {
            addCriterion("review_manager_id between", value1, value2, "reviewManagerId");
            return (Criteria) this;
        }

        public Criteria andReviewManagerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("review_manager_id not between", value1, value2, "reviewManagerId");
            return (Criteria) this;
        }

        public Criteria andReviewStaffIdIsNull() {
            addCriterion("review_staff_id is null");
            return (Criteria) this;
        }

        public Criteria andReviewStaffIdIsNotNull() {
            addCriterion("review_staff_id is not null");
            return (Criteria) this;
        }

        public Criteria andReviewStaffIdEqualTo(Integer value) {
            addCriterion("review_staff_id =", value, "reviewStaffId");
            return (Criteria) this;
        }

        public Criteria andReviewStaffIdNotEqualTo(Integer value) {
            addCriterion("review_staff_id <>", value, "reviewStaffId");
            return (Criteria) this;
        }

        public Criteria andReviewStaffIdGreaterThan(Integer value) {
            addCriterion("review_staff_id >", value, "reviewStaffId");
            return (Criteria) this;
        }

        public Criteria andReviewStaffIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("review_staff_id >=", value, "reviewStaffId");
            return (Criteria) this;
        }

        public Criteria andReviewStaffIdLessThan(Integer value) {
            addCriterion("review_staff_id <", value, "reviewStaffId");
            return (Criteria) this;
        }

        public Criteria andReviewStaffIdLessThanOrEqualTo(Integer value) {
            addCriterion("review_staff_id <=", value, "reviewStaffId");
            return (Criteria) this;
        }

        public Criteria andReviewStaffIdIn(List<Integer> values) {
            addCriterion("review_staff_id in", values, "reviewStaffId");
            return (Criteria) this;
        }

        public Criteria andReviewStaffIdNotIn(List<Integer> values) {
            addCriterion("review_staff_id not in", values, "reviewStaffId");
            return (Criteria) this;
        }

        public Criteria andReviewStaffIdBetween(Integer value1, Integer value2) {
            addCriterion("review_staff_id between", value1, value2, "reviewStaffId");
            return (Criteria) this;
        }

        public Criteria andReviewStaffIdNotBetween(Integer value1, Integer value2) {
            addCriterion("review_staff_id not between", value1, value2, "reviewStaffId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(Integer value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(Integer value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(Integer value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(Integer value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(Integer value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<Integer> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<Integer> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(Integer value1, Integer value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andProofFilePathIsNull() {
            addCriterion("proof_file_path is null");
            return (Criteria) this;
        }

        public Criteria andProofFilePathIsNotNull() {
            addCriterion("proof_file_path is not null");
            return (Criteria) this;
        }

        public Criteria andProofFilePathEqualTo(String value) {
            addCriterion("proof_file_path =", value, "proofFilePath");
            return (Criteria) this;
        }

        public Criteria andProofFilePathNotEqualTo(String value) {
            addCriterion("proof_file_path <>", value, "proofFilePath");
            return (Criteria) this;
        }

        public Criteria andProofFilePathGreaterThan(String value) {
            addCriterion("proof_file_path >", value, "proofFilePath");
            return (Criteria) this;
        }

        public Criteria andProofFilePathGreaterThanOrEqualTo(String value) {
            addCriterion("proof_file_path >=", value, "proofFilePath");
            return (Criteria) this;
        }

        public Criteria andProofFilePathLessThan(String value) {
            addCriterion("proof_file_path <", value, "proofFilePath");
            return (Criteria) this;
        }

        public Criteria andProofFilePathLessThanOrEqualTo(String value) {
            addCriterion("proof_file_path <=", value, "proofFilePath");
            return (Criteria) this;
        }

        public Criteria andProofFilePathLike(String value) {
            addCriterion("proof_file_path like", value, "proofFilePath");
            return (Criteria) this;
        }

        public Criteria andProofFilePathNotLike(String value) {
            addCriterion("proof_file_path not like", value, "proofFilePath");
            return (Criteria) this;
        }

        public Criteria andProofFilePathIn(List<String> values) {
            addCriterion("proof_file_path in", values, "proofFilePath");
            return (Criteria) this;
        }

        public Criteria andProofFilePathNotIn(List<String> values) {
            addCriterion("proof_file_path not in", values, "proofFilePath");
            return (Criteria) this;
        }

        public Criteria andProofFilePathBetween(String value1, String value2) {
            addCriterion("proof_file_path between", value1, value2, "proofFilePath");
            return (Criteria) this;
        }

        public Criteria andProofFilePathNotBetween(String value1, String value2) {
            addCriterion("proof_file_path not between", value1, value2, "proofFilePath");
            return (Criteria) this;
        }

        public Criteria andCurPosIsNull() {
            addCriterion("cur_pos is null");
            return (Criteria) this;
        }

        public Criteria andCurPosIsNotNull() {
            addCriterion("cur_pos is not null");
            return (Criteria) this;
        }

        public Criteria andCurPosEqualTo(Integer value) {
            addCriterion("cur_pos =", value, "curPos");
            return (Criteria) this;
        }

        public Criteria andCurPosNotEqualTo(Integer value) {
            addCriterion("cur_pos <>", value, "curPos");
            return (Criteria) this;
        }

        public Criteria andCurPosGreaterThan(Integer value) {
            addCriterion("cur_pos >", value, "curPos");
            return (Criteria) this;
        }

        public Criteria andCurPosGreaterThanOrEqualTo(Integer value) {
            addCriterion("cur_pos >=", value, "curPos");
            return (Criteria) this;
        }

        public Criteria andCurPosLessThan(Integer value) {
            addCriterion("cur_pos <", value, "curPos");
            return (Criteria) this;
        }

        public Criteria andCurPosLessThanOrEqualTo(Integer value) {
            addCriterion("cur_pos <=", value, "curPos");
            return (Criteria) this;
        }

        public Criteria andCurPosIn(List<Integer> values) {
            addCriterion("cur_pos in", values, "curPos");
            return (Criteria) this;
        }

        public Criteria andCurPosNotIn(List<Integer> values) {
            addCriterion("cur_pos not in", values, "curPos");
            return (Criteria) this;
        }

        public Criteria andCurPosBetween(Integer value1, Integer value2) {
            addCriterion("cur_pos between", value1, value2, "curPos");
            return (Criteria) this;
        }

        public Criteria andCurPosNotBetween(Integer value1, Integer value2) {
            addCriterion("cur_pos not between", value1, value2, "curPos");
            return (Criteria) this;
        }

        public Criteria andReviewManagerTimeIsNull() {
            addCriterion("review_manager_time is null");
            return (Criteria) this;
        }

        public Criteria andReviewManagerTimeIsNotNull() {
            addCriterion("review_manager_time is not null");
            return (Criteria) this;
        }

        public Criteria andReviewManagerTimeEqualTo(LocalDateTime value) {
            addCriterion("review_manager_time =", value, "reviewManagerTime");
            return (Criteria) this;
        }

        public Criteria andReviewManagerTimeNotEqualTo(LocalDateTime value) {
            addCriterion("review_manager_time <>", value, "reviewManagerTime");
            return (Criteria) this;
        }

        public Criteria andReviewManagerTimeGreaterThan(LocalDateTime value) {
            addCriterion("review_manager_time >", value, "reviewManagerTime");
            return (Criteria) this;
        }

        public Criteria andReviewManagerTimeGreaterThanOrEqualTo(LocalDateTime value) {
            addCriterion("review_manager_time >=", value, "reviewManagerTime");
            return (Criteria) this;
        }

        public Criteria andReviewManagerTimeLessThan(LocalDateTime value) {
            addCriterion("review_manager_time <", value, "reviewManagerTime");
            return (Criteria) this;
        }

        public Criteria andReviewManagerTimeLessThanOrEqualTo(LocalDateTime value) {
            addCriterion("review_manager_time <=", value, "reviewManagerTime");
            return (Criteria) this;
        }

        public Criteria andReviewManagerTimeIn(List<LocalDateTime> values) {
            addCriterion("review_manager_time in", values, "reviewManagerTime");
            return (Criteria) this;
        }

        public Criteria andReviewManagerTimeNotIn(List<LocalDateTime> values) {
            addCriterion("review_manager_time not in", values, "reviewManagerTime");
            return (Criteria) this;
        }

        public Criteria andReviewManagerTimeBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("review_manager_time between", value1, value2, "reviewManagerTime");
            return (Criteria) this;
        }

        public Criteria andReviewManagerTimeNotBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("review_manager_time not between", value1, value2, "reviewManagerTime");
            return (Criteria) this;
        }

        public Criteria andReviewStaffTimeIsNull() {
            addCriterion("review_staff_time is null");
            return (Criteria) this;
        }

        public Criteria andReviewStaffTimeIsNotNull() {
            addCriterion("review_staff_time is not null");
            return (Criteria) this;
        }

        public Criteria andReviewStaffTimeEqualTo(LocalDateTime value) {
            addCriterion("review_staff_time =", value, "reviewStaffTime");
            return (Criteria) this;
        }

        public Criteria andReviewStaffTimeNotEqualTo(LocalDateTime value) {
            addCriterion("review_staff_time <>", value, "reviewStaffTime");
            return (Criteria) this;
        }

        public Criteria andReviewStaffTimeGreaterThan(LocalDateTime value) {
            addCriterion("review_staff_time >", value, "reviewStaffTime");
            return (Criteria) this;
        }

        public Criteria andReviewStaffTimeGreaterThanOrEqualTo(LocalDateTime value) {
            addCriterion("review_staff_time >=", value, "reviewStaffTime");
            return (Criteria) this;
        }

        public Criteria andReviewStaffTimeLessThan(LocalDateTime value) {
            addCriterion("review_staff_time <", value, "reviewStaffTime");
            return (Criteria) this;
        }

        public Criteria andReviewStaffTimeLessThanOrEqualTo(LocalDateTime value) {
            addCriterion("review_staff_time <=", value, "reviewStaffTime");
            return (Criteria) this;
        }

        public Criteria andReviewStaffTimeIn(List<LocalDateTime> values) {
            addCriterion("review_staff_time in", values, "reviewStaffTime");
            return (Criteria) this;
        }

        public Criteria andReviewStaffTimeNotIn(List<LocalDateTime> values) {
            addCriterion("review_staff_time not in", values, "reviewStaffTime");
            return (Criteria) this;
        }

        public Criteria andReviewStaffTimeBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("review_staff_time between", value1, value2, "reviewStaffTime");
            return (Criteria) this;
        }

        public Criteria andReviewStaffTimeNotBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("review_staff_time not between", value1, value2, "reviewStaffTime");
            return (Criteria) this;
        }

        public Criteria andPaybackTimeIsNull() {
            addCriterion("payback_time is null");
            return (Criteria) this;
        }

        public Criteria andPaybackTimeIsNotNull() {
            addCriterion("payback_time is not null");
            return (Criteria) this;
        }

        public Criteria andPaybackTimeEqualTo(LocalDateTime value) {
            addCriterion("payback_time =", value, "paybackTime");
            return (Criteria) this;
        }

        public Criteria andPaybackTimeNotEqualTo(LocalDateTime value) {
            addCriterion("payback_time <>", value, "paybackTime");
            return (Criteria) this;
        }

        public Criteria andPaybackTimeGreaterThan(LocalDateTime value) {
            addCriterion("payback_time >", value, "paybackTime");
            return (Criteria) this;
        }

        public Criteria andPaybackTimeGreaterThanOrEqualTo(LocalDateTime value) {
            addCriterion("payback_time >=", value, "paybackTime");
            return (Criteria) this;
        }

        public Criteria andPaybackTimeLessThan(LocalDateTime value) {
            addCriterion("payback_time <", value, "paybackTime");
            return (Criteria) this;
        }

        public Criteria andPaybackTimeLessThanOrEqualTo(LocalDateTime value) {
            addCriterion("payback_time <=", value, "paybackTime");
            return (Criteria) this;
        }

        public Criteria andPaybackTimeIn(List<LocalDateTime> values) {
            addCriterion("payback_time in", values, "paybackTime");
            return (Criteria) this;
        }

        public Criteria andPaybackTimeNotIn(List<LocalDateTime> values) {
            addCriterion("payback_time not in", values, "paybackTime");
            return (Criteria) this;
        }

        public Criteria andPaybackTimeBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("payback_time between", value1, value2, "paybackTime");
            return (Criteria) this;
        }

        public Criteria andPaybackTimeNotBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("payback_time not between", value1, value2, "paybackTime");
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