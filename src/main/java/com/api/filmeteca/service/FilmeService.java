package com.api.filmeteca.service;

import com.api.filmeteca.enums.ParamApiEnum;
import com.api.filmeteca.enums.LinkEnum;
import com.api.filmeteca.model.Elenco;
import com.api.filmeteca.model.Filme;
import com.api.filmeteca.util.Filmoteca;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FilmeService {

    private RestTemplate restTemplate;

    private Filme filme;
    private Elenco elenco;
    private Filmoteca filmoteca;

    private ElencoService elencoService;

    public FilmeService() {
        this.restTemplate = new RestTemplate();
        this.elenco = new Elenco();
        this.filme = new Filme();
        this.elencoService = new ElencoService();
        this.filmoteca = new Filmoteca();
    }

    public Filme getFilme(String id) {

        this.filme = this.restTemplate.getForObject(montaUrlFilme(id), Filme.class);
        this.elenco = elencoService.getElenco(id);

        this.filme.setElencar(elenco.getCast());
        this.filme.setEquipe(elenco.getCrew());
        this.filme.setDiretor(elenco.getDiretor());

        return this.filme;
    }

    public Filmoteca getFilmesPopulares(int indexPaginacao) {

        this.filmoteca = this.restTemplate.getForObject(montarUrlFilmesPopulares(indexPaginacao), Filmoteca.class);

        return filmoteca;
    }

    private String montaUrlFilme(String id) {

        return LinkEnum.URL_BASE_FILME.getUrl() + id + "?" + ParamApiEnum.KEY_API.getConfig() + "&"
                + ParamApiEnum.LANGUAGE_PT_BR.getConfig();
    }

    private String montarUrlFilmesPopulares(int indexPaginacao) {

        return LinkEnum.URL_BASE_POPULARES.getUrl() + "?" + ParamApiEnum.KEY_API.getConfig() + "&"
                + ParamApiEnum.LANGUAGE_PT_BR.getConfig()
                + "&page=" + indexPaginacao;
    }
}
