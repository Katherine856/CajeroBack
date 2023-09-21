package com.example.practica.entidad;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="TRANSACCION")
public class Transaccion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_TRANSACCION")
	private Integer id_transaccion;
	
	@ManyToOne()
	@JoinColumn(name="NUMERO_CUENTA",  nullable = false)
	private Cuenta numCuentas;
	
	@Column(name="TIPO_TRANSACCION",  nullable = false)
	private String tipoTransaccion;
	
	@Column(name="FECHA",  nullable = false)
	private Date fecha;
	
	@Column(name="NUMERO_CUENTA_DESTINO",  nullable = true)
	private Integer numCuentaDestino;
	
	@Column(name="NUMERO_DOC_DESTINO",  nullable = true)
	private Integer numDocDestino;
	
	@Column(name="MONTO",  nullable = true)
	private Integer monto;
	
	public Integer getId_transaccion() {
		return id_transaccion;
	}

	public void setId_transaccion(Integer id_transaccion) {
		this.id_transaccion = id_transaccion;
	}

	public Cuenta getNumCuentas() {
		return numCuentas;
	}

	public void setNumCuentas(Cuenta numCuentas) {
		this.numCuentas = numCuentas;
	}

	public String getTipoTransaccion() {
		return tipoTransaccion;
	}

	public void setTipoTransaccion(String tipoTransaccion) {
		this.tipoTransaccion = tipoTransaccion;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Integer getNumCuentaDestino() {
		return numCuentaDestino;
	}

	public void setNumCuentaDestino(Integer numCuentaDestino) {
		this.numCuentaDestino = numCuentaDestino;
	}

	public Integer getNumDocDestino() {
		return numDocDestino;
	}

	public void setNumDocDestino(Integer numDocDestino) {
		this.numDocDestino = numDocDestino;
	}

	public Integer getMonto() {
		return monto;
	}

	public void setMonto(Integer monto) {
		this.monto = monto;
	}
}
