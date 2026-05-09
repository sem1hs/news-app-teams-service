package com.semihsahinoglu.teams_service.service;

import com.semihsahinoglu.teams_service.client.LeagueClient;
import com.semihsahinoglu.teams_service.dto.TeamCreateRequest;
import com.semihsahinoglu.teams_service.dto.TeamResponse;
import com.semihsahinoglu.teams_service.dto.TeamUpdateRequest;
import com.semihsahinoglu.teams_service.entity.Team;
import com.semihsahinoglu.teams_service.exception.TeamAlreadyExistsException;
import com.semihsahinoglu.teams_service.exception.TeamNotFoundException;
import com.semihsahinoglu.teams_service.mapper.TeamMapper;
import com.semihsahinoglu.teams_service.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    private final TeamRepository teamRepository;
    private final TeamMapper teamMapper;
    private final TeamSyncService teamSyncService;
    private final LeagueClient leagueClient;

    public TeamService(TeamRepository teamRepository, TeamMapper teamMapper, TeamSyncService teamSyncService, LeagueClient leagueClient) {
        this.teamRepository = teamRepository;
        this.teamMapper = teamMapper;
        this.teamSyncService = teamSyncService;
        this.leagueClient = leagueClient;
    }

    public TeamResponse getById(Long id) {
        Team team = teamRepository.findById(id).orElseThrow(() -> new TeamNotFoundException("Takım Bulunamadı ! " + id));
        return teamMapper.toDto(team);
    }

    public TeamResponse getByExternalId(Long externalId) {
        Team team = teamRepository.findByExternalId(externalId).orElseGet(() -> teamSyncService.syncTeam(externalId));
        return teamMapper.toDto(team);
    }

    public List<TeamResponse> getAll() {
        List<Team> teams = teamRepository.findAll();
        return teams.stream().map(teamMapper::toDto).toList();
    }

    public List<TeamResponse> getByLeagueId(Long leagueId) {
        Boolean exists = leagueClient.existsById(leagueId);
        if (!exists) throw new TeamNotFoundException("Ligdeki Takımlar Bulunamadı ! " + leagueId);
        List<Team> teams = teamRepository.findTeamsByLeagueId(leagueId).orElseThrow(() -> new TeamNotFoundException("Ligdeki Takımlar Bulunamadı ! " + leagueId));
        return teams.stream().map(teamMapper::toDto).toList();
    }

    public List<TeamResponse> bulkTeamsByLeague(Long leagueExternalId, int season) {
        List<Team> teams = teamSyncService.syncTeamsByLeague(leagueExternalId, season);
        return teams.stream()
                .map(teamMapper::toDto)
                .toList();
    }

    public TeamResponse create(TeamCreateRequest teamCreateRequest) {
        Team team = teamMapper.toEntity(teamCreateRequest);
        if (teamRepository.existsTeamByName(team.getName()))
            throw new TeamAlreadyExistsException("Takım Zaten Eklenmiş " + team.getName());
        Team savedTeam = teamRepository.save(team);
        return teamMapper.toDto(savedTeam);
    }

    public TeamResponse update(Long id, TeamUpdateRequest teamUpdateRequest) {
        Team league = teamRepository.findById(id).orElseThrow(() -> new TeamNotFoundException("Lig bulunamadı " + id));
        teamMapper.updateEntity(league, teamUpdateRequest);
        Team updatedLeague = teamRepository.save(league);
        return teamMapper.toDto(updatedLeague);
    }

    public void delete(Long id) {
        Team league = teamRepository.findById(id).orElseThrow(() -> new TeamNotFoundException("Lig bulunamadı " + id));
        teamRepository.delete(league);
    }

    public Boolean existsById(Long id) {
        return teamRepository.existsById(id);
    }
}
