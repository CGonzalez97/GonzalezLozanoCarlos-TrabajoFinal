package com.salesianostriana.dam.app.entidades;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;

import org.springframework.format.annotation.DateTimeFormat;
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
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate fechaNacimiento;
	private String gradoCursado;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate fechaInicioGrado;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate fechaFinGrado;
	
	public Alumno(String nick, String contrasenya, List<Mensaje> recibidos, List<Mensaje> enviados, String nombre,
			String email, String direccion, LocalDate fechaNacimiento, String gradoCursado, LocalDate fechaInicioGrado,
			LocalDate fechaFinGrado) {
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
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ALUMNO"));
	}




	
	
	
	
	
	

}
