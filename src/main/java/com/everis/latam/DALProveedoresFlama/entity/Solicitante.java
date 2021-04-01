package com.everis.latam.DALProveedoresFlama.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table (name = "solicitante")
public class Solicitante {
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int solicitante_Id;
	private String solicitante_Nombre;
	private String solicitante_Email;
	private String solicitante_Cargo;
	private String aprovador_Id;
	private String aprovador_Nombre;
}
