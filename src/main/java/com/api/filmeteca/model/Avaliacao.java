package com.api.filmeteca.model;

import java.util.Date;

public class Avaliacao {

    private Double valor; // Valor da nota
    private Date data; // Data da avaliacao

    private Filme filme;

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

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
