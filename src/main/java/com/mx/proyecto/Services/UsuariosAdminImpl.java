package com.mx.proyecto.Services;

	import java.util.List;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

import com.mx.proyecto.Dto.UsuariosAdminDTO;
import com.mx.proyecto.Entities.UsuariosAdmin;
import com.mx.proyecto.Repositories.UsuariosAdminDAO;


	//TODA LA LOGICA DEL NEGOCIO
	//IMPLEMENTACIÓN DEL SERVICIO
	//OPERACIONES CON DATOS
	//VALIDACIONES
	//LLENADO DE INFORMACION
	@Service
		public class UsuariosAdminImpl implements UsuariosAdminService{
		@Autowired
		private UsuariosAdminDAO usuariosAdminDAO;
		@Override
		public List<UsuariosAdmin> getUsuarios(){
			List<UsuariosAdmin> listaUsuarios= usuariosAdminDAO.obtieneUsuarios();
			return listaUsuarios;
	}
		@Override
		public String agregarNuevoUsuario (UsuariosAdminDTO nuevoUsuario) {
			UsuariosAdmin datosAInsertar=new UsuariosAdmin(); //declarar  un nuevo obj vacio
			datosAInsertar.setIdUser(nuevoUsuario.getIdUser());
			datosAInsertar.setNombreCompleto(nuevoUsuario.getNombreCompleto());
			datosAInsertar.setEdad(nuevoUsuario.getEdad());
			datosAInsertar.setDireccion(nuevoUsuario.getDireccion());
			datosAInsertar.setEstado(nuevoUsuario.getEstado());
			datosAInsertar.setRol(nuevoUsuario.getRol());
			//al final en esta posicion el objeto--> datos a insertar tiene toda la informacion  a insertar en la
			//tabla
			Integer resp=usuariosAdminDAO.insertarUsuario(datosAInsertar);
			String respInsert;
			if(resp ==1) {
				respInsert="Se inserto correctamente el registro";
			}else {
				respInsert="No se inserto el registro";
			}
			
			return respInsert;
		}
		@Override
		public String eliminarUsuario(UsuariosAdminDTO idUser) {
			
			Integer respuesta=usuariosAdminDAO.eliminaRegistro(idUser.getIdUser());
			String respDelete;
			
			if(respuesta ==1) {
				respDelete= "Registro eliminado";
			}else {
				respDelete="Error al eliminar";
			}
			
			return respDelete;
			
		}
		@Override
		public String actualizarUsuario(UsuariosAdmin datos) {
			Integer respuesta =usuariosAdminDAO.actualizarUsuario(datos);
			String respUpdate;
			
			if(respuesta ==1) {
				respUpdate="Usuario Actualizado";
			}else {
				respUpdate="El usuario no se Actualizo";
			}
			
			return respUpdate;
			
		}
		}
	