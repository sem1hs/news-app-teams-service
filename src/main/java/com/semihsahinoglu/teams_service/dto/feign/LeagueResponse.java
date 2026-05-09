package com.semihsahinoglu.teams_service.dto.feign;

public record LeagueResponse(
        Long id,
        Long externalId,
        String name,
        String country,
        String logoUrl

) {

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private Long externalId;
        private String name;
        private String country;
        private String logoUrl;

        private Builder() {
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder externalId(Long externalId) {
            this.externalId = externalId;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder country(String country) {
            this.country = country;
            return this;
        }

        public Builder logoUrl(String logoUrl) {
            this.logoUrl = logoUrl;
            return this;
        }

        public LeagueResponse build() {
            return new LeagueResponse(id, externalId, name, country, logoUrl);
        }
    }
}