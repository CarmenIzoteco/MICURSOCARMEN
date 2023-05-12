package com.mx.proyecto.Repositories;

import java.util.List;

import com.mx.proyecto.Dto.Alumnos;

public interface RepositoryPrincipal {
	
	List<Alumnos> getAlumno();
	int contarAlumnosNuevos();
	int insertAlumno(Alumnos nuevoAlumno);

}
