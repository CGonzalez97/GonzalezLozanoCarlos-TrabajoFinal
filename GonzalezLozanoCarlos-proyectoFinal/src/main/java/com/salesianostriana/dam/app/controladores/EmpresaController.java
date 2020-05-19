package com.salesianostriana.dam.app.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmpresaController {
	
	@GetMapping("/empresa/empresaVisualizacionAlumnos")
	public String accesoVisualizacionAlumnos() {
		return "/empresa/empresaVisualizacionAlumnos";
	}
	
	@GetMapping("/empresa/empresaVisualizacionMensajes")
	public String accesoVisualizacionMensajes() {
		return "/empresa/empresaVisualizacionMensajes";
	}
	
	@GetMapping("/empresa/empresaVisualizacionPerfilEmpresa")
	public String accesoVisualizacionPerfilEmpresa() {
		return "/empresa/empresaVisualizacionPerfilEmpresa";
	}

}
