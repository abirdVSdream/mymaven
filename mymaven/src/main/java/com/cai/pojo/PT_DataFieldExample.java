package com.cai.pojo;

import java.util.ArrayList;
import java.util.List;

public class PT_DataFieldExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PT_DataFieldExample() {
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

        public Criteria andDatafieldboIsNull() {
            addCriterion("datafieldBo is null");
            return (Criteria) this;
        }

        public Criteria andDatafieldboIsNotNull() {
            addCriterion("datafieldBo is not null");
            return (Criteria) this;
        }

        public Criteria andDatafieldboEqualTo(String value) {
            addCriterion("datafieldBo =", value, "datafieldbo");
            return (Criteria) this;
        }

        public Criteria andDatafieldboNotEqualTo(String value) {
            addCriterion("datafieldBo <>", value, "datafieldbo");
            return (Criteria) this;
        }

        public Criteria andDatafieldboGreaterThan(String value) {
            addCriterion("datafieldBo >", value, "datafieldbo");
            return (Criteria) this;
        }

        public Criteria andDatafieldboGreaterThanOrEqualTo(String value) {
            addCriterion("datafieldBo >=", value, "datafieldbo");
            return (Criteria) this;
        }

        public Criteria andDatafieldboLessThan(String value) {
            addCriterion("datafieldBo <", value, "datafieldbo");
            return (Criteria) this;
        }

        public Criteria andDatafieldboLessThanOrEqualTo(String value) {
            addCriterion("datafieldBo <=", value, "datafieldbo");
            return (Criteria) this;
        }

        public Criteria andDatafieldboLike(String value) {
            addCriterion("datafieldBo like", value, "datafieldbo");
            return (Criteria) this;
        }

        public Criteria andDatafieldboNotLike(String value) {
            addCriterion("datafieldBo not like", value, "datafieldbo");
            return (Criteria) this;
        }

        public Criteria andDatafieldboIn(List<String> values) {
            addCriterion("datafieldBo in", values, "datafieldbo");
            return (Criteria) this;
        }

        public Criteria andDatafieldboNotIn(List<String> values) {
            addCriterion("datafieldBo not in", values, "datafieldbo");
            return (Criteria) this;
        }

        public Criteria andDatafieldboBetween(String value1, String value2) {
            addCriterion("datafieldBo between", value1, value2, "datafieldbo");
            return (Criteria) this;
        }

        public Criteria andDatafieldboNotBetween(String value1, String value2) {
            addCriterion("datafieldBo not between", value1, value2, "datafieldbo");
            return (Criteria) this;
        }

        public Criteria andDatafieldIsNull() {
            addCriterion("datafield is null");
            return (Criteria) this;
        }

        public Criteria andDatafieldIsNotNull() {
            addCriterion("datafield is not null");
            return (Criteria) this;
        }

        public Criteria andDatafieldEqualTo(String value) {
            addCriterion("datafield =", value, "datafield");
            return (Criteria) this;
        }

        public Criteria andDatafieldNotEqualTo(String value) {
            addCriterion("datafield <>", value, "datafield");
            return (Criteria) this;
        }

        public Criteria andDatafieldGreaterThan(String value) {
            addCriterion("datafield >", value, "datafield");
            return (Criteria) this;
        }

        public Criteria andDatafieldGreaterThanOrEqualTo(String value) {
            addCriterion("datafield >=", value, "datafield");
            return (Criteria) this;
        }

        public Criteria andDatafieldLessThan(String value) {
            addCriterion("datafield <", value, "datafield");
            return (Criteria) this;
        }

        public Criteria andDatafieldLessThanOrEqualTo(String value) {
            addCriterion("datafield <=", value, "datafield");
            return (Criteria) this;
        }

        public Criteria andDatafieldLike(String value) {
            addCriterion("datafield like", value, "datafield");
            return (Criteria) this;
        }

        public Criteria andDatafieldNotLike(String value) {
            addCriterion("datafield not like", value, "datafield");
            return (Criteria) this;
        }

        public Criteria andDatafieldIn(List<String> values) {
            addCriterion("datafield in", values, "datafield");
            return (Criteria) this;
        }

        public Criteria andDatafieldNotIn(List<String> values) {
            addCriterion("datafield not in", values, "datafield");
            return (Criteria) this;
        }

        public Criteria andDatafieldBetween(String value1, String value2) {
            addCriterion("datafield between", value1, value2, "datafield");
            return (Criteria) this;
        }

