package com.api.filmeteca.service;

import com.api.filmeteca.dto.FilmeDto;

import com.api.filmeteca.model.Avaliacao;
import com.api.filmeteca.model.Usuario;
import com.api.filmeteca.repository.AvaliacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvaliacaoService {

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;


    public Avaliacao save(Avaliacao avaliacao){

        return avaliacaoRepository.save(avaliacao);
    }

    public List<Avaliacao> findByUsuario(Usuario usuario){

        return avaliacaoRepository.findByUsuario(usuario);
    }

    public List<Avaliacao> findByFilme(FilmeDto filmeDto){

        return avaliacaoRepository.findByIdFilme(filmeDto.getId());
    }

}
