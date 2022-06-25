package com.api.filmeteca.service;

import com.api.filmeteca.enums.ParamApiEnum;
import com.api.filmeteca.dto.ElencoDto;
import com.api.filmeteca.dto.FilmeDto;
import com.api.filmeteca.dto.FilmotecaDto;
import com.api.filmeteca.enums.LinkEnum;

import com.api.filmeteca.model.Avaliacao;
import com.api.filmeteca.repository.AvaliacaoRepository;
import com.api.filmeteca.repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FilmeService {

    @Autowired
    private ElencoService elencoService;

    @Autowired
    private ComentarioRepository comentarioRepository;

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    private RestTemplate restTemplate;

    public FilmeService(){
        this.restTemplate = new RestTemplate();
    }

    public FilmeDto getFilme(String id) {

        // Busca o Filme
        FilmeDto filmeDto =  this.restTemplate.getForObject(montaUrlFilme(id), FilmeDto.class);

        //Calcula nota local
        filmeDto.setVote_average_local(calculaNotaLocal(filmeDto.getId()).toString());

        // Busca o Elenco do Filme
        ElencoDto elencoDto = this.elencoService.getElenco(id);

        // SET ElencoDto no FilmeDto
        filmeDto.setElencoDto(elencoDto);

        // SET Comentario no Filme
        filmeDto.setComentarios(comentarioRepository.findByIdFilme(filmeDto.getId()));

        return filmeDto;
    }

    public FilmotecaDto getFilmesPopulares(String indexPaginacao) {

        try {

            int index = Integer.parseInt(indexPaginacao);
            return this.restTemplate.getForObject(montarUrlFilmesPopulares(index), FilmotecaDto.class);

        } catch (Exception e) {

            e.printStackTrace();
            return this.restTemplate.getForObject(montarUrlFilmesPopulares(1), FilmotecaDto.class);
        }

    }

    public FilmotecaDto procurarFilmes(String texto) {

        return this.restTemplate.getForObject(montarUrlProcurarFilmes(texto), FilmotecaDto.class);
    }

    private String montaUrlFilme(String id) {

        return LinkEnum.URL_BASE_FILME.getUrl() + id + "?" + ParamApiEnum.KEY_API.getConfig() + "&"
                + ParamApiEnum.LANGUAGE_PT_BR.getConfig();
    }

    private String montarUrlFilmesPopulares(int indexPaginacao) {

        return LinkEnum.URL_BASE_POPULARES.getUrl() + "?" + ParamApiEnum.KEY_API.getConfig() + "&"
                + ParamApiEnum.LANGUAGE_PT_BR.getConfig()
                + "&page=" + indexPaginacao;
    }

    private String montarUrlProcurarFilmes(String texto) {

        return LinkEnum.URL_SEARCH.getUrl() + "?" + ParamApiEnum.KEY_API.getConfig() + "&"
                + ParamApiEnum.LANGUAGE_PT_BR.getConfig()
                + "&query=" + texto;
    }

    private Double calculaNotaLocal(Long id){

        Double nota = 0.0;
        List<Avaliacao> avaliacaos = avaliacaoRepository.findByIdFilme(id);

        if(avaliacaos.isEmpty()){
            return nota;
        }

        for(Avaliacao avaliacao: avaliacaos){
            nota+= avaliacao.getValor();
        }

        return nota/avaliacaos.size();
    }

}
