package com.salesianostriana.dam.app.servicios;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImp implements UserDetailsService {

	private /*final*/ UsuarioServicio usuarioServicio;
	
	
	@Override
	public UserDetails loadUserByUsername(String nick) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return usuarioServicio.buscarPorNick(nick)
				.orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
	}

	

}
