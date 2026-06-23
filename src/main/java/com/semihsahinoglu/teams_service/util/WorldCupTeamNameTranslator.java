package com.semihsahinoglu.teams_service.util;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class WorldCupTeamNameTranslator {

    private static final Map<String, String> TEAM_NAMES = Map.ofEntries(
            Map.entry("Mexico", "Meksika"),
            Map.entry("South Korea", "Güney Kore"),
            Map.entry("Czech Republic", "Çekya"),
            Map.entry("South Africa", "Güney Afrika"),
            Map.entry("Canada", "Kanada"),
            Map.entry("Switzerland", "İsviçre"),
            Map.entry("Bosnia & Herzegovina", "Bosna Hersek"),
            Map.entry("Qatar", "Katar"),
            Map.entry("Brazil", "Brezilya"),
            Map.entry("Morocco", "Fas"),
            Map.entry("Scotland", "İskoçya"),
            Map.entry("Haiti", "Haiti"),
            Map.entry("USA", "ABD"),
            Map.entry("Australia", "Avustralya"),
            Map.entry("Paraguay", "Paraguay"),
            Map.entry("Türkiye", "Türkiye"),
            Map.entry("Germany", "Almanya"),
            Map.entry("Ivory Coast", "Fildişi Sahili"),
            Map.entry("Ecuador", "Ekvador"),
            Map.entry("Curaçao", "Curaçao"),
            Map.entry("Netherlands", "Hollanda"),
            Map.entry("Japan", "Japonya"),
            Map.entry("Sweden", "İsveç"),
            Map.entry("Tunisia", "Tunus"),
            Map.entry("Egypt", "Mısır"),
            Map.entry("Iran", "İran"),
            Map.entry("Belgium", "Belçika"),
            Map.entry("New Zealand", "Yeni Zelanda"),
            Map.entry("Spain", "İspanya"),
            Map.entry("Uruguay", "Uruguay"),
            Map.entry("Cape Verde Islands", "Yeşil Burun Adaları"),
            Map.entry("Saudi Arabia", "Suudi Arabistan"),
            Map.entry("France", "Fransa"),
            Map.entry("Norway", "Norveç"),
            Map.entry("Senegal", "Senegal"),
            Map.entry("Iraq", "Irak"),
            Map.entry("Argentina", "Arjantin"),
            Map.entry("Austria", "Avusturya"),
            Map.entry("Algeria", "Cezayir"),
            Map.entry("Jordan", "Ürdün"),
            Map.entry("Colombia", "Kolombiya"),
            Map.entry("Portugal", "Portekiz"),
            Map.entry("Congo DR", "Kongo Demokratik Cumhuriyeti"),
            Map.entry("Uzbekistan", "Özbekistan"),
            Map.entry("England", "İngiltere"),
            Map.entry("Ghana", "Gana"),
            Map.entry("Panama", "Panama"),
            Map.entry("Croatia", "Hırvatistan")
    );

    public String translate(String teamName) {
        return TEAM_NAMES.getOrDefault(teamName, teamName);
    }

}