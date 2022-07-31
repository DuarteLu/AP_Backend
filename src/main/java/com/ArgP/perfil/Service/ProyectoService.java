package com.ArgP.perfil.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ArgP.perfil.Entity.Proyecto;
import com.ArgP.perfil.Repository.IProyectoRepository;

@Service
@Transactional
public class ProyectoService {
	
	@Autowired
	IProyectoRepository proyectoRepository;

	
	 //agregar
	 public Proyecto AddProyecto(Proyecto proyecto){
		 return proyectoRepository.save(proyecto);
	 }

    //listar
	  public List<Proyecto> traerListaProyecto(){
	        return proyectoRepository.findAll();
	    }
	  
	  //eliminar
	  public void borrarProyecto(Long id){
		  proyectoRepository.deleteById(id);
	    }
	  
	  //editar
	  public Proyecto editarProyecto(Proyecto proyecto) {
		  return proyectoRepository.save(proyecto);
	  }
	  
	  //buscar por id
	  public Proyecto findProyecto(Long id) {
		  Proyecto proyecto =proyectoRepository.findById(id).orElse(null);
	        return proyecto;
	    }
}
