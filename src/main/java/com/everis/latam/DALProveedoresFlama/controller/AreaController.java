package com.everis.latam.DALProveedoresFlama.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.everis.latam.DALProveedoresFlama.dto.AreaDto;
import com.everis.latam.DALProveedoresFlama.service.AreaService;
import com.everis.latam.DALProveedoresFlama.service.implement.AreaServiceImplement;

@RestController
@RequestMapping("/area")
public class AreaController {
	
	
	@Autowired
	private AreaService areaService;

	
	
	@RequestMapping(value = "/areaSave", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<Object> getData(@RequestBody AreaDto area) {
		try {
		 areaService.save(area);
			
			System.out.println("area: "+ area);
			return new ResponseEntity<Object>(area, HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<Object>(area, HttpStatus.BAD_REQUEST);
		}
	}
	//@PostMapping("/AreaSaveimpl")
	//public void Insertar(@RequestBody AreaDto AreaDTO) {
	//	areaService.Guardar(AreaDTO);
		
//	}
}
