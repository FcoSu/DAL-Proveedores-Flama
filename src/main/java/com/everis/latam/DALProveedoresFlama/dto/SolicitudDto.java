package com.everis.latam.DALProveedoresFlama.dto;

import lombok.Data;

@Data
public class SolicitudDto {
	
	private int solicitudId;
	private	String proveedorId;
	private int areaId;
	private int centroId;
	private int solicitanteId;
	private int estadoSolicitudId;
	private int solicitudNumero;
	private int solicitudMonto;
	private float solicitudIva;
	private int solicitudPrioridad;
	private String solicitudDescripcion;

}
