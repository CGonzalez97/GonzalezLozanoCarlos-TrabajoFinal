package com.salesianostriana.dam.app.servicios;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.app.entidades.Alumno;
import com.salesianostriana.dam.app.entidades.Empresa;
import com.salesianostriana.dam.app.entidades.Mensaje;
import com.salesianostriana.dam.app.entidades.Usuario;
import com.salesianostriana.dam.app.repositorios.EmpresaRepository;

@Service
public class EmpresaServicio extends BaseService<Empresa, Long, EmpresaRepository> {

	
	
	
	public EmpresaServicio(EmpresaRepository repositorio) {
		super(repositorio);
		// TODO Auto-generated constructor stub
	}
	


	public void editar(Usuario t, @AuthenticationPrincipal Empresa emp,BCryptPasswordEncoder passwordEncoder) {		
		emp.setNick(t.getNick());
		
//		al.setContrasenya(passwordEncoder.encode(t.getContrasenya()));
		if(!emp.getContrasenya().equals(t.getContrasenya())) {
			emp.setContrasenya(passwordEncoder.encode(t.getContrasenya()));
		}
		
		emp.setCif(((Empresa)t).getCif());
		emp.setNombre(((Empresa)t).getNombre());
		emp.setSector(((Empresa)t).getSector());
		emp.setEmail(((Empresa)t).getEmail());
		emp.setTelefono(((Empresa)t).getTelefono());
		emp.setDireccion(((Empresa)t).getDireccion());
		edit(emp);
		
		

	}
	
	//Empresa mandar Mensaje desde mensaje
	public Long mandarMensajeDesdeMensaje(Usuario empresa, Long id, Mensaje mensaje, UsuarioServicio usuarioServicio, MensajeServicio mensajeServicio) {
		Mensaje men=new Mensaje();
		mensajeServicio.setearMensaje(empresa, usuarioServicio.findById(id), men, mensaje);
		usuarioServicio.edit(empresa);
		usuarioServicio.edit(usuarioServicio.findById(id));
		return men.getId();
		
	}
	
	//empresa mandar mensaje desde perfil
	public void mandarMensajeDesdePerfil(Usuario empresa, Long id, Mensaje mensaje, UsuarioServicio usuarioServicio, MensajeServicio mensajeServicio) {
		Mensaje men=new Mensaje();
		mensajeServicio.setearMensaje(empresa, usuarioServicio.findById(id), men, mensaje);
		usuarioServicio.edit(empresa);
		usuarioServicio.edit(usuarioServicio.findById(id));
		
	}
	
	

}
