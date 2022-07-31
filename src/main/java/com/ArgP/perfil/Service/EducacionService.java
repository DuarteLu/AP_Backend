package com.ArgP.perfil.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ArgP.perfil.Entity.Educacion;
import com.ArgP.perfil.Entity.Persona;
import com.ArgP.perfil.Repository.IEducacionRepository;

@Service
@Transactional
public class EducacionService {
	
	@Autowired
	 IEducacionRepository educacionRepository;
	
	//agrega una nueva educacion
	 public Educacion AddEducacion(Educacion educacion){
		 return educacionRepository.save(educacion);
	 }
 
	 //nos trae la lista de educacion
	  public List<Educacion> traerListaEducacion(){
	        return educacionRepository.findAll();
	    }
	  
	  public void borrarEducacion(Long id){
	       educacionRepository.deleteById(id);
	    }
	  
	  public Educacion editarEducacion(Educacion educacion) {
		  return educacionRepository.save(educacion);
	  }
	  
	  public Educacion findEducacion(Long id) {
		  Educacion educacion=educacionRepository.findById(id).orElse(null);
	        return educacion;
	    }
	    
	  
	   /*edita una educacion
		 public void saveEducacion(Educacion educacion){
			  educacionRepository.save(educacion);
		 }*/
	   /*public boolean existsById(Long id){
	        return educacionRepository.existsById(id);
	    }
	    
	   public boolean existsByTituloEdu(String tituloEdu){
	        return educacionRepository.existsByTituloEdu(tituloEdu);
	    }*/
	 
	 
}
