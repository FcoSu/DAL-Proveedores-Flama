package com.everis.latam.DALProveedoresFlama.dto;

import lombok.Data;

@Data
public class CentroCostoDto {
	
	
	private Integer centroId;
	private Integer aprovadorId;
	private String centroNombre;
	private Integer montoMaximo;
	private String moneda;

}
