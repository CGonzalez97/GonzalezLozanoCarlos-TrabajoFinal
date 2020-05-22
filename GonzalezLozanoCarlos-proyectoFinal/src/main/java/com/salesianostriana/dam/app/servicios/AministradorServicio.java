package com.salesianostriana.dam.app.servicios;

import java.util.ArrayList;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.app.entidades.Administrador;
import com.salesianostriana.dam.app.entidades.Alumno;
import com.salesianostriana.dam.app.entidades.Anuncio;
import com.salesianostriana.dam.app.entidades.Empresa;
import com.salesianostriana.dam.app.entidades.Mensaje;
import com.salesianostriana.dam.app.entidades.Usuario;
import com.salesianostriana.dam.app.repositorios.AdministradorRepository;


@Service
public class AministradorServicio extends BaseService<Administrador, Long, AdministradorRepository> {

	public AministradorServicio(AdministradorRepository repositorio) {
		super(repositorio);
		// TODO Auto-generated constructor stub
	}
	
	public void editarAnuncio(Anuncio anun, Anuncio anunMod) {
		
		anunMod.setTitulo(anun.getTitulo());
		anunMod.setFechaEvento(anun.getFechaEvento());
		anunMod.setDescripcion(anun.getDescripcion());
		
	}
	
	public void editarAlumno(Alumno a, Alumno al,BCryptPasswordEncoder passwordEncoder) {
		al.setNick(a.getNick());
		
		
//		al.setContrasenya(passwordEncoder.encode(t.getContrasenya()));
		if(!al.getContrasenya().equals(a.getContrasenya())) {
			al.setContrasenya(passwordEncoder.encode(a.getContrasenya()));
		}
		
		
		al.setNombre(a.getNombre());
		al.setFechaNacimiento(a.getFechaNacimiento());
		al.setDireccion(a.getDireccion());
		al.setEmail(a.getEmail());
		al.setGradoCursado(a.getGradoCursado());
		al.setFechaInicioGrado(a.getFechaInicioGrado());
		al.setFechaFinGrado(a.getFechaFinGrado());		
		
	}
	
	public void editarEmpresa(Empresa empresa, Empresa emp,BCryptPasswordEncoder passwordEncoder) {		
		emp.setNick(empresa.getNick());
		
//		al.setContrasenya(passwordEncoder.encode(t.getContrasenya()));
		if(!emp.getContrasenya().equals(empresa.getContrasenya())) {
			emp.setContrasenya(passwordEncoder.encode(empresa.getContrasenya()));
		}
		
		emp.setCif(empresa.getCif());
		emp.setNombre(empresa.getNombre());
		emp.setSector(empresa.getSector());
		emp.setEmail(empresa.getEmail());
		emp.setTelefono(empresa.getTelefono());
		emp.setDireccion(empresa.getDireccion());
	
	}
	
	//crear anuncio
	public void crearAnuncio(Usuario admin  , Anuncio anuncio, AnuncioServicio anuncioServicio) {
		
		
		admin=findById(admin.getId());
		((Administrador)admin).addAnuncio(anuncio);
		
		anuncioServicio.save(anuncio);
		
	}
	
	//crear alumno
	public void crearAlumno(Alumno alumno, BCryptPasswordEncoder passwordEncoder, UsuarioServicio usuarioServicio) {
		alumno.setRecibidos(new ArrayList<Mensaje>());
		alumno.setEnviados(new ArrayList<Mensaje>());
		usuarioServicio.save(alumno,passwordEncoder);
		
	}
	
	//crear empresa
	public void crearEmpresa(Empresa empresa, BCryptPasswordEncoder passwordEncoder, UsuarioServicio usuarioServicio) {
		empresa.setRecibidos(new ArrayList<Mensaje>());
		empresa.setEnviados(new ArrayList<Mensaje>());
		usuarioServicio.save(empresa,passwordEncoder);
		
	}
	
	
	
	
	

}
