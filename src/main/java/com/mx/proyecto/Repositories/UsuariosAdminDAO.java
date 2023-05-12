package com.mx.proyecto.Repositories;

import java.util.List;

import com.mx.proyecto.Entities.UsuariosAdmin;

public interface UsuariosAdminDAO {
		List<UsuariosAdmin> obtieneUsuarios();
		Integer insertarUsuario(UsuariosAdmin datosAInsertar);
		Integer eliminaRegistro(Long IdUser);
		Integer actualizarUsuario(UsuariosAdmin datos);
	}



