package com.everis.latam.DALProveedoresFlama.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table (name = "solicitud")
public class Solicitud {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int solicitud_Id;
	private	int proveedor_id_Registro;
	private int area_Id;
	private int centro_Id;
	private int solicitante_Id;
	private int estadoSolicitud_Id;
	private int solicitud_Numero;
	private int solicitud_Monto;
	private float solicitud_Iva;
	private int solicitud_Prioridad;
	private String solicitud_Descripcion;
}
