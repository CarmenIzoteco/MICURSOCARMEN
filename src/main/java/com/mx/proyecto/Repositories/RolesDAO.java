package com.mx.proyecto.Repositories;

	import java.util.List;

import com.mx.proyecto.Entities.Roles;

	public interface RolesDAO {
			List<Roles> obtieneUsuarios();
			Integer insertarUsuario(Roles datoAInsertar);
			Integer eliminaRegistro(Long IdRol);
			Integer actualizarUsuario(Roles datos);
		}
