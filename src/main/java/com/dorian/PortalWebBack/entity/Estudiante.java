package com.dorian.PortalWebBack.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Estudiante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	public String nombre;
	
	public String apellido;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_usuario", referencedColumnName = "id")
	public Usuario usuario;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_curriculum", referencedColumnName = "id")
	public Curriculum curriculum;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_suscripcion", referencedColumnName = "id")
	public Suscripcion suscripcion;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "oferta_empresa_estudiante", 
    joinColumns = @JoinColumn(name = "estudiante_id", referencedColumnName = "id"), 
    inverseJoinColumns = @JoinColumn(name = "oferta_empresa_id", referencedColumnName = "id"))
    @JsonIgnoreProperties("estudiantes")
	private List<OfertaEmpresa> ofertasEmpresa;
	
	
	public Estudiante() {
		
	}

	public Estudiante(String nombre, String apellido) {
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public void setOfertaEmpresa(OfertaEmpresa ofertaEmpresa) {
		if(this.ofertasEmpresa == null) {
			this.ofertasEmpresa = new ArrayList();
		}
		
		this.ofertasEmpresa.add(ofertaEmpresa);
	}
	
	public List<OfertaEmpresa> getOfertasEmpresa(){
		return this.ofertasEmpresa;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Curriculum getCurriculum() {
		return curriculum;
	}

	public void setCurriculum(Curriculum curriculum) {
		this.curriculum = curriculum;
	}

	public Suscripcion getSuscripcion() {
		return suscripcion;
	}

	public void setSuscripcion(Suscripcion suscripcion) {
		this.suscripcion = suscripcion;
	}
	
	
}