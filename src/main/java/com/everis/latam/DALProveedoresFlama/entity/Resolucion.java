package com.everis.latam.DALProveedoresFlama.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity
@Table (name = "resolucion")
public class Resolucion {
	
	@Id
	private int resolucion_Id;
	private int solicitud_Id;
	private	int	monto_Total;
	private String	resolucion_Comentario;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private	Date resolucion_Fecha;

}
