package com.salesianostriana.dam.app.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
	
	@GetMapping("/login")
	public String mostrarPaginaLogin(){
		return "/paginaFormularioLogin";
	}
	
	@GetMapping("/")
	public String mostrarPaginaLogin2(){
		return "/paginaFormularioLogin";
	}
	
	@GetMapping("/registroAlumno")
	public String mostrarRegistroAlumno() {
		return "/paginaFormularioRegistroAlumno";
	}
	
	@GetMapping("/registroEmpresa")
	public String mostrarRegistroEmpresa() {
		return "/paginaFormularioRegistroEmpresa";
	}
	
	
	

}
