package com.api.filmeteca.service;

import com.api.filmeteca.enums.ParamApiEnum;
import com.api.filmeteca.dto.FilmeDto;
import com.api.filmeteca.enums.LinkEnum;
import com.api.filmeteca.model.Elenco;
import com.api.filmeteca.model.Filme;
import com.api.filmeteca.util.Filmoteca;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FilmeService {

    private RestTemplate restTemplate;

    private FilmeDto filmeDto;
    private Elenco elenco;
    private Filmoteca filmoteca;

    private ElencoService elencoService;
    private ComentarioService comentarioService;

    public FilmeService() {
        this.restTemplate = new RestTemplate();
        this.elenco = new Elenco();
        this.filmeDto = new FilmeDto();
        this.elencoService = new ElencoService();
        this.filmoteca = new Filmoteca();
        this.comentarioService = new ComentarioService();
    }

    public Filme getFilme(String id) {

        this.filmeDto = this.restTemplate.getForObject(montaUrlFilme(id), FilmeDto.class);
        this.elenco = elencoService.getElenco(id);

        this.filmeDto.setElencar(elenco.getCast());
        this.filmeDto.setEquipe(elenco.getCrew());
        this.filmeDto.setDiretor(elenco.getDiretor());
        this.filmeDto.setComentarios(comentarioService.carregaComentario(filmeDto.getId()));

        return new Filme(this.filmeDto);
    }

    public Filmoteca getFilmesPopulares(int indexPaginacao) {

        this.filmoteca = this.restTemplate.getForObject(montarUrlFilmesPopulares(indexPaginacao), Filmoteca.class);

        return filmoteca;
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
}
