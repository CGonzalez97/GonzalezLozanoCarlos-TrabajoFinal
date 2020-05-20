package com.salesianostriana.dam.app.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.salesianostriana.dam.app.entidades.Alumno;
import com.salesianostriana.dam.app.entidades.Anuncio;
import com.salesianostriana.dam.app.entidades.Empresa;
import com.salesianostriana.dam.app.servicios.AlumnoServicio;
import com.salesianostriana.dam.app.servicios.AnuncioServicio;
import com.salesianostriana.dam.app.servicios.EmpresaServicio;
import com.salesianostriana.dam.app.servicios.UsuarioServicio;

@Controller
public class AlumnoController {
	
	@Autowired
	private AlumnoServicio alumnoServicio;	
	
	@Autowired
	private EmpresaServicio empresaServicio;
	
	@Autowired
	private AnuncioServicio anuncioServicio;
	
	@Autowired
	private UsuarioServicio usuarioServicio;
	
	
	
//	@GetMapping("/alumno/alumnoVisualizacionPerfilAlumno")
//	public String accesoPerfilAlumno() {
//		return "/alumno/alumnoVisualizacionPerfilAlumno";
//	}
	
	@GetMapping("/alumno/alumnoVisualizacionPerfilAlumno")
	public String accesoPerfilAlumno(@AuthenticationPrincipal Alumno alumno, Model model) {
		model.addAttribute("alumno", alumno);
		return "/alumno/alumnoVisualizacionPerfilAlumno";
	}
	
	
	@GetMapping("/alumno/alumnoVisualizacionAnuncios")
	public String accesoVisualizacionAnuncios(Model model) {
		model.addAttribute("anuncios", anuncioServicio.findAll());
		return "alumno/alumnoVisualizacionAnuncios";
	}
	
//	@GetMapping("/alumno/alumnoVisualizacionEmpresas")
//	public String accesoVisualizacionEmpresas() {
//		return "/alumno/alumnoVisualizacionEmpresas";
//	}
	
	@GetMapping("/alumno/alumnoVisualizacionEmpresas")
	public String accesoVisualizacionEmpresas(Model model) {
		model.addAttribute("empresas", empresaServicio.findAll());
		return "alumno/alumnoVisualizacionEmpresas";
	}
	
	@GetMapping("/alumno/alumnoVisualizacionMensajes")
	public String accesoVisualizacionMensajes() {
		return "/alumno/alumnoVisualizacionMensajes";
	}
	
	
	
	@GetMapping("/alumno/alumnoVisualizacionPerfilEmpresa/{id}")
	public String accesoPerfilEmpresa(Model model, @PathVariable Long id) {
		Empresa emp=empresaServicio.findById(id);
		model.addAttribute("empresa", emp);
		return "alumno/alumnoVisualizacionPerfilEmpresa";
	}
	
	@GetMapping("/alumno/alumnoVisualizacionPerfilAnuncio/{id}")
	public String accesoVisualizacionPerfilAnuncio(Model model, @PathVariable Long id) {
		Anuncio an=anuncioServicio.findById(id);
		model.addAttribute("anuncio", an);
		return "alumno/alumnoVisualizacionPerfilAnuncio";
	}
	
	
	
	

}
