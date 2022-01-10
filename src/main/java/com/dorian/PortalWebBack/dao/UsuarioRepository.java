package com.dorian.PortalWebBack.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dorian.PortalWebBack.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	public boolean existsByCorreo(String correo);
	
	public Optional<Usuario> getByCorreo(String correo);
}
