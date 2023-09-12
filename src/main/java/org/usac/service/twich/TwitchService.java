package org.usac.service.twich;

import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.annotation.RegisterClientHeaders;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

/**
 *
 * @author ebany
 */
@RequestScoped
@Path("/v4")
@RegisterRestClient(configKey = "twitch-api")
@RegisterClientHeaders()
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface TwitchService {

    @GET
    @Path("/games")
    public String getGames(
            @HeaderParam("Authorization") String token,
            @HeaderParam("Client-ID") String clientId
    );

}
