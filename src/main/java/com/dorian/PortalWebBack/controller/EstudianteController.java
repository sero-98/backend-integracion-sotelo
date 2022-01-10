package com.dorian.PortalWebBack.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dorian.PortalWebBack.dto.EstudianteDto;
import com.dorian.PortalWebBack.dto.Mensaje;
import com.dorian.PortalWebBack.dto.UsuarioDto;
import com.dorian.PortalWebBack.entity.Curriculum;
import com.dorian.PortalWebBack.entity.Estudiante;
import com.dorian.PortalWebBack.entity.Usuario;
import com.dorian.PortalWebBack.services.EstudianteService;
import com.dorian.PortalWebBack.services.UsuarioService;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST})
@RequestMapping("/api")
public class EstudianteController {

	@Autowired
	private EstudianteService estudiantesService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/estudiantes")
	public ResponseEntity<List<Estudiante>> getEstudiantes(){
		
		return new ResponseEntity<List<Estudiante>>(this.estudiantesService.getTodosLosEstudiantes(), HttpStatus.OK);
	}
	
	@GetMapping("/estudiantes/{elId}")
	public ResponseEntity<?> getUsuario(@PathVariable int elId){
		
		Optional<Estudiante> elEstudiante = this.estudiantesService.getEstudiantePorId(elId);
		
		if(elEstudiante.isEmpty()) {
			
			return new ResponseEntity<>(new Mensaje("Estudiante no encontrado en la BBDD"), HttpStatus.NOT_FOUND);
			
		}
		
		return new ResponseEntity<>(elEstudiante.get(), HttpStatus.OK);
	}
	
	@PostMapping("/estudianteInfo")
	public ResponseEntity<?> getEmpresaSegunUsuario(@RequestBody UsuarioDto usuariodto){
		
		if(this.usuarioService.getUsuario(usuariodto.getId()).isEmpty() || usuariodto == null) {
			return new ResponseEntity<>(new Mensaje("Estudiante no encontrado en la BBDD"), HttpStatus.NOT_FOUND);
		}
		
		Estudiante elEstudiante = this.estudiantesService.getEstudiantePorUsuario(this.usuarioService.getUsuario(usuariodto.getId()).get());
		
		if(elEstudiante == null) {
			
			return new ResponseEntity<>(new Mensaje("Estudiante no encontrado en la BBDD"), HttpStatus.NOT_FOUND);
			
		}
		
		return new ResponseEntity<>(elEstudiante,HttpStatus.OK);
	}
	
	@PostMapping("/estudiantes")
	public ResponseEntity<?> guardarEstudiante(@RequestBody EstudianteDto estudianteDto){
		
		if(this.usuarioService.ExisteUsuarioSegunCorreo(estudianteDto.getCorreo())) {
			
			return new ResponseEntity<>(new Mensaje("Nombre de correo repetido"), HttpStatus.BAD_REQUEST);
		}
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		System.out.println(estudianteDto);
		
		// GUARDADO EN AMBAS TABLAS
		Usuario elUsuario = new Usuario(estudianteDto.getCorreo(), passwordEncoder.encode(estudianteDto.getContrasenia()), "ESTUDIANTE");
		
		Estudiante elEstudiante = new Estudiante(estudianteDto.getNombre(), estudianteDto.getApellido());
		
		elEstudiante.setUsuario(elUsuario);
			
		this.estudiantesService.guardarEstudiante(elEstudiante);
		
		return new ResponseEntity<>(new Mensaje("Estudiante guardado en la BBDD"), HttpStatus.OK);
	}
	
	@PostMapping("/curriculum/{id}")
	public ResponseEntity<?> actualizarCurriculum(@PathVariable int id, @RequestBody Curriculum elCurriculum){
			
		Optional<Estudiante> elEstudiante = this.estudiantesService.getEstudiantePorId(id);
		
		if(elEstudiante.isEmpty()) {
			
			return new ResponseEntity<>(new Mensaje("Estudiante no encontrado en la BBDD"), HttpStatus.NOT_FOUND);
			
		}
		
		Curriculum curriculum = new Curriculum(elCurriculum.getDireccion(),
												 elCurriculum.getEmail(), 
												 elCurriculum.getFormacion(),
												 elCurriculum.getExperiencia(),
												 elCurriculum.getHabilidades(),
												 elCurriculum.getIdiomas());
		
		elEstudiante.get().setCurriculum(curriculum);
		
		this.estudiantesService.guardarEstudiante(elEstudiante.get());
		
		return new ResponseEntity<>(elEstudiante.get(), HttpStatus.OK);
		
	}
}
