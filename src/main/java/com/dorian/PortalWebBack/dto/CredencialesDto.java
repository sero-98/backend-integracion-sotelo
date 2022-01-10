package com.dorian.PortalWebBack.dto;

public class CredencialesDto {

	public int id;
	
	public String Correo;
	
	private String Contrasenia;

	public CredencialesDto(int id, String correo, String contrasenia) {
		this.id = id;
		Correo = correo;
		Contrasenia = contrasenia;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCorreo() {
		return Correo;
	}

	public void setCorreo(String correo) {
		Correo = correo;
	}

	public String getContrasenia() {
		return Contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		Contrasenia = contrasenia;
	}
	
}
