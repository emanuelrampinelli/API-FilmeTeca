package com.api.filmeteca.service;

import com.api.filmeteca.model.Filme;
import com.api.filmeteca.util.Filmoteca;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FilmeService {

    private static String KEY_API = "api_key=d7251e004d1f3faea8a9b0f9405646b6";
    private static String LANGUAGE_PT_BR = "language=pt-BR";
    private static String URL_BASE_FILME = "https://api.themoviedb.org/3/movie/";

    private static String URL_BASE_POPULARES = "https://api.themoviedb.org/3/movie/popular?api_key=d7251e004d1f3faea8a9b0f9405646b6&language=pt-BR&page=1";

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

    public Filmoteca getFilmesPopulares() {

        this.colecaoFilmes = this.restTemplate.getForObject(URL_BASE_POPULARES, Filmoteca.class);

        return colecaoFilmes;
    }

    private String montaUrlFilme(String idFilme) {

        return URL_BASE_FILME + idFilme + "?" + KEY_API + "&" + LANGUAGE_PT_BR;
    }
}
