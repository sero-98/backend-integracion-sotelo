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
import org.springframework.web.bind.annotation.RestController;

import com.dorian.PortalWebBack.dto.LoginDto;
import com.dorian.PortalWebBack.dto.Mensaje;
import com.dorian.PortalWebBack.entity.Usuario;
import com.dorian.PortalWebBack.services.UsuarioService;

import org.springframework.web.bind.annotation.RequestMethod;


@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping("/api")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/usuarios")
	public ResponseEntity<List<Usuario>> getUsuarios(){
		
		return new ResponseEntity<List<Usuario>>(usuarioService.getUsuarios(), HttpStatus.OK);
		
	}
	
	
	@GetMapping("/usuarios/{elId}")
	public ResponseEntity<?> getUsuario(@PathVariable int elId){
		
		Optional<Usuario> elUsuario = usuarioService.getUsuario(elId);
		
		if(elUsuario.isEmpty()) {
			
			return new ResponseEntity<>(new Mensaje("Usuario no encontrado en la BBDD"), HttpStatus.NOT_FOUND);
			
		}
		
		return new ResponseEntity<>(elUsuario.get(), HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> Login(@RequestBody LoginDto loginDto){
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

		System.out.println(loginDto.getCorreo());
		System.out.println(loginDto.getContrasenia());
		if(this.usuarioService.getUsuarioSegunCorreo(loginDto.getCorreo()).isEmpty()) {
			return new ResponseEntity<>(new Mensaje("Credenciales incorrectas"), HttpStatus.BAD_REQUEST);
		}
		
		Usuario elUsuario = this.usuarioService.getUsuarioSegunCorreo(loginDto.getCorreo()).get();

		if(!passwordEncoder.matches(loginDto.getContrasenia(), elUsuario.getContrasenia())) {
			
			return new ResponseEntity<>(new Mensaje("Credenciales incorrectas"), HttpStatus.BAD_REQUEST);

		}
		
		return new ResponseEntity<>(elUsuario, HttpStatus.OK);
			
	}
		
	
}
