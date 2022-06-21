package br.com.osvaldsoza.service;

import br.com.osvaldsoza.TvSerie;
import br.com.osvaldsoza.tvmaze.proxy.SingleSearchShowsProxy;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TvMazeService {

    @RestClient
    SingleSearchShowsProxy proxy;

    public TvSerie singleSearchShowsByTitle(String title) {
        var tvSerie = proxy.singlesearchShows(title);
        return tvSerie;
    }
}
