package com.everis.latam.DALProveedoresFlama.service;

import org.springframework.stereotype.Service;

import com.everis.latam.DALProveedoresFlama.dto.WaiverDto;

@Service
public interface WaiverService {

	WaiverDto BuscarWaiverPorId(String iDAprovador);

}
