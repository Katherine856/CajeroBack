package com.example.practica.servicio;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.practica.entidad.Sucursal;
import com.example.practica.repositorio.SucursalRepositorio;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class SucursalServicio {
	@Autowired
	SucursalRepositorio sucursalRepo;
	
	public boolean existsBySucursal(Integer id_sucursal) {
		return sucursalRepo.existsById(id_sucursal);
	}
}
