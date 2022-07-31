package com.ArgP.perfil.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Proyecto {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idproy;
	
	private String nombreProy;
	private String descripcionProy;
	private String ImagenProy;
	
	public Proyecto() {
		
	}

	public Proyecto(long idproy, String nombreProy, String descripcionProy, String imagenProy) {
		super();
		this.idproy = idproy;
		this.nombreProy = nombreProy;
		this.descripcionProy = descripcionProy;
		ImagenProy = imagenProy;
	}

	public long getIdproy() {
		return idproy;
	}

	public void setIdproy(long idproy) {
		this.idproy = idproy;
	}

	public String getNombreProy() {
		return nombreProy;
	}

	public void setNombreProy(String nombreProy) {
		this.nombreProy = nombreProy;
	}

	public String getDescripcionProy() {
		return descripcionProy;
	}

	public void setDescripcionProy(String descripcionProy) {
		this.descripcionProy = descripcionProy;
	}

	public String getImagenProy() {
		return ImagenProy;
	}

	public void setImagenProy(String imagenProy) {
		ImagenProy = imagenProy;
	}
	
	
	

}
