package com.ArgP.perfil.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ArgP.perfil.Entity.Experiencia;
import com.ArgP.perfil.Repository.IExperienciaRepository;

@Service
@Transactional
public class ExperienciaService {

	@Autowired
	IExperienciaRepository experienciaRepository;
	
	
         //agregar
		 public Experiencia AddExperiencia(Experiencia experiencia){
			 return experienciaRepository.save(experiencia);
		 }
	 
	    //listar
		  public List<Experiencia> traerListaExperiencia(){
		        return experienciaRepository.findAll();
		    }
		  
		  //eliminar
		  public void borrarExperiencia(Long id){
	        	experienciaRepository.deleteById(id);
		    }
		  
		  //editar
		  public Experiencia editarExperiencia(Experiencia experiencia) {
			  return experienciaRepository.save(experiencia);
		  }
		  
		  //buscar por id
		  public Experiencia findExperiencia(Long id) {
			  Experiencia experiencia=experienciaRepository.findById(id).orElse(null);
		        return experiencia;
		    }
}
