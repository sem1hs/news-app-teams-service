package com.semihsahinoglu.teams_service.client;

import com.semihsahinoglu.teams_service.config.InternalFeignConfig;
import com.semihsahinoglu.teams_service.dto.feign.LeagueResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "league-service", configuration = InternalFeignConfig.class)
public interface LeagueClient {

    @GetMapping("/internal/league/{id}/exists")
    Boolean existsById(@PathVariable Long id);

    @GetMapping("/internal/league/country/{country}")
    LeagueResponse getLeagueByCountry(@PathVariable String country, @RequestParam(defaultValue = "2025") int season);

    @GetMapping("/internal/league/external/{id}")
    LeagueResponse getLeagueByExternalId(@PathVariable Long id, @RequestParam(defaultValue = "2025") int season);
}
