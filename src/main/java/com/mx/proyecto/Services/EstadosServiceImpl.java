package com.mx.proyecto.Services;

	import java.util.List;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

import com.mx.proyecto.Dto.EstadosDTO;
import com.mx.proyecto.Entities.Estados;
import com.mx.proyecto.Repositories.EstadosDAO;


	//TODA LA LOGICA DEL NEGOCIO
	//IMPLEMENTACIÓN DEL SERVICIO
	//OPERACIONES CON DATOS
	//VALIDACIONES
	//LLENADO DE INFORMACION
	@Service
	public class EstadosServiceImpl  implements EstadosService{
		@Autowired
		private EstadosDAO estadosDAO;
		@Override
		public List<Estados> getUsuario(){
			List<Estados> listaUsuarios= estadosDAO.obtieneUsuario();
			return listaUsuarios;
	}
		
		
		@Override
		public String agregaNuevoUsuario (EstadosDTO nuevosUsuario) {
			Estados datoAInsertar=new Estados(); //declarar  un nuevo obj vacio
			datoAInsertar.setIdEstado(nuevosUsuario.getIdEstado());
			datoAInsertar.setNombre(nuevosUsuario.getNombre());
			datoAInsertar.setAbreviatura(nuevosUsuario.getAbreviatura());
			//al final en esta posicion el objeto--> datos a insertar tiene toda la informacion  a insertar en la
			//tabla
			Integer resp=estadosDAO.insertaUsuario(datoAInsertar);
			String respInsert;
			if(resp ==1) {
				respInsert="Se inserto correctamente el registro";
			}else {
				respInsert="No se inserto el registro";
			}
			
			return respInsert;
		}
		
		
		@Override
		public String eliminaUsuario(EstadosDTO idEstado) {
			Integer respuesta=estadosDAO.eliminarRegistro(idEstado.getIdEstado());
			String respDelete;
			if(respuesta ==1) {
				respDelete= "Registro eliminado";
			}else {
				respDelete="Error al eliminar";
			}
			return respDelete;	
		}
		
		
		@Override
		public String actualizaUsuario(Estados datos) {
			Integer respuesta =estadosDAO.actualizaUsuario(datos);
			String respUpdate;
			if(respuesta ==1) {
				respUpdate="Usuario Actualizado";
			}else {
				respUpdate="El usuario no se Actualizo";
			}
			return respUpdate;	
		}
		}
