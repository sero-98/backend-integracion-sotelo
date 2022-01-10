package com.dorian.PortalWebBack.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String correo;
	
	private String contrasenia;
	
	private String tipo;

	public Usuario() {
		
	}
	
	public Usuario(String correo, String contrasenia, String tipo) {
		this.correo = correo;
		this.contrasenia = contrasenia;
		this.tipo = tipo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", correo=" + correo + ", contrasenia=" + contrasenia + ", tipo=" + tipo + "]";
	}

	
	
}
