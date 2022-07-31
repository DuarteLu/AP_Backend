package com.ArgP.perfil.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ArgP.perfil.Entity.AcercaDe;
import com.ArgP.perfil.Entity.Experiencia;
import com.ArgP.perfil.Repository.IAcercaDeRepository;

@Service
@Transactional
public class AcercaDeService {
	
	@Autowired
	IAcercaDeRepository  acercaDeRepository;
	//solo vamos a necesitar que se muestre y que se edite. Pero igual 
	//dejamos las funciones para el crud completo
	
	
	  //editar
	  public AcercaDe editarAcercaDe(AcercaDe acercaDe) {
		  return acercaDeRepository.save(acercaDe);
	  }

   //listar
	  public List<AcercaDe> traerListaAcercaDe(){
	        return acercaDeRepository.findAll();
	    }
	    
	  //agregar
		 public AcercaDe AddAcercaDe(AcercaDe acercaDe){
			 return acercaDeRepository.save(acercaDe);	 }
	  //eliminar
	  public void borrarAcercaDe(Long id){
		  acercaDeRepository.deleteById(id);
	    }
	  
	
	  //buscar por id
	  public AcercaDe findAcercaDe(Long id) {
		  AcercaDe acercaDe=acercaDeRepository.findById(id).orElse(null);
	        return acercaDe;
	    }

}
