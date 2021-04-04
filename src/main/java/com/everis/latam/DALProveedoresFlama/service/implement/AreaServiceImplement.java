package com.everis.latam.DALProveedoresFlama.service.implement;

import java.util.ArrayList;
import java.util.List;

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
		
	
	@Override
	public AreaDto save(AreaDto area) {
		AreaDto Respuesta = new AreaDto();
		Area AreaEntidad = new Area();
		
		AreaEntidad = MapeoAEntidad(area);
		
		 areaRepository.save(AreaEntidad);
		  
		 Respuesta = MapeoADto(AreaEntidad);
		 
		 
		 return Respuesta;
		 
	}
	
	@Override
	public List<AreaDto> ListarAreas() {
		List<AreaDto> ListaAreas=new ArrayList<>();
		List<Area> AreaEntidad = areaRepository.ObtenerAreas();
		AreasMapper(ListaAreas, AreaEntidad);
		return ListaAreas;
	}
	
	@Override
	public AreaDto BuscarPorId(int ID) {
		AreaDto Respuesta = new AreaDto();
		Area Busqueda = areaRepository.BuscarPorId(ID);
		Respuesta = MapeoADto(Busqueda);
		return Respuesta;
	};
	
	
	
	public void AreasMapper(List<AreaDto> areasDTO, List<Area> areasEntidades) {
		for(Area area:areasEntidades) {
			AreaDto Auxiliar = new AreaDto();
			Auxiliar.setAreaID(area.getArea_Id());
			Auxiliar.setNombreArea(area.getArea_Nombre());
			Auxiliar.setResponsable(area.getArea_Responsable());
			Auxiliar.setEmail(area.getArea_Email());
			Auxiliar.setCeco(area.getArea_Ceco());
			
			areasDTO.add(Auxiliar);
		}
		
	}
	
	public Area MapeoAEntidad(AreaDto areaDTO) {
		Area Respuesta = new Area();
		Respuesta.setArea_Nombre(areaDTO.getNombreArea());
		Respuesta.setArea_Responsable(areaDTO.getResponsable());
		Respuesta.setArea_Email(areaDTO.getEmail());
		Respuesta.setArea_Ceco(areaDTO.getCeco());
		
		
		return Respuesta;
	}
	
	public AreaDto MapeoADto(Area areaEntidad) {
		AreaDto Respuesta = new AreaDto();
		
		Respuesta.setAreaID(areaEntidad.getArea_Id());
		Respuesta.setNombreArea(areaEntidad.getArea_Nombre());
		Respuesta.setResponsable(areaEntidad.getArea_Responsable());
		Respuesta.setEmail(areaEntidad.getArea_Email());
		Respuesta.setCeco(areaEntidad.getArea_Ceco());
		
		return Respuesta;
	}






	
}
