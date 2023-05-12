package com.mx.proyecto.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.proyecto.Dto.Comprador;
import com.mx.proyecto.Repositories.RepositoryComprador;


//TODA LA LOGICA DEL NEGOCIO
//IMPLEMENTACIÓN DEL SERVICIO
//OPERACIONES CON DATOS
//VALIDACIONES
//LLENADO DE INFORMACION
@Service
public class ServiceCompradorImpl implements ServiceComprador{

	@Autowired
	private RepositoryComprador repositoryComprador;
	
	
	public List<Comprador> getComprador() {
		// TODO Auto-generated method stub
		return repositoryComprador.getCompradores();
	}

	public int contarCompradorNuevos() {
	
		System.out.println("LLEGANDO AL METODO contarCompradorNuevos DE LA CLASE IMPLEMENTACIÓN DEL SERVICIO");
		return repositoryComprador.contarCompradorNuevos();
	}

	public String insertCompradores(Comprador nuevoCompradores) {
		int respuesta= repositoryComprador.insertComprador(nuevoCompradores);
		
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
	
public String updateCompradores(Comprador Compradores) {
		int respuesta= repositoryComprador.updateComprador(Compradores);
		
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

public String deleteCompradores(Comprador Compradores) {
	int respuesta= repositoryComprador.deleteComprador(Compradores);
	
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

