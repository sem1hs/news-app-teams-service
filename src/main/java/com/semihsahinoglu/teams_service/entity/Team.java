package com.semihsahinoglu.teams_service.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "teams")
public class Team extends Auditable {

    @NotBlank(message = "Takım ismi boş olamaz !")
    @Column(nullable = false)
    private String name;

    @NotBlank(message = "Takım kısaltması boş olamaz !")
    @Column(name = "short_name", nullable = false, length = 10)
    private String shortName;

    @Column(name = "logo_url")
    private String logoUrl;

    @NotNull(message = "League id is required")
    @Column(name = "league_id", nullable = false)
    private Long leagueId;

    protected Team() {
    }

    public Team(String name, String shortName, String logoUrl, Long leagueId) {
        this.name = name;
        this.shortName = shortName;
        this.logoUrl = logoUrl;
        this.leagueId = leagueId;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String name;
        private String shortName;
        private String logoUrl;
        private Long leagueId;

        private Builder() {
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

        public Team build() {
            return new Team(name, shortName, logoUrl, leagueId);
        }
    }

    public String getName() {
        return name;
    }

    public String getShortName() {
        return shortName;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public Long getLeagueId() {
        return leagueId;
    }
}
