package com.ArgP.perfil.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Skill {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idSkill;
	
	private String nombreSkill;
	
	private String porcentaje;
	
	
	public Skill() {
		
	}


	public Skill(long idSkill, String nombreSkill, String porcentaje) {
		super();
		this.idSkill = idSkill;
		this.nombreSkill = nombreSkill;
		this.porcentaje = porcentaje;
	}


	public long getIdSkill() {
		return idSkill;
	}


	public void setIdSkill(long idSkill) {
		this.idSkill = idSkill;
	}


	public String getNombreSkill() {
		return nombreSkill;
	}


	public void setNombreSkill(String nombreSkill) {
		this.nombreSkill = nombreSkill;
	}


	public String getPorcentaje() {
		return porcentaje;
	}


	public void setPorcentaje(String porcentaje) {
		this.porcentaje = porcentaje;
	}
	
	
	

}
