package com.everis.latam.DALProveedoresFlama.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.everis.latam.DALProveedoresFlama.URLs.URLs;
import com.everis.latam.DALProveedoresFlama.dto.WaiverDto;
import com.everis.latam.DALProveedoresFlama.service.WaiverService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/Waiver")
public class WaiverController {
	
	@Autowired
	WaiverService waiverServicio;
	
	@GetMapping(value = URLs.WaiverSearch)
	public ResponseEntity<WaiverDto> BuscarWaiverPorId(@RequestParam("id") String IDAprovador ){
		WaiverDto WaiverEncontrado = new WaiverDto();
		try {
			WaiverEncontrado = waiverServicio.BuscarWaiverPorId(IDAprovador);
			log.info("Procedimiento correcto en WaiverController, metodo: BuscarWaiverPorId");
			return new ResponseEntity<>(WaiverEncontrado,HttpStatus.OK);
		} catch (Exception e) {
			log.error("Error en WaiverController, metodo: BuscarWaiverPorId");
			return new ResponseEntity<>(WaiverEncontrado,HttpStatus.BAD_REQUEST);
		}
		
		
	}

}
