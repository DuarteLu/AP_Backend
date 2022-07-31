package com.ArgP.perfil.DTO;

import javax.validation.constraints.NotBlank;

public class EducacionDto {

	 @NotBlank
	private String tituloEdu;
	 @NotBlank
	private String descripcion;
	
	
	public EducacionDto() {
	}


	public EducacionDto(String tituloEdu, String descripcion, String imagenEdu) {
		this.tituloEdu = tituloEdu;
		this.descripcion = descripcion;
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



	
	
}
