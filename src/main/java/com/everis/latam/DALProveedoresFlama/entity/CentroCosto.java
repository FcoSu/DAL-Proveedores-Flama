package com.everis.latam.DALProveedoresFlama.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table (name = "centrodeCosto")
public class CentroCosto {
	
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer centro_Id;
	
	private Integer aprovador_Id;
	private String centro_Nombre;
	private Integer monto_Maximo;
	private String moneda;
	


}
