package com.gestion_usuarios.usuarios.Repositorios;

import com.gestion_usuarios.usuarios.Models.Partido;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositorioPartido extends MongoRepository<Partido,String>{
}

