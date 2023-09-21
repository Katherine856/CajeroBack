package com.example.practica.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.practica.entidad.Transaccion;
import com.example.practica.repositorio.TransaccionRepositorio;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TransaccionServicio {
	
	@Autowired
	TransaccionRepositorio transaccionRepo;
	
	public Transaccion guardar(Transaccion tran) {
		Transaccion trans = transaccionRepo.save(tran);
		return trans;
	}
	
	public Integer consultar(Integer numCuenta) {
		try {
			Integer saldoActual = transaccionRepo.consultarSaldo(numCuenta);
			return saldoActual;
		} catch (Exception e) {
			return null;
		}
	}
	
	public void retirar(Integer numCuenta, Integer monto) {
		try {
			transaccionRepo.retirar(numCuenta, monto);
		} catch (Exception e) {
			
		}
	}
	
	public void consignar(Integer numCuenta, Integer numCuentaDestino, Integer monto) {
		try {
			transaccionRepo.consignar(numCuenta, numCuentaDestino, monto);
		} catch (Exception e) {

		}
	}
	
	public void calIntereses() {
		try {
			transaccionRepo.intereses();
		} catch (Exception e) {

		}
	}
	
}
