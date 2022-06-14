package com.api.filmeteca.repository;

import com.api.filmeteca.model.Avaliacao;
import com.api.filmeteca.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvaliacaoRepository extends JpaRepository<Avaliacao,Long> {

    public List<Avaliacao> findByIdFilme(Long id);

    public List<Avaliacao> findByUsuario(Usuario usuario);
}
