package com.connie.sfmovies.dto;

public class Sfmovie {
    private Integer id;

    private String title;

    private String releaseyear;

    private String locations;

    private String funfacts;

    private String company;

    private String distributor;

    private String director;

    private String writer;

    private String actor1;

    private String actor2;

    private String actor3;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getReleaseyear() {
        return releaseyear;
    }

    public void setReleaseyear(String releaseyear) {
        this.releaseyear = releaseyear == null ? null : releaseyear.trim();
    }

    public String getLocations() {
        return locations;
    }

    public void setLocations(String locations) {
        this.locations = locations == null ? null : locations.trim();
    }

    public String getFunfacts() {
        return funfacts;
    }

    public void setFunfacts(String funfacts) {
        this.funfacts = funfacts == null ? null : funfacts.trim();
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public String getDistributor() {
        return distributor;
    }

    public void setDistributor(String distributor) {
        this.distributor = distributor == null ? null : distributor.trim();
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director == null ? null : director.trim();
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer == null ? null : writer.trim();
    }

    public String getActor1() {
        return actor1;
    }

    public void setActor1(String actor1) {
        this.actor1 = actor1 == null ? null : actor1.trim();
    }

    public String getActor2() {
        return actor2;
    }

    public void setActor2(String actor2) {
        this.actor2 = actor2 == null ? null : actor2.trim();
    }

    public String getActor3() {
        return actor3;
    }

    public void setActor3(String actor3) {
        this.actor3 = actor3 == null ? null : actor3.trim();
    }
}