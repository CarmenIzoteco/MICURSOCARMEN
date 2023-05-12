package com.mx.proyecto.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.proyecto.Dto.Vendedor;
import com.mx.proyecto.Repositories.RepositoryVendedor;

//TODA LA LOGICA DEL NEGOCIO
//IMPLEMENTACIÓN DEL SERVICIO
//OPERACIONES CON DATOS
//VALIDACIONES
//LLENADO DE INFORMACION
@Service
public class ServiceVendedorImpl implements ServiceVendedor{

	@Autowired
	private RepositoryVendedor repositoryVendedor;
	
	
	public List<Vendedor> getVendedor() {
		// TODO Auto-generated method stub
		return repositoryVendedor.getVendedorr();
	}

	public int contarVendedorNuevos() {
	
		System.out.println("LLEGANDO AL METODO contarVendedorNuevos DE LA CLASE IMPLEMENTACIÓN DEL SERVICIO");
		return repositoryVendedor.contarVendedorNuevos();
	}

	public String insertVendedorr(Vendedor nuevoVendedorr) {
		String respuestaFinal = "";
		if(nuevoVendedorr.getEdad()>999 || nuevoVendedorr.getEdad()<1) {
respuestaFinal="LA EDAD ES MAYOR A 999 O ES MENOR A CERO, NO SE PUEDE INSERTAR EL REGISTRO";
		}
		else {
			int respuesta= repositoryVendedor.insertVendedor(nuevoVendedorr);
			
			// SI LA VARIABLE RESPUESTA ES IGUAL A 1
			if(respuesta==1) {
				respuestaFinal = "¡Se Inserto correctamente!";
			}
			//si no
			else {
				respuestaFinal = "¡No se inserto correctamente!";
			}
		}
		
		
		return respuestaFinal;
	}
	
public String updateVendedorr(Vendedor Vendedorr) {
		int respuesta= repositoryVendedor.updateVendedor(Vendedorr);
		
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

	public String deleteVendedorr(Vendedor Vendedorr) {
		int respuesta= repositoryVendedor.deleteVendedor(Vendedorr);
		
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


