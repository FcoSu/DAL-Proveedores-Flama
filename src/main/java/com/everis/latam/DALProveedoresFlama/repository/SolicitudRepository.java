package com.everis.latam.DALProveedoresFlama.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.everis.latam.DALProveedoresFlama.entity.Solicitud;

public interface SolicitudRepository extends JpaRepository<Solicitud, Integer>{

	@Query(value = "SELECT * FROM solicitud", nativeQuery = true)
	List<Solicitud> ListarSolicitudes();

}
