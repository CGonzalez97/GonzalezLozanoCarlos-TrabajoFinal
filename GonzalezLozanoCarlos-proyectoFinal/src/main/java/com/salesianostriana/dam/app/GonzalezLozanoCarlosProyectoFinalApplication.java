package com.salesianostriana.dam.app;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.salesianostriana.dam.app.entidades.Administrador;
import com.salesianostriana.dam.app.entidades.Alumno;
import com.salesianostriana.dam.app.entidades.Anuncio;
import com.salesianostriana.dam.app.entidades.Empresa;
import com.salesianostriana.dam.app.entidades.Usuario;
import com.salesianostriana.dam.app.servicios.AnuncioServicio;
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
	public CommandLineRunner init(AnuncioServicio anuncioServicio, UsuarioServicio servicio, BCryptPasswordEncoder passwordEncoder) {
		return args -> {
			
			//-----------------------------------------------------------------------------
			//Alumnos
			Usuario u = new Alumno();			
			u.setNick("alumno");
			u.setContrasenya(passwordEncoder.encode("1234"));
			((Alumno) u).setNombre("Alumno1");
			((Alumno) u).setGradoCursado("DAM");
			((Alumno) u).setEmail("alumno1@gmail.com");
			((Alumno) u).setDireccion("c/ Pato Pato Pato Pato nºinfinite");
			((Alumno) u).setFechaNacimiento(LocalDate.now());
			((Alumno) u).setFechaInicioGrado(LocalDate.now());
			((Alumno) u).setFechaFinGrado(LocalDate.now());
			servicio.save(u);
			
			Usuario u2 = new Alumno();
			u2.setNick("alumno2");
			u2.setContrasenya(passwordEncoder.encode("1234"));
			((Alumno) u2).setNombre("Alumno2");
			((Alumno) u2).setGradoCursado("Gestión");
			((Alumno) u2).setEmail("alumno1@gmail.com");
			((Alumno) u2).setDireccion("c/ Pato Pato Pato Pato nºinfinite");
			((Alumno) u2).setFechaNacimiento(LocalDate.now());
			((Alumno) u2).setFechaInicioGrado(LocalDate.now());
			((Alumno) u2).setFechaFinGrado(LocalDate.now());
			servicio.save(u2);
			
			Usuario u3 = new Alumno();
			u3.setNick("alumno3");
			u3.setContrasenya(passwordEncoder.encode("1234"));
			((Alumno) u3).setNombre("Alumno3");
			((Alumno) u3).setGradoCursado("Comercio");
			((Alumno) u3).setEmail("alumno1@gmail.com");
			((Alumno) u3).setDireccion("c/ Pato Pato Pato Pato nºinfinite");
			((Alumno) u3).setFechaNacimiento(LocalDate.now());
			((Alumno) u3).setFechaInicioGrado(LocalDate.now());
			((Alumno) u3).setFechaFinGrado(LocalDate.now());
			servicio.save(u3);
			
			Usuario u4 = new Alumno();
			u4.setNick("alumno4");
			u4.setContrasenya(passwordEncoder.encode("1234"));
			((Alumno) u4).setNombre("Alumno4");
			((Alumno) u4).setGradoCursado("FPB");
			((Alumno) u4).setEmail("alumno1@gmail.com");
			((Alumno) u4).setDireccion("c/ Pato Pato Pato Pato nºinfinite");
			((Alumno) u4).setFechaNacimiento(LocalDate.now());
			((Alumno) u4).setFechaInicioGrado(LocalDate.now());
			((Alumno) u4).setFechaFinGrado(LocalDate.now());
			servicio.save(u4);
			
			Usuario u5 = new Alumno();
			u5.setNick("alumno5");
			u5.setContrasenya(passwordEncoder.encode("1234"));
			((Alumno) u5).setNombre("Alumno5");
			((Alumno) u5).setGradoCursado("Administración");
			((Alumno) u5).setEmail("alumno1@gmail.com");
			((Alumno) u5).setDireccion("c/ Pato Pato Pato Pato nºinfinite");
			((Alumno) u5).setFechaNacimiento(LocalDate.now());
			((Alumno) u5).setFechaInicioGrado(LocalDate.now());
			((Alumno) u5).setFechaFinGrado(LocalDate.now());
			servicio.save(u5);
			
			//-----------------------------------------------------------------------------
			//Administrador
			Usuario a = new Administrador();			
			a.setNick("admin");
			a.setContrasenya(passwordEncoder.encode("admin"));	
			((Administrador)a).setAnuncios(new ArrayList<Anuncio>());
			servicio.save(a);
			
			//-----------------------------------------------------------------------------
			//Empresas
			Usuario e=new Empresa();
			e.setNick("empresa");
			e.setContrasenya(passwordEncoder.encode("1234"));	
			((Empresa) e).setNombre("Empresa1");
			((Empresa) e).setSector("Electrónica");
			((Empresa) e).setCif("11111111");
			((Empresa) e).setEmail("empresa1@gmail.com");
			((Empresa) e).setTelefono("111111111");
			((Empresa) e).setDireccion("c/empresa nº1");
			servicio.save(e);
			
			Usuario e2=new Empresa();
			e2.setNick("empresa2");
			e2.setContrasenya(passwordEncoder.encode("1234"));
			((Empresa)e2).setNombre("Empresa2");
			((Empresa)e2).setSector("Programación");
			((Empresa) e2).setCif("22222222");
			((Empresa) e2).setEmail("empresa2@gmail.com");
			((Empresa) e2).setTelefono("222222222");
			((Empresa) e2).setDireccion("c/empresa nº2");
			servicio.save(e2);
			
			Usuario e3=new Empresa();
			e3.setNick("empresa3");
			e3.setContrasenya(passwordEncoder.encode("1234"));
			((Empresa)e3).setNombre("Empresa3");
			((Empresa)e3).setSector("Comerciales");
			((Empresa) e3).setCif("33333333");
			((Empresa) e3).setEmail("empresa3@gmail.com");
			((Empresa) e3).setTelefono("333333333");
			((Empresa) e3).setDireccion("c/empresa nº3");
			servicio.save(e3);
			
			
			
			Usuario e4=new Empresa();
			e4.setNick("empresa4");
			e4.setContrasenya(passwordEncoder.encode("1234"));
			((Empresa) e4).setNombre("Empresa4");
			((Empresa) e4).setSector("Desarrollo Web");
			((Empresa) e4).setCif("44444444");
			((Empresa) e4).setEmail("empresa4@gmail.com");
			((Empresa) e4).setTelefono("444444444");
			((Empresa) e4).setDireccion("c/empresa nº4");
			servicio.save(e4);
			
			Usuario e5=new Empresa();
			e5.setNick("empresa5");
			e5.setContrasenya(passwordEncoder.encode("1234"));
			((Empresa) e5).setNombre("Empresa5");
			((Empresa) e5).setSector("Asesoría");
			((Empresa) e5).setCif("55555555");
			((Empresa) e5).setEmail("empresa5@gmail.com");
			((Empresa) e5).setTelefono("555555555");
			((Empresa) e5).setDireccion("c/empresa nº5");
			servicio.save(e5);
			
			//-----------------------------------------------------------------------------
			//Anuncios
			Anuncio an=new Anuncio();
			an.setTitulo("Campaña Domund");
			an.setDescripcion("Esta semana se llevará a cabo la campaña solidaria del Domund,"
					+ " cada uno podrá ayudar con lo que desee.");
			an.setFechaEvento(LocalDate.now());
			anuncioServicio.save(an);		
			((Administrador) a).addAnuncio(an);
			servicio.edit(a);
			
			Anuncio an2=new Anuncio();
			an2.setTitulo("Campaña Kilo");
			an2.setDescripcion("Esta semana se llevará a cabo la campaña solidaria del Kilo,"
					+ " estaría bien trajerais alimentos no perecederos.");
			an2.setFechaEvento(LocalDate.now());
			anuncioServicio.save(an2);		
			((Administrador) a).addAnuncio(an2);
			servicio.edit(a);
					
			
			Anuncio an3=new Anuncio();
			an3.setTitulo("Campaña Kilo");
			an3.setDescripcion("Esta semana se celebrarán las fiestas de María Auxiliadora,"
					+ " todos estáis invitados.");
			an3.setFechaEvento(LocalDate.now());
			anuncioServicio.save(an3);		
			((Administrador) a).addAnuncio(an3);
			servicio.edit(a);
			
			
			
			
			
			
			
			
			
			
			
			
		};
	}

}
