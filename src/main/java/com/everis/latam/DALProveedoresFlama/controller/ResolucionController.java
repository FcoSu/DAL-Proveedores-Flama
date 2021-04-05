package com.everis.latam.DALProveedoresFlama.controller;

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
import com.everis.latam.DALProveedoresFlama.dto.ResolucionDto;
import com.everis.latam.DALProveedoresFlama.service.ResolucionService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
@RequestMapping("/Resolucion")
public class ResolucionController {
	
	@Autowired
	ResolucionService resolucionService;
	
	@PostMapping (value= URLs.ResolucionInsert)
	public ResponseEntity<ResolucionDto> ResolucionIgresar(@RequestBody ResolucionDto ResolucionDTO){
		ResolucionDto ResolucionIngreso = new ResolucionDto();
		ResolucionDto Response = new ResolucionDto();
		ResolucionIngreso = ResolucionDTO;
		
		try {
			Response = resolucionService.save(ResolucionIngreso);
			log.info("Procedimiento correcto en ResolucionController, metodo: ResolucionIgresar");
			return new ResponseEntity<>(Response, HttpStatus.OK);
		} catch (Exception e) {
			log.error("Error en ResolucionController, metodo: ResolucionIgresar");
			return new ResponseEntity<>(Response, HttpStatus.BAD_REQUEST);

		}
		
	}
	
	@GetMapping(value = URLs.ResolucionSearch)
	public ResponseEntity<ResolucionDto> ResolucionBuscarPorId(@RequestParam("id") int ID){
		ResolucionDto Respuesta = new ResolucionDto();
		try {
			Respuesta = resolucionService.BuscarPorId(ID);
			log.info("Procedimiento correcto en ResolucionController, metodo: ResolucionBuscarPorId");
			return new ResponseEntity<ResolucionDto>(Respuesta, HttpStatus.OK);
		} catch (Exception e) {
			log.error("Error en ResolucionController, metodo: ResolucionBuscarPorId");
			return new ResponseEntity<ResolucionDto>(Respuesta, HttpStatus.BAD_REQUEST);
			
		}
		
	}
	

}
