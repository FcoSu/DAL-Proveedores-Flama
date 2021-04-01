package com.everis.latam.DALProveedoresFlama.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table (name = "estadoSolicitud")
public class EstadoSolicitud {

	@Id
	private int estadoSolicitud_Id;
	private String estado;
	private String descripcion;
}
