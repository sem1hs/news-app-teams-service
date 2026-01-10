package com.semihsahinoglu.teams_service.service;

import com.semihsahinoglu.teams_service.client.LeagueClient;
import com.semihsahinoglu.teams_service.dto.TeamCreateRequest;
import com.semihsahinoglu.teams_service.dto.TeamResponse;
import com.semihsahinoglu.teams_service.entity.Team;
import com.semihsahinoglu.teams_service.exception.TeamNotFoundException;
import com.semihsahinoglu.teams_service.mapper.TeamMapper;
import com.semihsahinoglu.teams_service.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    private final TeamRepository teamRepository;
    private final TeamMapper teamMapper;
    private final LeagueClient leagueClient;

    public TeamService(TeamRepository teamRepository, TeamMapper teamMapper, LeagueClient leagueClient) {
        this.teamRepository = teamRepository;
        this.teamMapper = teamMapper;
        this.leagueClient = leagueClient;
    }

    public TeamResponse getById(Long id) {
        Team team = teamRepository.findById(id).orElseThrow(() -> new TeamNotFoundException("Takım Bulunamadı ! " + id));
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

    public TeamResponse create(TeamCreateRequest teamCreateRequest) {
        Team team = teamMapper.toEntity(teamCreateRequest);
        Team savedTeam = teamRepository.save(team);
        return teamMapper.toDto(savedTeam);
    }
}
