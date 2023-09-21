package com.example.practica.entidad;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="SUCURSAL")
public class Sucursal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_SUCURSAL")
	private Integer id_sucursal;
	
	@Column(name="NOMBRE_SUCURSAL", nullable = false, length = 50)
	private String nombre_s;
	
	@Column(name="DIRECCION", nullable = false, length = 50)
	private String direccion_s;
	
	@Column(name="TELEFONO", nullable = false)
	private Integer telefono_s;
	
	@JsonIgnore
	@OneToMany(mappedBy = "sucursal", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	Set<Cliente> clientes;

	public Integer getId_sucursal() {
		return id_sucursal;
	}

	public void setId_sucursal(Integer id_sucursal) {
		this.id_sucursal = id_sucursal;
	}

	public String getNombre_s() {
		return nombre_s;
	}

	public void setNombre_s(String nombre_s) {
		this.nombre_s = nombre_s;
	}

	public String getDireccion_s() {
		return direccion_s;
	}

	public void setDireccion_s(String direccion_s) {
		this.direccion_s = direccion_s;
	}

	public Integer getTelefono_s() {
		return telefono_s;
	}

	public void setTelefono_s(Integer telefono_s) {
		this.telefono_s = telefono_s;
	}

	public Set<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(Set<Cliente> clientes) {
		this.clientes = clientes;
	}

	
	
	
	
}
