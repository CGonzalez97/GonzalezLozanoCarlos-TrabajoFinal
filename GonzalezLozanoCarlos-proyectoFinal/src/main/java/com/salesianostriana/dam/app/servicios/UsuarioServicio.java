package com.salesianostriana.dam.app.servicios;

import java.util.Optional;

import org.springframework.stereotype.Service;

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
	/*
	public void saveUser(Usuario u) {
		repositorio.save(u);
	}
	*/
	

}
