package com.api.filmeteca.service;

import com.api.filmeteca.dto.ElencoDto;
import com.api.filmeteca.dto.ParticipanteDto;
import com.api.filmeteca.enums.LinkEnum;
import com.api.filmeteca.enums.ParamApiEnum;

import org.springframework.web.client.RestTemplate;

public class ElencoService {

    private RestTemplate restTemplate;
    private ElencoDto eleconDto;

    public ElencoService() {
        this.restTemplate = new RestTemplate();
        this.eleconDto = new ElencoDto();
    }

    public ElencoDto getElenco(String id) {

        this.eleconDto = this.restTemplate.getForObject(montaUrlDiretor(id), ElencoDto.class);
        this.eleconDto.setDiretor(findDiretor());
        return this.eleconDto;
    }

    private String montaUrlDiretor(String id) {

        return LinkEnum.URL_DIRETOR.getUrl() + id + "/credits?" + ParamApiEnum.KEY_API.getConfig() + "&"
                + ParamApiEnum.LANGUAGE_PT_BR.getConfig();
    }

    private ParticipanteDto findDiretor() {

        for (ParticipanteDto participante : eleconDto.getCrew()) {
            if (participante.getJob().equals("Director")) {
                return participante;
            }
        }
        return null;
    }

}
