package com.salesianostriana.dam.app.servicios;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.app.entidades.Mensaje;
import com.salesianostriana.dam.app.entidades.Usuario;
import com.salesianostriana.dam.app.repositorios.MensajeRepository;

@Service
public class MensajeServicio extends BaseService<Mensaje, Long, MensajeRepository> {

	public MensajeServicio(MensajeRepository repositorio) {
		super(repositorio);
		// TODO Auto-generated constructor stub
	}
	
	
	
	public void setearMensaje(Usuario u1, Usuario u2, Mensaje mensaje, Mensaje mensajeAux) {
		mensaje.setContenido(mensajeAux.getContenido());
		mensaje.setFechaEnvio(LocalDate.now());
		u1.addEnviado(mensaje);
		u2.addRecibido(mensaje);
		save(mensaje);
//		edit(mensaje);
//		repositorio.save(mensaje);
		
	}
	
	

}
