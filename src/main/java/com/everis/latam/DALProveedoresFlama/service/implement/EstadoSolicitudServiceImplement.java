package com.everis.latam.DALProveedoresFlama.service.implement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.latam.DALProveedoresFlama.dto.EstadoSolicitudDto;
import com.everis.latam.DALProveedoresFlama.entity.EstadoSolicitud;
import com.everis.latam.DALProveedoresFlama.repository.EstadoSolicitudRepository;
import com.everis.latam.DALProveedoresFlama.service.EstadoSolicitudService;

@Service
public class EstadoSolicitudServiceImplement implements EstadoSolicitudService {
	
	@Autowired
	EstadoSolicitudRepository EstadoRepository;

	@Override
	public List<EstadoSolicitudDto> EstadosListar() {
		List<EstadoSolicitudDto> EstadoListaDTO = new ArrayList<>();
		List<EstadoSolicitud> EstadoEntidades = EstadoRepository.EstadosListar();
		System.out.println("entindades "+ EstadoEntidades);
		
		EstadosMapper (EstadoListaDTO, EstadoEntidades);
		return null;
	}

	@Override
	public EstadoSolicitudDto BuscarEstadoPorId(int Id) {
		EstadoSolicitud EstadoaMapear = EstadoRepository.BuscarEstadoPorId(Id);
		EstadoSolicitudDto nuevoEstado = new EstadoSolicitudDto();
		nuevoEstado = mapperADto(EstadoaMapear);
		return nuevoEstado;
	}
	
	public void EstadosMapper(List<EstadoSolicitudDto> EstadoDTO, List<EstadoSolicitud> EstadoEntidades) {
		
		for(EstadoSolicitud Estado : EstadoEntidades) {
			EstadoSolicitudDto EstadoAux = new EstadoSolicitudDto();
			
			EstadoAux.setEstadoSolicitudId(Estado.getEstadoSolicitud_Id());
			EstadoAux.setEstado(Estado.getEstado());
			EstadoAux.setDescripcion(Estado.getDescripcion());
			
			EstadoDTO.add(EstadoAux);
			
		}
		
	}
	
	public EstadoSolicitudDto mapperADto(EstadoSolicitud EstadoEntidad) {
		EstadoSolicitudDto Auxiliar = new EstadoSolicitudDto();
		
		Auxiliar.setEstadoSolicitudId(EstadoEntidad.getEstadoSolicitud_Id());
		Auxiliar.setEstado(EstadoEntidad.getEstado());
		Auxiliar.setDescripcion(EstadoEntidad.getDescripcion());
		
		return Auxiliar;
	}

}
