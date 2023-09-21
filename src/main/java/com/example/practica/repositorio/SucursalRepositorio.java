package com.example.practica.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.practica.entidad.Sucursal;

@Repository
public interface SucursalRepositorio  extends JpaRepository<Sucursal, Integer>{

	Optional<Sucursal> findById(Integer id_sucursal);
}
