package com.api.filmeteca.dto;

import java.util.List;

import com.api.filmeteca.model.Comentario;
import com.api.filmeteca.model.Filme;
import com.api.filmeteca.model.Genero;

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
    private String runtime;
    private String status;

    private ElencoDto elencoDto;

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

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ElencoDto getElencoDto() {
        return elencoDto;
    }

    public void setElencoDto(ElencoDto elencoDto) {
        this.elencoDto = elencoDto;
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

    public Filme filmeDtoToFilme() {

        Filme filme = new Filme();

        filme.setId(this.id);
        filme.setNome(this.title);
        filme.setGeneros(this.genres);
        filme.setDataLancamento(this.release_date);
        filme.setMediaVotos(this.vote_average);
        filme.setMediaVotosLocal(this.vote_average_local);
        filme.setQuantVotos(this.vote_count);
        filme.setDescricao(this.overview);
        filme.setStatus(this.status);

        filme.setElenco(this.elencoDto.elencoDtoToElenco());

        filme.setComentarios(this.comentarios);

        filme.setPoster(this.poster_path);
        filme.setBackdrop(this.backdrop_path);

        return filme;
    }
}
