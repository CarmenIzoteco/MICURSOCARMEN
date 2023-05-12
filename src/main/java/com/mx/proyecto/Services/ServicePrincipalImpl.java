package com.mx.proyecto.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.proyecto.Dto.Alumnos;
import com.mx.proyecto.Repositories.RepositoryPrincipal;

//TODA LA LOGICA DEL NEGOCIO
//IMPLEMENTACIÓN DEL SERVICIO
//OPERACIONES CON DATOS
//VALIDACIONES
//LLENADO DE INFORMACION
@Service
public class ServicePrincipalImpl implements ServicePrincipal{

	@Autowired
	private RepositoryPrincipal repositoryPrincipal;
	
	
	public List<Alumnos> getAlumnos() {
		// TODO Auto-generated method stub
		return repositoryPrincipal.getAlumno();
	}

	public int contarAlumnosNuevos() {
	
		System.out.println("LLEGANDO AL METODO contarAlumnosNuevos DE LA CLASE IMPLEMENTACIÓN DEL SERVICIO");
		return repositoryPrincipal.contarAlumnosNuevos();
	}

	public String insertAlumno(Alumnos nuevoAlumno) {
		repositoryPrincipal.insertAlumno(nuevoAlumno);
		return null;
	}

}
