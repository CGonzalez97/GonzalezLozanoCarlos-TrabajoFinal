package com.salesianostriana.dam.app.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AlumnoController {
	
	@GetMapping("/alumno/alumnoVisualizacionPerfilAlumno")
	public String accesoPerfilAlumno() {
		return "/alumno/alumnoVisualizacionPerfilAlumno";
	}
	
	@GetMapping("/alumno/alumnoVisualizacionAnuncios")
	public String accesoVisualizacionAnuncios() {
		return "/alumno/alumnoVisualizacionAnuncios";
	}
	
	@GetMapping("/alumno/alumnoVisualizacionEmpresas")
	public String accesoVisualizacionEmpresas() {
		return "/alumno/alumnoVisualizacionEmpresas";
	}
	
	@GetMapping("/alumno/alumnoVisualizacionMensajes")
	public String accesoVisualizacionMensajes() {
		return "/alumno/alumnoVisualizacionMensajes";
	}
	
	

}
