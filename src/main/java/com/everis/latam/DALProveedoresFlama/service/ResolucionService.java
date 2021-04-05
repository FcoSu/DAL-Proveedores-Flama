package com.everis.latam.DALProveedoresFlama.service;

import org.springframework.stereotype.Service;

import com.everis.latam.DALProveedoresFlama.dto.ResolucionDto;

@Service
public interface ResolucionService {

	ResolucionDto save(ResolucionDto resolucionIngreso);
	ResolucionDto BuscarPorId(int Id);
	ResolucionDto BuscarUltimaResolucion();

}
