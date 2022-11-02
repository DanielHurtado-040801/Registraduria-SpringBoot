package com.gestion_usuarios.usuarios.Repositorios;

import com.gestion_usuarios.usuarios.Models.Candidato;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositorioCandidato extends MongoRepository<Candidato,String>{
}
