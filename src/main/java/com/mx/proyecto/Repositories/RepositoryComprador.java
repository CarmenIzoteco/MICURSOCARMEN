package com.mx.proyecto.Repositories;

import java.util.List;

import com.mx.proyecto.Dto.Comprador;


public interface RepositoryComprador {
	
	List<Comprador> getCompradores();
	int contarCompradorNuevos();
	int insertComprador(Comprador nuevoCompradores);
	int updateComprador(Comprador Compradores);
	int deleteComprador(Comprador Compradores);

}

