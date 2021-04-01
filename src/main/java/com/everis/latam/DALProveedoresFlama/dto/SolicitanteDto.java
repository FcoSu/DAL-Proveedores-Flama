package com.everis.latam.DALProveedoresFlama.dto;

import lombok.Data;

@Data
public class SolicitanteDto {
	
	private int solicitanteId;
	private String solicitanteNombre;
	private String solicitanteEmail;
	private String solicitanteCargo;
	private String aprovadorId;
	private String aprovadorNombre;
}
