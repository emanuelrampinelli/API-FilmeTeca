package com.api.filmeteca.service;

import com.api.filmeteca.model.Filme;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FilmeService {

    private static String URL = "https://api.themoviedb.org/3/movie/385128-f9?api_key=d7251e004d1f3faea8a9b0f9405646b6&language=pt-BR";
    private RestTemplate restTemplate;
    private Filme filme;

    public FilmeService() {
        this.restTemplate = new RestTemplate();
        filme = new Filme();
    }

    public Filme getListaInicial() {

        this.filme = this.restTemplate.getForObject(URL, Filme.class);
        return this.filme;
    }
}
