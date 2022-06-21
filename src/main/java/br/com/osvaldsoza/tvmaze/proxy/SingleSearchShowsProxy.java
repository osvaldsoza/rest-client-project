package br.com.osvaldsoza.tvmaze.proxy;

import br.com.osvaldsoza.TvSerie;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/singlesearch/")
@Produces(MediaType.APPLICATION_JSON)
@RegisterRestClient
public interface SingleSearchShowsProxy {

    @GET
    @Path("/shows")
    TvSerie singlesearchShows(@QueryParam("q") String title);

//    @GET
//    @Path("/shows/{id}/episodes")
//    List<String> showsEpisodesById(Long id);
}
