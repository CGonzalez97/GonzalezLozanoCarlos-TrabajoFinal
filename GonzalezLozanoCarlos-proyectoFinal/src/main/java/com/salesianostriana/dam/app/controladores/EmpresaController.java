package com.salesianostriana.dam.app.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.app.entidades.Alumno;
import com.salesianostriana.dam.app.entidades.Empresa;
import com.salesianostriana.dam.app.servicios.AlumnoServicio;
import com.salesianostriana.dam.app.servicios.AnuncioServicio;
import com.salesianostriana.dam.app.servicios.EmpresaServicio;
import com.salesianostriana.dam.app.servicios.UsuarioServicio;

@Controller
public class EmpresaController {
	
	@Autowired
	private AlumnoServicio alumnoServicio;	
	
	@Autowired
	private EmpresaServicio empresaServicio;
	
	@Autowired
	private AnuncioServicio anuncioServicio;
	
	@Autowired
	private UsuarioServicio usuarioServicio;
	
//	@GetMapping("/empresa/empresaVisualizacionAlumnos")
//	public String accesoVisualizacionAlumnos() {
//		return "/empresa/empresaVisualizacionAlumnos";
//	}
	
	@GetMapping("/empresa/empresaVisualizacionAlumnos")
	public String accesoVisualizacionAlumnos(Model model) {
		model.addAttribute("alumnos", alumnoServicio.findAll());
		return "empresa/empresaVisualizacionAlumnos";
	}
	
	
	@GetMapping("/empresa/empresaVisualizacionMensajes")
	public String accesoVisualizacionMensajes() {
		return "/empresa/empresaVisualizacionMensajes";
	}
	
//	@GetMapping("/empresa/empresaVisualizacionPerfilEmpresa")
//	public String accesoVisualizacionPerfilEmpresa() {
//		return "/empresa/empresaVisualizacionPerfilEmpresa";
//	}
	@GetMapping("/empresa/empresaVisualizacionPerfilEmpresa")
	public String accesoVisualizacionPerfilEmpresa(@AuthenticationPrincipal Empresa empresa, Model model) {
		model.addAttribute("empresa", empresa);
		return "/empresa/empresaVisualizacionPerfilEmpresa";
	}
	
	
	@GetMapping("/empresa/empresaVisualizacionPerfilAlumno/{id}")
	public String accesoVisualizacionPerfilAlumno(Model model, @PathVariable Long id) {
		Alumno al=alumnoServicio.findById(id);
		model.addAttribute("alumno", al);
		return "empresa/empresaVisualizacionPerfilAlumno";
	}
	
	@GetMapping("/empresa/empresaEliminarEmpresa/{id}")
	public String eliminarPerfilEmpresaPropio(Model model, @PathVariable Long id) {
		usuarioServicio.deleteById(id);
		return "/paginaFormularioLogin";
		
	}
	
	
//	//----------------------------------------------------------
//	//Modificar perfil
//	@GetMapping("/alumno/alumnoModificarPerfil")
//	public String  accesoRegistroAlumno(Model model, @AuthenticationPrincipal Alumno alumno) {		
//		model.addAttribute("alumnoForm", alumno);
//		
//		return "/alumno/alumnoModificarPerfil";
//	}
//	
//	@PostMapping("/alumno/alumnoEditPerfil")
//	public String procesarAlumnoModificarPerfil( @AuthenticationPrincipal Alumno al, @ModelAttribute("alumnoForm")Alumno alumno, Model model,BCryptPasswordEncoder passwordEncoder  ) {
//
//		
//		alumnoServicio.editar(alumno, al, passwordEncoder);
//		alumnoServicio.edit(al);
//		
//		return accesoPerfilAlumno(al ,  model)/*"alumnoVisualizacionPerfilAlumno"*/;
//	}
	
	//ModificarPerfil
	@GetMapping("/empresa/empresaModificarPerfil")
	public String accesoModificarPerfil(Model model, @AuthenticationPrincipal Empresa empresa) {
		model.addAttribute("empresaForm", empresa);
		return "/empresa/empresaModificarPerfil";	
	}
	
	@PostMapping("/empresa/empresaModificarPerfil")
	public String procesarModificarPerfil(@AuthenticationPrincipal Empresa empresa,Model model, @ModelAttribute("empresaForm") Empresa emp, BCryptPasswordEncoder passwordEncoder) {
		empresaServicio.editar(emp, empresa, passwordEncoder);
		empresaServicio.edit(empresa);
		return accesoVisualizacionPerfilEmpresa( empresa,  model);
	}
		
	
	
	
	
	
	
	
	
	
	
	

}
