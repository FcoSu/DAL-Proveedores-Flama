package com.everis.latam.DALProveedoresFlama.dto;

import java.util.Date;

import lombok.Data;

@Data
public class ResolucionDto {
	
	private int resolucionId;
	private int solicitudId;
	private	int	montoTotal;
	private String	resolucionComentario;
	private	Date resolucionFecha;
}
