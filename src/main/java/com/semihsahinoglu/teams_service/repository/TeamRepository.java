package com.semihsahinoglu.teams_service.repository;

import com.semihsahinoglu.teams_service.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

    Optional<List<Team>> findTeamsByLeagueId(Long leagueId);
}
