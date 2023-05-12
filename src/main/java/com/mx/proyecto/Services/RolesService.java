package com.mx.proyecto.Services;

	import java.util.List;

import com.mx.proyecto.Dto.RolesDTO;
import com.mx.proyecto.Entities.Roles;

	public interface RolesService {
		
		List<Roles> getUsuario();
		String agregarNuevoRol(RolesDTO nuevoRol);
		String eliminaUsuario(RolesDTO idRol);
		String actualizaUsuario(Roles datos);
	}


