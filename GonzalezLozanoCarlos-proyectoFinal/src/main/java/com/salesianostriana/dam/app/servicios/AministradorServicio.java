package com.salesianostriana.dam.app.servicios;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.app.entidades.Administrador;
import com.salesianostriana.dam.app.entidades.Anuncio;
import com.salesianostriana.dam.app.repositorios.AdministradorRepository;


@Service
public class AministradorServicio extends BaseService<Administrador, Long, AdministradorRepository> {

	public AministradorServicio(AdministradorRepository repositorio) {
		super(repositorio);
		// TODO Auto-generated constructor stub
	}
	
	public void editarAnuncio(Anuncio anun, Anuncio anunMod) {
		
		anunMod.setTitulo(anun.getTitulo());
		anunMod.setFechaEvento(anun.getFechaEvento());
		anunMod.setDescripcion(anun.getDescripcion());
		
	}
	
	
	
	
	

}
