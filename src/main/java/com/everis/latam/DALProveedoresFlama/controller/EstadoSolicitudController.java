package com.everis.latam.DALProveedoresFlama.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.everis.latam.DALProveedoresFlama.URLs.URLs;
import com.everis.latam.DALProveedoresFlama.dto.EstadoSolicitudDto;
import com.everis.latam.DALProveedoresFlama.service.EstadoSolicitudService;

@RestController
@RequestMapping("/EstadoSolicitud")
public class EstadoSolicitudController {
	
	@Autowired
	EstadoSolicitudService EstadoService;
	
	@GetMapping(value = URLs.EstadoSolicitudList)
	public ResponseEntity<Object> EstadoSolicitudListar(){
		List<EstadoSolicitudDto> EstadoDTO = new ArrayList<>();
		try {
		EstadoDTO = EstadoService.EstadosListar();
		return new ResponseEntity<>(EstadoDTO,HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(EstadoDTO,HttpStatus.BAD_REQUEST);
		}
		
		
	}
}
