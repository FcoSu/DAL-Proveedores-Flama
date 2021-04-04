package com.everis.latam.DALProveedoresFlama.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.latam.DALProveedoresFlama.dto.WaiverDto;
import com.everis.latam.DALProveedoresFlama.entity.Waiver;
import com.everis.latam.DALProveedoresFlama.repository.WaiverRepository;
import com.everis.latam.DALProveedoresFlama.service.WaiverService;

@Service
public class WaiverServiceImplement implements WaiverService {
	
	@Autowired
	WaiverRepository repositorio;

	@Override
	public WaiverDto BuscarWaiverPorId(String iDAprovador) {
		WaiverDto waiverEncontrado = new WaiverDto();
		Waiver entidad = new Waiver();
		try {
			entidad = repositorio.BuscarWaiverPorId(iDAprovador);
			waiverEncontrado = MapeoADto(entidad);
			return waiverEncontrado;
		} catch (Exception e) {
			return waiverEncontrado;
		}
		
	}
	
	public WaiverDto MapeoADto(Waiver entidad) {
		WaiverDto auxiliar = new WaiverDto();
		auxiliar.setIdAprobador(entidad.getAprovador_Id());
		auxiliar.setNombreArea(entidad.getArea_Nombre());
		auxiliar.setWaiver(entidad.getWaiver());
		
		return auxiliar;
	}

}
