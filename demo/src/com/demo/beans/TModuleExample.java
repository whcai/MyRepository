package com.demo.beans;

import java.util.ArrayList;
import java.util.List;

public class TModuleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TModuleExample() {
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

        public Criteria andModuleidIsNull() {
            addCriterion("moduleid is null");
            return (Criteria) this;
        }

        public Criteria andModuleidIsNotNull() {
            addCriterion("moduleid is not null");
            return (Criteria) this;
        }

        public Criteria andModuleidEqualTo(String value) {
            addCriterion("moduleid =", value, "moduleid");
            return (Criteria) this;
        }

        public Criteria andModuleidNotEqualTo(String value) {
            addCriterion("moduleid <>", value, "moduleid");
            return (Criteria) this;
        }

        public Criteria andModuleidGreaterThan(String value) {
            addCriterion("moduleid >", value, "moduleid");
            return (Criteria) this;
        }

        public Criteria andModuleidGreaterThanOrEqualTo(String value) {
            addCriterion("moduleid >=", value, "moduleid");
            return (Criteria) this;
        }

        public Criteria andModuleidLessThan(String value) {
            addCriterion("moduleid <", value, "moduleid");
            return (Criteria) this;
        }

        public Criteria andModuleidLessThanOrEqualTo(String value) {
            addCriterion("moduleid <=", value, "moduleid");
            return (Criteria) this;
        }

        public Criteria andModuleidLike(String value) {
            addCriterion("moduleid like", value, "moduleid");
            return (Criteria) this;
        }

        public Criteria andModuleidNotLike(String value) {
            addCriterion("moduleid not like", value, "moduleid");
            return (Criteria) this;
        }

        public Criteria andModuleidIn(List<String> values) {
            addCriterion("moduleid in", values, "moduleid");
            return (Criteria) this;
        }

        public Criteria andModuleidNotIn(List<String> values) {
            addCriterion("moduleid not in", values, "moduleid");
            return (Criteria) this;
        }

        public Criteria andModuleidBetween(String value1, String value2) {
            addCriterion("moduleid between", value1, value2, "moduleid");
            return (Criteria) this;
        }

        public Criteria andModuleidNotBetween(String value1, String value2) {
            addCriterion("moduleid not between", value1, value2, "moduleid");
            return (Criteria) this;
        }

        public Criteria andModulenameIsNull() {
            addCriterion("modulename is null");
            return (Criteria) this;
        }

        public Criteria andModulenameIsNotNull() {
            addCriterion("modulename is not null");
            return (Criteria) this;
        }

        public Criteria andModulenameEqualTo(String value) {
            addCriterion("modulename =", value, "modulename");
            return (Criteria) this;
        }

        public Criteria andModulenameNotEqualTo(String value) {
            addCriterion("modulename <>", value, "modulename");
            return (Criteria) this;
        }

        public Criteria andModulenameGreaterThan(String value) {
            addCriterion("modulename >", value, "modulename");
            return (Criteria) this;
        }

        public Criteria andModulenameGreaterThanOrEqualTo(String value) {
            addCriterion("modulename >=", value, "modulename");
            return (Criteria) this;
        }

        public Criteria andModulenameLessThan(String value) {
            addCriterion("modulename <", value, "modulename");
            return (Criteria) this;
        }

        public Criteria andModulenameLessThanOrEqualTo(String value) {
            addCriterion("modulename <=", value, "modulename");
            return (Criteria) this;
        }

        public Criteria andModulenameLike(String value) {
            addCriterion("modulename like", value, "modulename");
            return (Criteria) this;
        }

        public Criteria andModulenameNotLike(String value) {
            addCriterion("modulename not like", value, "modulename");
            return (Criteria) this;
        }

        public Criteria andModulenameIn(List<String> values) {
            addCriterion("modulename in", values, "modulename");
            return (Criteria) this;
        }

        public Criteria andModulenameNotIn(List<String> values) {
            addCriterion("modulename not in", values, "modulename");
            return (Criteria) this;
        }

        public Criteria andModulenameBetween(String value1, String value2) {
            addCriterion("modulename between", value1, value2, "modulename");
            return (Criteria) this;
        }

        public Criteria andModulenameNotBetween(String value1, String value2) {
            addCriterion("modulename not between", value1, value2, "modulename");
            return (Criteria) this;
        }

        public Criteria andExecfileIsNull() {
            addCriterion("execfile is null");
            return (Criteria) this;
        }

        public Criteria andExecfileIsNotNull() {
            addCriterion("execfile is not null");
            return (Criteria) this;
        }

        public Criteria andExecfileEqualTo(String value) {
            addCriterion("execfile =", value, "execfile");
            return (Criteria) this;
        }

