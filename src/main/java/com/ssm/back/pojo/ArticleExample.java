package com.ssm.back.pojo;

import java.util.ArrayList;
import java.util.List;

public class ArticleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ArticleExample() {
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

        public Criteria andArticle_titleIsNull() {
            addCriterion("article_title is null");
            return (Criteria) this;
        }

        public Criteria andArticle_titleIsNotNull() {
            addCriterion("article_title is not null");
            return (Criteria) this;
        }

        public Criteria andArticle_titleEqualTo(String value) {
            addCriterion("article_title =", value, "article_title");
            return (Criteria) this;
        }

        public Criteria andArticle_titleNotEqualTo(String value) {
            addCriterion("article_title <>", value, "article_title");
            return (Criteria) this;
        }

        public Criteria andArticle_titleGreaterThan(String value) {
            addCriterion("article_title >", value, "article_title");
            return (Criteria) this;
        }

        public Criteria andArticle_titleGreaterThanOrEqualTo(String value) {
            addCriterion("article_title >=", value, "article_title");
            return (Criteria) this;
        }

        public Criteria andArticle_titleLessThan(String value) {
            addCriterion("article_title <", value, "article_title");
            return (Criteria) this;
        }

        public Criteria andArticle_titleLessThanOrEqualTo(String value) {
            addCriterion("article_title <=", value, "article_title");
            return (Criteria) this;
        }

        public Criteria andArticle_titleLike(String value) {
            addCriterion("article_title like", value, "article_title");
            return (Criteria) this;
        }

        public Criteria andArticle_titleNotLike(String value) {
            addCriterion("article_title not like", value, "article_title");
            return (Criteria) this;
        }

        public Criteria andArticle_titleIn(List<String> values) {
            addCriterion("article_title in", values, "article_title");
            return (Criteria) this;
        }

        public Criteria andArticle_titleNotIn(List<String> values) {
            addCriterion("article_title not in", values, "article_title");
            return (Criteria) this;
        }

        public Criteria andArticle_titleBetween(String value1, String value2) {
            addCriterion("article_title between", value1, value2, "article_title");
            return (Criteria) this;
        }

        public Criteria andArticle_titleNotBetween(String value1, String value2) {
            addCriterion("article_title not between", value1, value2, "article_title");
            return (Criteria) this;
        }

        public Criteria andArticle_create_dateIsNull() {
            addCriterion("article_create_date is null");
            return (Criteria) this;
        }

        public Criteria andArticle_create_dateIsNotNull() {
            addCriterion("article_create_date is not null");
            return (Criteria) this;
        }

        public Criteria andArticle_create_dateEqualTo(String value) {
            addCriterion("article_create_date =", value, "article_create_date");
            return (Criteria) this;
        }

        public Criteria andArticle_create_dateNotEqualTo(String value) {
            addCriterion("article_create_date <>", value, "article_create_date");
            return (Criteria) this;
        }

        public Criteria andArticle_create_dateGreaterThan(String value) {
            addCriterion("article_create_date >", value, "article_create_date");
            return (Criteria) this;
        }

        public Criteria andArticle_create_dateGreaterThanOrEqualTo(String value) {
            addCriterion("article_create_date >=", value, "article_create_date");
            return (Criteria) this;
        }

        public Criteria andArticle_create_dateLessThan(String value) {
            addCriterion("article_create_date <", value, "article_create_date");
            return (Criteria) this;
        }

        public Criteria andArticle_create_dateLessThanOrEqualTo(String value) {
            addCriterion("article_create_date <=", value, "article_create_date");
            return (Criteria) this;
        }

        public Criteria andArticle_create_dateLike(String value) {
            addCriterion("article_create_date like", value, "article_create_date");
            return (Criteria) this;
        }

        public Criteria andArticle_create_dateNotLike(String value) {
            addCriterion("article_create_date not like", value, "article_create_date");
            return (Criteria) this;
        }

        public Criteria andArticle_create_dateIn(List<String> values) {
            addCriterion("article_create_date in", values, "article_create_date");
            return (Criteria) this;
        }

        public Criteria andArticle_create_dateNotIn(List<String> values) {
            addCriterion("article_create_date not in", values, "article_create_date");
            return (Criteria) this;
        }

