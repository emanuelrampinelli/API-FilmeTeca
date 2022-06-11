package com.api.filmeteca.dto;

import com.api.filmeteca.model.Usuario;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;

public class ComentarioDto {

    private UUID id;
    private Date dataCasdatro;

    @NotNull
    private String texto;

    @NotNull
    private Usuario usuario;

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
