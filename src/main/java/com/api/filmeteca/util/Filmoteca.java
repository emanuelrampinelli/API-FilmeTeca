package com.api.filmeteca.util;

import java.util.List;
import com.api.filmeteca.model.Filme;

//Coletivo de Filmes
public class Filmoteca {

    private List<Filme> results;

    public List<Filme> getResults() {
        return results;
    }

    public void setResults(List<Filme> results) {
        this.results = results;
    }
}
