package com.example.practica.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.practica.entidad.Cliente;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Integer>{

	Optional<Cliente> findById(Integer numDocumento);
	
	boolean existsByDocumento(Integer documento);
	
	
}
