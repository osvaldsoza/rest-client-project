package br.com.osvaldsoza.service;

import br.com.osvaldsoza.TvSerie;
import br.com.osvaldsoza.proxy.TvSeriesProxy;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TvSeriesService {

    @RestClient
    TvSeriesProxy proxy;

    public TvSerie singleSearchShowsByTitle(String title) {
        var tvSerie = proxy.get(title);
        return tvSerie;
    }
}
