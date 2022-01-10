package com.dorian.PortalWebBack.entity;

import javax.persistence.*;

@Entity
public class Empresa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 2500)
	public String nombreDeEmpresa;
	
    public String locacion;
    
    public long RUC;
    
    public String sitioWeb;
    
    public String descripcion;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_usuario", referencedColumnName = "id")
    public Usuario usuario;
        
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_pago_empresa", referencedColumnName = "id")
    public PagoEmpresa pagoEmpresa;
    
    public Empresa() {
    	
    }

	public Empresa(String nombreDeEmpresa, String locacion, long rUC, String sitioWeb, String descripcion) {
		this.nombreDeEmpresa = nombreDeEmpresa;
		this.locacion = locacion;
		this.RUC = rUC;
		this.sitioWeb = sitioWeb;
		this.descripcion = descripcion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombreDeEmpresa() {
		return nombreDeEmpresa;
	}

	public void setNombreDeEmpresa(String nombreDeEmpresa) {
		this.nombreDeEmpresa = nombreDeEmpresa;
	}

	public String getLocacion() {
		return locacion;
	}

	public void setLocacion(String locacion) {
		this.locacion = locacion;
	}

	public long getRUC() {
		return RUC;
	}

	public void setRUC(long rUC) {
		this.RUC = rUC;
	}

	public String getSitioWeb() {
		return sitioWeb;
	}

	public void setSitioWeb(String sitioWeb) {
		this.sitioWeb = sitioWeb;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public PagoEmpresa getPagoEmpresa() {
		return pagoEmpresa;
	}

	public void setPagoEmpresa(PagoEmpresa pagoEmpresa) {
		this.pagoEmpresa = pagoEmpresa;
	}
    
}
