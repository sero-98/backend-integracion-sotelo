package com.dorian.PortalWebBack.dto;

import java.util.Calendar;

public class OfertaEmpresaDto {
	
	public int IdEmpresa;
	
	public String Descripcion;
	
	public String Jornada;
	
	public String Salario;
	
	public Calendar Fecha;
	
	public String Requisitos;
	
	public String Beneficios;
	
	public String Area;

	public OfertaEmpresaDto(int idEmpresa, String descripcion, String jornada, String salario, Calendar fecha,
			String requisitos, String beneficios, String area) {
		super();
		IdEmpresa = idEmpresa;
		Descripcion = descripcion;
		Jornada = jornada;
		Salario = salario;
		Fecha = fecha;
		Requisitos = requisitos;
		Beneficios = beneficios;
		Area = area;
	}

	public int getIdEmpresa() {
		return IdEmpresa;
	}

	public void setIdEmpresa(int idEmpresa) {
		IdEmpresa = idEmpresa;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public String getJornada() {
		return Jornada;
	}

	public void setJornada(String jornada) {
		Jornada = jornada;
	}

	public String getSalario() {
		return Salario;
	}

	public void setSalario(String salario) {
		Salario = salario;
	}

	public Calendar getFecha() {
		return Fecha;
	}

	public void setFecha(Calendar fecha) {
		Fecha = fecha;
	}

	public String getRequisitos() {
		return Requisitos;
	}

	public void setRequisitos(String requisitos) {
		Requisitos = requisitos;
	}

	public String getBeneficios() {
		return Beneficios;
	}

	public void setBeneficios(String beneficios) {
		Beneficios = beneficios;
	}

	public String getArea() {
		return Area;
	}

	public void setArea(String area) {
		Area = area;
	}
	
}
