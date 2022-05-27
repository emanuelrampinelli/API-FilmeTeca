package com.api.filmeteca.dto;

import java.util.List;

//Coletivo de Filmes
public class FilmotecaDto {

    private List<FilmeDto> results;

    public List<FilmeDto> getResults() {
        return results;
    }

    public void setResults(List<FilmeDto> results) {
        this.results = results;
    }
}
