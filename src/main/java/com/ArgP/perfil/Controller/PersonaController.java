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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ArgP.perfil.Entity.Persona;
import com.ArgP.perfil.Service.PersonaService;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {

	@Autowired
	PersonaService personaService;
	
    @GetMapping("/traer")
    public List<Persona> getPersona(){
        return personaService.getPersona();
    }
	 
    
    @GetMapping("/traer/perfil")
    public Persona findPersona(){
        return personaService.findPersona((long)1);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public String createPersona(@RequestBody Persona persona){
        personaService.savePersona(persona);
        return "La persona fue creada correctamente";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/eliminar/{id}")
    public String deletePersona(@PathVariable Long id){
    	personaService.deletePersona(id);
        return "La persona fue eliminada correctamente";
    }
    
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/editar/{id}")
    public Persona editPersona(@PathVariable Long id,
                               @RequestParam("nombre") String nuevoNombre,
                               @RequestParam("apellido") String nuevoApellido,
                               @RequestParam("titulo") String nuevoTitulo,
                               @RequestParam("imgPerfil") String nuevoImg){
        Persona persona = personaService.findPersona(id);
        
        persona.setNombre(nuevoNombre);
        persona.setApellido(nuevoApellido);
        persona.setTitulo(nuevoTitulo);
        persona.setImgPerfil(nuevoImg);
        
        personaService.savePersona(persona);
        return persona;
    }
    
    
    //**Otra forma de hacerlo**//
  /*  Necesito q solo traiga el usuario del perfil
   * 
    @GetMapping("/id/{id}")
    public ResponseEntity<Persona> obtenerPersona(@PathVariable ("id")Long id){
    	Persona persona = personaService.findPersona(id);
    	return new ResponseEntity<>(persona,HttpStatus.OK);
    }
    
   // editar el perfil
    @PutMapping("/editar")
    public ResponseEntity<Persona> editarPersona(@RequestBody Persona persona){
    	Persona editarPersona =personaService.editarPersona(persona);
    	return new ResponseEntity<>(editarPersona,HttpStatus.OK);
    	
    }*/
    
}
