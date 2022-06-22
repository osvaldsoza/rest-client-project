package br.com.osvaldsoza.resource;


import br.com.osvaldsoza.service.TvMazeService;
import br.com.osvaldsoza.tvmaze.model.Episode;
import br.com.osvaldsoza.tvmaze.model.TvSerie;
import br.com.osvaldsoza.tvmaze.proxy.EpisodesProxy;
import br.com.osvaldsoza.tvmaze.proxy.TvSerieProxy;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("tvseries")
public class TvSeriesResource {

    @Inject
    private TvMazeService tvMazeService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@QueryParam("title") String title) {
        List<TvSerie> tvSeries = new ArrayList<>();
        TvSerie tvSerie = tvMazeService.getTvSeries(title);
        tvSeries.add(tvSerie);
        return Response.ok(tvSeries).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{title}/episodes")
    public Response getEpisodes(@PathParam("title") String title)  {
        TvSerie tvSerie = tvMazeService.getTvSeries(title);
        List<Episode> episodes = tvMazeService.getEpisodes(tvSerie.getId());
        return Response.ok(episodes).build();
    }

}
