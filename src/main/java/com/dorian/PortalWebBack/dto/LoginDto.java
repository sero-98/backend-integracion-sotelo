package com.dorian.PortalWebBack.dto;

public class LoginDto {

	public String Correo;
	
	public String Contrasenia;

	public LoginDto(String correo, String contrasenia) {
		Correo = correo;
		Contrasenia = contrasenia;
	}

	public String getCorreo() {
		return this.Correo;
	}

	public void setCorreo(String correo) {
		this.Correo = correo;
	}

	public String getContrasenia() {
		return this.Contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.Contrasenia = contrasenia;
	}
}
