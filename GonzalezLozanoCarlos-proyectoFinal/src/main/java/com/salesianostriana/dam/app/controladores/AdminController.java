package com.salesianostriana.dam.app.controladores;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.app.entidades.Administrador;
import com.salesianostriana.dam.app.entidades.Alumno;
import com.salesianostriana.dam.app.entidades.Anuncio;
import com.salesianostriana.dam.app.entidades.Empresa;
import com.salesianostriana.dam.app.entidades.Mensaje;
import com.salesianostriana.dam.app.entidades.Usuario;
import com.salesianostriana.dam.app.servicios.AlumnoServicio;
import com.salesianostriana.dam.app.servicios.AministradorServicio;
import com.salesianostriana.dam.app.servicios.AnuncioServicio;
import com.salesianostriana.dam.app.servicios.EmpresaServicio;
import com.salesianostriana.dam.app.servicios.UsuarioServicio;

@Controller
public class AdminController {
	
	@Autowired
	private AlumnoServicio alumnoServicio;	
	
	@Autowired
	private EmpresaServicio empresaServicio;
	
	@Autowired
	private AnuncioServicio anuncioServicio;
	
	@Autowired
	private UsuarioServicio usuarioServicio;
	
	@Autowired
	private AministradorServicio administradorServicio;
	
	
	
	
	
	@GetMapping("/admin/adminVisualizacionAnuncios")
	public String accesoVisualizacionAnuncios(Model model) {
		model.addAttribute("anuncios", anuncioServicio.findAll());
		return "/admin/adminVisualizacionAnuncios";
	}
	
	@GetMapping("/admin/adminVisualizacionAlumnos")
	public String accesoVisualizacionAlumnos(Model model) {
		model.addAttribute("alumnos",alumnoServicio.findAll());
		return "admin/adminVisualizacionAlumnos";
	}
	
	@GetMapping("/admin/adminVisualizacionEmpresas")
	public String accesoVisualizacionEmpresas(Model model) {
		model.addAttribute("empresas", empresaServicio.findAll());
		return "admin/adminVisualizacionEmpresas";
	}
	
	@GetMapping("/admin/visualizacionPerfilAlumno/{id}")
	public String accesoVisualizacionPerfilAlumno(Model model, @PathVariable Long id) {
		Alumno al= alumnoServicio.findById(id);
		model.addAttribute("alumno", al);
		return "admin/adminVisualizacionPerfilAlumno";
	}
	
	
//	Método para acceder al perfil de un anuncio seleccionado en la página de visualización de Anuncios
	@GetMapping("/admin/adminVisualizacionPerfilAnuncio/{id}")
	public String accesoVisualizacionPerfilAnuncio(Model model, @PathVariable Long id) {
		Anuncio anuncioSelect=anuncioServicio.findById(id);
		model.addAttribute("anuncio", anuncioSelect);
		return "admin/adminVisualizacionPerfilAnuncio";
	}
	
	@GetMapping("/admin/visualizacionPerfilEmpresa/{id}")
	public String accesoVisualizacionPerfilEmpresa(Model model, @PathVariable Long id) {
		Empresa emp=empresaServicio.findById(id);
		model.addAttribute("empresa", emp);
		return "admin/adminVisualizacionPerfilEmpresa";
	}
	
	//Creación anuncios
	@GetMapping("/admin/adminAddAnuncio")
	public String accesoAddAnuncio(Model model) {
		Anuncio anun=new Anuncio();
		model.addAttribute("anuncioForm", anun);
		return "admin/adminAddAnuncio";
	}
	
	@PostMapping("/admin/adminAddAnuncio")
	public String procesamientoAddAnuncio(@ModelAttribute("anuncioForm") Anuncio anuncio, Model model, @AuthenticationPrincipal Usuario admin) {
		((Administrador)admin).addAnuncio(anuncio);
		anuncioServicio.save(anuncio);
		return accesoVisualizacionAnuncios(model)/*"/admin/adminVisualizacionAnuncios"*/;
	}
	
	//Creacion Alumno
	
	@GetMapping("/admin/adminAddAlumno")
	public String adminAddAlumno(Model model) {
		Usuario alum=new Alumno();
		model.addAttribute("alumnoForm", alum);
		return "admin/adminAddAlumno";
	}
	
	@PostMapping("/admin/adminAddAlumno")
	public String procesarAddAlumno(@ModelAttribute("alumnoForm") Alumno alumno,Model model, BCryptPasswordEncoder passwordEncoder) {
//		alumno.setContrasenya(passwordEncoder.encode(alumno.getContrasenya()));
		alumno.setRecibidos(new ArrayList<Mensaje>());
		alumno.setEnviados(new ArrayList<Mensaje>());
		usuarioServicio.save(alumno,passwordEncoder);
		return accesoVisualizacionAlumnos( model);
	}
	
	
	//Creacion Empresa
	
