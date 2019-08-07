package cn.com.itcast.recon.dao.model.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class OuterBillDoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OuterBillDoExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andReconDateIsNull() {
            addCriterion("recon_date is null");
            return (Criteria) this;
        }

        public Criteria andReconDateIsNotNull() {
            addCriterion("recon_date is not null");
            return (Criteria) this;
        }

        public Criteria andReconDateEqualTo(Date value) {
            addCriterionForJDBCDate("recon_date =", value, "reconDate");
            return (Criteria) this;
        }

        public Criteria andReconDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("recon_date <>", value, "reconDate");
            return (Criteria) this;
        }

        public Criteria andReconDateGreaterThan(Date value) {
            addCriterionForJDBCDate("recon_date >", value, "reconDate");
            return (Criteria) this;
        }

        public Criteria andReconDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("recon_date >=", value, "reconDate");
            return (Criteria) this;
        }

        public Criteria andReconDateLessThan(Date value) {
            addCriterionForJDBCDate("recon_date <", value, "reconDate");
            return (Criteria) this;
        }

        public Criteria andReconDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("recon_date <=", value, "reconDate");
            return (Criteria) this;
        }

        public Criteria andReconDateIn(List<Date> values) {
            addCriterionForJDBCDate("recon_date in", values, "reconDate");
            return (Criteria) this;
        }

        public Criteria andReconDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("recon_date not in", values, "reconDate");
            return (Criteria) this;
        }

        public Criteria andReconDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("recon_date between", value1, value2, "reconDate");
            return (Criteria) this;
        }

        public Criteria andReconDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("recon_date not between", value1, value2, "reconDate");
            return (Criteria) this;
        }

        public Criteria andReconStatusIsNull() {
            addCriterion("recon_status is null");
            return (Criteria) this;
        }

        public Criteria andReconStatusIsNotNull() {
            addCriterion("recon_status is not null");
            return (Criteria) this;
        }

        public Criteria andReconStatusEqualTo(String value) {
            addCriterion("recon_status =", value, "reconStatus");
            return (Criteria) this;
        }

        public Criteria andReconStatusNotEqualTo(String value) {
            addCriterion("recon_status <>", value, "reconStatus");
            return (Criteria) this;
        }

        public Criteria andReconStatusGreaterThan(String value) {
            addCriterion("recon_status >", value, "reconStatus");
            return (Criteria) this;
        }

        public Criteria andReconStatusGreaterThanOrEqualTo(String value) {
            addCriterion("recon_status >=", value, "reconStatus");
            return (Criteria) this;
        }

        public Criteria andReconStatusLessThan(String value) {
            addCriterion("recon_status <", value, "reconStatus");
            return (Criteria) this;
        }

        public Criteria andReconStatusLessThanOrEqualTo(String value) {
            addCriterion("recon_status <=", value, "reconStatus");
            return (Criteria) this;
        }

        public Criteria andReconStatusLike(String value) {
            addCriterion("recon_status like", value, "reconStatus");
            return (Criteria) this;
        }

        public Criteria andReconStatusNotLike(String value) {
            addCriterion("recon_status not like", value, "reconStatus");
            return (Criteria) this;
        }

        public Criteria andReconStatusIn(List<String> values) {
            addCriterion("recon_status in", values, "reconStatus");
            return (Criteria) this;
        }

        public Criteria andReconStatusNotIn(List<String> values) {
            addCriterion("recon_status not in", values, "reconStatus");
            return (Criteria) this;
        }

        public Criteria andReconStatusBetween(String value1, String value2) {
            addCriterion("recon_status between", value1, value2, "reconStatus");
            return (Criteria) this;
        }

        public Criteria andReconStatusNotBetween(String value1, String value2) {
            addCriterion("recon_status not between", value1, value2, "reconStatus");
            return (Criteria) this;
        }

        public Criteria andAmountIsNull() {
            addCriterion("amount is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("amount is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(BigDecimal value) {
            addCriterion("amount =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(BigDecimal value) {
            addCriterion("amount <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(BigDecimal value) {
            addCriterion("amount >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("amount >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(BigDecimal value) {
            addCriterion("amount <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("amount <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<BigDecimal> values) {
            addCriterion("amount in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<BigDecimal> values) {
            addCriterion("amount not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amount between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amount not between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andTradeStatusIsNull() {
            addCriterion("trade_status is null");
            return (Criteria) this;
        }

        public Criteria andTradeStatusIsNotNull() {
            addCriterion("trade_status is not null");
            return (Criteria) this;
        }

        public Criteria andTradeStatusEqualTo(String value) {
            addCriterion("trade_status =", value, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusNotEqualTo(String value) {
            addCriterion("trade_status <>", value, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusGreaterThan(String value) {
            addCriterion("trade_status >", value, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusGreaterThanOrEqualTo(String value) {
            addCriterion("trade_status >=", value, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusLessThan(String value) {
            addCriterion("trade_status <", value, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusLessThanOrEqualTo(String value) {
            addCriterion("trade_status <=", value, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusLike(String value) {
            addCriterion("trade_status like", value, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusNotLike(String value) {
            addCriterion("trade_status not like", value, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusIn(List<String> values) {
            addCriterion("trade_status in", values, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusNotIn(List<String> values) {
            addCriterion("trade_status not in", values, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusBetween(String value1, String value2) {
            addCriterion("trade_status between", value1, value2, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusNotBetween(String value1, String value2) {
            addCriterion("trade_status not between", value1, value2, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andOuterBillNoIsNull() {
            addCriterion("outer_bill_no is null");
            return (Criteria) this;
        }

        public Criteria andOuterBillNoIsNotNull() {
            addCriterion("outer_bill_no is not null");
            return (Criteria) this;
        }

        public Criteria andOuterBillNoEqualTo(String value) {
            addCriterion("outer_bill_no =", value, "outerBillNo");
            return (Criteria) this;
        }

        public Criteria andOuterBillNoNotEqualTo(String value) {
            addCriterion("outer_bill_no <>", value, "outerBillNo");
            return (Criteria) this;
        }

        public Criteria andOuterBillNoGreaterThan(String value) {
            addCriterion("outer_bill_no >", value, "outerBillNo");
            return (Criteria) this;
        }

        public Criteria andOuterBillNoGreaterThanOrEqualTo(String value) {
            addCriterion("outer_bill_no >=", value, "outerBillNo");
            return (Criteria) this;
        }

        public Criteria andOuterBillNoLessThan(String value) {
            addCriterion("outer_bill_no <", value, "outerBillNo");
            return (Criteria) this;
        }

        public Criteria andOuterBillNoLessThanOrEqualTo(String value) {
            addCriterion("outer_bill_no <=", value, "outerBillNo");
            return (Criteria) this;
        }

        public Criteria andOuterBillNoLike(String value) {
            addCriterion("outer_bill_no like", value, "outerBillNo");
            return (Criteria) this;
        }

        public Criteria andOuterBillNoNotLike(String value) {
            addCriterion("outer_bill_no not like", value, "outerBillNo");
            return (Criteria) this;
        }

        public Criteria andOuterBillNoIn(List<String> values) {
            addCriterion("outer_bill_no in", values, "outerBillNo");
            return (Criteria) this;
        }

        public Criteria andOuterBillNoNotIn(List<String> values) {
            addCriterion("outer_bill_no not in", values, "outerBillNo");
            return (Criteria) this;
        }

        public Criteria andOuterBillNoBetween(String value1, String value2) {
            addCriterion("outer_bill_no between", value1, value2, "outerBillNo");
            return (Criteria) this;
        }

        public Criteria andOuterBillNoNotBetween(String value1, String value2) {
            addCriterion("outer_bill_no not between", value1, value2, "outerBillNo");
            return (Criteria) this;
        }

        public Criteria andOuterNoIsNull() {
            addCriterion("outer_no is null");
            return (Criteria) this;
        }

        public Criteria andOuterNoIsNotNull() {
            addCriterion("outer_no is not null");
            return (Criteria) this;
        }

        public Criteria andOuterNoEqualTo(String value) {
            addCriterion("outer_no =", value, "outerNo");
            return (Criteria) this;
        }

        public Criteria andOuterNoNotEqualTo(String value) {
            addCriterion("outer_no <>", value, "outerNo");
            return (Criteria) this;
        }

        public Criteria andOuterNoGreaterThan(String value) {
            addCriterion("outer_no >", value, "outerNo");
            return (Criteria) this;
        }

        public Criteria andOuterNoGreaterThanOrEqualTo(String value) {
            addCriterion("outer_no >=", value, "outerNo");
            return (Criteria) this;
        }

        public Criteria andOuterNoLessThan(String value) {
            addCriterion("outer_no <", value, "outerNo");
            return (Criteria) this;
        }

        public Criteria andOuterNoLessThanOrEqualTo(String value) {
            addCriterion("outer_no <=", value, "outerNo");
            return (Criteria) this;
        }

        public Criteria andOuterNoLike(String value) {
            addCriterion("outer_no like", value, "outerNo");
            return (Criteria) this;
        }

        public Criteria andOuterNoNotLike(String value) {
            addCriterion("outer_no not like", value, "outerNo");
            return (Criteria) this;
        }

        public Criteria andOuterNoIn(List<String> values) {
            addCriterion("outer_no in", values, "outerNo");
            return (Criteria) this;
        }

        public Criteria andOuterNoNotIn(List<String> values) {
            addCriterion("outer_no not in", values, "outerNo");
            return (Criteria) this;
        }

        public Criteria andOuterNoBetween(String value1, String value2) {
            addCriterion("outer_no between", value1, value2, "outerNo");
            return (Criteria) this;
        }

        public Criteria andOuterNoNotBetween(String value1, String value2) {
            addCriterion("outer_no not between", value1, value2, "outerNo");
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

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNull() {
            addCriterion("modify_time is null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNotNull() {
            addCriterion("modify_time is not null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeEqualTo(Date value) {
            addCriterion("modify_time =", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotEqualTo(Date value) {
            addCriterion("modify_time <>", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThan(Date value) {
            addCriterion("modify_time >", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("modify_time >=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThan(Date value) {
            addCriterion("modify_time <", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThanOrEqualTo(Date value) {
            addCriterion("modify_time <=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIn(List<Date> values) {
            addCriterion("modify_time in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotIn(List<Date> values) {
            addCriterion("modify_time not in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeBetween(Date value1, Date value2) {
            addCriterion("modify_time between", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotBetween(Date value1, Date value2) {
            addCriterion("modify_time not between", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
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