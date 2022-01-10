package com.dorian.PortalWebBack.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dorian.PortalWebBack.dao.UsuarioRepository;
import com.dorian.PortalWebBack.entity.Usuario;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public List<Usuario> getUsuarios(){
		
		return this.usuarioRepository.findAll();
		
	}
	
	
	public void saveUsuario(Usuario elUsuario) {
		
		this.usuarioRepository.save(elUsuario); 
		
	}
	
	
	public Optional<Usuario> getUsuario(int elId) {
		
		return this.usuarioRepository.findById(elId);
		
	}
	
	public boolean ExisteUsuarioSegunCorreo(String correo) {
		
		return this.usuarioRepository.existsByCorreo(correo);
	}
	
	public Optional<Usuario> getUsuarioSegunCorreo(String correo) {
		
		return this.usuarioRepository.getByCorreo(correo);
	}
}
