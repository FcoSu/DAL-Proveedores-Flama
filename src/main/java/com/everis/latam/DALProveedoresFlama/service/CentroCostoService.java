package com.everis.latam.DALProveedoresFlama.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.everis.latam.DALProveedoresFlama.dto.CentroCostoDto;
@Service
public interface CentroCostoService {

	List<CentroCostoDto> CentrosListar();
	CentroCostoDto ObtenerCentroPorNombre(String Nombre);

}
