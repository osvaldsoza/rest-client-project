package br.com.osvaldsoza;


import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("tvseries")
public class TvSeriesResource {

    @RestClient
    TvSeriesProxy proxy;

    private List<TvSerie> tvSeries = new ArrayList<>();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(){
        TvSerie tvSerie = proxy.get("game of thrones");
        tvSeries.add(tvSerie);
        return Response.ok(tvSeries).build();
    }
}
