package com.dorian.PortalWebBack.dto;

public class EstudianteDto {

	public String Nombre;
	
    public String Apellido;
    
    public String Correo;
    
    public String Contrasenia;
    
    public EstudianteDto() {
    	
    }

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String apellido) {
		Apellido = apellido;
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