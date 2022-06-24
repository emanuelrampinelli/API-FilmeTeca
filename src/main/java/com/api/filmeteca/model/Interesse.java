package com.api.filmeteca.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Interesse")
public class Interesse {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Date data;

    @Column(nullable = false)
    private Long id_filme;

    @ManyToOne
    private Usuario usuario;

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

    public Long getId_filme() {
        return id_filme;
    }

    public void setId_filme(Long id_filme) {
        this.id_filme = id_filme;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
