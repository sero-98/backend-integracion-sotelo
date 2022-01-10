package com.dorian.PortalWebBack.dto;

public class UsuarioDto {
	
	public int id;
	
	public String correo;
	
	public String contrasenia;
	
	public String tipo;

	public UsuarioDto(int id, String correo, String contrasenia, String tipo) {
		super();
		this.id = id;
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
	
}
