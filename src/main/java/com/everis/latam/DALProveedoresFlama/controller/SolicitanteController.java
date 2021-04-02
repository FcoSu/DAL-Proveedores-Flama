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
import com.everis.latam.DALProveedoresFlama.dto.SolicitanteDto;
import com.everis.latam.DALProveedoresFlama.service.SolicitanteService;

@RestController
@RequestMapping("/Solicitante")
public class SolicitanteController {
	
	@Autowired
	SolicitanteService solicitanteService;
	
	@PostMapping(value = URLs.SolicitanteInsert)
	public ResponseEntity<SolicitanteDto> IngresarSolicitante(@RequestBody SolicitanteDto SolicitanteDTO){
		SolicitanteDto SolicitanteAIngresar = new SolicitanteDto();
		SolicitanteDto Response = new SolicitanteDto();
		
		SolicitanteAIngresar = SolicitanteDTO;
		try {
			Response = solicitanteService.save(SolicitanteAIngresar);
			return new ResponseEntity<>(Response, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(Response, HttpStatus.BAD_REQUEST);
		}
		
	}
	@GetMapping(value = URLs.SolicitanteSearch)
	public ResponseEntity<SolicitanteDto> BuscarSolicitantePorId(@RequestParam("id") int ID){
		SolicitanteDto SolicitanteRespuesta = new SolicitanteDto();
		try {
			SolicitanteRespuesta = solicitanteService.BuscarSolicitantePorId(ID);
			return new ResponseEntity<>(SolicitanteRespuesta, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(SolicitanteRespuesta, HttpStatus.OK);

		}
		
	}

}
