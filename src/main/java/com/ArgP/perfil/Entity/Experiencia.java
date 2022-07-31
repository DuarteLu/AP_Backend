package com.ArgP.perfil.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Experiencia {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idExpe;
	
	private String nombreExp;
	private String descripcionExp;
	private String ImagenExp;
	
	
	public Experiencia() {
		
	}


	public Experiencia(long idExpe, String nombreExp, String descripcionExp, String imagenExp) {
		super();
		this.idExpe = idExpe;
		this.nombreExp = nombreExp;
		this.descripcionExp = descripcionExp;
		ImagenExp = imagenExp;
	}


	public long getIdExpe() {
		return idExpe;
	}


	public void setIdExpe(long idExpe) {
		this.idExpe = idExpe;
	}


	public String getNombreExp() {
		return nombreExp;
	}


	public void setNombreExp(String nombreExp) {
		this.nombreExp = nombreExp;
	}


	public String getDescripcionExp() {
		return descripcionExp;
	}


	public void setDescripcionExp(String descripcionExp) {
		this.descripcionExp = descripcionExp;
	}


	public String getImagenExp() {
		return ImagenExp;
	}


	public void setImagenExp(String imagenExp) {
		ImagenExp = imagenExp;
	}
	
	

}