	@GetMapping("/admin/adminAddEmpresa")
	public String adminAddEmpresa(Model model) {
		Usuario emp=new Empresa();
		model.addAttribute("empresaForm", emp);
		return "/admin/adminAddEmpresa";
	}
	
	@PostMapping("/admin/adminAddEmpresa")
	public String procesarAdminAddEmpresa(Model model, @ModelAttribute("empresaForm") Empresa empresa, BCryptPasswordEncoder passwordEncoder) {
//		empresa.setContrasenya(passwordEncoder.encode(empresa.getContrasenya()));
		empresa.setRecibidos(new ArrayList<Mensaje>());
		empresa.setEnviados(new ArrayList<Mensaje>());
		usuarioServicio.save(empresa,passwordEncoder);
		return accesoVisualizacionEmpresas( model);
	}
	
	
	//Método para borrar anuncio
	@GetMapping("/admin/adminEliminarAnuncio/{id}")
	public String adminEliminarAnuncio(Model model, @PathVariable Long id, @AuthenticationPrincipal Administrador admin) {
		Anuncio anun=anuncioServicio.findById(id);
//		admin.removeAnuncio(anun);
		anuncioServicio.delete(anun);
		return accesoVisualizacionAnuncios(model);
	}
	
	//Método para borrar Alumno
	@GetMapping("/admin/adminEliminarAlumno/{id}")
	public String adminEliminarAlumno(Model model, @PathVariable Long id) {
//		Usuario alum=usuarioServicio.findById(id);
		usuarioServicio.deleteById(id);
		return accesoVisualizacionAlumnos(model);
	}
	
	//Método para borra Empresa
	@GetMapping("/admin/adminEliminarEmpresa/{id}")
	public String adminEliminarempresa(Model model, @PathVariable Long id) {
//		Usuario emp=usuarioServicio.findById(id);
		usuarioServicio.deleteById(id);
		return accesoVisualizacionEmpresas(model);
	}
	
	//----------------------------------------------------------------------------------------------------
	//Modificar anuncio
	@GetMapping("/admin/adminModificarAnuncio/{id}")
	public String accesoModificarAnuncio(Model model, @PathVariable Long id) {
//		Anuncio anun=new Anuncio();
//		anun=anuncioServicio.findById(id);
		model.addAttribute("anuncioForm", anuncioServicio.findById(id));
		return "/admin/adminModificarAnuncio";
	}
	
	@PostMapping("/admin/adminModificarAnuncio/{id}")
	public String procesarModificarAnuncio(@ModelAttribute("anuncioForm")Anuncio anuncio, Model model, @PathVariable Long id) {
		
		administradorServicio.editarAnuncio(anuncio, anuncioServicio.findById(anuncio.getId()));
		anuncioServicio.edit(anuncioServicio.findById(anuncio.getId()));
		return accesoVisualizacionPerfilAnuncio( model, id);
	}
	
	//--------------------------------------------------------------------------------------------------------
	//Modificar alumno
	@GetMapping("/admin/adminModificarAlumno/{id}")
	public String accederModificaralumno(Model model, @PathVariable Long id) {
		model.addAttribute("alumnoForm", usuarioServicio.findById(id));
		return "/admin/adminModificarAlumno";
		
	}
	
	@PostMapping("/admin/adminModificarAlumno/{id}")
	public String procesarModificarAlumno(@ModelAttribute("alumnoForm")Alumno alumno, Model  model, @PathVariable Long id, BCryptPasswordEncoder passwordEncoder) {
		administradorServicio.editarAlumno(alumno, alumnoServicio.findById(id), passwordEncoder);
		usuarioServicio.edit(alumnoServicio.findById(id));
		return accesoVisualizacionPerfilAlumno( model,   id);
	}
	
	//------------------------------------------------------------------------------------------------------
	//modifica empresa
	@GetMapping("/admin/adminModificarEmpresa/{id}")
	public String accesoModificarEmpresa(Model model, @PathVariable Long id) {
		model.addAttribute("empresaForm", usuarioServicio.findById(id));
		return "/admin/adminModificarEmpresa";
		
	}
	
	@PostMapping("/admin/adminModificarEmpresa/{id}")
	public String procesarModificarEmpresa(@ModelAttribute("empresaForm")Empresa empresa, @PathVariable Long id, Model model, BCryptPasswordEncoder passwordEncoder) {
		administradorServicio.editarEmpresa(empresa, empresaServicio.findById(id), passwordEncoder);
		usuarioServicio.edit(empresaServicio.findById(id));
		
		return accesoVisualizacionPerfilEmpresa( model,   id);
	}
	
	
	
	
	
	

}
