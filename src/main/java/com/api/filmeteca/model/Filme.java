package com.api.filmeteca.model;

import java.util.List;

import com.api.filmeteca.dto.FilmeDto;

public class Filme {

    private int id;
    private String nome; // Nome
    private List<Genero> generos; // Generos
    private String dataLancamento; // Data de Lancamento
    private String mediaVotos; // Media de votos - API MAE
    private String mediaVotosLocal;// Media de votos - Local
    private String quantVotos; // Quantidade votos
    private String descricao;
    private String slogan;
    private String status;

    private Participante diretor;
    private List<Participante> elenco;
    private List<Participante> equipeProducao;

    private List<Comentario> comentarios;

    private String poster; // Link imagem - POSTER
    private String backdrop; // Link imagem - BACKDROP

    private List<Integer> genre_ids; // Auxilixar para coletar dados da API mae;

    public Filme(FilmeDto filmeDto) {

        this.id = filmeDto.getId();
        this.nome = filmeDto.getTitle();
        this.generos = filmeDto.getGenres();
        this.dataLancamento = filmeDto.getRelease_date();
        this.mediaVotos = filmeDto.getVote_average();
        this.mediaVotosLocal = filmeDto.getVote_average_local();
        this.quantVotos = filmeDto.getVote_count();
        this.descricao = filmeDto.getOverview();
        this.status = filmeDto.getStatus();

        this.diretor = filmeDto.getDiretor();
        this.elenco = filmeDto.getElencar();
        this.equipeProducao = filmeDto.getEquipe();

        this.comentarios = filmeDto.getComentarios();

        this.poster = filmeDto.getPoster_path();
        this.backdrop = filmeDto.getBackdrop_path();

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

    public Participante getDiretor() {
        return diretor;
    }

    public void setDiretor(Participante diretor) {
        this.diretor = diretor;
    }

    public List<Participante> getElenco() {
        return elenco;
    }

    public void setElenco(List<Participante> elenco) {
        this.elenco = elenco;
    }

    public List<Participante> getEquipeProducao() {
        return equipeProducao;
    }

    public void setEquipeProducao(List<Participante> equipeProducao) {
        this.equipeProducao = equipeProducao;
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
