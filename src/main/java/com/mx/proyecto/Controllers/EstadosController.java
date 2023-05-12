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

import com.mx.proyecto.Dto.EstadosDTO;
import com.mx.proyecto.Entities.Estados;
import com.mx.proyecto.Services.EstadosService;


@Controller
@RequestMapping("Estadoss")
public class EstadosController {
	//INYECCION DE DEPENDENCIAS
		//INSTANCIAR, LLAMAR O HACER USO DE UNA CLASE QUE TENGA UNA ANOTACIÓN DE SPRING, EJEMPLO:
		//@Service, @Repository, @Bean
		@Autowired
		private EstadosService estadosService;
		@ResponseBody //NOS PERMITE RETORNAR UNICAMENTE DATOS, Y NO UNA VISTA
	    @RequestMapping(value="/getEstados", method = RequestMethod.GET, produces = "application/json") //= select * from Aspirantes
		ResponseEntity <  List<Estados> > obtenerUsuarios(){
			final HttpHeaders httpHeaders = new HttpHeaders();
			List<Estados> respuesta = estadosService.getUsuario();
			
	              httpHeaders.setContentType(MediaType.APPLICATION_JSON);
			
			return new ResponseEntity <List<Estados>> (respuesta, httpHeaders, HttpStatus.OK);	
	    } 
		
		
       //AGREGAR REGISTROS POR HIBERNATE
		@ResponseBody //NOS PERMITE RETORNAR UNICAMENTE DATOS, Y NO UNA VISTA
	    @RequestMapping(value="/insertarRegistros", method = RequestMethod.POST, produces = "application/json") //= select * from Aspirantes
		ResponseEntity <String > insertarNuevoUsuario(@RequestBody EstadosDTO nuevosUsuario){
			final HttpHeaders httpHeaders = new HttpHeaders();
			String respuesta = estadosService.agregaNuevoUsuario(nuevosUsuario);
			
	              httpHeaders.setContentType(MediaType.APPLICATION_JSON);
			
			return new ResponseEntity <String> (respuesta, httpHeaders, HttpStatus.OK);	
	    } 
		
		
		//ELIMINAR REGISTRO
		@ResponseBody //NOS PERMITE RETORNAR UNICAMENTE DATOS, Y NO UNA VISTA
	    @RequestMapping(value="/eliminarUsuario", method = RequestMethod.POST, produces = "application/json") //= select * from Aspirantes
		ResponseEntity <String > eliminarUsuario(@RequestBody EstadosDTO idEstado){
			final HttpHeaders httpHeaders = new HttpHeaders();
			String respuesta = estadosService.eliminaUsuario(idEstado);
			
	              httpHeaders.setContentType(MediaType.APPLICATION_JSON);
			
			return new ResponseEntity <String> (respuesta, httpHeaders, HttpStatus.OK);	
	    } 
		
		
		//ACTUALIZAR REGISTRO
				@ResponseBody //NOS PERMITE RETORNAR UNICAMENTE DATOS, Y NO UNA VISTA
			    @RequestMapping(value="/actualizarDatos", method = RequestMethod.POST, produces = "application/json") //= select * from Aspirantes
				ResponseEntity <String > actualizarDatosUsuario(@RequestBody Estados datos){
					final HttpHeaders httpHeaders = new HttpHeaders();
					String respuesta = estadosService.actualizaUsuario(datos);
					
			              httpHeaders.setContentType(MediaType.APPLICATION_JSON);
					
					return new ResponseEntity <String> (respuesta, httpHeaders, HttpStatus.OK);	
			    } 
}