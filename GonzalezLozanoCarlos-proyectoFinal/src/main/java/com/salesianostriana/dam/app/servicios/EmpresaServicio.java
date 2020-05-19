package com.salesianostriana.dam.app.servicios;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.app.entidades.Empresa;
import com.salesianostriana.dam.app.repositorios.EmpresaRepository;

@Service
public class EmpresaServicio extends BaseService<Empresa, Long, EmpresaRepository> {

	public EmpresaServicio(EmpresaRepository repositorio) {
		super(repositorio);
		// TODO Auto-generated constructor stub
	}
	
	

}
