package com.example.practica.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.practica.entidad.Transaccion;

@Repository
public interface TransaccionRepositorio extends JpaRepository<Transaccion, Integer>{
	
	Optional<Transaccion> findById(Integer id_transaccion);
	
	@Query(value = "SELECT OBTENER_SALDO(:numCuenta) FROM DUAL", nativeQuery = true)
	Integer consultarSaldo(@Param("numCuenta") Integer numCuenta);
	
	@Query(value = "CALL RETIRAR(:numCuenta, :monto)", nativeQuery = true)
	public void retirar(@Param("numCuenta") Integer numCuenta, @Param("monto") Integer monto);
	
	@Query(value = "CALL CONSIGNAR(:numCuenta, :numCuentaDestino, :monto)", nativeQuery = true)
	public void consignar(@Param("numCuenta") Integer numCuenta, @Param("numCuentaDestino") Integer numCuentaDestino, @Param("monto") Integer monto);

	@Query(value = "CALL CAL_INTERES()", nativeQuery = true)
	public void intereses();
	
}
