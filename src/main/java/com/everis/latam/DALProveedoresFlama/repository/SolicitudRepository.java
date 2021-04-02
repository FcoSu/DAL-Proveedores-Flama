package com.everis.latam.DALProveedoresFlama.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.everis.latam.DALProveedoresFlama.entity.Solicitud;

public interface SolicitudRepository extends JpaRepository<Solicitud, Integer>{

	@Query(value = "SELECT * FROM solicitud", nativeQuery = true)
	List<Solicitud> ListarSolicitudes();

	
	@Query(value = "SELECT * FROM solicitud WHERE solicitud_Id=:idBuscar",nativeQuery = true)
	Solicitud BuscarSolictudPorId(@Param("idBuscar")int  idBuscar);

	@Modifying
	@Query (value = "UPDATE solicitud SET estado_solicitud_Id=:idNueva WHERE solicitud_Id=:idBuscar", nativeQuery = true)
	void UpdateSolicitudPorId( @Param("idNueva") int idNueva, @Param("idBuscar") int idBuscar );
}
