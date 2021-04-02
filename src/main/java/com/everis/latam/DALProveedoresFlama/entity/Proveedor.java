package com.everis.latam.DALProveedoresFlama.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table (name = "proveedor")
public class Proveedor {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int proveedor_id_Registro;
	
	private String proveedor_Id;
	private String proveedor_Nombre;
	private String proveedor_Rut;
	private String proveedor_Razon_Social;
	private String proveedor_Email;
}
