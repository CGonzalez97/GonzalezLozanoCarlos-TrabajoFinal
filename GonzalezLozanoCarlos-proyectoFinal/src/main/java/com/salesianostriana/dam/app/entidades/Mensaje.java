package com.salesianostriana.dam.app.entidades;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @ NoArgsConstructor
public class Mensaje {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String contenido;
	private LocalDate fechaEnvio;
	
	@ManyToOne
	private Usuario remitente;
	
	@ManyToOne
	private Usuario destinatario;
	
	
	
//	private Usuario remitente; -->@ManyToOne
//	
//	private Usuario destinatario -->@ManyToOne

}
