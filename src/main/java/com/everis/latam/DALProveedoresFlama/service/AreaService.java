package com.everis.latam.DALProveedoresFlama.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.everis.latam.DALProveedoresFlama.dto.AreaDto;

@Service
public interface AreaService {
		List<AreaDto> ListarAreas();
		AreaDto save(AreaDto area);
		AreaDto BuscarPorId(int Id);
		
	
}

