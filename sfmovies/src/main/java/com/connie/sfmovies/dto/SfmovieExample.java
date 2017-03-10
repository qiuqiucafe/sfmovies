package com.connie.sfmovies.dto;

import java.util.ArrayList;
import java.util.List;

public class SfmovieExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SfmovieExample() {
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

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andReleaseyearIsNull() {
            addCriterion("releaseyear is null");
            return (Criteria) this;
        }

        public Criteria andReleaseyearIsNotNull() {
            addCriterion("releaseyear is not null");
            return (Criteria) this;
        }

        public Criteria andReleaseyearEqualTo(String value) {
            addCriterion("releaseyear =", value, "releaseyear");
            return (Criteria) this;
        }

        public Criteria andReleaseyearNotEqualTo(String value) {
            addCriterion("releaseyear <>", value, "releaseyear");
            return (Criteria) this;
        }

        public Criteria andReleaseyearGreaterThan(String value) {
            addCriterion("releaseyear >", value, "releaseyear");
            return (Criteria) this;
        }

        public Criteria andReleaseyearGreaterThanOrEqualTo(String value) {
            addCriterion("releaseyear >=", value, "releaseyear");
            return (Criteria) this;
        }

        public Criteria andReleaseyearLessThan(String value) {
            addCriterion("releaseyear <", value, "releaseyear");
            return (Criteria) this;
        }

        public Criteria andReleaseyearLessThanOrEqualTo(String value) {
            addCriterion("releaseyear <=", value, "releaseyear");
            return (Criteria) this;
        }

        public Criteria andReleaseyearLike(String value) {
            addCriterion("releaseyear like", value, "releaseyear");
            return (Criteria) this;
        }

        public Criteria andReleaseyearNotLike(String value) {
            addCriterion("releaseyear not like", value, "releaseyear");
            return (Criteria) this;
        }

        public Criteria andReleaseyearIn(List<String> values) {
            addCriterion("releaseyear in", values, "releaseyear");
            return (Criteria) this;
        }

        public Criteria andReleaseyearNotIn(List<String> values) {
            addCriterion("releaseyear not in", values, "releaseyear");
            return (Criteria) this;
        }

        public Criteria andReleaseyearBetween(String value1, String value2) {
            addCriterion("releaseyear between", value1, value2, "releaseyear");
            return (Criteria) this;
        }

        public Criteria andReleaseyearNotBetween(String value1, String value2) {
            addCriterion("releaseyear not between", value1, value2, "releaseyear");
            return (Criteria) this;
        }

        public Criteria andLocationsIsNull() {
            addCriterion("locations is null");
            return (Criteria) this;
        }

        public Criteria andLocationsIsNotNull() {
            addCriterion("locations is not null");
            return (Criteria) this;
        }

        public Criteria andLocationsEqualTo(String value) {
            addCriterion("locations =", value, "locations");
            return (Criteria) this;
        }

        public Criteria andLocationsNotEqualTo(String value) {
            addCriterion("locations <>", value, "locations");
            return (Criteria) this;
        }

        public Criteria andLocationsGreaterThan(String value) {
            addCriterion("locations >", value, "locations");
            return (Criteria) this;
        }

        public Criteria andLocationsGreaterThanOrEqualTo(String value) {
            addCriterion("locations >=", value, "locations");
            return (Criteria) this;
        }

        public Criteria andLocationsLessThan(String value) {
            addCriterion("locations <", value, "locations");
            return (Criteria) this;
        }

        public Criteria andLocationsLessThanOrEqualTo(String value) {
            addCriterion("locations <=", value, "locations");
            return (Criteria) this;
        }

        public Criteria andLocationsLike(String value) {
            addCriterion("locations like", value, "locations");
            return (Criteria) this;
        }

        public Criteria andLocationsNotLike(String value) {
            addCriterion("locations not like", value, "locations");
            return (Criteria) this;
        }

