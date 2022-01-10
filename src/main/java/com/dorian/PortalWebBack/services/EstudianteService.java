package com.dorian.PortalWebBack.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dorian.PortalWebBack.dao.EstudianteRepository;
import com.dorian.PortalWebBack.entity.Estudiante;
import com.dorian.PortalWebBack.entity.Usuario;

@Service
public class EstudianteService {

	@Autowired
	private EstudianteRepository estudianteRepository;
	
	public Estudiante getEstudiantePorUsuario(Usuario elUsuario) {
		
		return this.estudianteRepository.findByUsuario(elUsuario);
	}
	
	public Optional<Estudiante> getEstudiantePorId(int elId) {
		
		return this.estudianteRepository.findById(elId);
	}
	
	public List<Estudiante> getTodosLosEstudiantes(){
		
		return this.estudianteRepository.findAll();
	}
	
	public void guardarEstudiante(Estudiante elEstudiante) {
		
		this.estudianteRepository.save(elEstudiante);
	}
}
