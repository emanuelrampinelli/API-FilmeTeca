package com.api.filmeteca.service;

import com.api.filmeteca.dto.GenerosDto;
import com.api.filmeteca.enums.LinkEnum;
import com.api.filmeteca.enums.ParamApiEnum;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GeneroService {

    private RestTemplate restTemplate;

    private GenerosDto genres;

    public GeneroService() {

        this.restTemplate = new RestTemplate();
        this.genres = new GenerosDto();
    }

    public GenerosDto getListGeneros() {

        this.genres = this.restTemplate.getForObject(montaUrlListGeneros(), GenerosDto.class);
        return this.genres;
    }

    private String montaUrlListGeneros() {

        return LinkEnum.URL_LIST_GENEROS.getUrl() + "?" + ParamApiEnum.KEY_API.getConfig() + "&"
                + ParamApiEnum.LANGUAGE_PT_BR.getConfig();
    }
}
