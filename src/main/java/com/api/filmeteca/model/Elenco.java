package com.api.filmeteca.model;

import java.util.List;

public class Elenco {

    private int id;
    private List<Participante> artistas; // artistas
    private List<Participante> equipe_producao; // Equipe_producao
    private Participante diretor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Participante> getArtistas() {
        return artistas;
    }

    public void setArtistas(List<Participante> artistas) {
        this.artistas = artistas;
    }

    public List<Participante> getEquipe_producao() {
        return equipe_producao;
    }

    public void setEquipe_producao(List<Participante> equipe_producao) {
        this.equipe_producao = equipe_producao;
    }

    public Participante getDiretor() {
        return diretor;
    }

    public void setDiretor(Participante diretor) {
        this.diretor = diretor;
    }

}
