package com.everis.latam.DALProveedoresFlama.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.everis.latam.DALProveedoresFlama.dto.EstadoSolicitudDto;

@Service
public interface EstadoSolicitudService {

	List<EstadoSolicitudDto> EstadosListar(); 
	EstadoSolicitudDto BuscarEstadoPorId(int Id);

}