        public Criteria andLocationsIn(List<String> values) {
            addCriterion("locations in", values, "locations");
            return (Criteria) this;
        }

        public Criteria andLocationsNotIn(List<String> values) {
            addCriterion("locations not in", values, "locations");
            return (Criteria) this;
        }

        public Criteria andLocationsBetween(String value1, String value2) {
            addCriterion("locations between", value1, value2, "locations");
            return (Criteria) this;
        }

        public Criteria andLocationsNotBetween(String value1, String value2) {
            addCriterion("locations not between", value1, value2, "locations");
            return (Criteria) this;
        }

        public Criteria andFunfactsIsNull() {
            addCriterion("funfacts is null");
            return (Criteria) this;
        }

        public Criteria andFunfactsIsNotNull() {
            addCriterion("funfacts is not null");
            return (Criteria) this;
        }

        public Criteria andFunfactsEqualTo(String value) {
            addCriterion("funfacts =", value, "funfacts");
            return (Criteria) this;
        }

        public Criteria andFunfactsNotEqualTo(String value) {
            addCriterion("funfacts <>", value, "funfacts");
            return (Criteria) this;
        }

        public Criteria andFunfactsGreaterThan(String value) {
            addCriterion("funfacts >", value, "funfacts");
            return (Criteria) this;
        }

        public Criteria andFunfactsGreaterThanOrEqualTo(String value) {
            addCriterion("funfacts >=", value, "funfacts");
            return (Criteria) this;
        }

        public Criteria andFunfactsLessThan(String value) {
            addCriterion("funfacts <", value, "funfacts");
            return (Criteria) this;
        }

        public Criteria andFunfactsLessThanOrEqualTo(String value) {
            addCriterion("funfacts <=", value, "funfacts");
            return (Criteria) this;
        }

        public Criteria andFunfactsLike(String value) {
            addCriterion("funfacts like", value, "funfacts");
            return (Criteria) this;
        }

        public Criteria andFunfactsNotLike(String value) {
            addCriterion("funfacts not like", value, "funfacts");
            return (Criteria) this;
        }

        public Criteria andFunfactsIn(List<String> values) {
            addCriterion("funfacts in", values, "funfacts");
            return (Criteria) this;
        }

        public Criteria andFunfactsNotIn(List<String> values) {
            addCriterion("funfacts not in", values, "funfacts");
            return (Criteria) this;
        }

        public Criteria andFunfactsBetween(String value1, String value2) {
            addCriterion("funfacts between", value1, value2, "funfacts");
            return (Criteria) this;
        }

        public Criteria andFunfactsNotBetween(String value1, String value2) {
            addCriterion("funfacts not between", value1, value2, "funfacts");
            return (Criteria) this;
        }

        public Criteria andCompanyIsNull() {
            addCriterion("company is null");
            return (Criteria) this;
        }

