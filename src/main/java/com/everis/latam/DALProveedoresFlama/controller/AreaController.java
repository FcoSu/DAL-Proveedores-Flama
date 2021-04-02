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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.everis.latam.DALProveedoresFlama.dto.AreaDto;
import com.everis.latam.DALProveedoresFlama.service.AreaService;
import com.everis.latam.DALProveedoresFlama.service.implement.AreaServiceImplement;
import com.everis.latam.DALProveedoresFlama.URLs.URLs;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/area")
public class AreaController {

	@Autowired
	private AreaService areaService;

	@RequestMapping(value = URLs.AreaInsert, method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<Object> getData(@RequestBody AreaDto area) {
		AreaDto areaDTO = new AreaDto();
		AreaDto Response = new AreaDto();
		areaDTO = area;
		log.info("mapeo completo");
		try {

			Response = areaService.save(areaDTO);
			return new ResponseEntity<Object>(Response, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(Response, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(value = URLs.AreaList)
	public ResponseEntity<List<AreaDto>> ObtenerListaAreas() {
		List<AreaDto> listaAreas = new ArrayList<>();
		try {
			listaAreas = areaService.ListarAreas();
			return new ResponseEntity<>(listaAreas, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(listaAreas, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(value = URLs.AreaSearch)
	public ResponseEntity<AreaDto> ObtenerAreaPorId(@RequestParam("id") int ID) {
		AreaDto AreaEncontrada = new AreaDto();
		try {
			AreaEncontrada = areaService.BuscarPorId(ID);

			return new ResponseEntity<>(AreaEncontrada, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(AreaEncontrada, HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/AreaSaveimpl")
	public void Insertar(@RequestBody AreaDto AreaDTO) {
		areaService.save(AreaDTO);

	}
}
