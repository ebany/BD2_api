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
 *
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

    @Scheduled(every = "5s")
    void getTwitchGames() {
        AuthDto authDto = authService.oauth2(clientId, clientSecret, "client_credentials");

        if (authDto == null) {
            System.out.println("No se pudo obtener el token");
            return;
        }

        System.out.println(apiService.getGames("Bearer " + authDto.getAccess_token(), clientId));
    }

}