        public Criteria andExecfileNotEqualTo(String value) {
            addCriterion("execfile <>", value, "execfile");
            return (Criteria) this;
        }

        public Criteria andExecfileGreaterThan(String value) {
            addCriterion("execfile >", value, "execfile");
            return (Criteria) this;
        }

        public Criteria andExecfileGreaterThanOrEqualTo(String value) {
            addCriterion("execfile >=", value, "execfile");
            return (Criteria) this;
        }

        public Criteria andExecfileLessThan(String value) {
            addCriterion("execfile <", value, "execfile");
            return (Criteria) this;
        }

        public Criteria andExecfileLessThanOrEqualTo(String value) {
            addCriterion("execfile <=", value, "execfile");
            return (Criteria) this;
        }

        public Criteria andExecfileLike(String value) {
            addCriterion("execfile like", value, "execfile");
            return (Criteria) this;
        }

        public Criteria andExecfileNotLike(String value) {
            addCriterion("execfile not like", value, "execfile");
            return (Criteria) this;
        }

        public Criteria andExecfileIn(List<String> values) {
            addCriterion("execfile in", values, "execfile");
            return (Criteria) this;
        }

        public Criteria andExecfileNotIn(List<String> values) {
            addCriterion("execfile not in", values, "execfile");
            return (Criteria) this;
        }

        public Criteria andExecfileBetween(String value1, String value2) {
            addCriterion("execfile between", value1, value2, "execfile");
            return (Criteria) this;
        }

        public Criteria andExecfileNotBetween(String value1, String value2) {
            addCriterion("execfile not between", value1, value2, "execfile");
            return (Criteria) this;
        }

        public Criteria andIfleafIsNull() {
            addCriterion("ifleaf is null");
            return (Criteria) this;
        }

        public Criteria andIfleafIsNotNull() {
            addCriterion("ifleaf is not null");
            return (Criteria) this;
        }

        public Criteria andIfleafEqualTo(String value) {
            addCriterion("ifleaf =", value, "ifleaf");
            return (Criteria) this;
        }

        public Criteria andIfleafNotEqualTo(String value) {
            addCriterion("ifleaf <>", value, "ifleaf");
            return (Criteria) this;
        }

        public Criteria andIfleafGreaterThan(String value) {
            addCriterion("ifleaf >", value, "ifleaf");
            return (Criteria) this;
        }

        public Criteria andIfleafGreaterThanOrEqualTo(String value) {
            addCriterion("ifleaf >=", value, "ifleaf");
            return (Criteria) this;
        }

        public Criteria andIfleafLessThan(String value) {
            addCriterion("ifleaf <", value, "ifleaf");
            return (Criteria) this;
        }

        public Criteria andIfleafLessThanOrEqualTo(String value) {
            addCriterion("ifleaf <=", value, "ifleaf");
            return (Criteria) this;
        }

        public Criteria andIfleafLike(String value) {
            addCriterion("ifleaf like", value, "ifleaf");
            return (Criteria) this;
        }

        public Criteria andIfleafNotLike(String value) {
            addCriterion("ifleaf not like", value, "ifleaf");
            return (Criteria) this;
        }

        public Criteria andIfleafIn(List<String> values) {
            addCriterion("ifleaf in", values, "ifleaf");
            return (Criteria) this;
        }

        public Criteria andIfleafNotIn(List<String> values) {
            addCriterion("ifleaf not in", values, "ifleaf");
            return (Criteria) this;
        }

        public Criteria andIfleafBetween(String value1, String value2) {
            addCriterion("ifleaf between", value1, value2, "ifleaf");
            return (Criteria) this;
        }

        public Criteria andIfleafNotBetween(String value1, String value2) {
            addCriterion("ifleaf not between", value1, value2, "ifleaf");
            return (Criteria) this;
        }

        public Criteria andPosIsNull() {
            addCriterion("pos is null");
            return (Criteria) this;
        }

        public Criteria andPosIsNotNull() {
            addCriterion("pos is not null");
            return (Criteria) this;
        }

        public Criteria andPosEqualTo(String value) {
            addCriterion("pos =", value, "pos");
            return (Criteria) this;
        }

        public Criteria andPosNotEqualTo(String value) {
            addCriterion("pos <>", value, "pos");
            return (Criteria) this;
        }

        public Criteria andPosGreaterThan(String value) {
            addCriterion("pos >", value, "pos");
            return (Criteria) this;
        }

        public Criteria andPosGreaterThanOrEqualTo(String value) {
            addCriterion("pos >=", value, "pos");
            return (Criteria) this;
        }

        public Criteria andPosLessThan(String value) {
            addCriterion("pos <", value, "pos");
            return (Criteria) this;
        }

        public Criteria andPosLessThanOrEqualTo(String value) {
            addCriterion("pos <=", value, "pos");
            return (Criteria) this;
        }

