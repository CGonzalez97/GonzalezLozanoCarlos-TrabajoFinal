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
import com.salesianostriana.dam.app.entidades.Anuncio;
import com.salesianostriana.dam.app.entidades.Empresa;
import com.salesianostriana.dam.app.entidades.Mensaje;
import com.salesianostriana.dam.app.entidades.Usuario;
import com.salesianostriana.dam.app.servicios.AlumnoServicio;
import com.salesianostriana.dam.app.servicios.AnuncioServicio;
import com.salesianostriana.dam.app.servicios.EmpresaServicio;
import com.salesianostriana.dam.app.servicios.MensajeServicio;
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
	
	@Autowired
	private MensajeServicio mensajeServicio;
	
	
	
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
	
	
	@GetMapping("/alumno/alumnoVisualizacionEmpresas")
	public String accesoVisualizacionEmpresas(Model model) {
		model.addAttribute("empresas", empresaServicio.findAll());
		return "alumno/alumnoVisualizacionEmpresas";
	}
	

	
	
	//AccederPerfilEmpresa
	@GetMapping("/alumno/alumnoVisualizacionPerfilEmpresa/{id}")
	public String accesoPerfilEmpresa(Model model, @PathVariable Long id) {
		Empresa emp=empresaServicio.findById(id);
		Mensaje men=new Mensaje();
		model.addAttribute("empresa", emp);
		model.addAttribute("mensajeForm", men);
		return "alumno/alumnoVisualizacionPerfilEmpresa";
	}
	
	@GetMapping("/alumno/alumnoVisualizacionPerfilAnuncio/{id}")
	public String accesoVisualizacionPerfilAnuncio(Model model, @PathVariable Long id) {
		Anuncio an=anuncioServicio.findById(id);
		model.addAttribute("anuncio", an);
		return "alumno/alumnoVisualizacionPerfilAnuncio";
	}
	//Eliminar perfil propio
	@GetMapping("/alumno/alumnoEliminarAlumno/{id}")
	public String alumnoEliminarPerfilPropio(Model model,  @PathVariable Long id) {
		usuarioServicio.deleteById(id);
		return "/paginaFormularioLogin";
		
	}
	
	//----------------------------------------------------------
	//Modificar perfil
	@GetMapping("/alumno/alumnoModificarPerfil")
	public String  accesoEdicionAlumno(Model model, @AuthenticationPrincipal Alumno alumno) {		
		model.addAttribute("alumnoForm", alumno);
		
		return "/alumno/alumnoModificarPerfil";
	}
	
	@PostMapping("/alumno/alumnoEditPerfil")
	public String procesarAlumnoModificarPerfil( @AuthenticationPrincipal Alumno al, @ModelAttribute("alumnoForm")Alumno alumno, Model model,BCryptPasswordEncoder passwordEncoder  ) {

		
		alumnoServicio.editar(alumno, al, passwordEncoder);
		alumnoServicio.edit(al);
		
		return accesoPerfilAlumno(al ,  model)/*"alumnoVisualizacionPerfilAlumno"*/;
	}
	
	
	//AccesoVisualizacionMensajes
	@GetMapping("/alumno/alumnoVisualizacionMensajes")
	public String accesoVisualizacionMensajes(Model model, @AuthenticationPrincipal Usuario alumno) {
		model.addAttribute("mensajes", usuarioServicio.findById(alumno.getId()).getRecibidos());
		model.addAttribute("enviados", usuarioServicio.findById(alumno.getId()).getEnviados());
		return "/alumno/alumnoVisualizacionMensajes";
	}
	
	//AccesovisualizacionPerfilMensaje
	
	@GetMapping("/alumno/alumnoVisualizacionPerfilMensaje/{id}")
	public String alumnoAccederPerfilMensaje(Model model, @PathVariable Long id) {
		model.addAttribute("mensaje", mensajeServicio.findById(id));
		Mensaje men=new Mensaje();
		model.addAttribute("mensajeForm", men);
		return "/alumno/alumnoVisualizacionPerfilMensaje";
	}
	
	@GetMapping("/alumno/alumnoVisualizacionPerfilMensajeEnviado/{id}")
	public String alumnoAccederPerfilMensajeEnviado(Model model, @PathVariable Long id) {
		model.addAttribute("mensaje", mensajeServicio.findById(id));
		return "/alumno/alumnoVisualizacionPerfilMensajeEnviado";
	}

	
	
	//MandarMensajeDesdePerfilEmpresa
	@PostMapping("/alumno/alumnoMandarMensajeDesdePerfil/{id}")
	public String mandarMensajeDesdePerfil( @ModelAttribute("mensajeForm")Mensaje mensaje , @AuthenticationPrincipal Usuario alumno, Model model, @PathVariable Long id) {
		Mensaje men=new Mensaje();
		mensajeServicio.setearMensaje(alumno, usuarioServicio.findById(id), men, mensaje);
		usuarioServicio.edit(alumno);
		usuarioServicio.edit(usuarioServicio.findById(id));
		return accesoPerfilEmpresa( model,   id);
	}
	
	//MandarMensajeDesdeOtro
	
	@PostMapping("/alumno/alumnoMandarMensajeDesdeMensaje/{id}")
	public String mandarMensajeDesdeMensaje(Model model, @ModelAttribute("mensajeForm")Mensaje mensaje, @AuthenticationPrincipal Usuario alumno, @PathVariable Long id) {
		Mensaje men=new Mensaje();
		mensajeServicio.setearMensaje(alumno, usuarioServicio.findById(id), men, mensaje);
		usuarioServicio.edit(alumno);
		usuarioServicio.edit(usuarioServicio.findById(id));
		return  alumnoAccederPerfilMensajeEnviado( model,   men.getId());//-----------
	}
	
	

	
	
	
	

}
