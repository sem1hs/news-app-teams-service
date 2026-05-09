package com.semihsahinoglu.teams_service.dto.api;

public record ApiFootballTeamDto(
        Long id,
        String name,
        String country,
        String code,
        String logo
) {
}