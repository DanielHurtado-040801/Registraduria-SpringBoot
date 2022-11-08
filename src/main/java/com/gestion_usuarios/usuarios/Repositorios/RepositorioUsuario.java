package com.gestion_usuarios.usuarios.Repositorios;

import com.gestion_usuarios.usuarios.Models.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface RepositorioUsuario extends MongoRepository<Usuario,String>{

    @Query("{'correo': ?0}") //El ?0 significa que ese valor se le va a asignar mas adelante
    public Usuario BuscarUsuarioCorreo(String correo);
}
