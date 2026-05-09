package com.semihsahinoglu.teams_service.dto.api;

import java.util.List;

public record ApiFootballTeamResponse(
        List<ApiFootballTeamWrapper> response
) {
}