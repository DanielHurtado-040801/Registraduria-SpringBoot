package com.gestion_usuarios.usuarios.Models;

import org.springframework.data.annotation.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;
@Data
@Document()
public class Usuario {
   @Id
   private String id;
   private String seudonimo;
   private String correo;
   private String contrasena;
   @DBRef
   private Rol rol;

   public Usuario(String seudonimo, String contrasena, String correo) {
      this.seudonimo = seudonimo;
      this.contrasena = contrasena;
      this.correo = correo;
   }

   public Rol getRol() {
      return rol;
   }
   public void setRol(Rol rol) {
      this.rol = rol;
   }
   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }

   public String getSeudonimo() {
      return seudonimo;
   }

   public void setSeudonimo(String seudonimo) {
      this.seudonimo = seudonimo;
   }

   public String getContrasena() {
      return contrasena;
   }

   public void setContrasena(String contrasena) {
      this.contrasena = contrasena;
   }

   public String getCorreo() {
      return correo;
   }

   public void setCorreo(String correo) {
      this.correo = correo;
   }


}
