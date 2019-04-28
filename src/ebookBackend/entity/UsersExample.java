package ebookBackend.entity;

import java.util.ArrayList;
import java.util.List;

public class UsersExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table users
     *
     * @mbggenerated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table users
     *
     * @mbggenerated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table users
     *
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users
     *
     * @mbggenerated
     */
    public UsersExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users
     *
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users
     *
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users
     *
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users
     *
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users
     *
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users
     *
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users
     *
     * @mbggenerated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users
     *
     * @mbggenerated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users
     *
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users
     *
     * @mbggenerated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table users
     *
     * @mbggenerated
     */
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

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdenIsNull() {
            addCriterion("iden is null");
            return (Criteria) this;
        }

        public Criteria andIdenIsNotNull() {
            addCriterion("iden is not null");
            return (Criteria) this;
        }

        public Criteria andIdenEqualTo(String value) {
            addCriterion("iden =", value, "iden");
            return (Criteria) this;
        }

        public Criteria andIdenNotEqualTo(String value) {
            addCriterion("iden <>", value, "iden");
            return (Criteria) this;
        }

        public Criteria andIdenGreaterThan(String value) {
            addCriterion("iden >", value, "iden");
            return (Criteria) this;
        }

        public Criteria andIdenGreaterThanOrEqualTo(String value) {
            addCriterion("iden >=", value, "iden");
            return (Criteria) this;
        }

        public Criteria andIdenLessThan(String value) {
            addCriterion("iden <", value, "iden");
            return (Criteria) this;
        }

        public Criteria andIdenLessThanOrEqualTo(String value) {
            addCriterion("iden <=", value, "iden");
            return (Criteria) this;
        }

        public Criteria andIdenLike(String value) {
            addCriterion("iden like", value, "iden");
            return (Criteria) this;
        }

        public Criteria andIdenNotLike(String value) {
            addCriterion("iden not like", value, "iden");
            return (Criteria) this;
        }

        public Criteria andIdenIn(List<String> values) {
            addCriterion("iden in", values, "iden");
            return (Criteria) this;
        }

        public Criteria andIdenNotIn(List<String> values) {
            addCriterion("iden not in", values, "iden");
            return (Criteria) this;
        }

        public Criteria andIdenBetween(String value1, String value2) {
            addCriterion("iden between", value1, value2, "iden");
            return (Criteria) this;
        }

        public Criteria andIdenNotBetween(String value1, String value2) {
            addCriterion("iden not between", value1, value2, "iden");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andBanIsNull() {
            addCriterion("ban is null");
            return (Criteria) this;
        }

        public Criteria andBanIsNotNull() {
            addCriterion("ban is not null");
            return (Criteria) this;
        }

        public Criteria andBanEqualTo(Boolean value) {
            addCriterion("ban =", value, "ban");
            return (Criteria) this;
        }

        public Criteria andBanNotEqualTo(Boolean value) {
            addCriterion("ban <>", value, "ban");
            return (Criteria) this;
        }

        public Criteria andBanGreaterThan(Boolean value) {
            addCriterion("ban >", value, "ban");
            return (Criteria) this;
        }

        public Criteria andBanGreaterThanOrEqualTo(Boolean value) {
            addCriterion("ban >=", value, "ban");
            return (Criteria) this;
        }

        public Criteria andBanLessThan(Boolean value) {
            addCriterion("ban <", value, "ban");
            return (Criteria) this;
        }

        public Criteria andBanLessThanOrEqualTo(Boolean value) {
            addCriterion("ban <=", value, "ban");
            return (Criteria) this;
        }

        public Criteria andBanIn(List<Boolean> values) {
            addCriterion("ban in", values, "ban");
            return (Criteria) this;
        }

        public Criteria andBanNotIn(List<Boolean> values) {
            addCriterion("ban not in", values, "ban");
            return (Criteria) this;
        }

        public Criteria andBanBetween(Boolean value1, Boolean value2) {
            addCriterion("ban between", value1, value2, "ban");
            return (Criteria) this;
        }

        public Criteria andBanNotBetween(Boolean value1, Boolean value2) {
            addCriterion("ban not between", value1, value2, "ban");
            return (Criteria) this;
        }

        public Criteria andMailIsNull() {
            addCriterion("mail is null");
            return (Criteria) this;
        }

        public Criteria andMailIsNotNull() {
            addCriterion("mail is not null");
            return (Criteria) this;
        }

        public Criteria andMailEqualTo(String value) {
            addCriterion("mail =", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailNotEqualTo(String value) {
            addCriterion("mail <>", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailGreaterThan(String value) {
            addCriterion("mail >", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailGreaterThanOrEqualTo(String value) {
            addCriterion("mail >=", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailLessThan(String value) {
            addCriterion("mail <", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailLessThanOrEqualTo(String value) {
            addCriterion("mail <=", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailLike(String value) {
            addCriterion("mail like", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailNotLike(String value) {
            addCriterion("mail not like", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailIn(List<String> values) {
            addCriterion("mail in", values, "mail");
            return (Criteria) this;
        }

        public Criteria andMailNotIn(List<String> values) {
            addCriterion("mail not in", values, "mail");
            return (Criteria) this;
        }

        public Criteria andMailBetween(String value1, String value2) {
            addCriterion("mail between", value1, value2, "mail");
            return (Criteria) this;
        }

        public Criteria andMailNotBetween(String value1, String value2) {
            addCriterion("mail not between", value1, value2, "mail");
            return (Criteria) this;
        }

        public Criteria andCartIsNull() {
            addCriterion("cart is null");
            return (Criteria) this;
        }

        public Criteria andCartIsNotNull() {
            addCriterion("cart is not null");
            return (Criteria) this;
        }

        public Criteria andCartEqualTo(String value) {
            addCriterion("cart =", value, "cart");
            return (Criteria) this;
        }

        public Criteria andCartNotEqualTo(String value) {
            addCriterion("cart <>", value, "cart");
            return (Criteria) this;
        }

        public Criteria andCartGreaterThan(String value) {
            addCriterion("cart >", value, "cart");
            return (Criteria) this;
        }

        public Criteria andCartGreaterThanOrEqualTo(String value) {
            addCriterion("cart >=", value, "cart");
            return (Criteria) this;
        }

        public Criteria andCartLessThan(String value) {
            addCriterion("cart <", value, "cart");
            return (Criteria) this;
        }

        public Criteria andCartLessThanOrEqualTo(String value) {
            addCriterion("cart <=", value, "cart");
            return (Criteria) this;
        }

        public Criteria andCartLike(String value) {
            addCriterion("cart like", value, "cart");
            return (Criteria) this;
        }

        public Criteria andCartNotLike(String value) {
            addCriterion("cart not like", value, "cart");
            return (Criteria) this;
        }

        public Criteria andCartIn(List<String> values) {
            addCriterion("cart in", values, "cart");
            return (Criteria) this;
        }

        public Criteria andCartNotIn(List<String> values) {
            addCriterion("cart not in", values, "cart");
            return (Criteria) this;
        }

        public Criteria andCartBetween(String value1, String value2) {
            addCriterion("cart between", value1, value2, "cart");
            return (Criteria) this;
        }

        public Criteria andCartNotBetween(String value1, String value2) {
            addCriterion("cart not between", value1, value2, "cart");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table users
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table users
     *
     * @mbggenerated
     */
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