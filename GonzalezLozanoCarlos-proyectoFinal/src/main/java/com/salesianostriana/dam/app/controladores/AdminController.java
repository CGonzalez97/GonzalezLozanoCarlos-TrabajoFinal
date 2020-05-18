package com.salesianostriana.dam.app.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
	
	@GetMapping("/admin/adminVisualizacionAnuncios")
	public String accesoVisualizacionAnuncios() {
		return "/admin/adminVisualizacionAnuncios";
	}

}
