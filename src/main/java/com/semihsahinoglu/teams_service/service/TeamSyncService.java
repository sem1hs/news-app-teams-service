package com.semihsahinoglu.teams_service.service;

import com.semihsahinoglu.teams_service.client.FootballTeamApiClient;
import com.semihsahinoglu.teams_service.client.LeagueClient;
import com.semihsahinoglu.teams_service.dto.api.ApiFootballTeamDto;
import com.semihsahinoglu.teams_service.dto.api.ApiFootballTeamResponse;
import com.semihsahinoglu.teams_service.dto.feign.LeagueResponse;
import com.semihsahinoglu.teams_service.entity.Team;
import com.semihsahinoglu.teams_service.exception.TeamNotFoundException;
import com.semihsahinoglu.teams_service.mapper.TeamMapper;
import com.semihsahinoglu.teams_service.repository.TeamRepository;
import org.springframework.stereotype.Service;

@Service
public class TeamSyncService {

    private final FootballTeamApiClient footballTeamApiClient;
    private final LeagueClient leagueClient;
    private final TeamRepository teamRepository;
    private final TeamMapper teamMapper;

    public TeamSyncService(FootballTeamApiClient footballTeamApiClient, LeagueClient leagueClient, TeamRepository teamRepository, TeamMapper teamMapper) {
        this.footballTeamApiClient = footballTeamApiClient;
        this.leagueClient = leagueClient;
        this.teamRepository = teamRepository;
        this.teamMapper = teamMapper;
    }


    public Team syncTeam(Long externalId) {
        ApiFootballTeamResponse response = footballTeamApiClient.getTeam(externalId);

        if (response == null || response.response() == null || response.response().isEmpty())
            throw new TeamNotFoundException("Takım bulunamadı : " + externalId);

        ApiFootballTeamDto apiTeam = response
                .response()
                .getFirst()
                .team();

        LeagueResponse league = leagueClient.getLeagueByCountry(apiTeam.country(), 2025);
        Team team = teamMapper.toEntity(apiTeam, league);
        return teamRepository.save(team);
    }
}