        public Criteria andDatafieldNotBetween(String value1, String value2) {
            addCriterion("datafield not between", value1, value2, "datafield");
            return (Criteria) this;
        }

        public Criteria andDatatagIsNull() {
            addCriterion("dataTag is null");
            return (Criteria) this;
        }

        public Criteria andDatatagIsNotNull() {
            addCriterion("dataTag is not null");
            return (Criteria) this;
        }

        public Criteria andDatatagEqualTo(String value) {
            addCriterion("dataTag =", value, "datatag");
            return (Criteria) this;
        }

        public Criteria andDatatagNotEqualTo(String value) {
            addCriterion("dataTag <>", value, "datatag");
            return (Criteria) this;
        }

        public Criteria andDatatagGreaterThan(String value) {
            addCriterion("dataTag >", value, "datatag");
            return (Criteria) this;
        }

        public Criteria andDatatagGreaterThanOrEqualTo(String value) {
            addCriterion("dataTag >=", value, "datatag");
            return (Criteria) this;
        }

        public Criteria andDatatagLessThan(String value) {
            addCriterion("dataTag <", value, "datatag");
            return (Criteria) this;
        }

        public Criteria andDatatagLessThanOrEqualTo(String value) {
            addCriterion("dataTag <=", value, "datatag");
            return (Criteria) this;
        }

        public Criteria andDatatagLike(String value) {
            addCriterion("dataTag like", value, "datatag");
            return (Criteria) this;
        }

        public Criteria andDatatagNotLike(String value) {
            addCriterion("dataTag not like", value, "datatag");
            return (Criteria) this;
        }

        public Criteria andDatatagIn(List<String> values) {
            addCriterion("dataTag in", values, "datatag");
            return (Criteria) this;
        }

        public Criteria andDatatagNotIn(List<String> values) {
            addCriterion("dataTag not in", values, "datatag");
            return (Criteria) this;
        }

        public Criteria andDatatagBetween(String value1, String value2) {
            addCriterion("dataTag between", value1, value2, "datatag");
            return (Criteria) this;
        }

