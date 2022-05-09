package com.api.filmeteca.service;

import com.api.filmeteca.enums.LinkEnum;
import com.api.filmeteca.enums.ParamApiEnum;
import com.api.filmeteca.model.Elenco;
import com.api.filmeteca.model.Participante;

import org.springframework.web.client.RestTemplate;

public class ElencoService {

    private RestTemplate restTemplate;
    private Elenco elenco;

    public ElencoService() {
        this.restTemplate = new RestTemplate();
        this.elenco = new Elenco();
    }

    public Elenco getElenco(String id) {

        this.elenco = this.restTemplate.getForObject(montaUrlDiretor(id), Elenco.class);
        this.elenco.setDiretor(findDiretor());
        return this.elenco;
    }

    private String montaUrlDiretor(String id) {

        String a = LinkEnum.URL_DIRETOR.getUrl() + id + "/credits?" + ParamApiEnum.KEY_API.getConfig() + "&"
                + ParamApiEnum.LANGUAGE_PT_BR.getConfig();
        return a;
    }

    private Participante findDiretor() {

        for (Participante participante : elenco.getCrew()) {
            if (participante.getJob().equals("Director")) {
                return participante;
            }
        }
        return null;
    }

}
