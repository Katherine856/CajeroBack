package com.example.practica.entidad;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="CLIENTE")
public class Cliente {
	
	@Id
	@Column(name="NUMERO_DOCUMENTO")
	private Integer documento;
	
	@Column(name="TIPO_DOCUMENTO", nullable = false)
	private String t_documento;
	
	@Column(name="NOMBRES", nullable = false, length = 50)
	private String nombres;
	
	@Column(name="APELLIDOS", nullable = false, length = 50)
	private String apellidos;
	
	@Column(name="CORREO", nullable = false, length = 50)
	private String correo;
	
	@Column(name="CELULAR", nullable = false)
	private Integer celular;
	
	@Column(name="DIRECCION", nullable = false, length = 50)
	private String direccion;
	
	@Column(name="CONTRASENA", nullable = false, length = 16)
	private String contrasena;
	
	@ManyToOne
	@JoinColumn(name = "id_sucursal")
	private Sucursal sucursal;
	
	@JsonIgnore
	@OneToMany(mappedBy = "docClientes", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	Set<Cuenta> cuentas;
	
	public Integer getDocumento() {
		return documento;
	}

	public void setDocumento(Integer documento) {
		this.documento = documento;
	}

	public String getT_documento() {
		return t_documento;
	}

	public void setT_documento(String t_documento) {
		this.t_documento = t_documento;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Integer getCelular() {
		return celular;
	}

	public void setCelular(Integer celular) {
		this.celular = celular;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public Sucursal getSucursal() {
		return sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}

	public Set<Cuenta> getCuentas() {
		return cuentas;
	}

	public void setCuentas(Set<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}

	
	
}
