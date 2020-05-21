package com.demo.beans;

import java.util.ArrayList;
import java.util.List;

public class StudentExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public StudentExample() {
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

		public Criteria andSnoIsNull() {
			addCriterion("sno is null");
			return (Criteria) this;
		}

		public Criteria andSnoIsNotNull() {
			addCriterion("sno is not null");
			return (Criteria) this;
		}

		public Criteria andSnoEqualTo(String value) {
			addCriterion("sno =", value, "sno");
			return (Criteria) this;
		}

		public Criteria andSnoNotEqualTo(String value) {
			addCriterion("sno <>", value, "sno");
			return (Criteria) this;
		}

		public Criteria andSnoGreaterThan(String value) {
			addCriterion("sno >", value, "sno");
			return (Criteria) this;
		}

		public Criteria andSnoGreaterThanOrEqualTo(String value) {
			addCriterion("sno >=", value, "sno");
			return (Criteria) this;
		}

		public Criteria andSnoLessThan(String value) {
			addCriterion("sno <", value, "sno");
			return (Criteria) this;
		}

		public Criteria andSnoLessThanOrEqualTo(String value) {
			addCriterion("sno <=", value, "sno");
			return (Criteria) this;
		}

		public Criteria andSnoIn(List<String> values) {
			addCriterion("sno in", values, "sno");
			return (Criteria) this;
		}

		public Criteria andSnoNotIn(List<String> values) {
			addCriterion("sno not in", values, "sno");
			return (Criteria) this;
		}

		public Criteria andSnoBetween(String value1, String value2) {
			addCriterion("sno between", value1, value2, "sno");
			return (Criteria) this;
		}

