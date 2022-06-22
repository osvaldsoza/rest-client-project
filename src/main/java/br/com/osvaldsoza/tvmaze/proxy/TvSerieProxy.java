package br.com.osvaldsoza.tvmaze.proxy;

import br.com.osvaldsoza.tvmaze.model.TvSerie;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/singlesearch/")
@Produces(MediaType.APPLICATION_JSON)
@RegisterRestClient
public interface TvSerieProxy {

    @GET
    @Path("/shows")
    TvSerie get(@QueryParam("q") String title);
}
