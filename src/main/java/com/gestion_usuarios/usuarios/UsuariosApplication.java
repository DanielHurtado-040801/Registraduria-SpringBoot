package com.gestion_usuarios.usuarios;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
              
@SpringBootApplication
@RestController
public class UsuariosApplication {
	
    public static void main(String[] args) {
    	SpringApplication.run(UsuariosApplication.class, args);
    }
                  
    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		name = "Daniel Hurtado desde Spring Boot";
 		return String.format("Hello %s!", name);
	}               
}