        public Criteria andPosLike(String value) {
            addCriterion("pos like", value, "pos");
            return (Criteria) this;
        }

        public Criteria andPosNotLike(String value) {
            addCriterion("pos not like", value, "pos");
            return (Criteria) this;
        }

        public Criteria andPosIn(List<String> values) {
            addCriterion("pos in", values, "pos");
            return (Criteria) this;
        }

        public Criteria andPosNotIn(List<String> values) {
            addCriterion("pos not in", values, "pos");
            return (Criteria) this;
        }

        public Criteria andPosBetween(String value1, String value2) {
            addCriterion("pos between", value1, value2, "pos");
            return (Criteria) this;
        }

        public Criteria andPosNotBetween(String value1, String value2) {
            addCriterion("pos not between", value1, value2, "pos");
            return (Criteria) this;
        }

        public Criteria andParentidIsNull() {
            addCriterion("parentid is null");
            return (Criteria) this;
        }

        public Criteria andParentidIsNotNull() {
            addCriterion("parentid is not null");
            return (Criteria) this;
        }

        public Criteria andParentidEqualTo(String value) {
            addCriterion("parentid =", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidNotEqualTo(String value) {
            addCriterion("parentid <>", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidGreaterThan(String value) {
            addCriterion("parentid >", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidGreaterThanOrEqualTo(String value) {
            addCriterion("parentid >=", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidLessThan(String value) {
            addCriterion("parentid <", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidLessThanOrEqualTo(String value) {
            addCriterion("parentid <=", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidLike(String value) {
            addCriterion("parentid like", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidNotLike(String value) {
            addCriterion("parentid not like", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidIn(List<String> values) {
            addCriterion("parentid in", values, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidNotIn(List<String> values) {
            addCriterion("parentid not in", values, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidBetween(String value1, String value2) {
            addCriterion("parentid between", value1, value2, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidNotBetween(String value1, String value2) {
            addCriterion("parentid not between", value1, value2, "parentid");
            return (Criteria) this;
        }

        public Criteria andRelIsNull() {
            addCriterion("rel is null");
            return (Criteria) this;
        }

        public Criteria andRelIsNotNull() {
            addCriterion("rel is not null");
            return (Criteria) this;
        }

        public Criteria andRelEqualTo(String value) {
            addCriterion("rel =", value, "rel");
            return (Criteria) this;
        }

        public Criteria andRelNotEqualTo(String value) {
            addCriterion("rel <>", value, "rel");
            return (Criteria) this;
        }

        public Criteria andRelGreaterThan(String value) {
            addCriterion("rel >", value, "rel");
            return (Criteria) this;
        }

        public Criteria andRelGreaterThanOrEqualTo(String value) {
            addCriterion("rel >=", value, "rel");
            return (Criteria) this;
        }

        public Criteria andRelLessThan(String value) {
            addCriterion("rel <", value, "rel");
            return (Criteria) this;
        }

        public Criteria andRelLessThanOrEqualTo(String value) {
            addCriterion("rel <=", value, "rel");
            return (Criteria) this;
        }

        public Criteria andRelLike(String value) {
            addCriterion("rel like", value, "rel");
            return (Criteria) this;
        }

        public Criteria andRelNotLike(String value) {
            addCriterion("rel not like", value, "rel");
            return (Criteria) this;
        }

        public Criteria andRelIn(List<String> values) {
            addCriterion("rel in", values, "rel");
            return (Criteria) this;
        }

        public Criteria andRelNotIn(List<String> values) {
            addCriterion("rel not in", values, "rel");
            return (Criteria) this;
        }

        public Criteria andRelBetween(String value1, String value2) {
            addCriterion("rel between", value1, value2, "rel");
            return (Criteria) this;
        }

        public Criteria andRelNotBetween(String value1, String value2) {
            addCriterion("rel not between", value1, value2, "rel");
            return (Criteria) this;
        }

        public Criteria andFlagIsNull() {
            addCriterion("flag is null");
            return (Criteria) this;
        }

        public Criteria andFlagIsNotNull() {
            addCriterion("flag is not null");
            return (Criteria) this;
        }

        public Criteria andFlagEqualTo(Integer value) {
            addCriterion("flag =", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotEqualTo(Integer value) {
            addCriterion("flag <>", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThan(Integer value) {
            addCriterion("flag >", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("flag >=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThan(Integer value) {
            addCriterion("flag <", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThanOrEqualTo(Integer value) {
            addCriterion("flag <=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagIn(List<Integer> values) {
            addCriterion("flag in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotIn(List<Integer> values) {
            addCriterion("flag not in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagBetween(Integer value1, Integer value2) {
            addCriterion("flag between", value1, value2, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("flag not between", value1, value2, "flag");
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