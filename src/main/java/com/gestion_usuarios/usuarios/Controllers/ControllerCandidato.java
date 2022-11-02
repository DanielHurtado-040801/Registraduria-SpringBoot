package com.gestion_usuarios.usuarios.Controllers;

import com.gestion_usuarios.usuarios.Models.Partido;
import com.gestion_usuarios.usuarios.Models.Candidato;
import com.gestion_usuarios.usuarios.Repositorios.RepositorioPartido;
import com.gestion_usuarios.usuarios.Repositorios.RepositorioCandidato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@CrossOrigin
@RestController //
@RequestMapping("/candidatos")

public class ControllerCandidato {

    @Autowired
    private RepositorioPartido repoPartido;
    @Autowired
    private RepositorioCandidato repoCandidato;
    
    @GetMapping("")
    public List<Candidato> index(){
        return this.repoCandidato.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public Candidato create(@RequestBody Candidato infoCandidato){
        return this.repoCandidato.save(infoCandidato);
    }

    @PutMapping("{id}")
    public Candidato update(@PathVariable String id,@RequestBody Candidato
            infoCandidato){
        Candidato candidatoActual=this.repoCandidato
                .findById(id)
                .orElse(null);
        if (candidatoActual!=null){
            candidatoActual.setName(infoCandidato.getName());
            candidatoActual.setCedula(infoCandidato.getCedula());
            candidatoActual.setResolution_number(infoCandidato.getResolution_number());
            return this.repoCandidato.save(candidatoActual);
        }else{
            return null;
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable String id){
        Candidato candidatoActual=this.repoCandidato
                .findById(id)
                .orElse(null);
        if (candidatoActual!=null){
            this.repoCandidato.delete(candidatoActual);
        }
    }

    @PostMapping("{id_candidato}/partido/{id_partido}")
    public Candidato asginarPartido(@PathVariable String id_candidato, @PathVariable String id_partido){
        Candidato candidatoConsulta = this.repoCandidato.findById(id_candidato).orElse(null);
        Partido partidoConsulta = this.repoPartido.findById(id_partido).orElse(null);
        if(candidatoConsulta != null && partidoConsulta != null){
            candidatoConsulta.setPartido(partidoConsulta);
            return this.repoCandidato.save(candidatoConsulta);
        }
        else{
            return null;
        }
    }
}
