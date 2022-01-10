package com.dorian.PortalWebBack.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dorian.PortalWebBack.entity.Empresa;
import com.dorian.PortalWebBack.entity.OfertaEmpresa;

@Repository
public interface OfertaEmpresaRepository extends JpaRepository<OfertaEmpresa, Integer> {

	public List<OfertaEmpresa> getByEmpresa(Empresa empresa);
}
