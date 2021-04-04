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
		
		Auxiliar.setProveedor_Id(proveedorAMapear.getIdProveedor());
		Auxiliar.setProveedor_Nombre(proveedorAMapear.getNombre());
		Auxiliar.setProveedor_Rut(proveedorAMapear.getRut());
		Auxiliar.setProveedor_Razon_Social(proveedorAMapear.getRazonSocial());
		Auxiliar.setProveedor_Email(proveedorAMapear.getEmail());
		
		return Auxiliar;
	}
	
	public ProveedorDto MapeoADto (Proveedor enti) {
		ProveedorDto Auxiliar = new ProveedorDto();
		
		Auxiliar.setProveedorIdRegistro(enti.getProveedor_id_Registro());
		Auxiliar.setIdProveedor(enti.getProveedor_Id());
		Auxiliar.setNombre(enti.getProveedor_Nombre());
		Auxiliar.setRut(enti.getProveedor_Rut());
		Auxiliar.setRazonSocial(enti.getProveedor_Razon_Social());
		Auxiliar.setEmail(enti.getProveedor_Email());
		return Auxiliar;
	}
	
	
	private void MapearProveedor(List<ProveedorDto> response, List<Proveedor> mapear) {
		for(Proveedor mapeo: mapear) {
			ProveedorDto auxiliar = new ProveedorDto();
			
			auxiliar.setProveedorIdRegistro(mapeo.getProveedor_id_Registro());
			auxiliar.setIdProveedor(mapeo.getProveedor_Id());
			auxiliar.setNombre(mapeo.getProveedor_Nombre());
			auxiliar.setRut(mapeo.getProveedor_Rut());
			auxiliar.setRazonSocial(mapeo.getProveedor_Razon_Social());
			auxiliar.setEmail(mapeo.getProveedor_Email());
			
			response.add(auxiliar);
			
			
		}
		
	}
}
