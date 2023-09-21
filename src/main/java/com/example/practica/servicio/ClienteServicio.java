package com.example.practica.servicio;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.practica.entidad.Cliente;
import com.example.practica.repositorio.ClienteRepositorio;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ClienteServicio {
	
	@Autowired
	ClienteRepositorio clienteRepo;
	
	public boolean existsByDocumento(Integer documento) {
		return clienteRepo.existsByDocumento(documento);
	}
	
	public Optional<Cliente> findById(Integer numDocumento) {
		return clienteRepo.findById(numDocumento);
	}
	
	public Cliente guardar(Cliente cliente) {
		Cliente client = clienteRepo.save(cliente);
		return client;
	}
	
}
