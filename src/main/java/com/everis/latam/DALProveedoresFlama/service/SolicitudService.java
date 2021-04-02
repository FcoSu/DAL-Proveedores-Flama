package com.everis.latam.DALProveedoresFlama.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.everis.latam.DALProveedoresFlama.dto.SolicitudDto;

@Service
public interface SolicitudService {

	SolicitudDto save(SolicitudDto solicitudAIngresar);

	List<SolicitudDto> ListarSolicitudes();

}
