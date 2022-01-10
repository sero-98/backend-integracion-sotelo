package com.dorian.PortalWebBack.dto;

public class EliminarOfertaDto {

	public int idEmpresa;
	
	public int idOferta;

	public EliminarOfertaDto(int idEmpresa, int idOferta) {
		super();
		this.idEmpresa = idEmpresa;
		this.idOferta = idOferta;
	}

	public int getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public int getIdOferta() {
		return idOferta;
	}

	public void setIdOferta(int idOferta) {
		this.idOferta = idOferta;
	}
	
	
}

