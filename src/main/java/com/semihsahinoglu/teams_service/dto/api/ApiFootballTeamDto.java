package com.semihsahinoglu.teams_service.dto.api;

public class ApiFootballTeamDto {

    private Long id;

    private String name;

    private String country;

    private String code;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getCode() {
        return code;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCode(String code) {
        this.code = code;
    }
}