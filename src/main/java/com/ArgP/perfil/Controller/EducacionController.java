package com.ArgP.perfil.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ArgP.perfil.Entity.Educacion;
import com.ArgP.perfil.Service.EducacionService;

@RestController
@RequestMapping("/educacion")
@CrossOrigin(origins = "http://localhost:4200")
public class EducacionController {

	@Autowired
	EducacionService educacionService ;
	
	@GetMapping("/id/{id}")
	public ResponseEntity<Educacion> obtenerEducacion(@PathVariable("id") Long id){
		Educacion educacion=educacionService.findEducacion(id);
		return new ResponseEntity<>(educacion,HttpStatus.OK);
	}
	
	@GetMapping("/listarEducacion")
	public ResponseEntity<List<Educacion>>ObtenerEducacion(){
		List<Educacion>educaciones=educacionService.traerListaEducacion();
		return new ResponseEntity<>(educaciones,HttpStatus.OK);
	};
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/agregar")
	public ResponseEntity<Educacion> agregarEducacion(@RequestBody Educacion educacion){
		Educacion nuevaEducacion=educacionService.AddEducacion(educacion);
		return new ResponseEntity<>(nuevaEducacion,HttpStatus.CREATED);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/eliminar/{id}")
	//el response lleva signo de pregunta porque no devuelve nada
	public ResponseEntity<?>eliminarEducacion(@PathVariable ("id") Long id){
		educacionService.borrarEducacion(id);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/editar")
	public ResponseEntity<Educacion>editarEducacion(@RequestBody Educacion educacion){
		Educacion editarEducacion=educacionService.editarEducacion(educacion);
		return new ResponseEntity<>(editarEducacion,HttpStatus.OK);
	}
	
	
}


