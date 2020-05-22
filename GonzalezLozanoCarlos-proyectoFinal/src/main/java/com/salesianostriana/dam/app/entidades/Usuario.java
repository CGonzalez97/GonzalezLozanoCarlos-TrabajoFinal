package com.salesianostriana.dam.app.entidades;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@NoArgsConstructor
public abstract class Usuario  implements UserDetails {
	
	

	@Id
	@GeneratedValue
	private long id;
	
	@Column(unique=true)
	private String nick;
	private String contrasenya;
	
	
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(fetch=FetchType.EAGER, mappedBy="destinatario")
	private List<Mensaje> recibidos;
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(fetch=FetchType.EAGER, mappedBy="remitente")
	private List<Mensaje> enviados;
	
	
	public Usuario(String nick, String contrasenya, List<Mensaje> recibidos, List<Mensaje> enviados) {
		super();
		this.nick = nick;
		this.contrasenya = contrasenya;
		this.recibidos = recibidos;
		this.enviados = enviados;
	}
	
	
	
	

//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		// TODO Auto-generated method stub
//		String rol=null;
//		if(this instanceof Alumno) {
//			rol="ROLE_ALUMNO";
//		}else if(this instanceof Administrador) {
//			rol="ROLE_ADMIN";
//		}else if(this instanceof Empresa) {
//			rol="ROLE_EMPRESA";
//		}
//		return Arrays.asList(new SimpleGrantedAuthority(rol));
//	}


	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return contrasenya;
	}


	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return nick;
	}


	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return /*false*/true;
	}


	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return /*false*/true;
	}


	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return /*false*/true;
	}


	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return /*false*/true;
	}


	//Helpers
	
	public void addEnviado(Mensaje enviado) {
		this.enviados.add(enviado);
		enviado.setRemitente(this);
	}
	
	public void removeEnviado(Mensaje enviado) {
		this.enviados.remove(enviado);
		enviado.setRemitente(null);
	}
	
	public void addRecibido(Mensaje recibido) {
		this.recibidos.add(recibido);
		recibido.setDestinatario(this);
	}
	
	public void removeRecibido(Mensaje recibido) {
		this.recibidos.add(recibido);
		recibido.setDestinatario(null);
	}


	
	
	
	
	
	
	
	
	

}