		public Criteria andSnoNotBetween(String value1, String value2) {
			addCriterion("sno not between", value1, value2, "sno");
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

		public Criteria andCardidIsNull() {
			addCriterion("cardid is null");
			return (Criteria) this;
		}

		public Criteria andCardidIsNotNull() {
			addCriterion("cardid is not null");
			return (Criteria) this;
		}

		public Criteria andCardidEqualTo(String value) {
			addCriterion("cardid =", value, "cardid");
			return (Criteria) this;
		}

		public Criteria andCardidNotEqualTo(String value) {
			addCriterion("cardid <>", value, "cardid");
			return (Criteria) this;
		}

		public Criteria andCardidGreaterThan(String value) {
			addCriterion("cardid >", value, "cardid");
			return (Criteria) this;
		}

		public Criteria andCardidGreaterThanOrEqualTo(String value) {
			addCriterion("cardid >=", value, "cardid");
			return (Criteria) this;
		}

		public Criteria andCardidLessThan(String value) {
			addCriterion("cardid <", value, "cardid");
			return (Criteria) this;
		}

		public Criteria andCardidLessThanOrEqualTo(String value) {
			addCriterion("cardid <=", value, "cardid");
			return (Criteria) this;
		}

		public Criteria andCardidLike(String value) {
			addCriterion("cardid like", value, "cardid");
			return (Criteria) this;
		}

		public Criteria andCardidNotLike(String value) {
			addCriterion("cardid not like", value, "cardid");
			return (Criteria) this;
		}

		public Criteria andCardidIn(List<String> values) {
			addCriterion("cardid in", values, "cardid");
			return (Criteria) this;
		}

		public Criteria andCardidNotIn(List<String> values) {
			addCriterion("cardid not in", values, "cardid");
			return (Criteria) this;
		}

		public Criteria andCardidBetween(String value1, String value2) {
			addCriterion("cardid between", value1, value2, "cardid");
			return (Criteria) this;
		}

		public Criteria andCardidNotBetween(String value1, String value2) {
			addCriterion("cardid not between", value1, value2, "cardid");
			return (Criteria) this;
		}

		public Criteria andSexIsNull() {
			addCriterion("sex is null");
			return (Criteria) this;
		}

		public Criteria andSexIsNotNull() {
			addCriterion("sex is not null");
			return (Criteria) this;
		}

		public Criteria andSexEqualTo(String value) {
			addCriterion("sex =", value, "sex");
			return (Criteria) this;
		}

		public Criteria andSexNotEqualTo(String value) {
			addCriterion("sex <>", value, "sex");
			return (Criteria) this;
		}

		public Criteria andSexGreaterThan(String value) {
			addCriterion("sex >", value, "sex");
			return (Criteria) this;
		}

		public Criteria andSexGreaterThanOrEqualTo(String value) {
			addCriterion("sex >=", value, "sex");
			return (Criteria) this;
		}

		public Criteria andSexLessThan(String value) {
			addCriterion("sex <", value, "sex");
			return (Criteria) this;
		}

		public Criteria andSexLessThanOrEqualTo(String value) {
			addCriterion("sex <=", value, "sex");
			return (Criteria) this;
		}

		public Criteria andSexIn(List<String> values) {
			addCriterion("sex in", values, "sex");
			return (Criteria) this;
		}

		public Criteria andSexNotIn(List<String> values) {
			addCriterion("sex not in", values, "sex");
			return (Criteria) this;
		}

		public Criteria andSexBetween(String value1, String value2) {
			addCriterion("sex between", value1, value2, "sex");
			return (Criteria) this;
		}

		public Criteria andSexNotBetween(String value1, String value2) {
			addCriterion("sex not between", value1, value2, "sex");
			return (Criteria) this;
		}

		public Criteria andCidIsNull() {
			addCriterion("cid is null");
			return (Criteria) this;
		}

		public Criteria andCidIsNotNull() {
			addCriterion("cid is not null");
			return (Criteria) this;
		}

		public Criteria andCidEqualTo(String value) {
			addCriterion("cid =", value, "cid");
			return (Criteria) this;
		}

		public Criteria andCidNotEqualTo(String value) {
			addCriterion("cid <>", value, "cid");
			return (Criteria) this;
		}

		public Criteria andCidGreaterThan(String value) {
			addCriterion("cid >", value, "cid");
			return (Criteria) this;
		}

		public Criteria andCidGreaterThanOrEqualTo(String value) {
			addCriterion("cid >=", value, "cid");
			return (Criteria) this;
		}

		public Criteria andCidLessThan(String value) {
			addCriterion("cid <", value, "cid");
			return (Criteria) this;
		}

		public Criteria andCidLessThanOrEqualTo(String value) {
			addCriterion("cid <=", value, "cid");
			return (Criteria) this;
		}

		public Criteria andCidIn(List<String> values) {
			addCriterion("cid in", values, "cid");
			return (Criteria) this;
		}

		public Criteria andCidNotIn(List<String> values) {
			addCriterion("cid not in", values, "cid");
			return (Criteria) this;
		}

		public Criteria andCidBetween(String value1, String value2) {
			addCriterion("cid between", value1, value2, "cid");
			return (Criteria) this;
		}

		public Criteria andCidNotBetween(String value1, String value2) {
			addCriterion("cid not between", value1, value2, "cid");
			return (Criteria) this;
		}

		public Criteria andPidIsNull() {
			addCriterion("pid is null");
			return (Criteria) this;
		}

		public Criteria andPidIsNotNull() {
			addCriterion("pid is not null");
			return (Criteria) this;
		}

		public Criteria andPidEqualTo(String value) {
			addCriterion("pid =", value, "pid");
			return (Criteria) this;
		}

		public Criteria andPidNotEqualTo(String value) {
			addCriterion("pid <>", value, "pid");
			return (Criteria) this;
		}

		public Criteria andPidGreaterThan(String value) {
			addCriterion("pid >", value, "pid");
			return (Criteria) this;
		}

		public Criteria andPidGreaterThanOrEqualTo(String value) {
			addCriterion("pid >=", value, "pid");
			return (Criteria) this;
		}

		public Criteria andPidLessThan(String value) {
			addCriterion("pid <", value, "pid");
			return (Criteria) this;
		}

		public Criteria andPidLessThanOrEqualTo(String value) {
			addCriterion("pid <=", value, "pid");
			return (Criteria) this;
		}

		public Criteria andPidIn(List<String> values) {
			addCriterion("pid in", values, "pid");
			return (Criteria) this;
		}

		public Criteria andPidNotIn(List<String> values) {
			addCriterion("pid not in", values, "pid");
			return (Criteria) this;
		}

		public Criteria andPidBetween(String value1, String value2) {
			addCriterion("pid between", value1, value2, "pid");
			return (Criteria) this;
		}

		public Criteria andPidNotBetween(String value1, String value2) {
			addCriterion("pid not between", value1, value2, "pid");
			return (Criteria) this;
		}

		public Criteria andBidIsNull() {
			addCriterion("bid is null");
			return (Criteria) this;
		}

		public Criteria andBidIsNotNull() {
			addCriterion("bid is not null");
			return (Criteria) this;
		}

		public Criteria andBidEqualTo(String value) {
			addCriterion("bid =", value, "bid");
			return (Criteria) this;
		}

		public Criteria andBidNotEqualTo(String value) {
			addCriterion("bid <>", value, "bid");
			return (Criteria) this;
		}

		public Criteria andBidGreaterThan(String value) {
			addCriterion("bid >", value, "bid");
			return (Criteria) this;
		}

		public Criteria andBidGreaterThanOrEqualTo(String value) {
			addCriterion("bid >=", value, "bid");
			return (Criteria) this;
		}

		public Criteria andBidLessThan(String value) {
			addCriterion("bid <", value, "bid");
			return (Criteria) this;
		}

		public Criteria andBidLessThanOrEqualTo(String value) {
			addCriterion("bid <=", value, "bid");
			return (Criteria) this;
		}

		public Criteria andBidIn(List<String> values) {
			addCriterion("bid in", values, "bid");
			return (Criteria) this;
		}

		public Criteria andBidNotIn(List<String> values) {
			addCriterion("bid not in", values, "bid");
			return (Criteria) this;
		}

		public Criteria andBidBetween(String value1, String value2) {
			addCriterion("bid between", value1, value2, "bid");
			return (Criteria) this;
		}

		public Criteria andBidNotBetween(String value1, String value2) {
			addCriterion("bid not between", value1, value2, "bid");
			return (Criteria) this;
		}

		public Criteria andGidIsNull() {
			addCriterion("gid is null");
			return (Criteria) this;
		}

		public Criteria andGidIsNotNull() {
			addCriterion("gid is not null");
			return (Criteria) this;
		}

		public Criteria andGidEqualTo(String value) {
			addCriterion("gid =", value, "gid");
			return (Criteria) this;
		}

		public Criteria andGidNotEqualTo(String value) {
			addCriterion("gid <>", value, "gid");
			return (Criteria) this;
		}

		public Criteria andGidGreaterThan(String value) {
			addCriterion("gid >", value, "gid");
			return (Criteria) this;
		}

		public Criteria andGidGreaterThanOrEqualTo(String value) {
			addCriterion("gid >=", value, "gid");
			return (Criteria) this;
		}

		public Criteria andGidLessThan(String value) {
			addCriterion("gid <", value, "gid");
			return (Criteria) this;
		}

		public Criteria andGidLessThanOrEqualTo(String value) {
			addCriterion("gid <=", value, "gid");
			return (Criteria) this;
		}

		public Criteria andGidIn(List<String> values) {
			addCriterion("gid in", values, "gid");
			return (Criteria) this;
		}

		public Criteria andGidNotIn(List<String> values) {
			addCriterion("gid not in", values, "gid");
			return (Criteria) this;
		}

		public Criteria andGidBetween(String value1, String value2) {
			addCriterion("gid between", value1, value2, "gid");
			return (Criteria) this;
		}

		public Criteria andGidNotBetween(String value1, String value2) {
			addCriterion("gid not between", value1, value2, "gid");
			return (Criteria) this;
		}

		public Criteria andNoteIsNull() {
			addCriterion("note is null");
			return (Criteria) this;
		}

		public Criteria andNoteIsNotNull() {
			addCriterion("note is not null");
			return (Criteria) this;
		}

		public Criteria andNoteEqualTo(String value) {
			addCriterion("note =", value, "note");
			return (Criteria) this;
		}

		public Criteria andNoteNotEqualTo(String value) {
			addCriterion("note <>", value, "note");
			return (Criteria) this;
		}

		public Criteria andNoteGreaterThan(String value) {
			addCriterion("note >", value, "note");
			return (Criteria) this;
		}

		public Criteria andNoteGreaterThanOrEqualTo(String value) {
			addCriterion("note >=", value, "note");
			return (Criteria) this;
		}

		public Criteria andNoteLessThan(String value) {
			addCriterion("note <", value, "note");
			return (Criteria) this;
		}

		public Criteria andNoteLessThanOrEqualTo(String value) {
			addCriterion("note <=", value, "note");
			return (Criteria) this;
		}

		public Criteria andNoteLike(String value) {
			addCriterion("note like", value, "note");
			return (Criteria) this;
		}

		public Criteria andNoteNotLike(String value) {
			addCriterion("note not like", value, "note");
			return (Criteria) this;
		}

		public Criteria andNoteIn(List<String> values) {
			addCriterion("note in", values, "note");
			return (Criteria) this;
		}

		public Criteria andNoteNotIn(List<String> values) {
			addCriterion("note not in", values, "note");
			return (Criteria) this;
		}

		public Criteria andNoteBetween(String value1, String value2) {
			addCriterion("note between", value1, value2, "note");
			return (Criteria) this;
		}

		public Criteria andNoteNotBetween(String value1, String value2) {
			addCriterion("note not between", value1, value2, "note");
			return (Criteria) this;
		}

		// 新增hid
		public Criteria andHidIsNull() {
			addCriterion("hid is null");
			return (Criteria) this;
		}

		public Criteria andHidIsNotNull() {
			addCriterion("hid is not null");
			return (Criteria) this;
		}

		public Criteria andHidEqualTo(String value) {
			addCriterion("hid =", value, "hid");
			return (Criteria) this;
		}

		public Criteria andHidNotEqualTo(String value) {
			addCriterion("hid <>", value, "hid");
			return (Criteria) this;
		}

		public Criteria andHidGreaterThan(String value) {
			addCriterion("hid >", value, "hid");
			return (Criteria) this;
		}

		public Criteria andHidGreaterThanOrEqualTo(String value) {
			addCriterion("hid >=", value, "hid");
			return (Criteria) this;
		}

		public Criteria andHidLessThan(String value) {
			addCriterion("hid <", value, "hid");
			return (Criteria) this;
		}

		public Criteria andHidLessThanOrEqualTo(String value) {
			addCriterion("hid <=", value, "hid");
			return (Criteria) this;
		}

		public Criteria andHidIn(List<String> values) {
			addCriterion("hid in", values, "hid");
			return (Criteria) this;
		}

		public Criteria andHidNotIn(List<String> values) {
			addCriterion("hid not in", values, "hid");
			return (Criteria) this;
		}

		public Criteria andHidBetween(String value1, String value2) {
			addCriterion("hid between", value1, value2, "hid");
			return (Criteria) this;
		}

		public Criteria andHidNotBetween(String value1, String value2) {
			addCriterion("hid not between", value1, value2, "hid");
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