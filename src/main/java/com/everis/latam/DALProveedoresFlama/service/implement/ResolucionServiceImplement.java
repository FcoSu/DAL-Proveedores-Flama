package com.everis.latam.DALProveedoresFlama.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.latam.DALProveedoresFlama.dto.ResolucionDto;
import com.everis.latam.DALProveedoresFlama.entity.Resolucion;
import com.everis.latam.DALProveedoresFlama.repository.ResolucionRepository;
import com.everis.latam.DALProveedoresFlama.service.ResolucionService;

@Service
public class ResolucionServiceImplement implements ResolucionService{
	
	@Autowired
	ResolucionRepository resolucionRepository;

	@Override
	public ResolucionDto save(ResolucionDto resolucionIngreso) {
		Resolucion ResolucionIngresoEntidad = new Resolucion();
		ResolucionDto Respuesta = new ResolucionDto();
		ResolucionIngresoEntidad = MapeoAEntidad(resolucionIngreso);
		resolucionRepository.save(ResolucionIngresoEntidad);
		Respuesta = MapeoADto(ResolucionIngresoEntidad);
		
		return Respuesta;
	}

	@Override
	public ResolucionDto BuscarPorId(int Id) {
		ResolucionDto Respuesta = new ResolucionDto();
		Resolucion Aux= new Resolucion();
		try {
			Aux = resolucionRepository.BuscarResolucionPorID(Id);
			Respuesta = MapeoADto(Aux);
			return Respuesta;
		} catch (Exception e) {
			return Respuesta;
		}
		
		
	}
	
	
	public ResolucionDto MapeoADto (Resolucion ResolucionAMapear) {
		ResolucionDto Auxiliar = new ResolucionDto ();
		Auxiliar.setResolucionId(ResolucionAMapear.getResolucion_Id());
		Auxiliar.setSolicitudId(ResolucionAMapear.getSolicitud_Id());
		Auxiliar.setMontoTotal(ResolucionAMapear.getMonto_Total());
		Auxiliar.setResolucionFecha(ResolucionAMapear.getResolucion_Fecha());
		Auxiliar.setResolucionComentario(ResolucionAMapear.getResolucion_Comentario());
		return Auxiliar;
	}
	public Resolucion MapeoAEntidad(ResolucionDto ResolucionDtoAMapear) {
		Resolucion auxiliar = new Resolucion();
		auxiliar.setResolucion_Id(ResolucionDtoAMapear.getResolucionId());
		auxiliar.setSolicitud_Id(ResolucionDtoAMapear.getSolicitudId());
		auxiliar.setMonto_Total(ResolucionDtoAMapear.getMontoTotal());
		auxiliar.setResolucion_Fecha(ResolucionDtoAMapear.getResolucionFecha());
		auxiliar.setResolucion_Comentario(ResolucionDtoAMapear.getResolucionComentario());
		
		return auxiliar;
	}

}
