package com.ArgP.perfil.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Educacion {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idEdu;
	
	private String tituloEdu;
	private String descripcion;
	private String ImagenEdu;
	
	
	
	
	public Educacion() {
		super();
	}
	
	
	public Educacion(long idEdu, String tituloEdu, String descripcion, String imagenEdu) {
		super();
		this.idEdu = idEdu;
		this.tituloEdu = tituloEdu;
		this.descripcion = descripcion;
		ImagenEdu = imagenEdu;
	}
	public long getIdEdu() {
		return idEdu;
	}
	public void setIdEdu(long idEdu) {
		this.idEdu = idEdu;
	}
	public String getTituloEdu() {
		return tituloEdu;
	}
	public void setTituloEdu(String tituloEdu) {
		this.tituloEdu = tituloEdu;
	}

	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getImagenEdu() {
		return ImagenEdu;
	}
	public void setImagenEdu(String imagenEdu) {
		ImagenEdu = imagenEdu;
	}
	
	

}
