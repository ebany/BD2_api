package org.usac.service.twich;

import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.*;
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

    @POST
    @Path("/games")
    public String getGames(
            @HeaderParam("Authorization") String token,
            @HeaderParam("Client-ID") String clientId,
            @QueryParam("fields") String fields,
            @QueryParam("limit") int limit,
            @QueryParam("offset") int offset
    );

    @POST
    @Path("/genres")
    public String getGenres(
            @HeaderParam("Authorization") String token,
            @HeaderParam("Client-ID") String clientId,
            @QueryParam("fields") String fields,
            @QueryParam("limit") int limit,
            @QueryParam("offset") int offset
    );

    @POST
    @Path("/platforms")
    public String getPlatforms(
            @HeaderParam("Authorization") String token,
            @HeaderParam("Client-ID") String clientId,
            @QueryParam("fields") String fields,
            @QueryParam("limit") int limit,
            @QueryParam("offset") int offset
    );

    @POST
    @Path("/languages")
    public String getLanguages(
            @HeaderParam("Authorization") String token,
            @HeaderParam("Client-ID") String clientId,
            @QueryParam("fields") String fields,
            @QueryParam("limit") int limit,
            @QueryParam("offset") int offset
    );

}
