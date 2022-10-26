package com.gestion_usuarios.usuarios.Repositorios;

import com.gestion_usuarios.usuarios.Models.Rol;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositorioRol extends MongoRepository<Rol,String>{
}
