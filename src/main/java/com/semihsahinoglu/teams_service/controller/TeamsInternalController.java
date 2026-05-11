package com.semihsahinoglu.teams_service.controller;

import com.semihsahinoglu.teams_service.dto.TeamResponse;
import com.semihsahinoglu.teams_service.service.TeamService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/external/{id}")
    public ResponseEntity<TeamResponse> getTeamByExternalId(@PathVariable Long id) {
        TeamResponse teamResponse = teamService.getByExternalId(id);
        return ResponseEntity.status(HttpStatus.OK).body(teamResponse);
    }

}
