package com.gestion_usuarios.usuarios.Models;

import org.springframework.data.annotation.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;

@Data
@Document()
public class Candidato {

    @Id
    private String id;
    private String name;
    private String resolution_number;
    private String cedula;
    @DBRef 
    private Partido partido;

    
    public Candidato(String name, String resolution_number, String cedula, Partido partido) {
        this.name = name;
        this.resolution_number = resolution_number;
        this.cedula = cedula;
        this.partido = partido;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResolution_number() {
        return resolution_number;
    }

    public void setResolution_number(String resolution_number) {
        this.resolution_number = resolution_number;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }
}
