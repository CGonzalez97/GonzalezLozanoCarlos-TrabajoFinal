package com.salesianostriana.dam.app.entidades;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity @Data @NoArgsConstructor
public class Anuncio {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate fechaEvento;
	private String titulo;
	private String descripcion;
	
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToOne
	private Administrador administrador;

	public Anuncio(LocalDate fechaEvento, String titulo, String descripcion, Administrador administrador) {
		super();
		this.fechaEvento = fechaEvento;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.administrador = administrador;
	}
	
	
	
	
	
	
	

}
