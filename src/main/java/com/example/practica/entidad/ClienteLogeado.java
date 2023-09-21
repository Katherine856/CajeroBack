package com.example.practica.entidad;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ClienteLogeado {
	
	@JsonProperty("documento")
	private Integer documento;
	
	public ClienteLogeado(Integer documento) {
		super();
		this.documento = documento;
	}

	public Integer getDocumento() {
		return documento;
	}

	public void setDocumento(Integer documento) {
		this.documento = documento;
	}
	
}
