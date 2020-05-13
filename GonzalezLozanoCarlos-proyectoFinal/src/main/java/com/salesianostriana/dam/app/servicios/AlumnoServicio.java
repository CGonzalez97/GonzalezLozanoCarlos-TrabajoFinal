package com.salesianostriana.dam.app.servicios;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.app.entidades.Alumno;
import com.salesianostriana.dam.app.repositorios.AlumnoRepository;

@Service
public class AlumnoServicio extends BaseService<Alumno ,Long, AlumnoRepository> {

	public AlumnoServicio(AlumnoRepository repositorio) {
		super(repositorio);
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	

}
