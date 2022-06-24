package com.api.filmeteca.dto;

import com.api.filmeteca.model.Usuario;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class InteresseDto {


    private Long id;

    private Date data;

    private Usuario usuario;

    @NotNull
    private Long idFilme;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Long getIdFilme() {
        return idFilme;
    }

    public void setIdFilme(Long idFilme) {
        this.idFilme = idFilme;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
