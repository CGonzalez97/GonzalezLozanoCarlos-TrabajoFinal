package com.salesianostriana.dam.app.entidades;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
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
public class Alumno extends Usuario {
	
	
	private String nombre;
	private String email;
	private String direccion;
	private Date fechaNacimiento;
	private String gradoCursado;
	private Date fechaInicioGrado;
	private Date fechaFinGrado;
	
	public Alumno(String nick, String contrasenya, List<Mensaje> recibidos, List<Mensaje> enviados, String nombre,
			String email, String direccion, Date fechaNacimiento, String gradoCursado, Date fechaInicioGrado,
			Date fechaFinGrado) {
		super(nick, contrasenya, recibidos, enviados);
		this.nombre = nombre;
		this.email = email;
		this.direccion = direccion;
		this.fechaNacimiento = fechaNacimiento;
		this.gradoCursado = gradoCursado;
		this.fechaInicioGrado = fechaInicioGrado;
		this.fechaFinGrado = fechaFinGrado;
	}
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"),new SimpleGrantedAuthority("ROLE_ALUMNO"));
	}




	
	
	
	
	
	

}
