package com.salesianostriana.dam.app.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.salesianostriana.dam.app.entidades.Anuncio;
import com.salesianostriana.dam.app.servicios.AlumnoServicio;
import com.salesianostriana.dam.app.servicios.AnuncioServicio;
import com.salesianostriana.dam.app.servicios.EmpresaServicio;

@Controller
public class AdminController {
	
	@Autowired
	private AlumnoServicio alumnoServicio;	
	
	@Autowired
	private EmpresaServicio empresaServicio;
	
	@Autowired
	private AnuncioServicio anuncioServicio;
	
	
	
	@GetMapping("/admin/adminVisualizacionAnuncios")
	public String accesoVisualizacionAnuncios(Model model) {
		model.addAttribute("anuncios", anuncioServicio.findAll());
		return "/admin/adminVisualizacionAnuncios";
	}
	
	@GetMapping("admin/adminVisualizacionAlumnos")
	public String accesoVisualizacionAlumnos(Model model) {
		model.addAttribute("alumnos",alumnoServicio.findAll());
		return "admin/adminVisualizacionAlumnos";
	}
	
	@GetMapping("admin/adminVisualizacionEmpresas")
	public String accesoVisualizacionEmpresas(Model model) {
		model.addAttribute("empresas", empresaServicio.findAll());
		return "admin/adminVisualizacionEmpresas";
	}
	
	@GetMapping("admin/adminVisualizacionPerfilAlumno")
	public String accesoVisualizacionPerfilAlumno() {
		return "admin/adminVisualizacionPerfilAlumno";
	}
	
	
//	Método para acceder al perfil de un anuncio seleccionado en la página de visualización de Anuncios
	@GetMapping("/admin/adminVisualizacionPerfilAnuncio/{id}")
	public String accesoVisualizacionPerfilAnuncio(Model model, @PathVariable Long id) {
		Anuncio anuncioSelect=anuncioServicio.findById(id);
		model.addAttribute("anuncio", anuncioSelect);
		return "admin/adminVisualizacionPerfilAnuncio";
	}
	
	
	
	

}