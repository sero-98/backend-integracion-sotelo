package com.dorian.PortalWebBack.dto;

public class PostularDto {

	public int idOfertaEmpresa;
	
	public int idEstudiante;

	public PostularDto(int idOfertaEmpresa, int idEstudiante) {
		super();
		this.idOfertaEmpresa = idOfertaEmpresa;
		this.idEstudiante = idEstudiante;
	}

	public int getIdOfertaEmpresa() {
		return idOfertaEmpresa;
	}

	public void setIdOfertaEmpresa(int idOfertaEmpresa) {
		this.idOfertaEmpresa = idOfertaEmpresa;
	}

	public int getIdEstudiante() {
		return idEstudiante;
	}

	public void setIdEstudiante(int idEstudiante) {
		this.idEstudiante = idEstudiante;
	}
	
	
	
}
