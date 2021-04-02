package com.everis.latam.DALProveedoresFlama.service.implement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.latam.DALProveedoresFlama.dto.ProveedorDto;
import com.everis.latam.DALProveedoresFlama.entity.Proveedor;
import com.everis.latam.DALProveedoresFlama.repository.ProveedorRepository;
import com.everis.latam.DALProveedoresFlama.service.ProveedorService;



@Service
public class ProveedorServiceImplement implements ProveedorService{
	
	@Autowired
	ProveedorRepository proveedorRepository;
	

	@Override
	public ProveedorDto save(ProveedorDto proveedor) {
		ProveedorDto Respuesta = new ProveedorDto();
		Proveedor Entidad = new Proveedor();
		Entidad = MapeoAEntidad(proveedor);
		proveedorRepository.save(Entidad);
		
		Respuesta = MapeoADto(Entidad);
		return Respuesta;
	}
	
	@Override
	public List<ProveedorDto> ListarProveedor() {
		List<ProveedorDto> Response = new ArrayList<>();
		List<Proveedor> Mapear = proveedorRepository.ListarProveedores();
		
		MapearProveedor(Response, Mapear);
		// TODO Auto-generated method stub
		return Response;
	}


	@Override
	public ProveedorDto BuscarProveedorPorID(int Id) {
		ProveedorDto Respuesta = new ProveedorDto();
		try {
		Proveedor Entidad = proveedorRepository.BuscarProveedorPorId(Id);
		Respuesta = MapeoADto(Entidad);
		
		return Respuesta;
		}catch (Exception e) {
			return Respuesta;
		}
	}

	
	
	public Proveedor MapeoAEntidad(ProveedorDto proveedorAMapear) {
		Proveedor Auxiliar = new Proveedor();
		
		Auxiliar.setProveedor_Id(proveedorAMapear.getProveedorId());
		Auxiliar.setProveedor_Nombre(proveedorAMapear.getProveedorNombre());
		Auxiliar.setProveedor_Rut(proveedorAMapear.getProveedorRut());
		Auxiliar.setProveedor_Razon_Social(proveedorAMapear.getProveedorRazonSocial());
		Auxiliar.setProveedor_Email(proveedorAMapear.getProveedorEmail());
		
		return Auxiliar;
	}
	
	public ProveedorDto MapeoADto (Proveedor enti) {
		ProveedorDto Auxiliar = new ProveedorDto();
		
		Auxiliar.setProveedorIdRegistro(enti.getProveedor_id_Registro());
		Auxiliar.setProveedorId(enti.getProveedor_Id());
		Auxiliar.setProveedorNombre(enti.getProveedor_Nombre());
		Auxiliar.setProveedorRut(enti.getProveedor_Rut());
		Auxiliar.setProveedorRazonSocial(enti.getProveedor_Razon_Social());
		Auxiliar.setProveedorEmail(enti.getProveedor_Email());
		return Auxiliar;
	}
	
	
	private void MapearProveedor(List<ProveedorDto> response, List<Proveedor> mapear) {
		for(Proveedor mapeo: mapear) {
			ProveedorDto auxiliar = new ProveedorDto();
			
			auxiliar.setProveedorIdRegistro(mapeo.getProveedor_id_Registro());
			auxiliar.setProveedorId(mapeo.getProveedor_Id());
			auxiliar.setProveedorNombre(mapeo.getProveedor_Nombre());
			auxiliar.setProveedorRut(mapeo.getProveedor_Rut());
			auxiliar.setProveedorRazonSocial(mapeo.getProveedor_Razon_Social());
			auxiliar.setProveedorEmail(mapeo.getProveedor_Email());
			
			response.add(auxiliar);
			
			
		}
		
	}
}
