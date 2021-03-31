package com.everis.latam.DALProveedoresFlama.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.latam.DALProveedoresFlama.dto.AreaDto;
import com.everis.latam.DALProveedoresFlama.entity.Area;
import com.everis.latam.DALProveedoresFlama.repository.AreaRepository;
import com.everis.latam.DALProveedoresFlama.service.AreaService;


@Service
public class AreaServiceImplement implements AreaService{

	
	
	
	@Autowired
	AreaRepository areaRepository;
	
	
	
	
	@SuppressWarnings("null")
	public void save(AreaDto area) {
		
		Area AreaEntidad = new Area();
		AreaEntidad.setArea_Nombre(area.getAreaNombre());
		AreaEntidad.setArea_Responsable(area.getAreaResponsable());
		AreaEntidad.setArea_Email(area.getAreaEmail());
		AreaEntidad.setArea_Ceco(area.getAreaCeco());
		
		
		 areaRepository.save(AreaEntidad);
		 
	}
}
