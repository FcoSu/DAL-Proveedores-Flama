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

import com.everis.latam.DALProveedoresFlama.service.ProveedorService;

import lombok.extern.slf4j.Slf4j;

import com.everis.latam.DALProveedoresFlama.URLs.URLs;
import com.everis.latam.DALProveedoresFlama.dto.ProveedorDto;

@Slf4j

@RestController
@RequestMapping("/Proveedor")
public class ProveedorController {
	
	@Autowired
	ProveedorService ProveedorServicio;
	
	@PostMapping(value = URLs.ProveedorInsert)
	public ResponseEntity<ProveedorDto> IngresarProveedor(@RequestBody ProveedorDto proveedor){
		ProveedorDto ProveedorAIngresar = new ProveedorDto();
		ProveedorDto Response = new ProveedorDto();
		ProveedorAIngresar = proveedor;
		log.info("Mapeo Correcto");
		try {
			
			Response = ProveedorServicio.save(ProveedorAIngresar);
			log.info("Procedimiento correcto en ProveedorController, metodo: IngresarProveedor");
			return new ResponseEntity<>(Response, HttpStatus.OK);
		}catch(Exception e) {
			log.info("Error en ProveedorController, metodo: IngresarProveedor");
			return new ResponseEntity<>(Response, HttpStatus.BAD_REQUEST);
		}
		
	
	}
	
	@GetMapping (value = URLs.ProveedorSearch)
	public ResponseEntity<ProveedorDto> ProveedorBuscarPorId(@RequestParam("id") int ID){
		ProveedorDto Respuesta = new ProveedorDto();
		
		try {
			Respuesta = ProveedorServicio.BuscarProveedorPorID(ID);
			log.info("Procedimiento correcto en ProveedorController, metodo: ProveedorBuscarPorId");
			return new ResponseEntity<>(Respuesta, HttpStatus.OK);
		} catch (Exception e) {
			log.info("Error en ProveedorController, metodo: ProveedorBuscarPorId");
			return new ResponseEntity<>(Respuesta, HttpStatus.OK);
		}
		
		
	}
	
	@GetMapping (value = URLs.ProveedorList)
	public ResponseEntity<Object> ProveedoresListar(){
		List<ProveedorDto> Respuesta = new ArrayList<>();
		
		try {
		Respuesta = ProveedorServicio.ListarProveedor();
		log.info("Procedimiento correcto en ProveedorController, metodo: ProveedoresListar");
		return new ResponseEntity<>(Respuesta, HttpStatus.OK);
		}catch(Exception e) {
			log.info("Error en ProveedorController, metodo: ProveedoresListar");
			return new ResponseEntity<>(Respuesta, HttpStatus.BAD_REQUEST);
		}
		
	}

}
