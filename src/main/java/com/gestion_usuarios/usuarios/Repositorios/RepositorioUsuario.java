package com.gestion_usuarios.usuarios.Repositorios;

import com.gestion_usuarios.usuarios.Models.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositorioUsuario extends MongoRepository<Usuario,String>{
}
