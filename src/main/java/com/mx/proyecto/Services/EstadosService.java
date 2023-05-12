package com.mx.proyecto.Services;

	import java.util.List;

import com.mx.proyecto.Dto.EstadosDTO;
import com.mx.proyecto.Entities.Estados;

	public interface EstadosService {
		
		List<Estados> getUsuario();
		String agregaNuevoUsuario(EstadosDTO nuevosUsuario);
		String eliminaUsuario(EstadosDTO idUser);
		String actualizaUsuario(Estados datos);
	}

