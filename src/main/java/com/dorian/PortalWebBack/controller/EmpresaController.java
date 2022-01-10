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

import com.dorian.PortalWebBack.dto.EmpresaDto;
import com.dorian.PortalWebBack.dto.Mensaje;
import com.dorian.PortalWebBack.dto.UsuarioDto;
import com.dorian.PortalWebBack.entity.Empresa;
import com.dorian.PortalWebBack.entity.Usuario;
import com.dorian.PortalWebBack.services.EmpresaService;
import com.dorian.PortalWebBack.services.UsuarioService;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST})
@RequestMapping("/api")
public class EmpresaController {


	@Autowired
	private EmpresaService empresaService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/empresas")
	public ResponseEntity<List<Empresa>> getEstudiantes(){
		
		return new ResponseEntity<List<Empresa>>(this.empresaService.getTodosLasEmpresas(), HttpStatus.OK);
	}
	
	@GetMapping("/empresas/{elId}")
	public ResponseEntity<?> getUsuario(@PathVariable int elId){
		
		Optional<Empresa> laEmpresa = this.empresaService.getEmpresaPorId(elId);
		
		if(laEmpresa.isEmpty()) {
			
			return new ResponseEntity<>(new Mensaje("Empresa no encontrada en la BBDD"), HttpStatus.NOT_FOUND);
			
		}
		
		return new ResponseEntity<>(laEmpresa.get(), HttpStatus.OK);
	}
	
	@PostMapping("/empresaInfo")
	public ResponseEntity<?> getEmpresaSegunUsuario(@RequestBody UsuarioDto usuariodto){
		
		if(usuariodto == null) {
			return new ResponseEntity<>(new Mensaje("Empresa no encontrada en la BBDD"), HttpStatus.BAD_REQUEST);
		}
		
		if(usuarioService.getUsuario(usuariodto.getId()).isEmpty()) {
			return new ResponseEntity<>(new Mensaje("Empresa no encontrada en la BBDD"), HttpStatus.NOT_FOUND);
		}
		
		Empresa laEmpresa = this.empresaService.getEmpresaPorUsuario(usuarioService.getUsuario(usuariodto.getId()).get());
		
		if(laEmpresa == null) {
			
			return new ResponseEntity<>(new Mensaje("Empresa no encontrada en la BBDD"), HttpStatus.NOT_FOUND);
			
		}
		
		return new ResponseEntity<>(laEmpresa,HttpStatus.OK);
	}
	
	@PostMapping("/empresas")
	public ResponseEntity<?> guardarEstudiante(@RequestBody EmpresaDto empresaDto){
		
		if(this.usuarioService.ExisteUsuarioSegunCorreo(empresaDto.getCorreo())) {
			return new ResponseEntity<>(new Mensaje("Nombre de correo repetido"), HttpStatus.BAD_REQUEST);
		}
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		// GUARDADO EN AMBAS TABLAS
		Usuario elUsuario = new Usuario(empresaDto.getCorreo(), passwordEncoder.encode(empresaDto.getContrasenia()), "EMPRESA");
		
		Empresa laEmpresa = new Empresa(empresaDto.getNombreDeEmpresa(),
										empresaDto.getLocacion(),
										empresaDto.getRUC(),
										empresaDto.getSitioWeb(),
										empresaDto.getDescripcion());
		
		laEmpresa.setUsuario(elUsuario);
			
		this.empresaService.guardarEmpresa(laEmpresa);
		
		return new ResponseEntity<>(new Mensaje("Empresa guardada en la BBDD"), HttpStatus.OK);
	}
	
}
