package com.mx.proyecto.Repositories;

import java.util.List;

import com.mx.proyecto.Dto.Ventas;


public interface RepositoryVentas {
	
	List<Ventas> getVenta();
	int contarVentasNuevos();
	int insertVentas(Ventas nuevoVenta);
	int updateVentas(Ventas Venta);
	int deleteVentas(Ventas Venta);

}

