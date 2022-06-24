package com.api.filmeteca.service;

import com.api.filmeteca.dto.FilmeDto;
import com.api.filmeteca.model.Avaliacao;

import com.api.filmeteca.model.Usuario;
import com.api.filmeteca.repository.AvaliacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AvaliacaoService {

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;


    public Avaliacao save(Avaliacao avaliacao,Usuario usuario){

        //Verifica se o filme ja foi avaliado pelo usuario;
        List<Avaliacao> avaliacaos = avaliacaoRepository.findByUsuarioAndIdFilme(usuario,avaliacao.getIdFilme());

        if(avaliacaos.isEmpty()){
            return avaliacaoRepository.save(avaliacao);
        }

        return null;

    }

    public List<Avaliacao> findByUsuario(Usuario usuario){

        return avaliacaoRepository.findByUsuario(usuario);
    }

    public List<Avaliacao> findByFilme(FilmeDto filmeDto){

        return avaliacaoRepository.findByIdFilme(filmeDto.getId());
    }

    public void delete(Avaliacao avaliacao){
        avaliacaoRepository.delete(avaliacao);
    }

    public Avaliacao update(Avaliacao avaliacao){

        //Carrega Avaliacao
        Optional<Avaliacao> avaliacaoOptional = avaliacaoRepository.findById(avaliacao.getId());

        if(!avaliacaoOptional.isEmpty()){

            Avaliacao avaliacaoLoad = avaliacaoOptional.get();

            avaliacaoLoad.setValor(avaliacao.getValor());

            return avaliacaoRepository.save(avaliacaoLoad);
        }

        return null;
    }

}
