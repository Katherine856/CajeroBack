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
@Table(name="TIPO_CUENTA")
public class TipoCuenta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_TIPO_CUENTA")
	private Integer id_tipoCuenta;
	
	@Column(name="NOMBRE_TIPO_CUENTA", nullable = false, length = 50)
	private String nombre_tp;
	
	@Column(name="INTERES", nullable = false)
	private String interes;
	
	@JsonIgnore
	@OneToMany(mappedBy = "tipoCuenta", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	Set<Cuenta> cuentas;
	
	public Integer getId_tipoCuenta() {
		return id_tipoCuenta;
	}

	public void setId_tipoCuenta(Integer id_tipoCuenta) {
		this.id_tipoCuenta = id_tipoCuenta;
	}

	public String getNombre_tp() {
		return nombre_tp;
	}

	public void setNombre_tp(String nombre_tp) {
		this.nombre_tp = nombre_tp;
	}

	public String getInteres() {
		return interes;
	}

	public void setInteres(String interes) {
		this.interes = interes;
	}

	public Set<Cuenta> getCuentas() {
		return cuentas;
	}

	public void setCuentas(Set<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}

	
	
	
}
