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

import com.ArgP.perfil.Entity.Experiencia;
import com.ArgP.perfil.Service.ExperienciaService;

@RestController
@RequestMapping("/experiencia")
@CrossOrigin(origins = "http://localhost:4200")
public class ExperienciaController {

	@Autowired
	ExperienciaService experienciaService;
	
	@GetMapping("/id/{id}")
	public ResponseEntity<Experiencia> obtenerExperiencia(@PathVariable("id") Long id){
		Experiencia experiencia=experienciaService.findExperiencia(id);
		return new ResponseEntity<>(experiencia,HttpStatus.OK);
	}
	
	@GetMapping("/listarExperiencia")
	public ResponseEntity<List<Experiencia>>ObtenerExperiencia(){
		List<Experiencia>experiencias=experienciaService.traerListaExperiencia();
		return new ResponseEntity<>(experiencias,HttpStatus.OK);
	};
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/agregar")
	public ResponseEntity<Experiencia>agregarExperiencia(@RequestBody Experiencia experiencia){
     Experiencia nuevaExperiencia=experienciaService.AddExperiencia(experiencia);
		return new ResponseEntity<>(nuevaExperiencia,HttpStatus.CREATED);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/eliminar/{id}")
	//el response lleva signo de pregunta porque no devuelve nada
	public ResponseEntity<?>eliminarEducacion(@PathVariable ("id") Long id){
		    experienciaService.borrarExperiencia(id);
		    return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/editar")
	public ResponseEntity<Experiencia>editarExperiencia(@RequestBody Experiencia experiencia){
		Experiencia editarExperiencia=experienciaService.editarExperiencia(experiencia);
		return new ResponseEntity<>(editarExperiencia,HttpStatus.OK);
	}
	
	

}
