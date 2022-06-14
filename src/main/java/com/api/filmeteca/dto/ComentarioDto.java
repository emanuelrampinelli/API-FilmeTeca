package com.api.filmeteca.dto;

import com.api.filmeteca.model.*;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class ComentarioDto {

    private UUID id;

    private Date dataCasdatro;

    @NotNull
    private String texto;

    @NotNull
    private Usuario usuario;

    @NotNull
    private long id_filme;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Date getDataCasdatro() {
        return dataCasdatro;
    }

    public void setDataCasdatro(Date dataCasdatro) {
        this.dataCasdatro = dataCasdatro;
    }

    public long getId_filme() {
        return id_filme;
    }

    public void setId_filme(int id_filme) {
        this.id_filme = id_filme;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Date getData() {
        return dataCasdatro;
    }

    public void setData(Date dataCasdatro) {
        this.dataCasdatro = dataCasdatro;
    }
}
