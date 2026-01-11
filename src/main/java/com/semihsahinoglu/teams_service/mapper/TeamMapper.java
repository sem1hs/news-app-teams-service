package com.semihsahinoglu.teams_service.mapper;

import com.semihsahinoglu.teams_service.dto.TeamCreateRequest;
import com.semihsahinoglu.teams_service.dto.TeamResponse;
import com.semihsahinoglu.teams_service.dto.TeamUpdateRequest;
import com.semihsahinoglu.teams_service.entity.Team;
import org.springframework.stereotype.Component;

@Component
public class TeamMapper {

    public Team toEntity(TeamCreateRequest dto) {
        return Team.builder()
                .name(dto.name())
                .shortName(dto.shortName())
                .logoUrl(dto.logoUrl())
                .leagueId(dto.leagueId())
                .build();
    }

    public TeamResponse toDto(Team team) {
        return TeamResponse.builder()
                .id(team.getId())
                .name(team.getName())
                .shortName(team.getShortName())
                .logoUrl(team.getLogoUrl())
                .leagueId(team.getLeagueId())
                .build();
    }

    public void updateEntity(Team team, TeamUpdateRequest teamUpdateRequest) {
        teamUpdateRequest.name().ifPresent(team::setName);
        teamUpdateRequest.shortName().ifPresent(team::setShortName);
        teamUpdateRequest.logoUrl().ifPresent(team::setLogoUrl);
        teamUpdateRequest.leagueId().ifPresent(team::setLeagueId);
    }
}
