package com.semihsahinoglu.teams_service.dto;

public record TeamResponse(
        Long id,
        String name,
        String shortName,
        String logoUrl,
        Long leagueId
) {

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private String name;
        private String shortName;
        private String logoUrl;
        private Long leagueId;

        private Builder() {
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder shortName(String shortName) {
            this.shortName = shortName;
            return this;
        }

        public Builder logoUrl(String logoUrl) {
            this.logoUrl = logoUrl;
            return this;
        }

        public Builder leagueId(Long leagueId) {
            this.leagueId = leagueId;
            return this;
        }

        public TeamResponse build() {
            return new TeamResponse(id, name, shortName, logoUrl, leagueId);
        }
    }
}
