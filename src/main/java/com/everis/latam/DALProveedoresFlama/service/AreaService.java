package com.everis.latam.DALProveedoresFlama.service;

import org.springframework.stereotype.Service;

import com.everis.latam.DALProveedoresFlama.dto.AreaDto;
import com.everis.latam.DALProveedoresFlama.entity.Area;

@Service
public interface AreaService {

		void save(AreaDto area);
		
	
}

