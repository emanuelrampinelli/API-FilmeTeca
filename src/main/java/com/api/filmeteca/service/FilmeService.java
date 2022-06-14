package com.api.filmeteca.service;

import com.api.filmeteca.enums.ParamApiEnum;
import com.api.filmeteca.dto.ElencoDto;
import com.api.filmeteca.dto.FilmeDto;
import com.api.filmeteca.dto.FilmotecaDto;
import com.api.filmeteca.enums.LinkEnum;

import com.api.filmeteca.model.Filme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class FilmeService {

    private RestTemplate restTemplate;

    private FilmeDto filmeDto;
    private ElencoDto elencoDto;
    private FilmotecaDto filmoteca;

    private ElencoService elencoService;

    public FilmeService() {
        this.restTemplate = new RestTemplate();
        this.elencoDto = new ElencoDto();
        this.filmeDto = new FilmeDto();
        this.elencoService = new ElencoService();
        this.filmoteca = new FilmotecaDto();
    }

    public FilmeDto getFilme(String id) {

        // Busca o Filme
        this.filmeDto = this.restTemplate.getForObject(montaUrlFilme(id), FilmeDto.class);

        // Busca o Elenco do Filme
        this.elencoDto = elencoService.getElenco(id);

        // SET ElencoDto no FilmeDto
        this.filmeDto.setElencoDto(elencoDto);

        // SET Comentario no Filme
        // this.filmeDto.setComentarios(comentarioService.carregaComentario(filmeDto.getId()));
        this.filmeDto.setComentarios(null);

        return this.filmeDto;
    }

    public FilmotecaDto getFilmesPopulares(String indexPaginacao) {

        int index;
        try {
            index = Integer.parseInt(indexPaginacao);
        } catch (Exception e) {
            index = 1;
            e.printStackTrace();
        }

        this.filmoteca = this.restTemplate.getForObject(montarUrlFilmesPopulares(index), FilmotecaDto.class);

        return filmoteca;
    }

    public FilmotecaDto procurarFilmes(String texto) {

        this.filmoteca = this.restTemplate.getForObject(montarUrlProcurarFilmes(texto), FilmotecaDto.class);
        return this.filmoteca;
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

}
