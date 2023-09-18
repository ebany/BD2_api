package org.usac.scheduler;

import io.quarkus.scheduler.Scheduled;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.usac.dto.AuthDto;
import org.usac.service.twich.TwitchAuthService;
import org.usac.service.twich.TwitchService;

/**
 * @author ebany
 */
@ApplicationScoped
public class TwitchSecheduler {

    @ConfigProperty(name = "client.id")
    String clientId;

    @ConfigProperty(name = "client.secret")
    String clientSecret;

    @Inject
    @RestClient
    TwitchAuthService authService;

    @Inject
    @RestClient
    TwitchService apiService;

    /*private final String fields = """
            age_ratings,
            aggregated_rating,
            aggregated_rating_count,
            alternative_names,artworks,bundles,
            category,checksum,collection,cover,created_at,
            dlcs,expanded_games,expansions,external_games,
            first_release_date,follows,forks,franchise,
            franchises,game_engines,game_localizations,
            game_modes,genres,hypes,involved_companies,keywords,language_supports,
            multiplayer_modes,name,parent_game,platforms,player_perspectives,ports,
            rating,rating_count,release_dates,remakes,remasters,screenshots,
            similar_games,slug,standalone_expansions,status,storyline,summary,
            tags,themes,total_rating,total_rating_count,updated_at,url,
            version_parent,version_title,videos,websites
            """;*/
    private final String fields = "name";

    private int page = 0;
    private final int limit = 500;

    @Scheduled(every = "10s")
    void getTwitchGames() {
        AuthDto authDto = authService.oauth2(clientId, clientSecret, "client_credentials");
        System.out.println("Token: " + authDto.getAccess_token());
        if (authDto == null) {
            System.out.println("No se pudo obtener el token");
            return;
        }

        System.out.println(apiService.getGames("Bearer " + authDto.getAccess_token(), clientId, fields, limit, page));
        page += limit;
    }

}
