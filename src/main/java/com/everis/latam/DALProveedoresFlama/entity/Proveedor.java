package com.everis.latam.DALProveedoresFlama.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table (name = "proveedor")
public class Proveedor {

	@Id
	private int proveedor_Id;
	private String proveedor_Nombre;
	private String proveedor_Rut;
	private String proveedor_RazonSocial;
	private String proveedor_Email;
}
