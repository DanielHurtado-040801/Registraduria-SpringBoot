package com.gestion_usuarios.usuarios.Repositorios;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.gestion_usuarios.usuarios.Models.Permiso;

public interface RepositorioPermiso extends MongoRepository<Permiso,String>{
}