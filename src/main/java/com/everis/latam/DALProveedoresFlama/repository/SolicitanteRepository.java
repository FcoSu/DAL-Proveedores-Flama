package com.everis.latam.DALProveedoresFlama.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.everis.latam.DALProveedoresFlama.entity.Solicitante;

public interface SolicitanteRepository extends JpaRepository <Solicitante, Integer> {

	@Query(value = "SELECT * FROM solicitante WHERE solicitante_Id=:idBuscar", nativeQuery = true)
	Solicitante BuscarSolicitantePorId(@Param("idBuscar") int idBuscar);

}
