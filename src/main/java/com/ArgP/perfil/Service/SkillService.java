package com.ArgP.perfil.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ArgP.perfil.Entity.Skill;
import com.ArgP.perfil.Repository.ISkillRepository;

@Service
@Transactional
public class SkillService {
	
	@Autowired
	ISkillRepository skillRepository;

	
	  //agregar
	 public Skill AddSkill(Skill skill){
		 return skillRepository.save(skill);
	 }

   //listar
	  public List<Skill> traerListaSkill(){
	        return skillRepository.findAll();
	    }
	  
	  //eliminar
	  public void borrarSkill(Long id){
		  skillRepository.deleteById(id);
	    }
	  
	  //editar
	  public Skill editarSkill(Skill skill) {
		  return skillRepository.save(skill);
	  }
	  
	  //buscar por id
	  public Skill findSkill(Long id) {
		  Skill skill =skillRepository.findById(id).orElse(null);
	        return skill;
	    }
}
