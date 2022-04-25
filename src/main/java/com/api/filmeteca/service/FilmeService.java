package com.api.filmeteca.service;

import com.api.filmeteca.enums.ParamApiEnum;
import com.api.filmeteca.enums.LinkEnum;
import com.api.filmeteca.model.Filme;
import com.api.filmeteca.util.Filmoteca;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FilmeService {

    private RestTemplate restTemplate;

    private Filme filme;
    private Filmoteca colecaoFilmes;

    public FilmeService() {

        this.restTemplate = new RestTemplate();
        this.filme = new Filme();
        this.colecaoFilmes = new Filmoteca();
    }

    public Filme getFilme(String idFilme) {

        this.filme = this.restTemplate.getForObject(montaUrlFilme(idFilme), Filme.class);
        return this.filme;
    }

    public Filmoteca getFilmesPopulares(int indexPaginacao) {

        this.colecaoFilmes = this.restTemplate.getForObject(montarUrlFilmesPopulares(indexPaginacao), Filmoteca.class);

        return colecaoFilmes;
    }

    private String montaUrlFilme(String idFilme) {

        return LinkEnum.URL_BASE_FILME.getUrl() + idFilme + "?" + ParamApiEnum.KEY_API.getConfig() + "&"
                + ParamApiEnum.LANGUAGE_PT_BR.getConfig();
    }

    private String montarUrlFilmesPopulares(int indexPaginacao) {

        return LinkEnum.URL_BASE_POPULARES.getUrl() + "?" + ParamApiEnum.KEY_API.getConfig() + "&"
                + ParamApiEnum.LANGUAGE_PT_BR.getConfig()
                + "&page=" + indexPaginacao;
    }
}
