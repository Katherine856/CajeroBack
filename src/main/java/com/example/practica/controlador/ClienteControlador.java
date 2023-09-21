package com.example.practica.controlador;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.practica.entidad.Cliente;
import com.example.practica.entidad.Sucursal;
import com.example.practica.repositorio.SucursalRepositorio;
import com.example.practica.servicio.ClienteServicio;
import com.example.practica.servicio.SucursalServicio;

import io.micrometer.common.util.StringUtils;

@Controller
@RequestMapping("/cliente")
@CrossOrigin(origins = "*")
public class ClienteControlador {
	
	@Autowired
	ClienteServicio clienteServicio;
	
	@PostMapping("/nuevo")
	public ResponseEntity<?> guardarCliente(@RequestBody Cliente cliente){
		
		if(clienteServicio.existsByDocumento(cliente.getDocumento()))
			return new ResponseEntity(new String("Ese documento ya est� registrado"), HttpStatus.BAD_REQUEST);
		
		try {
			cliente = clienteServicio.guardar(cliente);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity(new String("Guardado"), HttpStatus.CREATED);
	}

}
