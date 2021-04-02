package com.everis.latam.DALProveedoresFlama.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.everis.latam.DALProveedoresFlama.entity.Proveedor;

public interface ProveedorRepository extends JpaRepository<Proveedor,String> {

	
	@Query(value = "SELECT * FROM proveedor", nativeQuery = true)
	public List<Proveedor> ListarProveedores();
	
	@Query(value = "SELECT * FROM proveedor WHERE proveedor_id_Registro=:idBuscar", nativeQuery = true)
	public Proveedor BuscarProveedorPorId(@Param("idBuscar") int idBuscar);
}
