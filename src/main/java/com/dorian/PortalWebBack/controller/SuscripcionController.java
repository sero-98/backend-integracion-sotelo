package com.dorian.PortalWebBack.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dorian.PortalWebBack.dto.Mensaje;
import com.dorian.PortalWebBack.dto.PostularDto;
import com.dorian.PortalWebBack.entity.Estudiante;
import com.dorian.PortalWebBack.entity.OfertaEmpresa;
import com.dorian.PortalWebBack.services.EstudianteService;
import com.dorian.PortalWebBack.services.OfertaEmpresaService;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})
@RequestMapping("/api")
public class SuscripcionController {

	@Autowired
	public OfertaEmpresaService ofertaEmpresaService;
	
	@Autowired
	private EstudianteService estudiantesService;
	
	@PostMapping("/postularse")
	public ResponseEntity<?> postularse(@RequestBody PostularDto laPostulacion){
		
		Optional<OfertaEmpresa> miOfertaEmpresa = this.ofertaEmpresaService.obtenerOfertaPorId(laPostulacion.getIdOfertaEmpresa());
		
		if(miOfertaEmpresa.isEmpty()) {
			return new ResponseEntity<>(new Mensaje("Oferta no encontrada"), HttpStatus.NOT_FOUND);
		}
		
		Optional<Estudiante> miEstudiante = this.estudiantesService.getEstudiantePorId(laPostulacion.getIdEstudiante());
		
		if(miEstudiante.isEmpty()) {
			return new ResponseEntity<>(new Mensaje("Estudiante no encontrado"), HttpStatus.NOT_FOUND);
		}
		
		miOfertaEmpresa.get().setEstudiante(miEstudiante.get());
		miEstudiante.get().setOfertaEmpresa(miOfertaEmpresa.get());
		
		System.out.println("id estudiante: " + laPostulacion.getIdEstudiante());
		System.out.println("id oferta: " + laPostulacion.getIdOfertaEmpresa());

		
		this.estudiantesService.guardarEstudiante(miEstudiante.get());
		this.ofertaEmpresaService.guardarOActualizarOferta(miOfertaEmpresa.get());

		return new ResponseEntity<>(new Mensaje("Postulacion registrada"), HttpStatus.OK);

	}

}
