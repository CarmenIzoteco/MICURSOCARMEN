package com.mx.proyecto.Services;

	import java.util.List;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

import com.mx.proyecto.Dto.RolesDTO;
import com.mx.proyecto.Entities.Roles;
import com.mx.proyecto.Repositories.RolesDAO;


	//TODA LA LOGICA DEL NEGOCIO
	//IMPLEMENTACIÓN DEL SERVICIO
	//OPERACIONES CON DATOS
	//VALIDACIONES
	//LLENADO DE INFORMACION
	@Service
		public class RolesServiceImpl implements RolesService{
		@Autowired
		private RolesDAO rolesDAO;
		@Override
		public List<Roles> getUsuario(){
			List<Roles> listaUsuario= rolesDAO.obtieneUsuarios();
			return listaUsuario;
	}
		
		
		@Override
		public String agregarNuevoRol(RolesDTO nuevoRol) {
			Roles datoAInsertar=new Roles(); //declarar  un nuevo obj vacio
			datoAInsertar.setIdRol(nuevoRol.getIdRol());
			datoAInsertar.setNombre(nuevoRol.getNombre());
			datoAInsertar.setDescripcion(nuevoRol.getDescripcion());
			
			//al final en esta posicion el objeto--> datos a insertar tiene toda la informacion  a insertar en la
			//tabla
			Integer res=rolesDAO.insertarUsuario(datoAInsertar);
			String resInsert;
			if(res ==1) {
				resInsert="Se inserto correctamente el registro";
			}else {
				resInsert="No se inserto el registro";
			}
			
			return resInsert;
		}
		
		
		@Override
		public String eliminaUsuario(RolesDTO idRol) {
			
			Integer respuesta=rolesDAO.eliminaRegistro(idRol.getIdRol());
			String resDelete;
			
			if(respuesta ==1) {
				resDelete= "Registro eliminado";
			}else {
				resDelete="Error al eliminar";
			}
			return resDelete;	
		}
		
		
		@Override
		public String actualizaUsuario(Roles datos) {
			Integer respuesta =rolesDAO.actualizarUsuario(datos);
			String resUpdate;
			
			if(respuesta ==1) {
				resUpdate="Usuario Actualizado";
			}else {
				resUpdate="El usuario no se Actualizo";
			}
			
			return resUpdate;
			
		}
		}
	
		