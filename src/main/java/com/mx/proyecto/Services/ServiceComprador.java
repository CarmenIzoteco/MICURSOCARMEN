package com.mx.proyecto.Services;

import java.util.List;

import com.mx.proyecto.Dto.Comprador;

public interface ServiceComprador {

	List<Comprador> getComprador();
	int contarCompradorNuevos();
	String insertCompradores(Comprador nuevoCompradores);
	String updateCompradores(Comprador Compradores);
	String deleteCompradores(Comprador Compradores);
}
