package com.everis.latam.DALProveedoresFlama.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



import lombok.Data;

@Data
//@AllArgsConstructor
@Entity
@Table(name = "area")
public class Area {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer area_Id;
	
	private String area_Nombre;
	private String area_Responsable;
	private String area_Email;
	private String area_Ceco;
}
