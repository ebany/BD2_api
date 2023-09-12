package org.usac.service.twich;

import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.annotation.RegisterClientHeaders;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.usac.dto.AuthDto;

/**
 *
 * @author ebany
 */
@RequestScoped
@Path("/oauth2")
@RegisterRestClient(configKey = "twitch-auth")
@RegisterClientHeaders()
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface TwitchAuthService {

    @POST
    @Path("/token")
    public AuthDto oauth2(
            @QueryParam("client_id") String clientId,
            @QueryParam("client_secret") String clientSecret,
            @QueryParam("grant_type") String grantType
    );

}
