package com.api.filmeteca.model;

import java.util.List;

public class Filme {

    private int id;
    private String nome; // Nome
    private List<Genero> generos; // Generos
    private String dataLancamento; // Data de Lancamento
    private String mediaVotos; // Media de votos - API MAE
    private String mediaVotosLocal;// Media de votos - Local
    private String quantVotos; // Quantidade votos
    private String descricao;
    private String duracao;
    private String slogan;
    private String status;

    private Elenco elenco;

    private List<Comentario> comentarios;

    private String poster; // Link imagem - POSTER
    private String backdrop; // Link imagem - BACKDROP

    private List<Integer> genre_ids; // Auxilixar para coletar dados da API mae;

    public String getDuracao() {
        return duracao;
    }

    public Elenco getElenco() {
        return elenco;
    }

    public void setElenco(Elenco elenco) {
        this.elenco = elenco;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Genero> getGeneros() {
        return generos;
    }

    public void setGeneros(List<Genero> generos) {
        this.generos = generos;
    }

    public String getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(String dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public String getMediaVotos() {
        return mediaVotos;
    }

    public void setMediaVotos(String mediaVotos) {
        this.mediaVotos = mediaVotos;
    }

    public String getMediaVotosLocal() {
        return mediaVotosLocal;
    }

    public void setMediaVotosLocal(String mediaVotosLocal) {
        this.mediaVotosLocal = mediaVotosLocal;
    }

    public String getQuantVotos() {
        return quantVotos;
    }

    public void setQuantVotos(String quantVotos) {
        this.quantVotos = quantVotos;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getBackdrop() {
        return backdrop;
    }

    public void setBackdrop(String backdrop) {
        this.backdrop = backdrop;
    }

    public List<Integer> getGenre_ids() {
        return genre_ids;
    }

    public void setGenre_ids(List<Integer> genre_ids) {
        this.genre_ids = genre_ids;
    }

}
