package com.salesianostriana.dam.app.servicios;

import java.util.Optional;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.app.entidades.Alumno;
import com.salesianostriana.dam.app.entidades.Usuario;
import com.salesianostriana.dam.app.repositorios.UsuarioRepository;

@Service
public class UsuarioServicio extends BaseService<Usuario, Long, UsuarioRepository> {

	public UsuarioServicio(UsuarioRepository repositorio) {
		super(repositorio);
		// TODO Auto-generated constructor stub
	}
	
	public Optional<Usuario> buscarPorNick(String nick) {
		return repositorio.findFirstByNick(nick);
	}

	
	public Usuario save(Usuario t, BCryptPasswordEncoder passwordEncoder) {
		// TODO Auto-generated method stub
		t.setContrasenya(passwordEncoder.encode(t.getContrasenya()));
		return super.save(t);
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
//		edit(al);
		
		
		
	}
	
	/*
	public void saveUser(Usuario u) {
		repositorio.save(u);
	}
	*/
	
	
	

}
