package com.gestion_usuarios.usuarios.Controllers;

import com.gestion_usuarios.usuarios.Models.Permiso;
import com.gestion_usuarios.usuarios.Repositorios.RepositorioPermiso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/permisos")

public class ControllerPermiso {
    @Autowired
    private RepositorioPermiso miReposiotrioPmermiso;
    @GetMapping("")
    public List<Permiso> index() {
        return this.miReposiotrioPmermiso.findAll();
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Permiso create(@RequestBody Permiso infoPmeriso){
        return this.miReposiotrioPmermiso.save(infoPmeriso);
    }

    @GetMapping("{id}")
    public Permiso show(@PathVariable String id){
        Permiso permisoActual = this.miReposiotrioPmermiso
                        .findById(id)
                        .orElse(null);
        return permisoActual;
    }

    @PutMapping("{id}")
    public Permiso update(@PathVariable String id, @RequestBody Permiso infoPmeriso){
        Permiso permisoActual = this.miReposiotrioPmermiso
                        .findById(id)
                        .orElse(null);
        if(permisoActual != null){
            permisoActual.setUrl(infoPmeriso.getUrl());
            permisoActual.setMetodo(infoPmeriso.getMetodo());
            return this.miReposiotrioPmermiso.save(permisoActual);
        }
        else{
            return null;
        }
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id){
        Permiso permisoActual = this.miReposiotrioPmermiso
                        .findById(id)
                        .orElse(null);
        if(permisoActual != null){
            this.miReposiotrioPmermiso.delete(permisoActual);
        }
    }
}

