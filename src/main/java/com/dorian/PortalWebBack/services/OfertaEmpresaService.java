package com.dorian.PortalWebBack.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dorian.PortalWebBack.dao.OfertaEmpresaRepository;
import com.dorian.PortalWebBack.entity.Empresa;
import com.dorian.PortalWebBack.entity.OfertaEmpresa;

@Service
public class OfertaEmpresaService {

	@Autowired
	private OfertaEmpresaRepository ofertaEmpresaRepository;
	
	public List<OfertaEmpresa> obtenerTodasLasOfertas(){
		
		return this.ofertaEmpresaRepository.findAll();
	}
	
	public Optional<OfertaEmpresa> obtenerOfertaPorId(int id) {
		return this.ofertaEmpresaRepository.findById(id);
	}
	
	public List<OfertaEmpresa> obtenerSegunEmpresa(Empresa empresa){
		
		return this.ofertaEmpresaRepository.getByEmpresa(empresa);
	}
	
	public void guardarOActualizarOferta(OfertaEmpresa ofertaEmpresa) {
		
		this.ofertaEmpresaRepository.save(ofertaEmpresa);
	}
	
	public void eliminarOferta(int elId) {
		
		this.ofertaEmpresaRepository.deleteById(elId);
	}
	
	public boolean existeOferta(int elId) {
		
		return this.ofertaEmpresaRepository.existsById(elId);
	}
	
}
