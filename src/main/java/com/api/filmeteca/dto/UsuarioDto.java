package com.api.filmeteca.dto;

import com.api.filmeteca.model.Avaliacao;
import com.api.filmeteca.model.Comentario;
import com.api.filmeteca.model.Favorito;
import com.api.filmeteca.model.Interesse;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.joda.time.DateTime;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class UsuarioDto {

    private UUID id;

    private String nome;

    @Email
    private String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String senha;

    private Date dataCasdastro;

    private List<Comentario> comentarios;
    private List<Interesse> interesses;
    private List<Favorito> favoritos;
    private List<Avaliacao> avaliacaos;


    public Date getDataCasdastro() {
        return dataCasdastro;
    }

    public void setDataCasdastro(Date dataCasdastro) {
        this.dataCasdastro = dataCasdastro;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
