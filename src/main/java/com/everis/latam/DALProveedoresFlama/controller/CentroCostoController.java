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

import com.everis.latam.DALProveedoresFlama.service.CentroCostoService;

import lombok.extern.slf4j.Slf4j;

import com.everis.latam.DALProveedoresFlama.URLs.URLs;
import com.everis.latam.DALProveedoresFlama.dto.CentroCostoDto;

@Slf4j
@RestController
@RequestMapping("/CentroCosto")
public class CentroCostoController {

	@Autowired
	public CentroCostoService centroService;
	
	@GetMapping(value = URLs.CentroList)
	public ResponseEntity<List<CentroCostoDto>> ListarCentrosCosto(){
		List <CentroCostoDto> centroLista = new ArrayList<>(); 
		try {
			centroLista = centroService.CentrosListar();
			log.info("Procedimiento correcto en CentroCostoController, metodo: ListarCentrosCosto");
			return new ResponseEntity<>(centroLista,HttpStatus.OK);
		}catch(Exception e) {
			log.error("ERROR en CentroCostoController metodo: ListarCentrosCosto");
			return new ResponseEntity<>(centroLista, HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@GetMapping(value = URLs.CentroSearch)
	public ResponseEntity<CentroCostoDto> BuscarCentroPorNombre(@RequestParam("nombre") String Nombre){
		CentroCostoDto CentroEncontrado = new CentroCostoDto();
		try {
			CentroEncontrado = centroService.ObtenerCentroPorNombre(Nombre);
			log.info("Procedimiento correcto en CentroCostoController, metodo: BuscarCentroPorNombre");
			return new ResponseEntity<>(CentroEncontrado,HttpStatus.OK);
		}catch(Exception e) {
			log.error("ERROR en CentroCostoController metodo: BuscarCentroPorNombre");
			return new ResponseEntity<>(CentroEncontrado,HttpStatus.BAD_REQUEST);
			
		}
		
	}
	
}
