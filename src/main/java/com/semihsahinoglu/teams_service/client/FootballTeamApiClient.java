package com.semihsahinoglu.teams_service.client;

import com.semihsahinoglu.teams_service.dto.api.ApiFootballTeamResponse;
import com.semihsahinoglu.teams_service.exception.TeamNotFoundException;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class FootballTeamApiClient {

    private final WebClient footballWebClient;

    public FootballTeamApiClient(WebClient footballWebClient) {
        this.footballWebClient = footballWebClient;
    }

    public ApiFootballTeamResponse getTeam(Long teamId) {

        return footballWebClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/teams")
                        .queryParam("id", teamId)
                        .build())
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, response -> Mono.error(new TeamNotFoundException("Takım bulunamadı : " + teamId)))
                .onStatus(HttpStatusCode::is5xxServerError, response -> Mono.error(new RuntimeException("Football API currently unavailable")))
                .bodyToMono(ApiFootballTeamResponse.class)
                .block();
    }
}
