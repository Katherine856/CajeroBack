package com.example.practica.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.practica.entidad.Cuenta;
import com.example.practica.servicio.CuentaServicio;

@RestController
@RequestMapping("/cuenta")
@CrossOrigin(origins = "*")
public class CuentaControlador {
	
	@Autowired
	CuentaServicio cuentaServicio;
	
	@PostMapping("/nuevo")
	public ResponseEntity<?> guardarCuenta(@RequestBody Cuenta cuenta){
		cuenta = cuentaServicio.guardar(cuenta);
		return new ResponseEntity(new String(cuenta + ""), HttpStatus.CREATED);
	}
	
	@GetMapping("/ver/{numDocumento}")
	public ResponseEntity<List<Cuenta>> getCuentasCliente(@PathVariable Integer numDocumento) {
		List<Cuenta> cuenta = cuentaServicio.cuentasByDoc(numDocumento);
		return new ResponseEntity<List<Cuenta>>(cuenta, HttpStatus.OK);
	}
	
}
