package com.mx.proyecto.Services;

import java.util.List;

import com.mx.proyecto.Dto.Ventas;

public interface ServiceVentas {

	List<Ventas> getVentas();
	int contarVentasNuevos();
	String insertVentas(Ventas nuevoVenta);
	String updateVentas(Ventas Venta);
	String deleteVentas(Ventas Venta);
}