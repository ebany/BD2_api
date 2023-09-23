package org.usac.scheduler;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.quarkus.scheduler.Scheduled;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.List;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.usac.dto.AuthDto;
import org.usac.dto.GeneroDto;
import org.usac.dto.JuegoDto;
import org.usac.model.Genero;
import org.usac.model.Language;
import org.usac.model.Plataforma;
import org.usac.model.PlataformaVideojuego;
import org.usac.model.Videojuego;
import org.usac.model.VideojuegoGenero;
import org.usac.repository.GeneroRepository;
import org.usac.repository.JuegoRepository;
import org.usac.repository.LanguageRepository;
import org.usac.repository.PlataformaRepository;
import org.usac.repository.PlataformaVideojuegoRepository;
import org.usac.repository.VideoJuegoGeneroRepository;
import org.usac.service.twich.TwitchAuthService;
import org.usac.service.twich.TwitchService;

/**
 * @author ebany
 */
@ApplicationScoped
public class TwitchSecheduler {

    @Inject
    GeneroRepository generoRepository;

    @Inject
    PlataformaRepository plataformaRepository;

    @Inject
    LanguageRepository languageRepository;

    @Inject
    JuegoRepository juegoRepo;

    @Inject
    PlataformaVideojuegoRepository plataformaVideoRepo;

    @Inject
    VideoJuegoGeneroRepository VideoGenRepo;

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

    private final String fields = "name,platforms,genres, summary, storyline, first_release_date, rating, rating_count";
    private final String genreFields = "name";

    private int page = 119800;
    private final int limit = 500;

    private AuthDto authDto;

    @Scheduled(every = "2s")
    void getTwitchGames() {
        if (authDto == null) {
            authDto = authService.oauth2(clientId, clientSecret, "client_credentials");
            return;
        }

        System.out.println("------------------------------------------");
        System.out.println("Token: " + authDto.getAccess_token());
        System.out.println("------------------------------------------");

//        String json = apiService.getLanguages("Bearer " + authDto.getAccess_token(), clientId, genreFields, limit, page);
//        List<GeneroDto> data = new Gson().fromJson(json, new TypeToken<List<GeneroDto>>() {
//        }.getType());
//
//        if (data.size() > 0) {
//            for (GeneroDto item : data) {
//                System.out.println(item);
//                languageRepository.persistAndFlush(new Language(item.getId(), item.getName()));
//            }
//        } else {
//            System.out.println("Teminar Ciclo");
//        }
        String json = apiService.getGames("Bearer " + authDto.getAccess_token(), clientId, fields, limit, page);
        List<JuegoDto> data = new Gson().fromJson(json, new TypeToken<List<JuegoDto>>() {
        }.getType());

        if (data.size() > 0) {
            System.out.println("----------------------------------------------");
            System.out.println("Page: " + page);
            System.out.println("----------------------------------------------");
            
            for (JuegoDto item : data) {
                //System.out.println(item);

                Videojuego juego = new Videojuego(
                        item.getId(),
                        item.getName(),
                        item.getSummary(),
                        item.getStoryline(),
                        item.getFirst_release_date(),
                        item.getRating(),
                        item.getRating_count(),
                        item.getAggregated_rating(),
                        item.getAggregated_rating_count()
                );

                juegoRepo.persistAndFlush(juego);

                if (item.getGenres().size() > 0) {
                    for (Long genre : item.getGenres()) {
                        VideoGenRepo.persistAndFlush(new VideojuegoGenero(genre, item.getId()));
                    }
                }

                if (item.getPlatforms().size() > 0) {
                    for (Long plarform : item.getPlatforms()) {
                        plataformaVideoRepo.persistAndFlush(new PlataformaVideojuego(item.getId(), plarform));
                    }
                }

                //languageRepository.persistAndFlush(new Language(item.getId(), item.getName()));
            }
        } else {
            System.out.println("-----------------------------------------");
            System.out.println("Teminar Ciclo");
            System.out.println("-----------------------------------------");
        }

        page += limit;
//
//        System.out.println(apiService.getGames("Bearer " + authDto.getAccess_token(), clientId, fields, limit, page));

    }

}
