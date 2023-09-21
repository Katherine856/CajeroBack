package com.example.practica.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.practica.entidad.Transaccion;
import com.example.practica.servicio.CuentaServicio;
import com.example.practica.servicio.TransaccionServicio;

@Controller
@RequestMapping("/transaccion")
@CrossOrigin(origins = "*")
public class TransaccionControlador {
	
	@Autowired
	TransaccionServicio transaccionServicio;
	
	@Autowired
	CuentaServicio cuentaServicio;
	
	@PostMapping("/consultar")
	public ResponseEntity<Integer> consultarSaldo(@RequestBody Transaccion transaccion) {
		Integer saldo = transaccionServicio.consultar(transaccion.getNumCuentas().getNumCuenta());
		transaccion = transaccionServicio.guardar(transaccion);
		return new ResponseEntity<Integer>(saldo, HttpStatus.OK);
	}
	
	@PostMapping("/retirar")
	public ResponseEntity<?> retirar(@RequestBody Transaccion transaccion) {
		Integer saldo = cuentaServicio.obtenerSaldo(transaccion.getNumCuentas().getNumCuenta());
		if(saldo<transaccion.getMonto())
			return new ResponseEntity(new String("Muy poco"), HttpStatus.BAD_REQUEST);
		try {
			transaccionServicio.retirar(transaccion.getNumCuentas().getNumCuenta(), transaccion.getMonto());
			transaccion = transaccionServicio.guardar(transaccion);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return new ResponseEntity(new String("Listo"), HttpStatus.OK);
	}
	
	@PostMapping("/consignar")
	public ResponseEntity<Integer> consignar(@RequestBody Transaccion transaccion) {
		Integer saldo = cuentaServicio.obtenerSaldo(transaccion.getNumCuentas().getNumCuenta());
		if(saldo<transaccion.getMonto())
			return new ResponseEntity(new String("Muy poco"), HttpStatus.BAD_REQUEST);
		try {
			transaccionServicio.consignar(transaccion.getNumCuentas().getNumCuenta(), transaccion.getNumCuentaDestino(), transaccion.getMonto());
			transaccion = transaccionServicio.guardar(transaccion);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return new ResponseEntity(new String(saldo +"Listo"), HttpStatus.OK);
	}
	
	@GetMapping("/intereses")
	public ResponseEntity<Integer> calIntereses() {
		transaccionServicio.calIntereses();
		return new ResponseEntity(new String("Listo"), HttpStatus.OK);
	}
	
}
