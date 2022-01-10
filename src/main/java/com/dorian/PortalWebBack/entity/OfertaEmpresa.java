package com.dorian.PortalWebBack.entity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class OfertaEmpresa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
    @JoinColumn(name="fk_empresa")
    private Empresa empresa;
	
	@ManyToMany(mappedBy = "ofertasEmpresa")
    @JsonIgnoreProperties("ofertasEmpresa")
	private List<Estudiante> estudiantes;
	
	private String descripcion;
	
	private String jornada;
	
	private String salario;
	
	private Calendar fecha;
	
	private String requisitos;
	
	private String beneficios;
	
	private String area;
	
	public OfertaEmpresa() {
		
	}

	public OfertaEmpresa(String descripcion, String jornada, String salario, Calendar fecha, String requisitos,
			String beneficios, String area) {
		super();
		this.descripcion = descripcion;
		this.jornada = jornada;
		this.salario = salario;
		this.fecha = fecha;
		this.requisitos = requisitos;
		this.beneficios = beneficios;
		this.area = area;
	}

	public void setEstudiante(Estudiante estudiante) {
		if(this.estudiantes == null) {
			this.estudiantes = new ArrayList();
		}
		
		this.estudiantes.add(estudiante);
	}
	
	
	public List<Estudiante> getEstudiantes(){
		return this.estudiantes;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getJornada() {
		return jornada;
	}

	public void setJornada(String jornada) {
		this.jornada = jornada;
	}

	public String getSalario() {
		return salario;
	}

	public void setSalario(String salario) {
		this.salario = salario;
	}

	public Calendar getFecha() {
		return fecha;
	}

	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}

	public String getRequisitos() {
		return requisitos;
	}

	public void setRequisitos(String requisitos) {
		this.requisitos = requisitos;
	}

	public String getBeneficios() {
		return beneficios;
	}

	public void setBeneficios(String beneficios) {
		this.beneficios = beneficios;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
}
