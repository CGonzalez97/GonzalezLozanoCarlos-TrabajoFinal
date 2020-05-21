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
	
	
	
	
	
	
	

}
