package com.semihsahinoglu.teams_service.dto.api;

import java.util.List;

public class ApiFootballTeamResponse {

    private List<ApiFootballTeamWrapper> response;

    public List<ApiFootballTeamWrapper> getResponse() {
        return response;
    }

    public void setResponse(List<ApiFootballTeamWrapper> response) {
        this.response = response;
    }
}