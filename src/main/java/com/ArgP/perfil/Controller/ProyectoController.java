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

import com.ArgP.perfil.Entity.Proyecto;
import com.ArgP.perfil.Service.ProyectoService;

@RestController
@RequestMapping("/proyecto")
@CrossOrigin(origins = "http://localhost:4200")
public class ProyectoController {
	
	
	@Autowired
	ProyectoService proyectoService;
	
	@GetMapping("/id/{id}")
	public ResponseEntity<Proyecto> obtenerProyecto(@PathVariable("id") Long id){
		Proyecto proyecto = proyectoService.findProyecto(id);
		return new ResponseEntity<>(proyecto,HttpStatus.OK);
	}
	
	@GetMapping("/listarProyecto")
	public ResponseEntity<List<Proyecto>>ObtenerProyecto(){
		List<Proyecto>proyectos=proyectoService.traerListaProyecto();
		return new ResponseEntity<>(proyectos,HttpStatus.OK);
	};
	
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/agregar")
	public ResponseEntity<Proyecto>agregarProyecto(@RequestBody Proyecto proyecto){
     Proyecto nuevaProyecto=proyectoService.AddProyecto(proyecto);
		return new ResponseEntity<>(nuevaProyecto,HttpStatus.CREATED);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/eliminar/{id}")
	//el response lleva signo de pregunta porque no devuelve nada
	public ResponseEntity<?>eliminarProyecto(@PathVariable ("id") Long id){
		proyectoService.borrarProyecto(id);
		    return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/editar")
	public ResponseEntity<Proyecto>editarProyecto(@RequestBody Proyecto proyecto){
		Proyecto editarProyecto=proyectoService.editarProyecto(proyecto);
		return new ResponseEntity<>(editarProyecto,HttpStatus.OK);
	}
	

}
