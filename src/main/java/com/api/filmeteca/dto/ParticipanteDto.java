package com.api.filmeteca.dto;

import com.api.filmeteca.model.Participante;

public class ParticipanteDto {

    private int id;
    private String name;
    private String job;
    private String profile_path;
    private String character;

    public int getId() {
        return id;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfile_path() {
        return profile_path;
    }

    public void setProfile_path(String profile_path) {
        this.profile_path = profile_path;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public Participante participanteDtoToParticipante() {

        Participante participante = new Participante();

        participante.setId(id);
        participante.setNome(this.name);
        participante.setFuncao(this.job);
        participante.setPapel(this.character);
        participante.setProfile_path(this.profile_path);

        return participante;
    }
}
