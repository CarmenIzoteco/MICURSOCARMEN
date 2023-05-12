package com.mx.proyecto.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.proyecto.Dto.Ventas;
import com.mx.proyecto.Repositories.RepositoryVentas;


//TODA LA LOGICA DEL NEGOCIO
//IMPLEMENTACIÓN DEL SERVICIO
//OPERACIONES CON DATOS
//VALIDACIONES
//LLENADO DE INFORMACION
@Service
public class ServiceVentasImpl implements ServiceVentas{

	@Autowired
	private RepositoryVentas repositoryVentas;
	
	
	public List<Ventas> getVentas() {
		// TODO Auto-generated method stub
		return repositoryVentas.getVenta();
	}

	public int contarVentasNuevos() {
	
		System.out.println("LLEGANDO AL METODO contarVentasNuevos DE LA CLASE IMPLEMENTACIÓN DEL SERVICIO");
		return repositoryVentas.contarVentasNuevos();
	}

	public String insertVentas(Ventas nuevoVenta) {
		int respuesta= repositoryVentas.insertVentas(nuevoVenta);
		
		String respuestaFinal = "";
		// SI LA VARIABLE RESPUESTA ES IGUAL A 1
		if(respuesta==1) {
			respuestaFinal = "¡Se Inserto correctamente!";
		}
		//si no
		else {
			respuestaFinal = "¡No se inserto correctamente!";
		}
		return respuestaFinal;
	}
	
public String updateVentas(Ventas Venta) {
		int respuesta= repositoryVentas.updateVentas(Venta);
		
		String respuestaFinal = "";
		// SI LA VARIABLE RESPUESTA ES IGUAL A 1
		if(respuesta==1) {
			respuestaFinal ="¡Se actualizo correctamente!";
		}
		//si no
		else {
			respuestaFinal="¡No se actualizo correctamente!";
		}
		return respuestaFinal;
	}

public String deleteVentas(Ventas Venta) {
	int respuesta= repositoryVentas.deleteVentas(Venta);
	
	String respuestaFinal="";
	// SI LA VARIABLE RESPUESTA ES IGUAL A 1
	if(respuesta==1) {
		respuestaFinal= "¡SE ELIMINO CORRECTAMENTE!";
	}
	//si no
	else {
		respuestaFinal= "¡EL USUARIO NO EXISTE EN LA BASE DE DATOS";
	}
	return respuestaFinal;
}
}



