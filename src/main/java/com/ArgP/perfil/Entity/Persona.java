package com.ArgP.perfil.Entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Persona {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
    @Size(min = 1, max = 50, message = "no cumple con la longitud")
    private String nombre;
    
	 
	@NotNull
	@Size(min = 1, max = 50, message = "no cumple con la longitud")
    private String apellido;
	
	
	private String titulo;
	
	 @Size(min = 1, max = 50, message = "no cumple con la longitud")   
	 private String imgPerfil;
	 
	 
	 @OneToMany(fetch = FetchType.LAZY,mappedBy ="idEdu")
	 private List<Educacion> educacionList;
	 
	 @OneToMany(fetch = FetchType.LAZY,mappedBy ="idExpe")
	 private List<Experiencia> experienciaList;
	 
	 
	 @OneToMany(fetch = FetchType.LAZY,mappedBy ="idproy")
	 private List<Proyecto> proyectoList;
	 
	 @OneToMany(fetch = FetchType.LAZY,mappedBy ="idSkill")
	 private List<Skill> skillList;
	 
	 
	 public  Persona() {
		 
	 }
	 
	 
	

	public Persona(Long id, String nombre,
			       String apellido, String titulo,
		           String imgPerfil) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.titulo = titulo;
		this.imgPerfil = imgPerfil;
	}



	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getImgPerfil() {
		return imgPerfil;
	}

	public void setImgPerfil(String imgPerfil) {
		this.imgPerfil = imgPerfil;
	}
	 
	 
}
