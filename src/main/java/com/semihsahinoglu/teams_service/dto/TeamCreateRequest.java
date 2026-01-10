package com.semihsahinoglu.teams_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TeamCreateRequest(
        @NotBlank(message = "Team name cannot be blank")
        String name,

        @NotBlank(message = "Team short name cannot be blank")
        String shortName,

        String logoUrl,

        @NotNull(message = "League id is required")
        Long leagueId
) {
}
