package com.everis.latam.DALProveedoresFlama.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.latam.DALProveedoresFlama.dto.SolicitanteDto;
import com.everis.latam.DALProveedoresFlama.entity.Solicitante;
import com.everis.latam.DALProveedoresFlama.repository.SolicitanteRepository;
import com.everis.latam.DALProveedoresFlama.service.SolicitanteService;

@Service
public class SolicitanteServiceImplement implements SolicitanteService {
	
	@Autowired
	SolicitanteRepository solicitanteRepository;

	@Override
	public SolicitanteDto save(SolicitanteDto solicitanteAIngresar) {
		Solicitante SolicitanteEntidad = new Solicitante();
		SolicitanteDto Respuesta = new SolicitanteDto();
		SolicitanteEntidad = MapeoAEntidad(solicitanteAIngresar);
		solicitanteRepository.save(SolicitanteEntidad);
		Respuesta = MapeoADto(SolicitanteEntidad);
		return Respuesta;
	}

	@Override
	public SolicitanteDto BuscarSolicitantePorId(int Id) {
		SolicitanteDto Respuesta = new SolicitanteDto();
		Solicitante buscar = new Solicitante();
		try {
			buscar = solicitanteRepository.BuscarSolicitantePorId(Id);
			Respuesta = MapeoADto(buscar);
			return Respuesta;
		} catch (Exception e) {
			return Respuesta;
		}
		
	}

	
	public SolicitanteDto MapeoADto(Solicitante EntidadSolicitante) {
		SolicitanteDto auxiliar = new SolicitanteDto();
		
		auxiliar.setSolicitanteId(EntidadSolicitante.getSolicitante_Id());
		auxiliar.setSolicitanteNombre(EntidadSolicitante.getSolicitante_Nombre());
		auxiliar.setSolicitanteCargo(EntidadSolicitante.getSolicitante_Cargo());
		auxiliar.setSolicitanteEmail(EntidadSolicitante.getSolicitante_Email());
		auxiliar.setAprovadorId(EntidadSolicitante.getAprovador_Id());
		auxiliar.setAprovadorNombre(EntidadSolicitante.getAprovador_Nombre());
		
		return auxiliar;
		
	}
	
	public Solicitante MapeoAEntidad (SolicitanteDto SolicitanteDTO) {
		Solicitante auxiliar = new Solicitante();
		
		auxiliar.setSolicitante_Id(SolicitanteDTO.getSolicitanteId());
		auxiliar.setSolicitante_Nombre(SolicitanteDTO.getSolicitanteNombre());
		auxiliar.setSolicitante_Cargo(SolicitanteDTO.getSolicitanteCargo());
		auxiliar.setSolicitante_Email(SolicitanteDTO.getSolicitanteEmail());
		auxiliar.setAprovador_Id(SolicitanteDTO.getAprovadorId());
		auxiliar.setAprovador_Nombre(SolicitanteDTO.getAprovadorNombre());
		
		return auxiliar;
	}
}
