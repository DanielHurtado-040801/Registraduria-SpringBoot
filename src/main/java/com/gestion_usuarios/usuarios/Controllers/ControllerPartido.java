package com.gestion_usuarios.usuarios.Controllers;

import com.gestion_usuarios.usuarios.Models.Partido;
import com.gestion_usuarios.usuarios.Repositorios.RepositorioPartido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@CrossOrigin
@RestController //
@RequestMapping("/partidos")

public class ControllerPartido {

    @Autowired
    private RepositorioPartido repoPartido;
    
    @GetMapping("")
    public List<Partido> index(){
        return this.repoPartido.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public Partido create(@RequestBody Partido infoPartido){
        return this.repoPartido.save(infoPartido);
    }

    @PutMapping("{id}")
    public Partido update(@PathVariable String id,@RequestBody Partido
            infoPartido){
        Partido partidoActual=this.repoPartido
                .findById(id)
                .orElse(null);
        if (partidoActual!=null){
            partidoActual.setName(infoPartido.getName());
            partidoActual.setLema(infoPartido.getLema());
            ;
            return this.repoPartido.save(partidoActual);
        }else{
            return null;
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable String id){
        Partido partidoActual=this.repoPartido
                .findById(id)
                .orElse(null);
        if (partidoActual!=null){
            this.repoPartido.delete(partidoActual);
        }
    }
}
