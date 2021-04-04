package com.everis.latam.DALProveedoresFlama.service.implement;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.latam.DALProveedoresFlama.dto.SolicitudDto;
import com.everis.latam.DALProveedoresFlama.entity.Solicitud;
import com.everis.latam.DALProveedoresFlama.repository.SolicitudRepository;
import com.everis.latam.DALProveedoresFlama.service.SolicitudService;

@Service
public class SolicitudServiceImplement implements SolicitudService {
	
	@Autowired
	SolicitudRepository solicitudRepository;

	@Override
	public SolicitudDto save(SolicitudDto solicitudAIngresar) {
		SolicitudDto SolicitudGuardar = new SolicitudDto();
		SolicitudDto respuesta = new SolicitudDto();
		Solicitud entidad= new Solicitud();
		
		try {
			SolicitudGuardar = solicitudAIngresar;
			entidad = MapeoAEntidad(SolicitudGuardar);
			solicitudRepository.save(entidad);
			respuesta = MapeoADTO(entidad);
			return respuesta;
		} catch (Exception e) {
			return respuesta;
		}
	}
	
	
	@Override
	public List<SolicitudDto> ListarSolicitudes() {
		List<Solicitud> Mapear = new ArrayList<>();
		List<SolicitudDto> Respuesta = new ArrayList<>();
		try {
		Mapear = solicitudRepository.ListarSolicitudes();
		MapeoSolicitudes(Respuesta, Mapear);
		return Respuesta;
		}catch(Exception e) {
		return Respuesta;
		}
	}
	
	@Override
	public List<SolicitudDto> ListarSolicitudesPorFecha() {
		List<Solicitud> MapearPorFecha = new ArrayList<>();
		List<SolicitudDto> RespuestaPorFecha = new ArrayList<>();
		try {
		MapearPorFecha = solicitudRepository.ListarSolicitudesPorFecha();
		System.out.println(MapearPorFecha);
		MapeoSolicitudes(RespuestaPorFecha, MapearPorFecha);
		return RespuestaPorFecha;
		}catch(Exception e) {
		return RespuestaPorFecha;
		}
	}
	
	
	@Override
	public SolicitudDto BuscarSolicitudPorId(int idBuscar) {
		SolicitudDto respuesta = new SolicitudDto();
		Solicitud solicitudEncontrada = new Solicitud();
		try {
		solicitudEncontrada = solicitudRepository.BuscarSolictudPorId(idBuscar);
		respuesta = MapeoADTO(solicitudEncontrada);
		return respuesta;
		}catch (Exception e) {
			return respuesta;
		}
	}
	
	

	@Override
	public SolicitudDto ModificarSolicitud(int idBuscar, int estadoNuevo) {
		SolicitudDto respuesta = new SolicitudDto();
		
		System.out.println("Datos a enviar: id: "+ idBuscar+"  nuevo estado: "+ estadoNuevo);
		try {
			System.out.println("stry");
			respuesta = MapeoADTO(solicitudRepository.BuscarSolictudPorId(idBuscar));
			respuesta.setEstadoSolicitudId(estadoNuevo);
			solicitudRepository.save(MapeoAEntidad(respuesta));
			System.out.println(respuesta);
			
			return respuesta;
		} catch (Exception e) {
			return respuesta;
		}
		
	}
	
	
	

	public Solicitud MapeoAEntidad(SolicitudDto solicitudDTO) {
		Solicitud auxiliar = new Solicitud();
		
		auxiliar.setSolicitud_Id(solicitudDTO.getSolicitudId());
		auxiliar.setProveedor_id_Registro(solicitudDTO.getProveedorIdRegistro());
		auxiliar.setArea_Id(solicitudDTO.getAreaId());
		auxiliar.setCentro_Id(solicitudDTO.getCentroId());
		auxiliar.setSolicitante_Id(solicitudDTO.getSolicitanteId());
		auxiliar.setEstadoSolicitud_Id(solicitudDTO.getEstadoSolicitudId());
		auxiliar.setSolicitud_Numero(solicitudDTO.getNumero());
		auxiliar.setSolicitud_Monto(solicitudDTO.getMonto());
		auxiliar.setSolicitud_Iva(solicitudDTO.getIva());
		auxiliar.setSolicitud_Prioridad(solicitudDTO.getPrioridad());
		auxiliar.setSolicitud_Descripcion(solicitudDTO.getDescripcion());
		
		
		return auxiliar;
	}
	
	public void MapeoSolicitudes(List<SolicitudDto> Respuesta, List<Solicitud> Mapear) {
		for(Solicitud mapper:Mapear) {
			SolicitudDto objetoMapeo = new SolicitudDto();
			
			objetoMapeo.setSolicitudId(mapper.getSolicitud_Id());
			objetoMapeo.setProveedorIdRegistro(mapper.getProveedor_id_Registro());
			objetoMapeo.setAreaId(mapper.getArea_Id());
			objetoMapeo.setCentroId(mapper.getCentro_Id());
			objetoMapeo.setSolicitanteId(mapper.getSolicitante_Id());
			objetoMapeo.setEstadoSolicitudId(mapper.getSolicitud_Id());
			objetoMapeo.setNumero(mapper.getSolicitud_Numero());
			objetoMapeo.setMonto(mapper.getSolicitud_Monto());
			objetoMapeo.setIva(mapper.getSolicitud_Iva());
			objetoMapeo.setPrioridad(mapper.getSolicitud_Prioridad());
			objetoMapeo.setDescripcion(mapper.getSolicitud_Descripcion());
			
			Respuesta.add(objetoMapeo);
			
			
		}
		
	}
	
	public SolicitudDto MapeoADTO(Solicitud Mapear) {
		SolicitudDto auxiliar = new SolicitudDto();
		
		auxiliar.setSolicitudId(Mapear.getSolicitud_Id());
		auxiliar.setProveedorIdRegistro(Mapear.getProveedor_id_Registro());
		auxiliar.setAreaId(Mapear.getArea_Id());
		auxiliar.setCentroId(Mapear.getCentro_Id());
		auxiliar.setSolicitanteId(Mapear.getSolicitante_Id());
		auxiliar.setEstadoSolicitudId(Mapear.getSolicitud_Id());
		auxiliar.setNumero(Mapear.getSolicitud_Numero());
		auxiliar.setMonto(Mapear.getSolicitud_Monto());
		auxiliar.setIva(Mapear.getSolicitud_Iva());
		auxiliar.setPrioridad(Mapear.getSolicitud_Prioridad());
		auxiliar.setDescripcion(Mapear.getSolicitud_Descripcion());
		
		return auxiliar;
	}


	




	



	
}
