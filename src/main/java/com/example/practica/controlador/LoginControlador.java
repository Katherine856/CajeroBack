package com.example.practica.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.practica.entidad.ClienteLogeado;
import com.example.practica.entidad.Credenciales;
import com.example.practica.servicio.LoginServicio;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class LoginControlador {
	
	@Autowired
	LoginServicio loginServicio;
	
	@PostMapping("/otroLogin")
	public ClienteLogeado Login(@RequestBody Credenciales credenciales) {
		try {
			if (credenciales != null) {
				if (credenciales.getDocumento() != null && !credenciales.getContrasena().isBlank()) {
					ClienteLogeado clientelog = loginServicio.comprobar(credenciales);
					return clientelog;
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return null;
	}
}
