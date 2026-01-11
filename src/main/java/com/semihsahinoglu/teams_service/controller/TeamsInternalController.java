package com.semihsahinoglu.teams_service.controller;

import com.semihsahinoglu.teams_service.dto.TeamResponse;
import com.semihsahinoglu.teams_service.service.TeamService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/internal/teams")
public class TeamsInternalController {

    private final TeamService teamService;

    public TeamsInternalController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("/{id}/exists")
    public Boolean existsById(@PathVariable Long id) {
        return teamService.existsById(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeamResponse> getTeamById(@PathVariable Long id) {
        TeamResponse teamResponse = teamService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(teamResponse);
    }
}
