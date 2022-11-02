package com.gestion_usuarios.usuarios.Controllers;

import com.gestion_usuarios.usuarios.Models.Rol;
import com.gestion_usuarios.usuarios.Models.Permiso;
import com.gestion_usuarios.usuarios.Models.RolPermiso;


import com.gestion_usuarios.usuarios.Repositorios.RepositorioRol;
import com.gestion_usuarios.usuarios.Repositorios.RepositorioPermiso;
import com.gestion_usuarios.usuarios.Repositorios.RepositorioRolPermiso;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/RolPermiso")

public class ControllerRolPermiso {
    @Autowired
    private RepositorioRolPermiso miRepositorioRolPermiso;
    @Autowired
    private RepositorioRol miRepositorioRol;
    @Autowired
    private RepositorioPermiso miRepositorioPermiso;


    @PostMapping("crear/{idRol}/permiso/{idPermiso}")
    public RolPermiso create(@PathVariable String idRol, @PathVariable String idPermiso){
        Rol rolConsulta = miRepositorioRol.findById(idRol).orElseThrow(RuntimeException::new);
        Permiso permisoConsulta = miRepositorioPermiso.findById(idPermiso).orElseThrow(RuntimeException::new);
        if(rolConsulta != null && permisoConsulta != null){
            RolPermiso rolPermiso = new RolPermiso(rolConsulta, permisoConsulta);
            return this.miRepositorioRolPermiso.save(rolPermiso);
        }
        else{
            return null;
        }
    }

    @GetMapping("")
    public List<RolPermiso> index(){
        return miRepositorioRolPermiso.findAll();
    } 
}
