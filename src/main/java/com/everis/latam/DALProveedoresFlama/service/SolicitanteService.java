package com.everis.latam.DALProveedoresFlama.service;

import org.springframework.stereotype.Service;

import com.everis.latam.DALProveedoresFlama.dto.SolicitanteDto;

@Service
public interface SolicitanteService {

	SolicitanteDto save(SolicitanteDto solicitanteAIngresar);
	SolicitanteDto BuscarSolicitantePorId(int Id);
//Utilizar funcion .save (como en Area) para obtener la id una vez ingresada
}
