package com.everis.latam.DALProveedoresFlama.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.everis.latam.DALProveedoresFlama.entity.Resolucion;

public interface ResolucionRepository extends JpaRepository<Resolucion, Integer> {

	@Query(value = "SELECT * FROM resolucion WHERE resolucion_Id=:idBuscar",nativeQuery = true)
	Resolucion BuscarResolucionPorID(@Param("idBuscar")int idBuscar);

}