        public Criteria andArticle_create_dateBetween(String value1, String value2) {
            addCriterion("article_create_date between", value1, value2, "article_create_date");
            return (Criteria) this;
        }

        public Criteria andArticle_create_dateNotBetween(String value1, String value2) {
            addCriterion("article_create_date not between", value1, value2, "article_create_date");
            return (Criteria) this;
        }

        public Criteria andIs_topIsNull() {
            addCriterion("is_top is null");
            return (Criteria) this;
        }

        public Criteria andIs_topIsNotNull() {
            addCriterion("is_top is not null");
            return (Criteria) this;
        }

        public Criteria andIs_topEqualTo(Integer value) {
            addCriterion("is_top =", value, "is_top");
            return (Criteria) this;
        }

        public Criteria andIs_topNotEqualTo(Integer value) {
            addCriterion("is_top <>", value, "is_top");
            return (Criteria) this;
        }

        public Criteria andIs_topGreaterThan(Integer value) {
            addCriterion("is_top >", value, "is_top");
            return (Criteria) this;
        }

        public Criteria andIs_topGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_top >=", value, "is_top");
            return (Criteria) this;
        }

        public Criteria andIs_topLessThan(Integer value) {
            addCriterion("is_top <", value, "is_top");
            return (Criteria) this;
        }

        public Criteria andIs_topLessThanOrEqualTo(Integer value) {
            addCriterion("is_top <=", value, "is_top");
            return (Criteria) this;
        }

        public Criteria andIs_topIn(List<Integer> values) {
            addCriterion("is_top in", values, "is_top");
            return (Criteria) this;
        }

        public Criteria andIs_topNotIn(List<Integer> values) {
            addCriterion("is_top not in", values, "is_top");
            return (Criteria) this;
        }

        public Criteria andIs_topBetween(Integer value1, Integer value2) {
            addCriterion("is_top between", value1, value2, "is_top");
            return (Criteria) this;
        }

        public Criteria andIs_topNotBetween(Integer value1, Integer value2) {
            addCriterion("is_top not between", value1, value2, "is_top");
            return (Criteria) this;
        }

        public Criteria andAdd_nameIsNull() {
            addCriterion("add_name is null");
            return (Criteria) this;
        }

        public Criteria andAdd_nameIsNotNull() {
            addCriterion("add_name is not null");
            return (Criteria) this;
        }

        public Criteria andAdd_nameEqualTo(String value) {
            addCriterion("add_name =", value, "add_name");
            return (Criteria) this;
        }

        public Criteria andAdd_nameNotEqualTo(String value) {
            addCriterion("add_name <>", value, "add_name");
            return (Criteria) this;
        }

        public Criteria andAdd_nameGreaterThan(String value) {
            addCriterion("add_name >", value, "add_name");
            return (Criteria) this;
        }

        public Criteria andAdd_nameGreaterThanOrEqualTo(String value) {
            addCriterion("add_name >=", value, "add_name");
            return (Criteria) this;
        }

        public Criteria andAdd_nameLessThan(String value) {
            addCriterion("add_name <", value, "add_name");
            return (Criteria) this;
        }

        public Criteria andAdd_nameLessThanOrEqualTo(String value) {
            addCriterion("add_name <=", value, "add_name");
            return (Criteria) this;
        }

        public Criteria andAdd_nameLike(String value) {
            addCriterion("add_name like", value, "add_name");
            return (Criteria) this;
        }

        public Criteria andAdd_nameNotLike(String value) {
            addCriterion("add_name not like", value, "add_name");
            return (Criteria) this;
        }

        public Criteria andAdd_nameIn(List<String> values) {
            addCriterion("add_name in", values, "add_name");
            return (Criteria) this;
        }

        public Criteria andAdd_nameNotIn(List<String> values) {
            addCriterion("add_name not in", values, "add_name");
            return (Criteria) this;
        }

        public Criteria andAdd_nameBetween(String value1, String value2) {
            addCriterion("add_name between", value1, value2, "add_name");
            return (Criteria) this;
        }

        public Criteria andAdd_nameNotBetween(String value1, String value2) {
            addCriterion("add_name not between", value1, value2, "add_name");
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