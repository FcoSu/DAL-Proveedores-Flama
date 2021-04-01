package com.everis.latam.DALProveedoresFlama.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table (name = "waiver")
public class Waiver {
	
	@Id
	private String aprovador_Id;
	private String area_Nombre;
	private boolean waiver;
}
