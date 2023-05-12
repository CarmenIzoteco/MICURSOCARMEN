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

import com.mx.proyecto.Dto.RolesDTO;
import com.mx.proyecto.Entities.Roles;
import com.mx.proyecto.Services.RolesService;




	@Controller
	@RequestMapping("Rolless")
	public class RolesController {
		//INYECCION DE DEPENDENCIAS
			//INSTANCIAR, LLAMAR O HACER USO DE UNA CLASE QUE TENGA UNA ANOTACIÓN DE SPRING, EJEMPLO:
			//@Service, @Repository, @Bean
			@Autowired
			private RolesService rolesService;
			
			@ResponseBody //NOS PERMITE RETORNAR UNICAMENTE DATOS, Y NO UNA VISTA
		    @RequestMapping(value="/getRoles", method = RequestMethod.GET, produces = "application/json") //= select * from Aspirantes
			ResponseEntity <  List<Roles> > obtenerUsuarios(){
				final HttpHeaders httpHeaders = new HttpHeaders();
				List<Roles> respuesta =rolesService.getUsuario();
				
		              httpHeaders.setContentType(MediaType.APPLICATION_JSON);
				
				return new ResponseEntity <List<Roles>> (respuesta, httpHeaders, HttpStatus.OK);	
		    } 
			
			
	       //AGREGAR REGISTROS POR HIBERNATE
			@ResponseBody //NOS PERMITE RETORNAR UNICAMENTE DATOS, Y NO UNA VISTA
		    @RequestMapping(value="/insertarRol", method = RequestMethod.POST, produces = "application/json") //= select * from Aspirantes
			ResponseEntity <String > insertarNuevoRol(@RequestBody RolesDTO nuevoRol){
				final HttpHeaders httpHeaders = new HttpHeaders();
				String respuesta = rolesService.agregarNuevoRol(nuevoRol);
				
		              httpHeaders.setContentType(MediaType.APPLICATION_JSON);
				
				return new ResponseEntity <String> (respuesta, httpHeaders, HttpStatus.OK);	
		    } 
			
			
			
			//ELIMINAR REGISTRO
			@ResponseBody //NOS PERMITE RETORNAR UNICAMENTE DATOS, Y NO UNA VISTA
		    @RequestMapping(value="/eliminarRol", method = RequestMethod.POST, produces = "application/json") //= select * from Aspirantes
			ResponseEntity <String > eliminarUsuario(@RequestBody RolesDTO idRol){
				final HttpHeaders httpHeaders = new HttpHeaders();
				String respuesta = rolesService.eliminaUsuario(idRol);
				
		              httpHeaders.setContentType(MediaType.APPLICATION_JSON);
				
				return new ResponseEntity <String> (respuesta, httpHeaders, HttpStatus.OK);	
		    } 
			
			
			
			//ACTUALIZAR REGISTRO
					@ResponseBody //NOS PERMITE RETORNAR UNICAMENTE DATOS, Y NO UNA VISTA
				    @RequestMapping(value="/actualizarDatos", method = RequestMethod.POST, produces = "application/json") //= select * from Aspirantes
					ResponseEntity <String > actualizarDatosUsuario(@RequestBody Roles datos){
						final HttpHeaders httpHeaders = new HttpHeaders();
						String respuesta = rolesService.actualizaUsuario(datos);
						
				              httpHeaders.setContentType(MediaType.APPLICATION_JSON);
						
						return new ResponseEntity <String> (respuesta, httpHeaders, HttpStatus.OK);	
				    } 
	}
