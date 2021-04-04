package com.everis.latam.DALProveedoresFlama.dto;

import lombok.Data;

@Data
public class SolicitanteDto {
	
	private int solicitanteId;
	private String nombreSolicitante;
	private String email;
	private String cargo;
	private String idAprobador;
	private String aprovador;
}
