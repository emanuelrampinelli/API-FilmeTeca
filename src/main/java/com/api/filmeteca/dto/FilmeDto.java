package com.api.filmeteca.dto;

import java.util.List;

import com.api.filmeteca.model.Comentario;
import com.api.filmeteca.model.Genero;
import com.api.filmeteca.model.Participante;

public class FilmeDto {

    private int id;
    private String title; // Nome
    private List<Genero> genres; // Generos
    private String release_date; // Data de Lancamento
    private String vote_average; // Media de votos - API MAE
    private String vote_average_local;// Media de votos - Local
    private String vote_count; // Quantidade votos
    private String overview;
    private String tagline;
    private String status;

    private Participante diretor;
    private List<Participante> elencar;
    private List<Participante> equipe;

    private List<Comentario> comentarios;

    private String poster_path; // Link imagem - POSTER
    private String backdrop_path; // Link imagem - BACKDROP

    private List<Integer> genre_ids; // Auxilixar para coletar dados da API mae;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Genero> getGenres() {
        return genres;
    }

    public void setGenres(List<Genero> genres) {
        this.genres = genres;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getVote_average() {
        return vote_average;
    }

    public void setVote_average(String vote_average) {
        this.vote_average = vote_average;
    }

    public String getVote_average_local() {
        return vote_average_local;
    }

    public void setVote_average_local(String vote_average_local) {
        this.vote_average_local = vote_average_local;
    }

    public String getVote_count() {
        return vote_count;
    }

    public void setVote_count(String vote_count) {
        this.vote_count = vote_count;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Participante getDiretor() {
        return diretor;
    }

    public void setDiretor(Participante diretor) {
        this.diretor = diretor;
    }

    public List<Participante> getElencar() {
        return elencar;
    }

    public void setElencar(List<Participante> elencar) {
        this.elencar = elencar;
    }

    public List<Participante> getEquipe() {
        return equipe;
    }

    public void setEquipe(List<Participante> equipe) {
        this.equipe = equipe;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public List<Integer> getGenre_ids() {
        return genre_ids;
    }

    public void setGenre_ids(List<Integer> genre_ids) {
        this.genre_ids = genre_ids;
    }

}
