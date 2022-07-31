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

import com.ArgP.perfil.Entity.Skill;
import com.ArgP.perfil.Service.SkillService;

@RestController
@RequestMapping("/skill")
@CrossOrigin(origins = "http://localhost:4200")
public class SkillController {
	
	@Autowired
	SkillService skillService;
	
	@GetMapping("/id/{id}")
	public ResponseEntity<Skill> obtenerSkill(@PathVariable("id") Long id){
		Skill skill =skillService.findSkill(id);
		return new ResponseEntity<>(skill,HttpStatus.OK);
	}
	
	@GetMapping("/listarSkill")
	public ResponseEntity<List<Skill>>ListarSkill(){
		List<Skill>skills=skillService.traerListaSkill();
		return new ResponseEntity<>(skills,HttpStatus.OK);
	};
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/agregar")
	public ResponseEntity<Skill> agregarSkill(@RequestBody Skill skill){
		Skill habilidad =skillService.AddSkill(skill);
		return new ResponseEntity<>(habilidad,HttpStatus.CREATED);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/eliminar/{id}")
	//el response lleva signo de pregunta porque no devuelve nada
	public ResponseEntity<?>eliminarSkill(@PathVariable ("id") Long id){
		skillService.borrarSkill(id);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/editar")
	public ResponseEntity<Skill>editarSkill(@RequestBody Skill skill){
		Skill editarSkill =skillService.editarSkill(skill);
		return new ResponseEntity<>(editarSkill,HttpStatus.OK);
	}

}
