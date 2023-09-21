package com.example.practica.entidad;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Credenciales {

	@JsonProperty("documento")
	private Integer documento = null;

	@JsonProperty("contrasena")
	private String contrasena = null;

	public Credenciales(Integer documento, String contrasena) {
		super();
		this.documento = documento;
		this.contrasena = contrasena;
	}
	
	public Credenciales() {
		
	}

	public Integer getDocumento() {
		return documento;
	}

	public void setDocumento(Integer documento) {
		this.documento = documento;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

}
