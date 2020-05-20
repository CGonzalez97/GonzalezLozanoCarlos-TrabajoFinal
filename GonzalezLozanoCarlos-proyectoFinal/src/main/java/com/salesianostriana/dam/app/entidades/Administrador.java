package com.salesianostriana.dam.app.entidades;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

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
public class Administrador extends Usuario {
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(fetch =FetchType.EAGER, mappedBy="administrador")
	private List<Anuncio> anuncios;
	
	public Administrador(String nick, String contrasenya, List<Mensaje> recibidos, List<Mensaje> enviados,
			List<Anuncio> anuncios) {
		super(nick, contrasenya, recibidos, enviados);
		this.anuncios = anuncios;
	}
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}
	
	//Helpers
	
	public void addAnuncio(Anuncio anuncio) {
		this.anuncios.add(anuncio);
		anuncio.setAdministrador(this);
	}
	
	public void removeAnuncio(Anuncio anuncio) {
		this.anuncios.remove(anuncio);
		anuncio.setAdministrador(null);
	}

	




	




	
	
	
	
		

}
