package com.example.practica.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.practica.entidad.Cliente;
import com.example.practica.entidad.ClienteLogeado;
import com.example.practica.entidad.Credenciales;
import com.example.practica.entidad.Cuenta;
import com.example.practica.repositorio.ClienteRepositorio;
import com.example.practica.repositorio.CuentaRepositorio;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class LoginServicio {
	
	@Autowired
	ClienteRepositorio clienteRepo;

	public ClienteLogeado comprobar(Credenciales credenciales) {
		Cliente cliente = clienteRepo.findById(credenciales.getDocumento()).get();

		if (cliente != null) {

			if (cliente.getDocumento().equals(credenciales.getDocumento()) && cliente.getContrasena().equals(credenciales.getContrasena())) {
				
				ClienteLogeado respuesta = new ClienteLogeado(cliente.getDocumento());

				return respuesta;
			} else {
				return null;

			}
		} else {
			return null;
		}
	}

}
