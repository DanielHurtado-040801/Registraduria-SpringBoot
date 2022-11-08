package com.gestion_usuarios.usuarios.Controllers;

import com.gestion_usuarios.usuarios.Models.Usuario;
import com.gestion_usuarios.usuarios.Models.Rol;
import com.gestion_usuarios.usuarios.Repositorios.RepositorioUsuario;
import com.gestion_usuarios.usuarios.Repositorios.RepositorioRol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
@CrossOrigin
@RestController //
@RequestMapping("/usuarios")

public class ControllerUsuario {
    @Autowired
    private RepositorioUsuario miRepositorioUsuario;
    @Autowired
    private RepositorioRol miRepositorioRol;
    
    @GetMapping("")
    public List<Usuario> index(){
        return this.miRepositorioUsuario.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Usuario create(@RequestBody Usuario infoUsuario){
        infoUsuario.setContrasena(convertirSHA256(infoUsuario.getContrasena()));
        return this.miRepositorioUsuario.save(infoUsuario);
    }

    @PostMapping("{id_usuario}/rol/{id_rol}")
    public Usuario asignarRol(@PathVariable String id_usuario, @PathVariable String id_rol){
        Usuario usuarioActual = miRepositorioUsuario.findById(id_usuario).orElseThrow(RuntimeException::new);
        Rol rolActual = miRepositorioRol.findById(id_rol).orElseThrow(RuntimeException::new);
        usuarioActual.setRol(rolActual);
        return this.miRepositorioUsuario.save(usuarioActual);
    }


    @GetMapping("{id}")
    public Usuario show(@PathVariable String id){
        Usuario usuarioActual=this.miRepositorioUsuario
                .findById(id)
                .orElse(null);
        return usuarioActual;
    }


    @PutMapping("{id}")
    public Usuario update(@PathVariable String id,@RequestBody Usuario
            infoUsuario){
        Usuario usuarioActual=this.miRepositorioUsuario
                .findById(id)
                .orElse(null);
        if (usuarioActual!=null){
            usuarioActual.setSeudonimo(infoUsuario.getSeudonimo());
            usuarioActual.setCorreo(infoUsuario.getCorreo());
            usuarioActual.setContrasena(convertirSHA256(infoUsuario.getContrasena()))
            ;
            return this.miRepositorioUsuario.save(usuarioActual);
        }else{
            return null;
        }
    }
    
    
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable String id){
        Usuario usuarioActual=this.miRepositorioUsuario
                .findById(id)
                .orElse(null);
        if (usuarioActual!=null){
            this.miRepositorioUsuario.delete(usuarioActual);
        }
    }
   
   
    public String convertirSHA256(String password) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-256");
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
        byte[] hash = md.digest(password.getBytes());
        StringBuffer sb = new StringBuffer();
        for(byte b : hash) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    @PostMapping("/login")
    public Usuario login(@RequestBody Usuario usuario, HttpServletResponse respuesta) throws IOException{
        Usuario usuarioConsulta = miRepositorioUsuario.BuscarUsuarioCorreo(usuario.getCorreo());
/*         System.out.println(usuarioConsulta);
        System.out.println("Contraseña login: " + convertirSHA256(usuario.getContrasena())); 
        System.out.println("Contraseña real: " + usuarioConsulta.getContrasena()); */
        if(usuarioConsulta != null && convertirSHA256(usuario.getContrasena()).equals(usuarioConsulta.getContrasena())){
            usuarioConsulta.setContrasena("");
            return usuarioConsulta;
        }
        else{
            System.out.println("Usuario no registrado");
            respuesta.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            return null;
        }
    }
}
