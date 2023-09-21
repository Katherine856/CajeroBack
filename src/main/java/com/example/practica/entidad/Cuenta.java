package com.example.practica.entidad;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="CUENTA")
public class Cuenta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="NUMERO_CUENTA")
	private Integer numCuenta;
	
	@ManyToOne
	@JoinColumn(name="ID_TIPO_CUENTA")
	private TipoCuenta tipoCuenta;
	
	@ManyToOne
	@JoinColumn(name="NUMERO_DOCUMENTO")
	private Cliente docClientes;
	
	@Column(name="SALDO", nullable = false)
	private Integer saldo;
	
	@Column(name="CLAVE", nullable = false)
	private Integer clave;
	
	@JsonIgnore
	@OneToMany(mappedBy = "numCuentas", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	Set<Transaccion> transaccion;

	public Integer getNumCuenta() {
		return numCuenta;
	}

	public void setNumCuenta(Integer numCuenta) {
		this.numCuenta = numCuenta;
	}

	public TipoCuenta getTipoCuenta() {
		return tipoCuenta;
	}

	public void setTipoCuenta(TipoCuenta tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}

	public Cliente getDocClientes() {
		return docClientes;
	}

	public void setDocClientes(Cliente docClientes) {
		this.docClientes = docClientes;
	}

	public Integer getSaldo() {
		return saldo;
	}

	public void setSaldo(Integer saldo) {
		this.saldo = saldo;
	}

	public Integer getClave() {
		return clave;
	}

	public void setClave(Integer clave) {
		this.clave = clave;
	}

	public Set<Transaccion> getTransaccion() {
		return transaccion;
	}

	public void setTransaccion(Set<Transaccion> transaccion) {
		this.transaccion = transaccion;
	}
	
	
	
}
