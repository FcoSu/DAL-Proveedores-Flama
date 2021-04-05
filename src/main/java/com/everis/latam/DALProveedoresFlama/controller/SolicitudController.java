package com.everis.latam.DALProveedoresFlama.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.everis.latam.DALProveedoresFlama.URLs.URLs;
import com.everis.latam.DALProveedoresFlama.dto.SolicitudDto;
import com.everis.latam.DALProveedoresFlama.service.SolicitudService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/Solicitud")
public class SolicitudController {

	@Autowired
	SolicitudService solicitudService;

	@PostMapping(value = URLs.SolicitudInsert)
	public ResponseEntity<SolicitudDto> SolicitudIngresar(@RequestBody SolicitudDto SolicitudIngreso) {
		SolicitudDto SolicitudAIngresar = new SolicitudDto();

		SolicitudDto Response = new SolicitudDto();
		try {
			SolicitudAIngresar = SolicitudIngreso;
			Response = solicitudService.save(SolicitudAIngresar);
			log.info("Procedimiento correcto en SolicitudController, metodo: SolicitudIngresar");
			return new ResponseEntity<>(Response, HttpStatus.OK);
		} catch (Exception e) {
			log.info("Error en SolicitudController, metodo: SolicitudIngresar");
			return new ResponseEntity<>(Response, HttpStatus.BAD_REQUEST);
		}

	}
	
	@GetMapping (value = URLs.SolicitudList)
	public ResponseEntity<List<SolicitudDto>> SolicitudesListar(){
		List<SolicitudDto> SolicitudesAListar = new ArrayList<>();
		try {
			log.info("Procedimiento correcto en SolicitudController, metodo: SolicitudesListar");
			SolicitudesAListar = solicitudService.ListarSolicitudes();
			return new ResponseEntity<>(SolicitudesAListar,HttpStatus.OK);
		} catch (Exception e) {
			log.info("Error en SolicitudController, metodo: SolicitudesListar");
			return new ResponseEntity<>(SolicitudesAListar,HttpStatus.BAD_REQUEST);
 
		}
		
	}
	@GetMapping (value = URLs.SolicitudSearch)
	public ResponseEntity<SolicitudDto> BuscarSolicitudPorId(@RequestParam("id") int idBuscar){
		SolicitudDto SolicitudEncontrada = new SolicitudDto();
		try {
			SolicitudEncontrada = solicitudService.BuscarSolicitudPorId(idBuscar);
			log.info("Procedimiento correcto en SolicitudController, metodo: BuscarSolicitudPorId");
			return new ResponseEntity<>(SolicitudEncontrada,HttpStatus.OK);
		} catch (Exception e) {
			log.info("Error en SolicitudController, metodo: BuscarSolicitudPorId");
			return new ResponseEntity<>(SolicitudEncontrada,HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@PostMapping (value = URLs.SolicitudUpdate)
	public ResponseEntity<SolicitudDto> ModificarEstadoSolicitud(@RequestParam ("id") int idBuscar, @RequestParam ("nuevoEstado") int EstadoNuevo){
		SolicitudDto solicitudModificada =new SolicitudDto();
		try {
			solicitudModificada = solicitudService.ModificarSolicitud(idBuscar,EstadoNuevo);
			log.info("Procedimiento correcto en SolicitudController, metodo: ModificarEstadoSolicitud");
			return new ResponseEntity<>(solicitudModificada, HttpStatus.OK);
		} catch (Exception e) {
			log.info("Error en SolicitudController, metodo: ModificarEstadoSolicitud");
			return new ResponseEntity<>(solicitudModificada, HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@GetMapping(value= URLs.SolicitudListDate)
	public ResponseEntity<List<SolicitudDto>> ListarSolicitudesPorFecha(){
		List<SolicitudDto> SolicitudesAListarPorFecha = new ArrayList<>();
		try {
			SolicitudesAListarPorFecha = solicitudService.ListarSolicitudesPorFecha();
			log.info("Procedimiento correcto en SolicitudController, metodo: ListarSolicitudesPorFecha");
			return new ResponseEntity<>(SolicitudesAListarPorFecha,HttpStatus.OK);
		} catch (Exception e) {
			log.info("Error en SolicitudController, metodo: ListarSolicitudesPorFecha");
			return new ResponseEntity<>(SolicitudesAListarPorFecha,HttpStatus.BAD_REQUEST);
 
		}
		
		
	}

}
