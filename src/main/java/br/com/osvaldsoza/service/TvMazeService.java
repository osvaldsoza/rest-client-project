package br.com.osvaldsoza.service;

import br.com.osvaldsoza.tvmaze.model.Episode;
import br.com.osvaldsoza.tvmaze.model.TvSerie;
import br.com.osvaldsoza.tvmaze.proxy.EpisodesProxy;
import br.com.osvaldsoza.tvmaze.proxy.TvSerieProxy;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class TvMazeService {

    @RestClient
    TvSerieProxy tvSerieProxy;

    @RestClient
    EpisodesProxy episodesProxy;

    public TvSerie getTvSeries(String title) {
        var tvSerie = tvSerieProxy.get(title);
        return tvSerie;
    }

    public List<Episode> getEpisodes(Long id){
        var episodes = episodesProxy.get(id);
        return episodes;
    }
}
