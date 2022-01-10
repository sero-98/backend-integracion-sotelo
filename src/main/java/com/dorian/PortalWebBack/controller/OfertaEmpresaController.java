package com.dorian.PortalWebBack.controller;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dorian.PortalWebBack.dto.CredencialesDto;
import com.dorian.PortalWebBack.dto.EliminarOfertaDto;
import com.dorian.PortalWebBack.dto.Mensaje;
import com.dorian.PortalWebBack.dto.OfertaEmpresaDto;
import com.dorian.PortalWebBack.entity.Empresa;
import com.dorian.PortalWebBack.entity.OfertaEmpresa;
import com.dorian.PortalWebBack.services.EmpresaService;
import com.dorian.PortalWebBack.services.OfertaEmpresaService;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})
@RequestMapping("/api")
public class OfertaEmpresaController {
	
	@Autowired
	public OfertaEmpresaService ofertaEmpresaService;
	
	@Autowired
	private EmpresaService empresaService;
	
	@GetMapping("/ofertasTotales")
	public ResponseEntity<List<OfertaEmpresa>> obtenerOfertas(){
		
		return new ResponseEntity<List<OfertaEmpresa>>(this.ofertaEmpresaService.obtenerTodasLasOfertas(), HttpStatus.OK);
	}
	
	@PostMapping("/ofertasSegunEmpresa")
	public ResponseEntity<?> obtenerOfertasPorEmpresa(@RequestBody CredencialesDto credencialesDto){
		
		Optional<Empresa> empresa = empresaService.getEmpresaPorId(credencialesDto.getId());
		
		if(empresa.isEmpty()) {
			return new ResponseEntity<>(new Mensaje("Empresa no encontrada en la BBDD"), HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(this.ofertaEmpresaService.obtenerSegunEmpresa(empresa.get()) , HttpStatus.OK);
	}
	

	@PostMapping("/ofertasEmpresa")
	public ResponseEntity<?> guardarOfertaDeEmpresa(@RequestBody OfertaEmpresaDto ofertaEmpresaDto){

		Optional<Empresa> empresa = this.empresaService.getEmpresaPorId(ofertaEmpresaDto.getIdEmpresa());
		
		if(empresa.isEmpty()) {
			return new ResponseEntity<>(new Mensaje("Empresa no encontrada en la BBDD"), HttpStatus.NOT_FOUND);
		}
		
		OfertaEmpresa laOfertaEmpresa = new OfertaEmpresa(ofertaEmpresaDto.getDescripcion(),
											ofertaEmpresaDto.getJornada(),
											ofertaEmpresaDto.getSalario(),
											Calendar.getInstance(),
											ofertaEmpresaDto.getRequisitos(),
											ofertaEmpresaDto.getBeneficios(),
											ofertaEmpresaDto.getArea());
		
		laOfertaEmpresa.setEmpresa(empresa.get());
		
		laOfertaEmpresa.setId(0); //Nueva oferta
		
		this.ofertaEmpresaService.guardarOActualizarOferta(laOfertaEmpresa);
		
		return new ResponseEntity<>(new Mensaje("Oferta guardada en la BBDD"), HttpStatus.OK);
		
	}
	
	@DeleteMapping("/ofertasEmpresa")
	public ResponseEntity<?> eliminarDeEmpresa(@RequestBody EliminarOfertaDto EliminarOfertaDto){

		Optional<Empresa> empresa = this.empresaService.getEmpresaPorId(EliminarOfertaDto.getIdEmpresa());
		
		if(empresa.isEmpty()) {
			return new ResponseEntity<>(new Mensaje("Empresa no encontrada en la BBDD"), HttpStatus.NOT_FOUND);
		}

		if(!this.ofertaEmpresaService.existeOferta(EliminarOfertaDto.getIdOferta())) {
			return new ResponseEntity<>(new Mensaje("Oferta no encontrada en la BBDD"), HttpStatus.NOT_FOUND);
		}
		
		this.ofertaEmpresaService.eliminarOferta(EliminarOfertaDto.getIdOferta());
		
		return new ResponseEntity<>(new Mensaje("Registro eliminado correctamente"), HttpStatus.OK);
		
	}

}
