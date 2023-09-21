package com.example.practica.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.practica.entidad.Cuenta;

@Repository
public interface CuentaRepositorio extends JpaRepository<Cuenta, Integer> {

	Optional<Cuenta> findById(Integer id_cuenta);
	
	boolean existsById(Integer id_cuenta);
	
	@Query(value = "SELECT * FROM CUENTA C WHERE C.NUMERO_DOCUMENTO=:numDocumento", nativeQuery = true)
	public List<Cuenta> obtenerCuentasByDoc(@Param("numDocumento") Integer numDocumento);
	
	@Query(value = "SELECT SALDO FROM CUENTA C WHERE C.NUMERO_CUENTA=:numCuenta", nativeQuery = true)
	Integer obtenerSaldo(@Param("numCuenta") Integer numCuenta);
	
}

