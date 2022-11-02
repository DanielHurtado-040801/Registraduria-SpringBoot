package com.gestion_usuarios.usuarios.Repositorios;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.gestion_usuarios.usuarios.Models.RolPermiso;

public interface RepositorioRolPermiso extends MongoRepository<RolPermiso,String>{
}
