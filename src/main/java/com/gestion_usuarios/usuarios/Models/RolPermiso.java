package com.gestion_usuarios.usuarios.Models;

import org.springframework.data.annotation.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;

@Data
@Document()
public class RolPermiso {
    @Id
    private String id;


    @DBRef
    private Rol rol;
    @DBRef
    private Permiso permiso;

    
    public RolPermiso(Rol rol,Permiso permiso) {
        this.rol = rol;
        this.permiso = permiso;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Permiso getPermiso() {
        return permiso;
    }

    public void setPermiso(Permiso permiso) {
        this.permiso = permiso;
    }
}
