package com.everis.latam.DALProveedoresFlama.service.implement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.latam.DALProveedoresFlama.dto.CentroCostoDto;
import com.everis.latam.DALProveedoresFlama.entity.CentroCosto;
import com.everis.latam.DALProveedoresFlama.service.CentroCostoService;
import com.everis.latam.DALProveedoresFlama.repository.CentroCostoRepository;


@Service
public class CentroCostoServiceImplement implements CentroCostoService {
	
	@Autowired
	CentroCostoRepository CentroRepository;

	@Override
	public List<CentroCostoDto> CentrosListar() {
		List <CentroCostoDto> Respuesta = new ArrayList<>();
		List<CentroCosto> listaEntidad = new ArrayList<>();
		try {
		listaEntidad= CentroRepository.ObtenerCentros();
		CentroMapper(Respuesta, listaEntidad);
		return Respuesta;
		}catch(Exception e) {
			return Respuesta;
		}
	}
	
	@Override
	public CentroCostoDto ObtenerCentroPorNombre(String Nombre) {
		CentroCostoDto Respuesta = new CentroCostoDto ();
		CentroCosto  centroCostoEntidad= CentroRepository.BuscarCentroPorNombre(Nombre);
		Respuesta = MapeoADto(centroCostoEntidad);
		return Respuesta;
	}
	
	
	public void CentroMapper(List<CentroCostoDto> Respuesta,List<CentroCosto> centroEntidad) {
		
		for(CentroCosto Centro:centroEntidad) {
			CentroCostoDto Auxiliar = new CentroCostoDto();
			
			Auxiliar.setCentroId(Centro.getCentro_Id());
			Auxiliar.setAprovadorId(Centro.getAprovador_Id());
			Auxiliar.setCentroNombre(Centro.getCentro_Nombre());
			Auxiliar.setMontoMaximo(Centro.getMonto_Maximo());
			Auxiliar.setMoneda(Centro.getMoneda());
			
			Respuesta.add(Auxiliar);
		}
	}
	
	public CentroCostoDto MapeoADto(CentroCosto centro) {
		CentroCostoDto Auxiliar = new CentroCostoDto ();
		Auxiliar.setCentroId(centro.getCentro_Id());
		Auxiliar.setAprovadorId(centro.getAprovador_Id());
		Auxiliar.setCentroNombre(centro.getCentro_Nombre());
		Auxiliar.setMontoMaximo(centro.getMonto_Maximo());
		Auxiliar.setMoneda(centro.getMoneda());
		
		return Auxiliar;
	}

}
