package com.everis.latam.DALProveedoresFlama.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.everis.latam.DALProveedoresFlama.entity.Area;


@Repository
public interface AreaRepository extends JpaRepository<Area,Integer> {
	

	@Query(value = "SELECT * FROM area", nativeQuery = true)
	public List<Area> ObtenerAreas();
	
	@Query(value= "SELECT * FROM area WHERE area_Id=:id_Busqueda",nativeQuery = true)
	public Area BuscarPorId(@Param("id_Busqueda") int ID);

	}

