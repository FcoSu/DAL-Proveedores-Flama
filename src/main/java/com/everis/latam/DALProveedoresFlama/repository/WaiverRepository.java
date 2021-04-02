package com.everis.latam.DALProveedoresFlama.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.everis.latam.DALProveedoresFlama.entity.Waiver;

public interface WaiverRepository extends JpaRepository <Waiver,String> {

	
	@Query(value = "SELECT * FROM waiver WHERE aprovador_Id=:iDAprovador", nativeQuery = true)
	Waiver BuscarWaiverPorId(@Param("iDAprovador") String iDAprovador);

}
