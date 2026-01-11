package com.semihsahinoglu.teams_service.dto;

import java.util.Optional;

public record TeamUpdateRequest(
        Optional<String> name,
        Optional<String> shortName,
        Optional<String> logoUrl,
        Optional<Long> leagueId
) {
}
