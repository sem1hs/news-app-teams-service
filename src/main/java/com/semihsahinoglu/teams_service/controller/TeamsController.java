package com.semihsahinoglu.teams_service.controller;

import com.semihsahinoglu.teams_service.dto.TeamCreateRequest;
import com.semihsahinoglu.teams_service.dto.TeamResponse;
import com.semihsahinoglu.teams_service.service.TeamService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/teams")
public class TeamsController {

    private final TeamService teamService;

    public TeamsController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping
    public ResponseEntity<List<TeamResponse>> getTeams(@RequestParam(required = false) Long leagueId) {
        List<TeamResponse> teams = (leagueId == null) ? teamService.getAll() : teamService.getByLeagueId(leagueId);
        return ResponseEntity.status(HttpStatus.OK).body(teams);
    }


    @GetMapping("/{id}")
    public ResponseEntity<TeamResponse> getTeamById(@PathVariable Long id) {
        TeamResponse team = teamService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(team);
    }


    @PostMapping
    public ResponseEntity<TeamResponse> createTeam(@Valid @RequestBody TeamCreateRequest request) {
        TeamResponse team = teamService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(team);
    }
}
