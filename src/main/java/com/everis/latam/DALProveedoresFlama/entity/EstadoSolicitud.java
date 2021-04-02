package com.everis.latam.DALProveedoresFlama.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table (name = "estadoSolicitud")
public class EstadoSolicitud {

	@Id
	@Column(name="estado_solicitud_Id", nullable=false)
	private int estadoSolicitud_Id;
	
	private String estado;
	private String descripcion;
}
