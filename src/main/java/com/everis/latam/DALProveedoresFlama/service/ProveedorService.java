package com.everis.latam.DALProveedoresFlama.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.everis.latam.DALProveedoresFlama.dto.ProveedorDto;

@Service
public interface ProveedorService {
	//Utilizar funcion .save (como en Area) para obtener la id una vez ingresada
	List<ProveedorDto> ListarProveedor();
	ProveedorDto save(ProveedorDto proveedor);
	ProveedorDto BuscarProveedorPorID(String Id);
	

}
