package com.everis.latam.DALProveedoresFlama.dto;

import javax.persistence.Id;

import lombok.Data;

@Data
public class EstadoSolicitudDto {

	
	
	private int estadoSolicitudId;
	private String estado;
	private String descripcion;
}
