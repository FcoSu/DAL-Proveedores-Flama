package com.everis.latam.DALProveedoresFlama.repository;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.everis.latam.DALProveedoresFlama.dto.AreaDto;
import com.everis.latam.DALProveedoresFlama.entity.Area;


@Repository
public interface AreaRepository extends JpaRepository<Area,Integer> {
	
	//@Modifying(clearAutomatically = true)
    //@Transactional
    //@Query("insert into AREA (AREA_NOMBRE,AREA_RESPONSABLE,AREA_EMAIL,AREA_CECO) select :areaNombre,:areaResponsable,:areaEmail,:areaCeco from area")
    //public void Guardar(@Param("area")Area );


	

	}
