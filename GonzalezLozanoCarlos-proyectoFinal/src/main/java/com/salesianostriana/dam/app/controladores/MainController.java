package com.salesianostriana.dam.app.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.app.entidades.Alumno;
import com.salesianostriana.dam.app.entidades.Empresa;
import com.salesianostriana.dam.app.entidades.Usuario;
import com.salesianostriana.dam.app.servicios.AlumnoServicio;
import com.salesianostriana.dam.app.servicios.AnuncioServicio;
import com.salesianostriana.dam.app.servicios.EmpresaServicio;
import com.salesianostriana.dam.app.servicios.UsuarioServicio;

@Controller
public class MainController {
	
	@Autowired
	private AlumnoServicio alumnoServicio;	
	
	@Autowired
	private EmpresaServicio empresaServicio;
	
	@Autowired
	private AnuncioServicio anuncioServicio;
	
	@Autowired
	private UsuarioServicio usuarioServicio;
	
	@GetMapping("/login")
	public String mostrarPaginaLogin(){
		return "/paginaFormularioLogin";
	}
	
	@GetMapping("/")
	public String mostrarPaginaLogin2(){
		return "/paginaFormularioLogin";
	}
	
//	@GetMapping("/registroAlumno")
//	public String mostrarRegistroAlumno() {
//		return "/paginaFormularioRegistroAlumno";
//	}
	
//	@GetMapping("/registroEmpresa")
//	public String mostrarRegistroEmpresa() {
//		return "/paginaFormularioRegistroEmpresa";
//	}
	
	
	//Registro Alumno----------------------------------------------------------------------------
	@GetMapping("/registroAlumno")
	public String  accesoRegistroAlumno(Model model) {
		Usuario al=new Alumno();
		model.addAttribute("alumnoForm", al);
		return "paginaFormularioRegistroAlumno";
	}
	
	@PostMapping("/addAlumno")
	public String procesarFormularioAlumno(@ModelAttribute("alumnoForm")Alumno alumno, Model model,BCryptPasswordEncoder passwordEncoder  ) {
//		alumno.setContrasenya(passwordEncoder.encode(alumno.getContrasenya()));
		usuarioServicio.save(alumno, passwordEncoder);
		return "/paginaFormularioLogin";
	}
	
	//---------------------------------------------------------------------------------------------
	
	//Registro Empresa----------------------------------------------------------------------------
	@GetMapping("/registroEmpresa")
	public String accederRegistrEmpresa(Model model) {
		Usuario emp=new Empresa();
		model.addAttribute("empresaForm", emp);
		return "/paginaFormularioRegistroEmpresa";
	}
	
	@PostMapping("/addEmpresa")
	public String procesarFormularioEmpresa(@ModelAttribute Empresa empresa, Model model, BCryptPasswordEncoder passwordEncoder) {
//		empresa.setContrasenya(passwordEncoder.encode(empresa.getContrasenya()));
		usuarioServicio.save(empresa, passwordEncoder);
		return "/paginaFormularioLogin";
	}
	
	
	
	

}
