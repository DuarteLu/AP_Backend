package com.ArgP.perfil.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ArgP.perfil.Entity.Persona;
import com.ArgP.perfil.Exception.UserNotFoundException;
import com.ArgP.perfil.Repository.IPersonaRepository;

@Service
@Transactional
public class PersonaService {
	
	@Autowired
	IPersonaRepository personaRepository;

	 //Traer una lista de personas
    public List<Persona> getPersona(){
    	 List<Persona> personas = personaRepository.findAll();
    	 return personas;
    }
    
    //Guardar un objeto de tipo Persona
    public void savePersona(Persona persona) {
    	personaRepository.save(persona);
    }
    
    //Eliminar un objeto pero lo buscamos por ID
    public void deletePersona(Long id) {
    	personaRepository.deleteById(id);
    }
    
    /*Buscar una persona por ID
    public Persona findPersona(Long id) {
    	 return  personaRepository.findById(id).orElseThrow(()-> new UserNotFoundException("Usuario No encontrado"));
    	 
    }*/
    
    public Persona findPersona(Long id) {
        Persona persona = personaRepository.findById(id).orElse(null);
        return persona;
    }
    
    public Persona editarPersona(Persona usu) {
		return personaRepository.save(usu);
	}
}
