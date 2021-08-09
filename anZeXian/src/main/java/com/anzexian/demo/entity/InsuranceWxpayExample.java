package com.anzexian.demo.entity;

import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.List;

public class InsuranceWxpayExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public InsuranceWxpayExample() {
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

        public Criteria andOpenIdIsNull() {
            addCriterion("open_id is null");
            return (Criteria) this;
        }

        public Criteria andOpenIdIsNotNull() {
            addCriterion("open_id is not null");
            return (Criteria) this;
        }

        public Criteria andOpenIdEqualTo(String value) {
            addCriterion("open_id =", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotEqualTo(String value) {
            addCriterion("open_id <>", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdGreaterThan(String value) {
            addCriterion("open_id >", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdGreaterThanOrEqualTo(String value) {
            addCriterion("open_id >=", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdLessThan(String value) {
            addCriterion("open_id <", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdLessThanOrEqualTo(String value) {
            addCriterion("open_id <=", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdLike(String value) {
            addCriterion("open_id like", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotLike(String value) {
            addCriterion("open_id not like", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdIn(List<String> values) {
            addCriterion("open_id in", values, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotIn(List<String> values) {
            addCriterion("open_id not in", values, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdBetween(String value1, String value2) {
            addCriterion("open_id between", value1, value2, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotBetween(String value1, String value2) {
            addCriterion("open_id not between", value1, value2, "openId");
            return (Criteria) this;
        }

        public Criteria andAppIdIsNull() {
            addCriterion("app_id is null");
            return (Criteria) this;
        }

        public Criteria andAppIdIsNotNull() {
            addCriterion("app_id is not null");
            return (Criteria) this;
        }

        public Criteria andAppIdEqualTo(String value) {
            addCriterion("app_id =", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotEqualTo(String value) {
            addCriterion("app_id <>", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThan(String value) {
            addCriterion("app_id >", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThanOrEqualTo(String value) {
            addCriterion("app_id >=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThan(String value) {
            addCriterion("app_id <", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThanOrEqualTo(String value) {
            addCriterion("app_id <=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLike(String value) {
            addCriterion("app_id like", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotLike(String value) {
            addCriterion("app_id not like", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdIn(List<String> values) {
            addCriterion("app_id in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotIn(List<String> values) {
            addCriterion("app_id not in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdBetween(String value1, String value2) {
            addCriterion("app_id between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotBetween(String value1, String value2) {
            addCriterion("app_id not between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andMchIdIsNull() {
            addCriterion("mch_id is null");
            return (Criteria) this;
        }

        public Criteria andMchIdIsNotNull() {
            addCriterion("mch_id is not null");
            return (Criteria) this;
        }

        public Criteria andMchIdEqualTo(String value) {
            addCriterion("mch_id =", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdNotEqualTo(String value) {
            addCriterion("mch_id <>", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdGreaterThan(String value) {
            addCriterion("mch_id >", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdGreaterThanOrEqualTo(String value) {
            addCriterion("mch_id >=", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdLessThan(String value) {
            addCriterion("mch_id <", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdLessThanOrEqualTo(String value) {
            addCriterion("mch_id <=", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdLike(String value) {
            addCriterion("mch_id like", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdNotLike(String value) {
            addCriterion("mch_id not like", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdIn(List<String> values) {
            addCriterion("mch_id in", values, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdNotIn(List<String> values) {
            addCriterion("mch_id not in", values, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdBetween(String value1, String value2) {
            addCriterion("mch_id between", value1, value2, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdNotBetween(String value1, String value2) {
            addCriterion("mch_id not between", value1, value2, "mchId");
            return (Criteria) this;
        }

        public Criteria andNonceStrIsNull() {
            addCriterion("nonce_str is null");
            return (Criteria) this;
        }

        public Criteria andNonceStrIsNotNull() {
            addCriterion("nonce_str is not null");
            return (Criteria) this;
        }

        public Criteria andNonceStrEqualTo(String value) {
            addCriterion("nonce_str =", value, "nonceStr");
            return (Criteria) this;
        }

        public Criteria andNonceStrNotEqualTo(String value) {
            addCriterion("nonce_str <>", value, "nonceStr");
            return (Criteria) this;
        }

        public Criteria andNonceStrGreaterThan(String value) {
            addCriterion("nonce_str >", value, "nonceStr");
            return (Criteria) this;
        }

        public Criteria andNonceStrGreaterThanOrEqualTo(String value) {
            addCriterion("nonce_str >=", value, "nonceStr");
            return (Criteria) this;
        }

        public Criteria andNonceStrLessThan(String value) {
            addCriterion("nonce_str <", value, "nonceStr");
            return (Criteria) this;
        }

        public Criteria andNonceStrLessThanOrEqualTo(String value) {
            addCriterion("nonce_str <=", value, "nonceStr");
            return (Criteria) this;
        }

        public Criteria andNonceStrLike(String value) {
            addCriterion("nonce_str like", value, "nonceStr");
            return (Criteria) this;
        }

        public Criteria andNonceStrNotLike(String value) {
            addCriterion("nonce_str not like", value, "nonceStr");
            return (Criteria) this;
        }

        public Criteria andNonceStrIn(List<String> values) {
            addCriterion("nonce_str in", values, "nonceStr");
            return (Criteria) this;
        }

        public Criteria andNonceStrNotIn(List<String> values) {
            addCriterion("nonce_str not in", values, "nonceStr");
            return (Criteria) this;
        }

        public Criteria andNonceStrBetween(String value1, String value2) {
            addCriterion("nonce_str between", value1, value2, "nonceStr");
            return (Criteria) this;
        }

        public Criteria andNonceStrNotBetween(String value1, String value2) {
            addCriterion("nonce_str not between", value1, value2, "nonceStr");
            return (Criteria) this;
        }

        public Criteria andBodyIsNull() {
            addCriterion("body is null");
            return (Criteria) this;
        }

        public Criteria andBodyIsNotNull() {
            addCriterion("body is not null");
            return (Criteria) this;
        }

        public Criteria andBodyEqualTo(String value) {
            addCriterion("body =", value, "body");
            return (Criteria) this;
        }

        public Criteria andBodyNotEqualTo(String value) {
            addCriterion("body <>", value, "body");
            return (Criteria) this;
        }

        public Criteria andBodyGreaterThan(String value) {
            addCriterion("body >", value, "body");
            return (Criteria) this;
        }

        public Criteria andBodyGreaterThanOrEqualTo(String value) {
            addCriterion("body >=", value, "body");
            return (Criteria) this;
        }

        public Criteria andBodyLessThan(String value) {
            addCriterion("body <", value, "body");
            return (Criteria) this;
        }

        public Criteria andBodyLessThanOrEqualTo(String value) {
            addCriterion("body <=", value, "body");
            return (Criteria) this;
        }

        public Criteria andBodyLike(String value) {
            addCriterion("body like", value, "body");
            return (Criteria) this;
        }

        public Criteria andBodyNotLike(String value) {
            addCriterion("body not like", value, "body");
            return (Criteria) this;
        }

        public Criteria andBodyIn(List<String> values) {
            addCriterion("body in", values, "body");
            return (Criteria) this;
        }

        public Criteria andBodyNotIn(List<String> values) {
            addCriterion("body not in", values, "body");
            return (Criteria) this;
        }

        public Criteria andBodyBetween(String value1, String value2) {
            addCriterion("body between", value1, value2, "body");
            return (Criteria) this;
        }

        public Criteria andBodyNotBetween(String value1, String value2) {
            addCriterion("body not between", value1, value2, "body");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoIsNull() {
            addCriterion("out_trade_no is null");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoIsNotNull() {
            addCriterion("out_trade_no is not null");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoEqualTo(String value) {
            addCriterion("out_trade_no =", value, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoNotEqualTo(String value) {
            addCriterion("out_trade_no <>", value, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoGreaterThan(String value) {
            addCriterion("out_trade_no >", value, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoGreaterThanOrEqualTo(String value) {
            addCriterion("out_trade_no >=", value, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoLessThan(String value) {
            addCriterion("out_trade_no <", value, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoLessThanOrEqualTo(String value) {
            addCriterion("out_trade_no <=", value, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoLike(String value) {
            addCriterion("out_trade_no like", value, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoNotLike(String value) {
            addCriterion("out_trade_no not like", value, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoIn(List<String> values) {
            addCriterion("out_trade_no in", values, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoNotIn(List<String> values) {
            addCriterion("out_trade_no not in", values, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoBetween(String value1, String value2) {
            addCriterion("out_trade_no between", value1, value2, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoNotBetween(String value1, String value2) {
            addCriterion("out_trade_no not between", value1, value2, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andTotalFeeIsNull() {
            addCriterion("total_fee is null");
            return (Criteria) this;
        }

        public Criteria andTotalFeeIsNotNull() {
            addCriterion("total_fee is not null");
            return (Criteria) this;
        }

        public Criteria andTotalFeeEqualTo(String value) {
            addCriterion("total_fee =", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeNotEqualTo(String value) {
            addCriterion("total_fee <>", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeGreaterThan(String value) {
            addCriterion("total_fee >", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeGreaterThanOrEqualTo(String value) {
            addCriterion("total_fee >=", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeLessThan(String value) {
            addCriterion("total_fee <", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeLessThanOrEqualTo(String value) {
            addCriterion("total_fee <=", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeLike(String value) {
            addCriterion("total_fee like", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeNotLike(String value) {
            addCriterion("total_fee not like", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeIn(List<String> values) {
            addCriterion("total_fee in", values, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeNotIn(List<String> values) {
            addCriterion("total_fee not in", values, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeBetween(String value1, String value2) {
            addCriterion("total_fee between", value1, value2, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeNotBetween(String value1, String value2) {
            addCriterion("total_fee not between", value1, value2, "totalFee");
            return (Criteria) this;
        }

        public Criteria andSpbillCreateIpIsNull() {
            addCriterion("spbill_create_ip is null");
            return (Criteria) this;
        }

        public Criteria andSpbillCreateIpIsNotNull() {
            addCriterion("spbill_create_ip is not null");
            return (Criteria) this;
        }

        public Criteria andSpbillCreateIpEqualTo(String value) {
            addCriterion("spbill_create_ip =", value, "spbillCreateIp");
            return (Criteria) this;
        }

        public Criteria andSpbillCreateIpNotEqualTo(String value) {
            addCriterion("spbill_create_ip <>", value, "spbillCreateIp");
            return (Criteria) this;
        }

        public Criteria andSpbillCreateIpGreaterThan(String value) {
            addCriterion("spbill_create_ip >", value, "spbillCreateIp");
            return (Criteria) this;
        }

        public Criteria andSpbillCreateIpGreaterThanOrEqualTo(String value) {
            addCriterion("spbill_create_ip >=", value, "spbillCreateIp");
            return (Criteria) this;
        }

        public Criteria andSpbillCreateIpLessThan(String value) {
            addCriterion("spbill_create_ip <", value, "spbillCreateIp");
            return (Criteria) this;
        }

        public Criteria andSpbillCreateIpLessThanOrEqualTo(String value) {
            addCriterion("spbill_create_ip <=", value, "spbillCreateIp");
            return (Criteria) this;
        }

        public Criteria andSpbillCreateIpLike(String value) {
            addCriterion("spbill_create_ip like", value, "spbillCreateIp");
            return (Criteria) this;
        }

        public Criteria andSpbillCreateIpNotLike(String value) {
            addCriterion("spbill_create_ip not like", value, "spbillCreateIp");
            return (Criteria) this;
        }

        public Criteria andSpbillCreateIpIn(List<String> values) {
            addCriterion("spbill_create_ip in", values, "spbillCreateIp");
            return (Criteria) this;
        }

        public Criteria andSpbillCreateIpNotIn(List<String> values) {
            addCriterion("spbill_create_ip not in", values, "spbillCreateIp");
            return (Criteria) this;
        }

        public Criteria andSpbillCreateIpBetween(String value1, String value2) {
            addCriterion("spbill_create_ip between", value1, value2, "spbillCreateIp");
            return (Criteria) this;
        }

        public Criteria andSpbillCreateIpNotBetween(String value1, String value2) {
            addCriterion("spbill_create_ip not between", value1, value2, "spbillCreateIp");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlIsNull() {
            addCriterion("notify_url is null");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlIsNotNull() {
            addCriterion("notify_url is not null");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlEqualTo(String value) {
            addCriterion("notify_url =", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlNotEqualTo(String value) {
            addCriterion("notify_url <>", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlGreaterThan(String value) {
            addCriterion("notify_url >", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlGreaterThanOrEqualTo(String value) {
            addCriterion("notify_url >=", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlLessThan(String value) {
            addCriterion("notify_url <", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlLessThanOrEqualTo(String value) {
            addCriterion("notify_url <=", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlLike(String value) {
            addCriterion("notify_url like", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlNotLike(String value) {
            addCriterion("notify_url not like", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlIn(List<String> values) {
            addCriterion("notify_url in", values, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlNotIn(List<String> values) {
            addCriterion("notify_url not in", values, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlBetween(String value1, String value2) {
            addCriterion("notify_url between", value1, value2, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlNotBetween(String value1, String value2) {
            addCriterion("notify_url not between", value1, value2, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andTradeTypeIsNull() {
            addCriterion("trade_type is null");
            return (Criteria) this;
        }

        public Criteria andTradeTypeIsNotNull() {
            addCriterion("trade_type is not null");
            return (Criteria) this;
        }

        public Criteria andTradeTypeEqualTo(String value) {
            addCriterion("trade_type =", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeNotEqualTo(String value) {
            addCriterion("trade_type <>", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeGreaterThan(String value) {
            addCriterion("trade_type >", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeGreaterThanOrEqualTo(String value) {
            addCriterion("trade_type >=", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeLessThan(String value) {
            addCriterion("trade_type <", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeLessThanOrEqualTo(String value) {
            addCriterion("trade_type <=", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeLike(String value) {
            addCriterion("trade_type like", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeNotLike(String value) {
            addCriterion("trade_type not like", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeIn(List<String> values) {
            addCriterion("trade_type in", values, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeNotIn(List<String> values) {
            addCriterion("trade_type not in", values, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeBetween(String value1, String value2) {
            addCriterion("trade_type between", value1, value2, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeNotBetween(String value1, String value2) {
            addCriterion("trade_type not between", value1, value2, "tradeType");
            return (Criteria) this;
        }

        public Criteria andReturnCodeIsNull() {
            addCriterion("return_code is null");
            return (Criteria) this;
        }

        public Criteria andReturnCodeIsNotNull() {
            addCriterion("return_code is not null");
            return (Criteria) this;
        }

        public Criteria andReturnCodeEqualTo(String value) {
            addCriterion("return_code =", value, "returnCode");
            return (Criteria) this;
        }

        public Criteria andReturnCodeNotEqualTo(String value) {
            addCriterion("return_code <>", value, "returnCode");
            return (Criteria) this;
        }

        public Criteria andReturnCodeGreaterThan(String value) {
            addCriterion("return_code >", value, "returnCode");
            return (Criteria) this;
        }

        public Criteria andReturnCodeGreaterThanOrEqualTo(String value) {
            addCriterion("return_code >=", value, "returnCode");
            return (Criteria) this;
        }

        public Criteria andReturnCodeLessThan(String value) {
            addCriterion("return_code <", value, "returnCode");
            return (Criteria) this;
        }

        public Criteria andReturnCodeLessThanOrEqualTo(String value) {
            addCriterion("return_code <=", value, "returnCode");
            return (Criteria) this;
        }

        public Criteria andReturnCodeLike(String value) {
            addCriterion("return_code like", value, "returnCode");
            return (Criteria) this;
        }

        public Criteria andReturnCodeNotLike(String value) {
            addCriterion("return_code not like", value, "returnCode");
            return (Criteria) this;
        }

        public Criteria andReturnCodeIn(List<String> values) {
            addCriterion("return_code in", values, "returnCode");
            return (Criteria) this;
        }

        public Criteria andReturnCodeNotIn(List<String> values) {
            addCriterion("return_code not in", values, "returnCode");
            return (Criteria) this;
        }

        public Criteria andReturnCodeBetween(String value1, String value2) {
            addCriterion("return_code between", value1, value2, "returnCode");
            return (Criteria) this;
        }

        public Criteria andReturnCodeNotBetween(String value1, String value2) {
            addCriterion("return_code not between", value1, value2, "returnCode");
            return (Criteria) this;
        }

        public Criteria andResultCodeIsNull() {
            addCriterion("result_code is null");
            return (Criteria) this;
        }

        public Criteria andResultCodeIsNotNull() {
            addCriterion("result_code is not null");
            return (Criteria) this;
        }

        public Criteria andResultCodeEqualTo(String value) {
            addCriterion("result_code =", value, "resultCode");
            return (Criteria) this;
        }

        public Criteria andResultCodeNotEqualTo(String value) {
            addCriterion("result_code <>", value, "resultCode");
            return (Criteria) this;
        }

        public Criteria andResultCodeGreaterThan(String value) {
            addCriterion("result_code >", value, "resultCode");
            return (Criteria) this;
        }

        public Criteria andResultCodeGreaterThanOrEqualTo(String value) {
            addCriterion("result_code >=", value, "resultCode");
            return (Criteria) this;
        }

        public Criteria andResultCodeLessThan(String value) {
            addCriterion("result_code <", value, "resultCode");
            return (Criteria) this;
        }

        public Criteria andResultCodeLessThanOrEqualTo(String value) {
            addCriterion("result_code <=", value, "resultCode");
            return (Criteria) this;
        }

        public Criteria andResultCodeLike(String value) {
            addCriterion("result_code like", value, "resultCode");
            return (Criteria) this;
        }

        public Criteria andResultCodeNotLike(String value) {
            addCriterion("result_code not like", value, "resultCode");
            return (Criteria) this;
        }

        public Criteria andResultCodeIn(List<String> values) {
            addCriterion("result_code in", values, "resultCode");
            return (Criteria) this;
        }

        public Criteria andResultCodeNotIn(List<String> values) {
            addCriterion("result_code not in", values, "resultCode");
            return (Criteria) this;
        }

        public Criteria andResultCodeBetween(String value1, String value2) {
            addCriterion("result_code between", value1, value2, "resultCode");
            return (Criteria) this;
        }

        public Criteria andResultCodeNotBetween(String value1, String value2) {
            addCriterion("result_code not between", value1, value2, "resultCode");
            return (Criteria) this;
        }

        public Criteria andPrepayIdIsNull() {
            addCriterion("prepay_id is null");
            return (Criteria) this;
        }

        public Criteria andPrepayIdIsNotNull() {
            addCriterion("prepay_id is not null");
            return (Criteria) this;
        }

        public Criteria andPrepayIdEqualTo(String value) {
            addCriterion("prepay_id =", value, "prepayId");
            return (Criteria) this;
        }

        public Criteria andPrepayIdNotEqualTo(String value) {
            addCriterion("prepay_id <>", value, "prepayId");
            return (Criteria) this;
        }

        public Criteria andPrepayIdGreaterThan(String value) {
            addCriterion("prepay_id >", value, "prepayId");
            return (Criteria) this;
        }

        public Criteria andPrepayIdGreaterThanOrEqualTo(String value) {
            addCriterion("prepay_id >=", value, "prepayId");
            return (Criteria) this;
        }

        public Criteria andPrepayIdLessThan(String value) {
            addCriterion("prepay_id <", value, "prepayId");
            return (Criteria) this;
        }

        public Criteria andPrepayIdLessThanOrEqualTo(String value) {
            addCriterion("prepay_id <=", value, "prepayId");
            return (Criteria) this;
        }

        public Criteria andPrepayIdLike(String value) {
            addCriterion("prepay_id like", value, "prepayId");
            return (Criteria) this;
        }

        public Criteria andPrepayIdNotLike(String value) {
            addCriterion("prepay_id not like", value, "prepayId");
            return (Criteria) this;
        }

        public Criteria andPrepayIdIn(List<String> values) {
            addCriterion("prepay_id in", values, "prepayId");
            return (Criteria) this;
        }

        public Criteria andPrepayIdNotIn(List<String> values) {
            addCriterion("prepay_id not in", values, "prepayId");
            return (Criteria) this;
        }

        public Criteria andPrepayIdBetween(String value1, String value2) {
            addCriterion("prepay_id between", value1, value2, "prepayId");
            return (Criteria) this;
        }

        public Criteria andPrepayIdNotBetween(String value1, String value2) {
            addCriterion("prepay_id not between", value1, value2, "prepayId");
            return (Criteria) this;
        }

        public Criteria andSignTypeIsNull() {
            addCriterion("sign_type is null");
            return (Criteria) this;
        }

        public Criteria andSignTypeIsNotNull() {
            addCriterion("sign_type is not null");
            return (Criteria) this;
        }

        public Criteria andSignTypeEqualTo(String value) {
            addCriterion("sign_type =", value, "signType");
            return (Criteria) this;
        }

        public Criteria andSignTypeNotEqualTo(String value) {
            addCriterion("sign_type <>", value, "signType");
            return (Criteria) this;
        }

        public Criteria andSignTypeGreaterThan(String value) {
            addCriterion("sign_type >", value, "signType");
            return (Criteria) this;
        }

        public Criteria andSignTypeGreaterThanOrEqualTo(String value) {
            addCriterion("sign_type >=", value, "signType");
            return (Criteria) this;
        }

        public Criteria andSignTypeLessThan(String value) {
            addCriterion("sign_type <", value, "signType");
            return (Criteria) this;
        }

        public Criteria andSignTypeLessThanOrEqualTo(String value) {
            addCriterion("sign_type <=", value, "signType");
            return (Criteria) this;
        }

        public Criteria andSignTypeLike(String value) {
            addCriterion("sign_type like", value, "signType");
            return (Criteria) this;
        }

        public Criteria andSignTypeNotLike(String value) {
            addCriterion("sign_type not like", value, "signType");
            return (Criteria) this;
        }

        public Criteria andSignTypeIn(List<String> values) {
            addCriterion("sign_type in", values, "signType");
            return (Criteria) this;
        }

        public Criteria andSignTypeNotIn(List<String> values) {
            addCriterion("sign_type not in", values, "signType");
            return (Criteria) this;
        }

        public Criteria andSignTypeBetween(String value1, String value2) {
            addCriterion("sign_type between", value1, value2, "signType");
            return (Criteria) this;
        }

        public Criteria andSignTypeNotBetween(String value1, String value2) {
            addCriterion("sign_type not between", value1, value2, "signType");
            return (Criteria) this;
        }

        public Criteria andTimeStampIsNull() {
            addCriterion("time_stamp is null");
            return (Criteria) this;
        }

        public Criteria andTimeStampIsNotNull() {
            addCriterion("time_stamp is not null");
            return (Criteria) this;
        }

        public Criteria andTimeStampEqualTo(String value) {
            addCriterion("time_stamp =", value, "timeStamp");
            return (Criteria) this;
        }

        public Criteria andTimeStampNotEqualTo(String value) {
            addCriterion("time_stamp <>", value, "timeStamp");
            return (Criteria) this;
        }

        public Criteria andTimeStampGreaterThan(String value) {
            addCriterion("time_stamp >", value, "timeStamp");
            return (Criteria) this;
        }

        public Criteria andTimeStampGreaterThanOrEqualTo(String value) {
            addCriterion("time_stamp >=", value, "timeStamp");
            return (Criteria) this;
        }

        public Criteria andTimeStampLessThan(String value) {
            addCriterion("time_stamp <", value, "timeStamp");
            return (Criteria) this;
        }

        public Criteria andTimeStampLessThanOrEqualTo(String value) {
            addCriterion("time_stamp <=", value, "timeStamp");
            return (Criteria) this;
        }

        public Criteria andTimeStampLike(String value) {
            addCriterion("time_stamp like", value, "timeStamp");
            return (Criteria) this;
        }

        public Criteria andTimeStampNotLike(String value) {
            addCriterion("time_stamp not like", value, "timeStamp");
            return (Criteria) this;
        }

        public Criteria andTimeStampIn(List<String> values) {
            addCriterion("time_stamp in", values, "timeStamp");
            return (Criteria) this;
        }

        public Criteria andTimeStampNotIn(List<String> values) {
            addCriterion("time_stamp not in", values, "timeStamp");
            return (Criteria) this;
        }

        public Criteria andTimeStampBetween(String value1, String value2) {
            addCriterion("time_stamp between", value1, value2, "timeStamp");
            return (Criteria) this;
        }

        public Criteria andTimeStampNotBetween(String value1, String value2) {
            addCriterion("time_stamp not between", value1, value2, "timeStamp");
            return (Criteria) this;
        }

        public Criteria andPaySignIsNull() {
            addCriterion("pay_sign is null");
            return (Criteria) this;
        }

        public Criteria andPaySignIsNotNull() {
            addCriterion("pay_sign is not null");
            return (Criteria) this;
        }

        public Criteria andPaySignEqualTo(String value) {
            addCriterion("pay_sign =", value, "paySign");
            return (Criteria) this;
        }

        public Criteria andPaySignNotEqualTo(String value) {
            addCriterion("pay_sign <>", value, "paySign");
            return (Criteria) this;
        }

        public Criteria andPaySignGreaterThan(String value) {
            addCriterion("pay_sign >", value, "paySign");
            return (Criteria) this;
        }

        public Criteria andPaySignGreaterThanOrEqualTo(String value) {
            addCriterion("pay_sign >=", value, "paySign");
            return (Criteria) this;
        }

        public Criteria andPaySignLessThan(String value) {
            addCriterion("pay_sign <", value, "paySign");
            return (Criteria) this;
        }

        public Criteria andPaySignLessThanOrEqualTo(String value) {
            addCriterion("pay_sign <=", value, "paySign");
            return (Criteria) this;
        }

        public Criteria andPaySignLike(String value) {
            addCriterion("pay_sign like", value, "paySign");
            return (Criteria) this;
        }

        public Criteria andPaySignNotLike(String value) {
            addCriterion("pay_sign not like", value, "paySign");
            return (Criteria) this;
        }

        public Criteria andPaySignIn(List<String> values) {
            addCriterion("pay_sign in", values, "paySign");
            return (Criteria) this;
        }

        public Criteria andPaySignNotIn(List<String> values) {
            addCriterion("pay_sign not in", values, "paySign");
            return (Criteria) this;
        }

        public Criteria andPaySignBetween(String value1, String value2) {
            addCriterion("pay_sign between", value1, value2, "paySign");
            return (Criteria) this;
        }

        public Criteria andPaySignNotBetween(String value1, String value2) {
            addCriterion("pay_sign not between", value1, value2, "paySign");
            return (Criteria) this;
        }

        public Criteria andUnifiedorderSucceedIsNull() {
            addCriterion("unifiedorder_succeed is null");
            return (Criteria) this;
        }

        public Criteria andUnifiedorderSucceedIsNotNull() {
            addCriterion("unifiedorder_succeed is not null");
            return (Criteria) this;
        }

        public Criteria andUnifiedorderSucceedEqualTo(Boolean value) {
            addCriterion("unifiedorder_succeed =", value, "unifiedorderSucceed");
            return (Criteria) this;
        }

        public Criteria andUnifiedorderSucceedNotEqualTo(Boolean value) {
            addCriterion("unifiedorder_succeed <>", value, "unifiedorderSucceed");
            return (Criteria) this;
        }

        public Criteria andUnifiedorderSucceedGreaterThan(Boolean value) {
            addCriterion("unifiedorder_succeed >", value, "unifiedorderSucceed");
            return (Criteria) this;
        }

        public Criteria andUnifiedorderSucceedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("unifiedorder_succeed >=", value, "unifiedorderSucceed");
            return (Criteria) this;
        }

        public Criteria andUnifiedorderSucceedLessThan(Boolean value) {
            addCriterion("unifiedorder_succeed <", value, "unifiedorderSucceed");
            return (Criteria) this;
        }

        public Criteria andUnifiedorderSucceedLessThanOrEqualTo(Boolean value) {
            addCriterion("unifiedorder_succeed <=", value, "unifiedorderSucceed");
            return (Criteria) this;
        }

        public Criteria andUnifiedorderSucceedIn(List<Boolean> values) {
            addCriterion("unifiedorder_succeed in", values, "unifiedorderSucceed");
            return (Criteria) this;
        }

        public Criteria andUnifiedorderSucceedNotIn(List<Boolean> values) {
            addCriterion("unifiedorder_succeed not in", values, "unifiedorderSucceed");
            return (Criteria) this;
        }

        public Criteria andUnifiedorderSucceedBetween(Boolean value1, Boolean value2) {
            addCriterion("unifiedorder_succeed between", value1, value2, "unifiedorderSucceed");
            return (Criteria) this;
        }

        public Criteria andUnifiedorderSucceedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("unifiedorder_succeed not between", value1, value2, "unifiedorderSucceed");
            return (Criteria) this;
        }

        public Criteria andPaySucceedIsNull() {
            addCriterion("pay_succeed is null");
            return (Criteria) this;
        }

        public Criteria andPaySucceedIsNotNull() {
            addCriterion("pay_succeed is not null");
            return (Criteria) this;
        }

        public Criteria andPaySucceedEqualTo(Boolean value) {
            addCriterion("pay_succeed =", value, "paySucceed");
            return (Criteria) this;
        }

        public Criteria andPaySucceedNotEqualTo(Boolean value) {
            addCriterion("pay_succeed <>", value, "paySucceed");
            return (Criteria) this;
        }

        public Criteria andPaySucceedGreaterThan(Boolean value) {
            addCriterion("pay_succeed >", value, "paySucceed");
            return (Criteria) this;
        }

        public Criteria andPaySucceedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("pay_succeed >=", value, "paySucceed");
            return (Criteria) this;
        }

        public Criteria andPaySucceedLessThan(Boolean value) {
            addCriterion("pay_succeed <", value, "paySucceed");
            return (Criteria) this;
        }

        public Criteria andPaySucceedLessThanOrEqualTo(Boolean value) {
            addCriterion("pay_succeed <=", value, "paySucceed");
            return (Criteria) this;
        }

        public Criteria andPaySucceedIn(List<Boolean> values) {
            addCriterion("pay_succeed in", values, "paySucceed");
            return (Criteria) this;
        }

        public Criteria andPaySucceedNotIn(List<Boolean> values) {
            addCriterion("pay_succeed not in", values, "paySucceed");
            return (Criteria) this;
        }

        public Criteria andPaySucceedBetween(Boolean value1, Boolean value2) {
            addCriterion("pay_succeed between", value1, value2, "paySucceed");
            return (Criteria) this;
        }

        public Criteria andPaySucceedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("pay_succeed not between", value1, value2, "paySucceed");
            return (Criteria) this;
        }

        public Criteria andUnifiedorderTimeIsNull() {
            addCriterion("unifiedOrder_time is null");
            return (Criteria) this;
        }

        public Criteria andUnifiedorderTimeIsNotNull() {
            addCriterion("unifiedOrder_time is not null");
            return (Criteria) this;
        }

        public Criteria andUnifiedorderTimeEqualTo(LocalDateTime value) {
            addCriterion("unifiedOrder_time =", value, "unifiedorderTime");
            return (Criteria) this;
        }

        public Criteria andUnifiedorderTimeNotEqualTo(LocalDateTime value) {
            addCriterion("unifiedOrder_time <>", value, "unifiedorderTime");
            return (Criteria) this;
        }

        public Criteria andUnifiedorderTimeGreaterThan(LocalDateTime value) {
            addCriterion("unifiedOrder_time >", value, "unifiedorderTime");
            return (Criteria) this;
        }

        public Criteria andUnifiedorderTimeGreaterThanOrEqualTo(LocalDateTime value) {
            addCriterion("unifiedOrder_time >=", value, "unifiedorderTime");
            return (Criteria) this;
        }

        public Criteria andUnifiedorderTimeLessThan(LocalDateTime value) {
            addCriterion("unifiedOrder_time <", value, "unifiedorderTime");
            return (Criteria) this;
        }

        public Criteria andUnifiedorderTimeLessThanOrEqualTo(LocalDateTime value) {
            addCriterion("unifiedOrder_time <=", value, "unifiedorderTime");
            return (Criteria) this;
        }

        public Criteria andUnifiedorderTimeIn(List<LocalDateTime> values) {
            addCriterion("unifiedOrder_time in", values, "unifiedorderTime");
            return (Criteria) this;
        }

        public Criteria andUnifiedorderTimeNotIn(List<LocalDateTime> values) {
            addCriterion("unifiedOrder_time not in", values, "unifiedorderTime");
            return (Criteria) this;
        }

        public Criteria andUnifiedorderTimeBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("unifiedOrder_time between", value1, value2, "unifiedorderTime");
            return (Criteria) this;
        }

        public Criteria andUnifiedorderTimeNotBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("unifiedOrder_time not between", value1, value2, "unifiedorderTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeIsNull() {
            addCriterion("pay_time is null");
            return (Criteria) this;
        }

        public Criteria andPayTimeIsNotNull() {
            addCriterion("pay_time is not null");
            return (Criteria) this;
        }

        public Criteria andPayTimeEqualTo(LocalDateTime value) {
            addCriterion("pay_time =", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotEqualTo(LocalDateTime value) {
            addCriterion("pay_time <>", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeGreaterThan(LocalDateTime value) {
            addCriterion("pay_time >", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeGreaterThanOrEqualTo(LocalDateTime value) {
            addCriterion("pay_time >=", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeLessThan(LocalDateTime value) {
            addCriterion("pay_time <", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeLessThanOrEqualTo(LocalDateTime value) {
            addCriterion("pay_time <=", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeIn(List<LocalDateTime> values) {
            addCriterion("pay_time in", values, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotIn(List<LocalDateTime> values) {
            addCriterion("pay_time not in", values, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("pay_time between", value1, value2, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("pay_time not between", value1, value2, "payTime");
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