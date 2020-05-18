package com.salesianostriana.dam.app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.salesianostriana.dam.app.entidades.Administrador;
import com.salesianostriana.dam.app.entidades.Alumno;
import com.salesianostriana.dam.app.entidades.Empresa;
import com.salesianostriana.dam.app.entidades.Usuario;
import com.salesianostriana.dam.app.servicios.AlumnoServicio;
import com.salesianostriana.dam.app.servicios.UsuarioServicio;

@SpringBootApplication
public class GonzalezLozanoCarlosProyectoFinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(GonzalezLozanoCarlosProyectoFinalApplication.class, args);
	}
	
	/*
	@Bean
	public CommandLineRunner init (UsuarioServicio usuarioServicio, AlumnoServicio servicioAlu, BCryptPasswordEncoder passwordEncoder) {
		
		return args->{
			Usuario p=new Alumno();
			p.setNick("usuario");
			p.setContrasenya(passwordEncoder.encode("usuario"));
			
			usuarioServicio.save(p);
			
			
			Usuario a=new Administrador();
			p.setNick("admin");
			p.setContrasenya(passwordEncoder.encode("admin"));
			usuarioServicio.save(a);
			
			Usuario e=new Empresa();
			e.setNick("empresa");
			e.setContrasenya(passwordEncoder.encode("empresa"));
			usuarioServicio.save(e);		
			
		};
		
	}
	*/
	
	@Bean
	public CommandLineRunner init(UsuarioServicio servicio, BCryptPasswordEncoder passwordEncoder) {
		return args -> {
			
			Usuario u = new Alumno();
			
			u.setNick("alumno");
			u.setContrasenya(passwordEncoder.encode("1234"));
			
			servicio.save(u);
			
			
			Usuario a = new Administrador();
			
			a.setNick("admin");
			a.setContrasenya(passwordEncoder.encode("admin"));
			
			servicio.save(a);
			
			Usuario e=new Empresa();
			e.setNick("empresa");
			e.setContrasenya("1234");
			
			servicio.save(e);
			
		};
	}

}
