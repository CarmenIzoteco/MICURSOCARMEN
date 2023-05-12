package com.mx.proyecto.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mx.proyecto.Dto.UsuariosAdminDTO;
import com.mx.proyecto.Entities.UsuariosAdmin;
import com.mx.proyecto.Services.UsuariosAdminService;

@Controller
@RequestMapping("UsuariosAdmin")
public class UsuariosAdminController {
	//INYECCION DE DEPENDENCIAS
		//INSTANCIAR, LLAMAR O HACER USO DE UNA CLASE QUE TENGA UNA ANOTACIÓN DE SPRING, EJEMPLO:
		//@Service, @Repository, @Bean
		@Autowired
		private UsuariosAdminService usuariosAdminService;
		
		@ResponseBody //NOS PERMITE RETORNAR UNICAMENTE DATOS, Y NO UNA VISTA
	    @RequestMapping(value="/getUsuariosAdmin", method = RequestMethod.GET, produces = "application/json") //= select * from Aspirantes
		ResponseEntity <  List<UsuariosAdmin> > obtenerUsuarios(){
			final HttpHeaders httpHeaders = new HttpHeaders();
			List<UsuariosAdmin> respuesta = usuariosAdminService.getUsuarios();
			
	              httpHeaders.setContentType(MediaType.APPLICATION_JSON);
			
			return new ResponseEntity <List<UsuariosAdmin>> (respuesta, httpHeaders, HttpStatus.OK);	
	    } 
       //AGREGAR REGISTROS POR HIBERNATE
		@ResponseBody //NOS PERMITE RETORNAR UNICAMENTE DATOS, Y NO UNA VISTA
	    @RequestMapping(value="/insertarRegistros", method = RequestMethod.POST, produces = "application/json") //= select * from Aspirantes
		ResponseEntity <String > insertarNuevoUsuario(@RequestBody UsuariosAdminDTO nuevoUsuario){
			final HttpHeaders httpHeaders = new HttpHeaders();
			String respuesta = usuariosAdminService.agregarNuevoUsuario(nuevoUsuario);
			
	              httpHeaders.setContentType(MediaType.APPLICATION_JSON);
			
			return new ResponseEntity <String> (respuesta, httpHeaders, HttpStatus.OK);	
	    } 
		
		//ELIMINAR REGISTRO
		@ResponseBody //NOS PERMITE RETORNAR UNICAMENTE DATOS, Y NO UNA VISTA
	    @RequestMapping(value="/eliminarUsuario", method = RequestMethod.POST, produces = "application/json") //= select * from Aspirantes
		ResponseEntity <String > eliminarUsuario(@RequestBody UsuariosAdminDTO idUser){
			final HttpHeaders httpHeaders = new HttpHeaders();
			String respuesta = usuariosAdminService.eliminarUsuario(idUser);
			
	              httpHeaders.setContentType(MediaType.APPLICATION_JSON);
			
			return new ResponseEntity <String> (respuesta, httpHeaders, HttpStatus.OK);	
	    } 
		
		//ACTUALIZAR REGISTRO
				@ResponseBody //NOS PERMITE RETORNAR UNICAMENTE DATOS, Y NO UNA VISTA
			    @RequestMapping(value="/actualizarDatos", method = RequestMethod.POST, produces = "application/json") //= select * from Aspirantes
				ResponseEntity <String > actualizarDatosUsuario(@RequestBody UsuariosAdmin datos){
					final HttpHeaders httpHeaders = new HttpHeaders();
					String respuesta = usuariosAdminService.actualizarUsuario(datos);
					
			              httpHeaders.setContentType(MediaType.APPLICATION_JSON);
					
					return new ResponseEntity <String> (respuesta, httpHeaders, HttpStatus.OK);	
			    } 
}