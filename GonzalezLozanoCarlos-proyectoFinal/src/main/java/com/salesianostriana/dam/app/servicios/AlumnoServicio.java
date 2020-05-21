package com.salesianostriana.dam.app.servicios;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.app.entidades.Alumno;
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
		
	}
	
	
	
	
	
	
	

}
