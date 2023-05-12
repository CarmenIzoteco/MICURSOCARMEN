package com.mx.proyecto.Services;

import java.util.List;

import com.mx.proyecto.Dto.Alumnos;

public interface ServicePrincipal {

	List<Alumnos> getAlumnos();
	int contarAlumnosNuevos();
	String insertAlumno(Alumnos nuevoAlumno);
}
