package com.api.filmeteca.dto;

import com.api.filmeteca.model.Usuario;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class AvaliacaoDto {

    private Long id;

    private Long idFilme;

    private Date dataCadastro;

    private Usuario usuario;

    @NotNull
    private Double valor;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdFilme() {
        return idFilme;
    }

    public void setIdFilme(Long idFilme) {
        this.idFilme = idFilme;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
