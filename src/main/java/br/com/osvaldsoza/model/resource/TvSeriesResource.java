package br.com.osvaldsoza.model.resource;


import br.com.osvaldsoza.TvSerie;
import br.com.osvaldsoza.service.TvMazeService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("tvseries")
public class TvSeriesResource {

    @Inject
    private TvMazeService tvMazeService;

    private List<TvSerie> tvSeries = new ArrayList<>();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@QueryParam("title") String title) {
        TvSerie tvSerie = tvMazeService.singleSearchShowsByTitle(title);
        tvSeries.add(tvSerie);
        return Response.ok(tvSeries).build();
    }
}
