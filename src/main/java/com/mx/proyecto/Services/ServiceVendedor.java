package com.mx.proyecto.Services;

import java.util.List;
import com.mx.proyecto.Dto.Vendedor;


public interface ServiceVendedor {

	List<Vendedor> getVendedor();
	int contarVendedorNuevos();
	String insertVendedorr(Vendedor nuevoVendedorr);
	String updateVendedorr(Vendedor Vendedorr);
	String deleteVendedorr(Vendedor Vendedorr);
}
