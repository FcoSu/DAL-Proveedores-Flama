package com.everis.latam.DALProveedoresFlama.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class AreaDto  {
	
	//private static final long serialVersionUID = 1L;
	
	private int areaID;
	private String areaNombre;
	private String areaResponsable;	
	private String areaEmail;
	private String areaCeco;

}