        public Criteria andDatatagNotBetween(String value1, String value2) {
            addCriterion("dataTag not between", value1, value2, "datatag");
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

        public Criteria andFieldtypeIsNull() {
            addCriterion("fieldType is null");
            return (Criteria) this;
        }

        public Criteria andFieldtypeIsNotNull() {
            addCriterion("fieldType is not null");
            return (Criteria) this;
        }

        public Criteria andFieldtypeEqualTo(String value) {
            addCriterion("fieldType =", value, "fieldtype");
            return (Criteria) this;
        }

        public Criteria andFieldtypeNotEqualTo(String value) {
            addCriterion("fieldType <>", value, "fieldtype");
            return (Criteria) this;
        }

        public Criteria andFieldtypeGreaterThan(String value) {
            addCriterion("fieldType >", value, "fieldtype");
            return (Criteria) this;
        }

        public Criteria andFieldtypeGreaterThanOrEqualTo(String value) {
            addCriterion("fieldType >=", value, "fieldtype");
            return (Criteria) this;
        }

        public Criteria andFieldtypeLessThan(String value) {
            addCriterion("fieldType <", value, "fieldtype");
            return (Criteria) this;
        }

        public Criteria andFieldtypeLessThanOrEqualTo(String value) {
            addCriterion("fieldType <=", value, "fieldtype");
            return (Criteria) this;
        }

        public Criteria andFieldtypeLike(String value) {
            addCriterion("fieldType like", value, "fieldtype");
            return (Criteria) this;
        }

        public Criteria andFieldtypeNotLike(String value) {
            addCriterion("fieldType not like", value, "fieldtype");
            return (Criteria) this;
        }

        public Criteria andFieldtypeIn(List<String> values) {
            addCriterion("fieldType in", values, "fieldtype");
            return (Criteria) this;
        }

        public Criteria andFieldtypeNotIn(List<String> values) {
            addCriterion("fieldType not in", values, "fieldtype");
            return (Criteria) this;
        }

        public Criteria andFieldtypeBetween(String value1, String value2) {
            addCriterion("fieldType between", value1, value2, "fieldtype");
            return (Criteria) this;
        }

        public Criteria andFieldtypeNotBetween(String value1, String value2) {
            addCriterion("fieldType not between", value1, value2, "fieldtype");
            return (Criteria) this;
        }

        public Criteria andMaskgroupboIsNull() {
            addCriterion("maskgroupBo is null");
            return (Criteria) this;
        }

        public Criteria andMaskgroupboIsNotNull() {
            addCriterion("maskgroupBo is not null");
            return (Criteria) this;
        }

        public Criteria andMaskgroupboEqualTo(String value) {
            addCriterion("maskgroupBo =", value, "maskgroupbo");
            return (Criteria) this;
        }

        public Criteria andMaskgroupboNotEqualTo(String value) {
            addCriterion("maskgroupBo <>", value, "maskgroupbo");
            return (Criteria) this;
        }

        public Criteria andMaskgroupboGreaterThan(String value) {
            addCriterion("maskgroupBo >", value, "maskgroupbo");
            return (Criteria) this;
        }

        public Criteria andMaskgroupboGreaterThanOrEqualTo(String value) {
            addCriterion("maskgroupBo >=", value, "maskgroupbo");
            return (Criteria) this;
        }

        public Criteria andMaskgroupboLessThan(String value) {
            addCriterion("maskgroupBo <", value, "maskgroupbo");
            return (Criteria) this;
        }

        public Criteria andMaskgroupboLessThanOrEqualTo(String value) {
            addCriterion("maskgroupBo <=", value, "maskgroupbo");
            return (Criteria) this;
        }

        public Criteria andMaskgroupboLike(String value) {
            addCriterion("maskgroupBo like", value, "maskgroupbo");
            return (Criteria) this;
        }

        public Criteria andMaskgroupboNotLike(String value) {
            addCriterion("maskgroupBo not like", value, "maskgroupbo");
            return (Criteria) this;
        }

        public Criteria andMaskgroupboIn(List<String> values) {
            addCriterion("maskgroupBo in", values, "maskgroupbo");
            return (Criteria) this;
        }

        public Criteria andMaskgroupboNotIn(List<String> values) {
            addCriterion("maskgroupBo not in", values, "maskgroupbo");
            return (Criteria) this;
        }

        public Criteria andMaskgroupboBetween(String value1, String value2) {
            addCriterion("maskgroupBo between", value1, value2, "maskgroupbo");
            return (Criteria) this;
        }

        public Criteria andMaskgroupboNotBetween(String value1, String value2) {
            addCriterion("maskgroupBo not between", value1, value2, "maskgroupbo");
            return (Criteria) this;
        }

        public Criteria andFieldunitIsNull() {
            addCriterion("fieldUnit is null");
            return (Criteria) this;
        }

        public Criteria andFieldunitIsNotNull() {
            addCriterion("fieldUnit is not null");
            return (Criteria) this;
        }

        public Criteria andFieldunitEqualTo(String value) {
            addCriterion("fieldUnit =", value, "fieldunit");
            return (Criteria) this;
        }

        public Criteria andFieldunitNotEqualTo(String value) {
            addCriterion("fieldUnit <>", value, "fieldunit");
            return (Criteria) this;
        }

        public Criteria andFieldunitGreaterThan(String value) {
            addCriterion("fieldUnit >", value, "fieldunit");
            return (Criteria) this;
        }

        public Criteria andFieldunitGreaterThanOrEqualTo(String value) {
            addCriterion("fieldUnit >=", value, "fieldunit");
            return (Criteria) this;
        }

        public Criteria andFieldunitLessThan(String value) {
            addCriterion("fieldUnit <", value, "fieldunit");
            return (Criteria) this;
        }

        public Criteria andFieldunitLessThanOrEqualTo(String value) {
            addCriterion("fieldUnit <=", value, "fieldunit");
            return (Criteria) this;
        }

        public Criteria andFieldunitLike(String value) {
            addCriterion("fieldUnit like", value, "fieldunit");
            return (Criteria) this;
        }

        public Criteria andFieldunitNotLike(String value) {
            addCriterion("fieldUnit not like", value, "fieldunit");
            return (Criteria) this;
        }

        public Criteria andFieldunitIn(List<String> values) {
            addCriterion("fieldUnit in", values, "fieldunit");
            return (Criteria) this;
        }

        public Criteria andFieldunitNotIn(List<String> values) {
            addCriterion("fieldUnit not in", values, "fieldunit");
            return (Criteria) this;
        }

        public Criteria andFieldunitBetween(String value1, String value2) {
            addCriterion("fieldUnit between", value1, value2, "fieldunit");
            return (Criteria) this;
        }

        public Criteria andFieldunitNotBetween(String value1, String value2) {
            addCriterion("fieldUnit not between", value1, value2, "fieldunit");
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