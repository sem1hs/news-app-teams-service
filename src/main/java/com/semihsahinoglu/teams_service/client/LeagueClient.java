package com.semihsahinoglu.teams_service.client;

import com.semihsahinoglu.teams_service.config.InternalFeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "league-service",configuration = InternalFeignConfig.class)
public interface LeagueClient {

    @GetMapping("/internal/league/{id}/exists")
    Boolean existsById(@PathVariable("id") Long id);
}
