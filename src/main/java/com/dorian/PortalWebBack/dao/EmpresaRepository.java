package com.dorian.PortalWebBack.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dorian.PortalWebBack.entity.Empresa;
import com.dorian.PortalWebBack.entity.Usuario;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {

	public Empresa findByUsuario(Usuario usuario);

}
