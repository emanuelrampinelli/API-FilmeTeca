package com.api.filmeteca.dto;

import com.api.filmeteca.model.*;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

public class ComentarioDto {

    private Long id;

    private Date dataCasdatro;

    @NotNull
    private String texto;

    private Usuario usuario;

    private Long idFilme;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataCasdatro() {
        return dataCasdatro;
    }

    public void setDataCasdatro(Date dataCasdatro) {
        this.dataCasdatro = dataCasdatro;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Long getIdFilme() {
        return idFilme;
    }

    public void setIdFilme(Long idFilme) {
        this.idFilme = idFilme;
    }
}
