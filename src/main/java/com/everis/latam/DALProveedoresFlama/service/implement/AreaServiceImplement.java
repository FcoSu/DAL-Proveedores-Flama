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
		
	
	
	public AreaDto save(AreaDto area) {
		AreaDto Respuesta = new AreaDto();
		Area AreaEntidad = new Area();
		AreaEntidad = MapeoAEntidad(area);
		
		 areaRepository.save(AreaEntidad);
		 
		 
		 
		 Respuesta = MapeoADto(AreaEntidad);
		 
		 
		 return Respuesta;
		 
	}
	
	
	
	
	
	
	public Area MapeoAEntidad(AreaDto areaDTO) {
		Area Respuesta = new Area();
		Respuesta.setArea_Nombre(areaDTO.getAreaNombre());
		Respuesta.setArea_Responsable(areaDTO.getAreaResponsable());
		Respuesta.setArea_Email(areaDTO.getAreaEmail());
		Respuesta.setArea_Ceco(areaDTO.getAreaCeco());
		
		
		return Respuesta;
	}
	
	public AreaDto MapeoADto(Area areaEntidad) {
		AreaDto Respuesta = new AreaDto();
		
		Respuesta.setAreaID(areaEntidad.getArea_Id());
		Respuesta.setAreaNombre(areaEntidad.getArea_Nombre());
		Respuesta.setAreaResponsable(areaEntidad.getArea_Responsable());
		Respuesta.setAreaEmail(areaEntidad.getArea_Email());
		Respuesta.setAreaCeco(areaEntidad.getArea_Ceco());
		
		return Respuesta;
	}
}