        public Criteria andCompanyIsNotNull() {
            addCriterion("company is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyEqualTo(String value) {
            addCriterion("company =", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotEqualTo(String value) {
            addCriterion("company <>", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyGreaterThan(String value) {
            addCriterion("company >", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("company >=", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLessThan(String value) {
            addCriterion("company <", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLessThanOrEqualTo(String value) {
            addCriterion("company <=", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLike(String value) {
            addCriterion("company like", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotLike(String value) {
            addCriterion("company not like", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyIn(List<String> values) {
            addCriterion("company in", values, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotIn(List<String> values) {
            addCriterion("company not in", values, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyBetween(String value1, String value2) {
            addCriterion("company between", value1, value2, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotBetween(String value1, String value2) {
            addCriterion("company not between", value1, value2, "company");
            return (Criteria) this;
        }

        public Criteria andDistributorIsNull() {
            addCriterion("distributor is null");
            return (Criteria) this;
        }

        public Criteria andDistributorIsNotNull() {
            addCriterion("distributor is not null");
            return (Criteria) this;
        }

        public Criteria andDistributorEqualTo(String value) {
            addCriterion("distributor =", value, "distributor");
            return (Criteria) this;
        }

        public Criteria andDistributorNotEqualTo(String value) {
            addCriterion("distributor <>", value, "distributor");
            return (Criteria) this;
        }

        public Criteria andDistributorGreaterThan(String value) {
            addCriterion("distributor >", value, "distributor");
            return (Criteria) this;
        }

        public Criteria andDistributorGreaterThanOrEqualTo(String value) {
            addCriterion("distributor >=", value, "distributor");
            return (Criteria) this;
        }

        public Criteria andDistributorLessThan(String value) {
            addCriterion("distributor <", value, "distributor");
            return (Criteria) this;
        }

        public Criteria andDistributorLessThanOrEqualTo(String value) {
            addCriterion("distributor <=", value, "distributor");
            return (Criteria) this;
        }

        public Criteria andDistributorLike(String value) {
            addCriterion("distributor like", value, "distributor");
            return (Criteria) this;
        }

        public Criteria andDistributorNotLike(String value) {
            addCriterion("distributor not like", value, "distributor");
            return (Criteria) this;
        }

        public Criteria andDistributorIn(List<String> values) {
            addCriterion("distributor in", values, "distributor");
            return (Criteria) this;
        }

        public Criteria andDistributorNotIn(List<String> values) {
            addCriterion("distributor not in", values, "distributor");
            return (Criteria) this;
        }

        public Criteria andDistributorBetween(String value1, String value2) {
            addCriterion("distributor between", value1, value2, "distributor");
            return (Criteria) this;
        }

        public Criteria andDistributorNotBetween(String value1, String value2) {
            addCriterion("distributor not between", value1, value2, "distributor");
            return (Criteria) this;
        }

        public Criteria andDirectorIsNull() {
            addCriterion("director is null");
            return (Criteria) this;
        }

        public Criteria andDirectorIsNotNull() {
            addCriterion("director is not null");
            return (Criteria) this;
        }

        public Criteria andDirectorEqualTo(String value) {
            addCriterion("director =", value, "director");
            return (Criteria) this;
        }

        public Criteria andDirectorNotEqualTo(String value) {
            addCriterion("director <>", value, "director");
            return (Criteria) this;
        }

        public Criteria andDirectorGreaterThan(String value) {
            addCriterion("director >", value, "director");
            return (Criteria) this;
        }

        public Criteria andDirectorGreaterThanOrEqualTo(String value) {
            addCriterion("director >=", value, "director");
            return (Criteria) this;
        }

        public Criteria andDirectorLessThan(String value) {
            addCriterion("director <", value, "director");
            return (Criteria) this;
        }

        public Criteria andDirectorLessThanOrEqualTo(String value) {
            addCriterion("director <=", value, "director");
            return (Criteria) this;
        }

        public Criteria andDirectorLike(String value) {
            addCriterion("director like", value, "director");
            return (Criteria) this;
        }

        public Criteria andDirectorNotLike(String value) {
            addCriterion("director not like", value, "director");
            return (Criteria) this;
        }

        public Criteria andDirectorIn(List<String> values) {
            addCriterion("director in", values, "director");
            return (Criteria) this;
        }

        public Criteria andDirectorNotIn(List<String> values) {
            addCriterion("director not in", values, "director");
            return (Criteria) this;
        }

        public Criteria andDirectorBetween(String value1, String value2) {
            addCriterion("director between", value1, value2, "director");
            return (Criteria) this;
        }

        public Criteria andDirectorNotBetween(String value1, String value2) {
            addCriterion("director not between", value1, value2, "director");
            return (Criteria) this;
        }

        public Criteria andWriterIsNull() {
            addCriterion("writer is null");
            return (Criteria) this;
        }

        public Criteria andWriterIsNotNull() {
            addCriterion("writer is not null");
            return (Criteria) this;
        }

        public Criteria andWriterEqualTo(String value) {
            addCriterion("writer =", value, "writer");
            return (Criteria) this;
        }

        public Criteria andWriterNotEqualTo(String value) {
            addCriterion("writer <>", value, "writer");
            return (Criteria) this;
        }

        public Criteria andWriterGreaterThan(String value) {
            addCriterion("writer >", value, "writer");
            return (Criteria) this;
        }

        public Criteria andWriterGreaterThanOrEqualTo(String value) {
            addCriterion("writer >=", value, "writer");
            return (Criteria) this;
        }

        public Criteria andWriterLessThan(String value) {
            addCriterion("writer <", value, "writer");
            return (Criteria) this;
        }

        public Criteria andWriterLessThanOrEqualTo(String value) {
            addCriterion("writer <=", value, "writer");
            return (Criteria) this;
        }

        public Criteria andWriterLike(String value) {
            addCriterion("writer like", value, "writer");
            return (Criteria) this;
        }

        public Criteria andWriterNotLike(String value) {
            addCriterion("writer not like", value, "writer");
            return (Criteria) this;
        }

        public Criteria andWriterIn(List<String> values) {
            addCriterion("writer in", values, "writer");
            return (Criteria) this;
        }

        public Criteria andWriterNotIn(List<String> values) {
            addCriterion("writer not in", values, "writer");
            return (Criteria) this;
        }

        public Criteria andWriterBetween(String value1, String value2) {
            addCriterion("writer between", value1, value2, "writer");
            return (Criteria) this;
        }

        public Criteria andWriterNotBetween(String value1, String value2) {
            addCriterion("writer not between", value1, value2, "writer");
            return (Criteria) this;
        }

        public Criteria andActor1IsNull() {
            addCriterion("actor1 is null");
            return (Criteria) this;
        }

        public Criteria andActor1IsNotNull() {
            addCriterion("actor1 is not null");
            return (Criteria) this;
        }

        public Criteria andActor1EqualTo(String value) {
            addCriterion("actor1 =", value, "actor1");
            return (Criteria) this;
        }

        public Criteria andActor1NotEqualTo(String value) {
            addCriterion("actor1 <>", value, "actor1");
            return (Criteria) this;
        }

        public Criteria andActor1GreaterThan(String value) {
            addCriterion("actor1 >", value, "actor1");
            return (Criteria) this;
        }

        public Criteria andActor1GreaterThanOrEqualTo(String value) {
            addCriterion("actor1 >=", value, "actor1");
            return (Criteria) this;
        }

        public Criteria andActor1LessThan(String value) {
            addCriterion("actor1 <", value, "actor1");
            return (Criteria) this;
        }

        public Criteria andActor1LessThanOrEqualTo(String value) {
            addCriterion("actor1 <=", value, "actor1");
            return (Criteria) this;
        }

        public Criteria andActor1Like(String value) {
            addCriterion("actor1 like", value, "actor1");
            return (Criteria) this;
        }

        public Criteria andActor1NotLike(String value) {
            addCriterion("actor1 not like", value, "actor1");
            return (Criteria) this;
        }

        public Criteria andActor1In(List<String> values) {
            addCriterion("actor1 in", values, "actor1");
            return (Criteria) this;
        }

        public Criteria andActor1NotIn(List<String> values) {
            addCriterion("actor1 not in", values, "actor1");
            return (Criteria) this;
        }

        public Criteria andActor1Between(String value1, String value2) {
            addCriterion("actor1 between", value1, value2, "actor1");
            return (Criteria) this;
        }

        public Criteria andActor1NotBetween(String value1, String value2) {
            addCriterion("actor1 not between", value1, value2, "actor1");
            return (Criteria) this;
        }

        public Criteria andActor2IsNull() {
            addCriterion("actor2 is null");
            return (Criteria) this;
        }

        public Criteria andActor2IsNotNull() {
            addCriterion("actor2 is not null");
            return (Criteria) this;
        }

        public Criteria andActor2EqualTo(String value) {
            addCriterion("actor2 =", value, "actor2");
            return (Criteria) this;
        }

        public Criteria andActor2NotEqualTo(String value) {
            addCriterion("actor2 <>", value, "actor2");
            return (Criteria) this;
        }

        public Criteria andActor2GreaterThan(String value) {
            addCriterion("actor2 >", value, "actor2");
            return (Criteria) this;
        }

        public Criteria andActor2GreaterThanOrEqualTo(String value) {
            addCriterion("actor2 >=", value, "actor2");
            return (Criteria) this;
        }

        public Criteria andActor2LessThan(String value) {
            addCriterion("actor2 <", value, "actor2");
            return (Criteria) this;
        }

        public Criteria andActor2LessThanOrEqualTo(String value) {
            addCriterion("actor2 <=", value, "actor2");
            return (Criteria) this;
        }

        public Criteria andActor2Like(String value) {
            addCriterion("actor2 like", value, "actor2");
            return (Criteria) this;
        }

        public Criteria andActor2NotLike(String value) {
            addCriterion("actor2 not like", value, "actor2");
            return (Criteria) this;
        }

        public Criteria andActor2In(List<String> values) {
            addCriterion("actor2 in", values, "actor2");
            return (Criteria) this;
        }

        public Criteria andActor2NotIn(List<String> values) {
            addCriterion("actor2 not in", values, "actor2");
            return (Criteria) this;
        }

        public Criteria andActor2Between(String value1, String value2) {
            addCriterion("actor2 between", value1, value2, "actor2");
            return (Criteria) this;
        }

        public Criteria andActor2NotBetween(String value1, String value2) {
            addCriterion("actor2 not between", value1, value2, "actor2");
            return (Criteria) this;
        }

        public Criteria andActor3IsNull() {
            addCriterion("actor3 is null");
            return (Criteria) this;
        }

        public Criteria andActor3IsNotNull() {
            addCriterion("actor3 is not null");
            return (Criteria) this;
        }

        public Criteria andActor3EqualTo(String value) {
            addCriterion("actor3 =", value, "actor3");
            return (Criteria) this;
        }

        public Criteria andActor3NotEqualTo(String value) {
            addCriterion("actor3 <>", value, "actor3");
            return (Criteria) this;
        }

        public Criteria andActor3GreaterThan(String value) {
            addCriterion("actor3 >", value, "actor3");
            return (Criteria) this;
        }

        public Criteria andActor3GreaterThanOrEqualTo(String value) {
            addCriterion("actor3 >=", value, "actor3");
            return (Criteria) this;
        }

        public Criteria andActor3LessThan(String value) {
            addCriterion("actor3 <", value, "actor3");
            return (Criteria) this;
        }

        public Criteria andActor3LessThanOrEqualTo(String value) {
            addCriterion("actor3 <=", value, "actor3");
            return (Criteria) this;
        }

        public Criteria andActor3Like(String value) {
            addCriterion("actor3 like", value, "actor3");
            return (Criteria) this;
        }

        public Criteria andActor3NotLike(String value) {
            addCriterion("actor3 not like", value, "actor3");
            return (Criteria) this;
        }

        public Criteria andActor3In(List<String> values) {
            addCriterion("actor3 in", values, "actor3");
            return (Criteria) this;
        }

        public Criteria andActor3NotIn(List<String> values) {
            addCriterion("actor3 not in", values, "actor3");
            return (Criteria) this;
        }

        public Criteria andActor3Between(String value1, String value2) {
            addCriterion("actor3 between", value1, value2, "actor3");
            return (Criteria) this;
        }

        public Criteria andActor3NotBetween(String value1, String value2) {
            addCriterion("actor3 not between", value1, value2, "actor3");
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