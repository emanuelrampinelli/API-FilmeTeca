package com.api.filmeteca.util;

import java.util.List;

import com.api.filmeteca.dto.FilmeDto;

//Coletivo de Filmes
public class Filmoteca {

    private List<FilmeDto> results;

    public List<FilmeDto> getResults() {
        return results;
    }

    public void setResults(List<FilmeDto> results) {
        this.results = results;
    }
}
