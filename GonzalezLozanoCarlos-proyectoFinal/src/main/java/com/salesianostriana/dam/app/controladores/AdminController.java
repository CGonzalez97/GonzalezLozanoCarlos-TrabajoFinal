package com.salesianostriana.dam.app.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
	
	@GetMapping("/admin/adminVisualizacionAnuncios")
	public String accesoVisualizacionAnuncios() {
		return "/admin/adminVisualizacionAnuncios";
	}
	
	@GetMapping("admin/adminVisualizacionAlumnos")
	public String accesoVisualizacionAlumnos() {
		return "admin/adminVisualizacionAlumnos";
	}
	
	@GetMapping("admin/adminVisualizacionEmpresas")
	public String accesoVisualizacionEmpresas() {
		return "admin/adminVisualizacionEmpresas";
	}
	
	@GetMapping("admin/adminVisualizacionPerfilAlumno")
	public String accesoVisualizacionPerfilAlumno() {
		return "admin/adminVisualizacionPerfilAlumno";
	}
	
	@GetMapping("admin/adminVisualizacionPerfilAnuncio")
	public String accesoVisualizacionPerfilAnuncio() {
		return "admin/adminVisualizacionPerfilAnuncio";
	}
	
	

}
