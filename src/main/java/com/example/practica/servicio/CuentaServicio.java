package com.example.practica.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.practica.repositorio.CuentaRepositorio;
import com.example.practica.entidad.Cliente;
import com.example.practica.entidad.Cuenta;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CuentaServicio {
	
	@Autowired
	CuentaRepositorio cuentaRepo;
	
	public boolean existsById(Integer documento) {
		return cuentaRepo.existsById(documento);
	}
	
	public List<Cuenta> cuentasByDoc(Integer numDocumento) {
		List<Cuenta> cuenta = cuentaRepo.obtenerCuentasByDoc(numDocumento);
		return cuenta;
	}
	
	public Cuenta guardar(Cuenta cuenta) {
		Cuenta cuent = cuentaRepo.save(cuenta);
		return cuent;
	}
	
	public Integer obtenerSaldo(Integer numCuenta) {
		Integer saldo = cuentaRepo.obtenerSaldo(numCuenta);
		return saldo;
	}
}
