package com.dorian.PortalWebBack.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dorian.PortalWebBack.entity.Estudiante;
import com.dorian.PortalWebBack.entity.Usuario;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Integer> {

	public Estudiante findByUsuario(Usuario usuario);
}
