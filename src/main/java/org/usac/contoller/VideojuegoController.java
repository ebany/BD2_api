package org.usac.contoller;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.usac.repository.JuegoRepository;

@Path("/roles")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class VideojuegoController {

    JuegoRepository juegoRepository;

    public VideojuegoController(JuegoRepository juegoRepository) {
        this.juegoRepository = juegoRepository;
    }

    @GET
    public Response getGames() {
        juegoRepository.generateJsonFile();
        return Response.ok(true).build();
    }

}
