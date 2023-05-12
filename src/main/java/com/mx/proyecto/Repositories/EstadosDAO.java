package com.mx.proyecto.Repositories;

	import java.util.List;

import com.mx.proyecto.Entities.Estados;

	public interface EstadosDAO {
			List<Estados> obtieneUsuario();
			Integer insertaUsuario(Estados datosAInsertar);
			Integer eliminarRegistro(Long IdEstado);
			Integer actualizaUsuario(Estados datos);
		}
