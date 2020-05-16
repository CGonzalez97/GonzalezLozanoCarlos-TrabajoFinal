package com.salesianostriana.dam.app.entidades;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@Entity
public class Empresa extends Usuario {
	
	private String cif;
	private String nombre;
	private String sector;
	private String email;
	private String telefono;
	private String direccion;
	
	public Empresa(String nick, String contrasenya, List<Mensaje> recibidos, List<Mensaje> enviados, String cif,
			String nombre, String sector, String email, String telefono, String direccion) {
		super(nick, contrasenya, recibidos, enviados);
		this.cif = cif;
		this.nombre = nombre;
		this.sector = sector;
		this.email = email;
		this.telefono = telefono;
		this.direccion = direccion;
	}
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"),new SimpleGrantedAuthority("ROLE_EMPRESA"));
	}




	
	
	
	

}
