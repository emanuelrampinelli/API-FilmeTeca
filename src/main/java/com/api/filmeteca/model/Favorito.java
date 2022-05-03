package com.api.filmeteca.model;

import java.util.Date;

public class Favorito {

    private Date data;

    private Filme filme;

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

}
