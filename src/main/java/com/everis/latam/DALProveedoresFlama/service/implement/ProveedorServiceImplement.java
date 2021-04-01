package com.everis.latam.DALProveedoresFlama.service.implement;

import java.util.List;

import org.springframework.stereotype.Service;

import com.everis.latam.DALProveedoresFlama.dto.ProveedorDto;
import com.everis.latam.DALProveedoresFlama.entity.Proveedor;
import com.everis.latam.DALProveedoresFlama.service.ProveedorService;



@Service
public class ProveedorServiceImplement implements ProveedorService{

	@Override
	public List<ProveedorDto> ListarProveedor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProveedorDto save(ProveedorDto proveedor) {
		ProveedorDto Respuesta = new ProveedorDto();
		Proveedor Entidad = new Proveedor();
		Entidad = MapeoAEntidad(proveedor);
		
		return null;
	}

	@Override
	public ProveedorDto BuscarProveedorPorID(String Id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	public Proveedor MapeoAEntidad(ProveedorDto proveedorAMapear) {
		Proveedor Auxiliar = new Proveedor();
		
		Auxiliar.setProveedor_Id(proveedorAMapear.getProveedorId());
		Auxiliar.setProveedor_Nombre(proveedorAMapear.getProveedorNombre());
		Auxiliar.setProveedor_Rut(proveedorAMapear.getProveedorRut());
		Auxiliar.setProveedor_RazonSocial(proveedorAMapear.getProveedorRazonSocial());
		Auxiliar.setProveedor_Email(proveedorAMapear.getProveedorEmail());
		
		return Auxiliar;
	}
}
