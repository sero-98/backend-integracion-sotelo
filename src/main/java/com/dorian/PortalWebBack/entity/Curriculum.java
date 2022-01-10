package com.dorian.PortalWebBack.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Curriculum {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
		
	public String direccion;
	
	public String email;
	
	public String formacion;
	
	public String experiencia;
	
	public String habilidades;
	
	public String idiomas;

	public Curriculum() {
		
	}

	public Curriculum(String direccion, String email, String formacion, String experiencia, String habilidades,
			String idiomas) {
		super();
		this.direccion = direccion;
		this.email = email;
		this.formacion = formacion;
		this.experiencia = experiencia;
		this.habilidades = habilidades;
		this.idiomas = idiomas;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFormacion() {
		return formacion;
	}

	public void setFormacion(String formacion) {
		this.formacion = formacion;
	}

	public String getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(String experiencia) {
		this.experiencia = experiencia;
	}

	public String getHabilidades() {
		return habilidades;
	}

	public void setHabilidades(String habilidades) {
		this.habilidades = habilidades;
	}

	public String getIdiomas() {
		return idiomas;
	}

	public void setIdiomas(String idiomas) {
		this.idiomas = idiomas;
	}
	
	
}

