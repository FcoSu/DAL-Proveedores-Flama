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
import org.springframework.web.bind.annotation.RestController;

import com.everis.latam.DALProveedoresFlama.URLs.URLs;
import com.everis.latam.DALProveedoresFlama.dto.SolicitanteDto;
import com.everis.latam.DALProveedoresFlama.dto.SolicitudDto;
import com.everis.latam.DALProveedoresFlama.service.SolicitudService;

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
			return new ResponseEntity<>(Response, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(Response, HttpStatus.BAD_REQUEST);
		}

	}
	
	@GetMapping (value = URLs.SolicitudList)
	public ResponseEntity<List<SolicitudDto>> SolicitudesListar(){
		List<SolicitudDto> SolicitudesAListar = new ArrayList<>();
		try {
			SolicitudesAListar = solicitudService.ListarSolicitudes();
			return new ResponseEntity<>(SolicitudesAListar,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(SolicitudesAListar,HttpStatus.BAD_REQUEST);
 
		}
		
	}

}
