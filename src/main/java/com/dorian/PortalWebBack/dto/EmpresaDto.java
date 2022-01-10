package com.dorian.PortalWebBack.dto;

public class EmpresaDto {

	public String NombreDeEmpresa;
	
	public String Locacion;
    
	public long RUC;
    
	public String SitioWeb;
    
	public String Descripcion;
    
	public String Correo;
    
	public String Contrasenia;
    
	public EmpresaDto() {
    	
    }

	public String getNombreDeEmpresa() {
		return this.NombreDeEmpresa;
	}

	public void setNombreDeEmpresa(String nombreDeEmpresa) {
		this.NombreDeEmpresa = nombreDeEmpresa;
	}

	public String getLocacion() {
		return this.Locacion;
	}

	public void setLocacion(String locacion) {
		this.Locacion = locacion;
	}

	public long getRUC() {
		return this.RUC;
	}

	public void setRUC(long rUC) {
		this.RUC = rUC;
	}

	public String getSitioWeb() {
		return this.SitioWeb;
	}

	public void setSitioWeb(String sitioWeb) {
		this.SitioWeb = sitioWeb;
	}

	public String getDescripcion() {
		return this.Descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.Descripcion = descripcion;
	}

	public String getCorreo() {
		return this.Correo;
	}

	public void setCorreo(String correo) {
		this.Correo = correo;
	}

	public String getContrasenia() {
		return Contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		Contrasenia = contrasenia;
	}
    
    
    
}
