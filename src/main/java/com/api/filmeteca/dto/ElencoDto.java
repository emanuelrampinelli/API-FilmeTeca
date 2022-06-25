package com.api.filmeteca.dto;

import java.util.ArrayList;
import java.util.List;

import com.api.filmeteca.model.Participante;

public class ElencoDto {

    private int id;
    private List<ParticipanteDto> cast; // artistas
    private List<ParticipanteDto> crew; // Equipe_producao
    private ParticipanteDto diretor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<ParticipanteDto> getCast() {
        return cast;
    }

    public void setCast(List<ParticipanteDto> cast) {
        this.cast = cast;
    }

    public List<ParticipanteDto> getCrew() {
        return crew;
    }

    public void setCrew(List<ParticipanteDto> crew) {
        this.crew = crew;
    }

    public ParticipanteDto getDiretor() {
        return diretor;
    }

    public void setDiretor(ParticipanteDto diretor) {
        this.diretor = diretor;
    }

    private List<Participante> listParticipanteDtoToListParticipante(List<ParticipanteDto> participantesDto) {

        List<Participante> participantes = new ArrayList<>();

        for (ParticipanteDto participanteDto : participantesDto) {

            Participante participante = new Participante();

            participante.setId(participanteDto.getId());
            participante.setNome(participanteDto.getName());
            participante.setFuncao(participanteDto.getJob());
            participante.setPapel(participanteDto.getCharacter());
            participante.setProfile_path(participanteDto.getProfile_path());

            participantes.add(participante);

        }

        return participantes;
    }

}
