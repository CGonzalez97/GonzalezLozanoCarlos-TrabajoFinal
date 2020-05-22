package com.salesianostriana.dam.app.servicios;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.app.entidades.Alumno;
import com.salesianostriana.dam.app.entidades.Mensaje;
import com.salesianostriana.dam.app.entidades.Usuario;
import com.salesianostriana.dam.app.repositorios.AlumnoRepository;

@Service
public class AlumnoServicio extends BaseService<Alumno ,Long, AlumnoRepository> {

	public AlumnoServicio(AlumnoRepository repositorio) {
		super(repositorio);
		// TODO Auto-generated constructor stub
	}
	
	public void editar(Usuario t, @AuthenticationPrincipal Alumno al,BCryptPasswordEncoder passwordEncoder) {
		al.setNick(t.getNick());
		
		
//		al.setContrasenya(passwordEncoder.encode(t.getContrasenya()));
		if(!al.getContrasenya().equals(t.getContrasenya())) {
			al.setContrasenya(passwordEncoder.encode(t.getContrasenya()));
		}
		
		
		al.setNombre(((Alumno)t).getNombre());
		al.setFechaNacimiento(((Alumno)t).getFechaNacimiento());
		al.setDireccion(((Alumno)t).getDireccion());
		al.setEmail(((Alumno)t).getEmail());
		al.setGradoCursado(((Alumno)t).getGradoCursado());
		al.setFechaInicioGrado(((Alumno)t).getFechaInicioGrado());
		al.setFechaFinGrado(((Alumno)t).getFechaFinGrado());	
		edit(al);
		
	}
	
	//alumno mandar Mensaje desde mensaje
	public Long mandarMensajeDesdeMensaje(Usuario alumno, Long id, Mensaje mensaje, UsuarioServicio usuarioServicio, MensajeServicio mensajeServicio) {
		Mensaje men=new Mensaje();
		mensajeServicio.setearMensaje(alumno, usuarioServicio.findById(id), men, mensaje);
		usuarioServicio.edit(alumno);
		usuarioServicio.edit(usuarioServicio.findById(id));
		return men.getId();
		
	}
	
	//alumno mandar mensaje desde perfil
	public void mandarMensajeDesdePerfil(Usuario alumno, Long id, Mensaje mensaje, UsuarioServicio usuarioServicio, MensajeServicio mensajeServicio) {
		Mensaje men=new Mensaje();
		mensajeServicio.setearMensaje(alumno, usuarioServicio.findById(id), men, mensaje);
		usuarioServicio.edit(alumno);
		usuarioServicio.edit(usuarioServicio.findById(id));
		
	}
	
	
	
	
	
	
	

}
