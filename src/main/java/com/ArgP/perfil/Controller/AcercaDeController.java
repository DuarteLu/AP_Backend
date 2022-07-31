package com.ArgP.perfil.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ArgP.perfil.Entity.AcercaDe;
import com.ArgP.perfil.Service.AcercaDeService;

@RestController
@RequestMapping("/AcercaDe")
@CrossOrigin(origins = "http://localhost:4200")
public class AcercaDeController {

	@Autowired
	AcercaDeService acercaDeService;
	
	
	   //mostrar
	   @GetMapping("/id/{id}")
	    public ResponseEntity<AcercaDe> obtenerAcercaDe(@PathVariable ("id")Long id){
	    	AcercaDe acercaDe = acercaDeService.findAcercaDe(id);
	    	return new ResponseEntity<>(acercaDe,HttpStatus.OK);
	    }
	    
	   // editar 
	    @PreAuthorize("hasRole('ADMIN')")
	    @PutMapping("/editar")
	    public ResponseEntity<AcercaDe> editarAcercaDe(@RequestBody AcercaDe acercaDe){
	    	AcercaDe editar =acercaDeService.editarAcercaDe(acercaDe);
	    	return new ResponseEntity<>(editar,HttpStatus.OK);
        }
}
