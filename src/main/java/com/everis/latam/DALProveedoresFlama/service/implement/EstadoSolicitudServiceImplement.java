package com.everis.latam.DALProveedoresFlama.service.implement;

import java.util.List;

import org.springframework.stereotype.Service;

import com.everis.latam.DALProveedoresFlama.dto.EstadoSolicitudDto;
import com.everis.latam.DALProveedoresFlama.entity.EstadoSolicitud;
import com.everis.latam.DALProveedoresFlama.service.EstadoSolicitudService;

@Service
public class EstadoSolicitudServiceImplement implements EstadoSolicitudService {

	@Override
	public List<EstadoSolicitudDto> EstadosListar() {
		
		return null;
	}

	@Override
	public EstadoSolicitudDto BuscarEstadoPorId(int Id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void EstadoMapper(List<EstadoSolicitudDto> EstadoDTO,List<EstadoSolicitud> EstadoEntidad) {
		
		
	}
	
	public EstadoSolicitudDto mapperADto(EstadoSolicitud EstadoEntidad) {
		EstadoSolicitudDto Auxiliar = new EstadoSolicitudDto();
		
		return Auxiliar;
	}

}
