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
		auxiliar.setNombreSolicitante(EntidadSolicitante.getSolicitante_Nombre());
		auxiliar.setCargo(EntidadSolicitante.getSolicitante_Cargo());
		auxiliar.setEmail(EntidadSolicitante.getSolicitante_Email());
		auxiliar.setIdAprobador(EntidadSolicitante.getAprovador_Id());
		auxiliar.setAprovador(EntidadSolicitante.getAprovador_Nombre());
		
		return auxiliar;
		
	}
	
	public Solicitante MapeoAEntidad (SolicitanteDto SolicitanteDTO) {
		Solicitante auxiliar = new Solicitante();
		
		auxiliar.setSolicitante_Id(SolicitanteDTO.getSolicitanteId());
		auxiliar.setSolicitante_Nombre(SolicitanteDTO.getNombreSolicitante());
		auxiliar.setSolicitante_Cargo(SolicitanteDTO.getCargo());
		auxiliar.setSolicitante_Email(SolicitanteDTO.getEmail());
		auxiliar.setAprovador_Id(SolicitanteDTO.getIdAprobador());
		auxiliar.setAprovador_Nombre(SolicitanteDTO.getAprovador());
		
		return auxiliar;
	}
}
