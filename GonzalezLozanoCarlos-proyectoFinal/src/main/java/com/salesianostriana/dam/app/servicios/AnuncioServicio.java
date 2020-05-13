package com.salesianostriana.dam.app.servicios;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.app.entidades.Anuncio;
import com.salesianostriana.dam.app.repositorios.AnuncioRepository;

@Service
public class AnuncioServicio extends BaseService <Anuncio, Long, AnuncioRepository> {

	public AnuncioServicio(AnuncioRepository repositorio) {
		super(repositorio);
		// TODO Auto-generated constructor stub
	}
	
	

}
