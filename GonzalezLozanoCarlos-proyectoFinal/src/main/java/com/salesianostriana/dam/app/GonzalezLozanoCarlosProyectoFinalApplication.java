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
import com.salesianostriana.dam.app.servicios.UsuarioServicio;

@SpringBootApplication
public class GonzalezLozanoCarlosProyectoFinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(GonzalezLozanoCarlosProyectoFinalApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner init (UsuarioServicio usuarioServicio, BCryptPasswordEncoder passwordEncoder) {
		
		return args->{
			Usuario p=new Alumno();
			p.setNick("usuario");
			p.setContrasenya("usuario");
			/*p.setNombre("Usuario1");
			p.setEmail("afbiubfuiaf@gmail.com");
			p.setDireccion("ijkbjafbai");
			p.setFechaNacimiento(Date.now);
			p.setGradoCursado("afnuicpq");
			p.setFechaInicioGrado(Date.now);
			p.setFechaFinGrado(Date.now);*/
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

}
