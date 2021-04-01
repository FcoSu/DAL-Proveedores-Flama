package com.everis.latam.DALProveedoresFlama.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.everis.latam.DALProveedoresFlama.dto.CentroCostoDto;
import com.everis.latam.DALProveedoresFlama.entity.CentroCosto;

public interface CentroCostoRepository extends JpaRepository<CentroCosto,String>{

	@Query(value = "SELECT * FROM centrodeCosto", nativeQuery = true)
	public List<CentroCosto> ObtenerCentros();
	
	@Query (value = "SELECT * FROM centrodeCosto WHERE centro_Nombre=:NombreBusqueda", nativeQuery = true)
	public CentroCosto BuscarCentroPorNombre(@Param("NombreBusqueda") String NombreBusqueda);
}
