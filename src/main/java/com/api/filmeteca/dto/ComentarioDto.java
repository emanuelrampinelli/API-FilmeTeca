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
    private FilmeDto filmeDto;

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

    public FilmeDto getFilmeDto() {
        return filmeDto;
    }

    public void setFilmeDto(FilmeDto filmeDto) {
        this.filmeDto = filmeDto;
    }
}
