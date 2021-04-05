package com.everis.latam.DALProveedoresFlama.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.everis.latam.DALProveedoresFlama.URLs.URLs;
import com.everis.latam.DALProveedoresFlama.dto.EstadoSolicitudDto;
import com.everis.latam.DALProveedoresFlama.service.EstadoSolicitudService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
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
		log.info("Procedimiento correcto en EstadoSolicitudController, metodo: EstadoSolicitudListar");
		return new ResponseEntity<>(EstadoDTO,HttpStatus.OK);
		}catch(Exception e) {
			log.info("ERROR en EstadoSolicitudController, metodo: EstadoSolicitudListar");
			return new ResponseEntity<>(EstadoDTO,HttpStatus.BAD_REQUEST);
		}
		
		
	}
	@GetMapping(value = URLs.EstadoSolicitudSearch)
	public ResponseEntity<Object> EstadoSolicitudBuscarPorId(@RequestParam("id") int ID){
		EstadoSolicitudDto EstadoEncontrado =  new EstadoSolicitudDto();
		try {
			EstadoEncontrado = EstadoService.BuscarEstadoPorId(ID);
			log.info("Procedimiento correcto en EstadoSolicitudController, metodo: EstadoSolicitudBuscarPorId");
			return new ResponseEntity<>(EstadoEncontrado, HttpStatus.OK);
		}catch (Exception e) {
			log.info("ERROR en EstadoSolicitudController, metodo: EstadoSolicitudBuscarPorId");
			return new ResponseEntity<>(EstadoEncontrado, HttpStatus.BAD_REQUEST);
		}
		
	}
}
