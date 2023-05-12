package com.mx.proyecto.Repositories;

import java.util.List;

import com.mx.proyecto.Dto.Vendedor;



public interface RepositoryVendedor {
	
	List<Vendedor> getVendedorr();
	int contarVendedorNuevos();
	int insertVendedor(Vendedor nuevoVendedorr);
	int updateVendedor(Vendedor Vendedorr);
	int deleteVendedor(Vendedor Vendedorr);

}
