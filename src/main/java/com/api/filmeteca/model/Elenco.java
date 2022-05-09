package com.api.filmeteca.model;

import java.util.List;

public class Elenco {

    private int id;
    private List<Participante> cast; // elencar
    private List<Participante> crew; // Equipe
    private Participante diretor;

    public List<Participante> getCast() {
        return cast;
    }

    public Participante getDiretor() {
        return diretor;
    }

    public void setDiretor(Participante diretor) {
        this.diretor = diretor;
    }

    public List<Participante> getCrew() {
        return crew;
    }

    public void setCrew(List<Participante> crew) {
        this.crew = crew;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCast(List<Participante> cast) {
        this.cast = cast;
    }

}
