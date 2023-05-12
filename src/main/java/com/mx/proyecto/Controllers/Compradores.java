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

import com.mx.proyecto.Dto.Comprador;
import com.mx.proyecto.Services.ServiceComprador;


//ADMINISTRAR LAS PETICONES DEL USUARIO

@Controller
@RequestMapping("CompradoresController")
public class Compradores {
	
	
	//INYECCION DE DEPENDENCIAS
	//INSTANCIAR, LLAMAR O HACER USO DE UNA CLASE QUE TENGA UNA ANOTACIÓN DE SPRING, EJEMPLO:
	//@Service, @Repository, @Bean
	@Autowired
	private ServiceComprador serviceComprador;
	

	@ResponseBody //NOS PERMITE RETORNAR UNICAMENTE DATOS, Y NO UNA VISTA
    @RequestMapping(value="/getComprador", method = RequestMethod.GET, produces = "application/json") //= select * from Aspirantes
	ResponseEntity <  List<Comprador> > getComprador(){
		final HttpHeaders httpHeaders = new HttpHeaders();
		List<Comprador> lista = serviceComprador.getComprador();
		
//		for(Aspirantes run : lista) {
//			System.out.println("Nombre: "+run.getIdAlumno());
//	    	System.out.println("Edad: "+run.getNombreAlumno());
//	    	System.out.println("Direccion: "+run.getEdad());
//	    	System.out.println("Nombre: "+run.getFechaInscripcion());
//	    	System.out.println("Edad: "+run.getCurso());
//	    	System.out.println("Direccion: "+run.getMaestro());
//		}
              httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		
		return new ResponseEntity <List<Comprador>> (lista, httpHeaders, HttpStatus.OK);	
    } 
	
	@ResponseBody //NOS PERMITE RETORNAR UNICAMENTE DATOS, Y NO UNA VISTA
    @RequestMapping(value="/insertComprador", method = RequestMethod.POST, produces = "application/json") //= select * from Aspirantes
	ResponseEntity <  String >  insertAspirante(@RequestBody Comprador nuevoCompradores){
		final HttpHeaders httpHeaders = new HttpHeaders();
		
		String respuesta=serviceComprador.insertCompradores(nuevoCompradores);
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		
		return new ResponseEntity <String> (respuesta, httpHeaders, HttpStatus.OK);	
    } 
	@ResponseBody //NOS PERMITE RETORNAR UNICAMENTE DATOS, Y NO UNA VISTA
    @RequestMapping(value="/updateComprador", method = RequestMethod.PUT, produces = "application/json") //= select * from Aspirantes
	ResponseEntity <  String >  updateAspirante(@RequestBody Comprador Compradores){
		final HttpHeaders httpHeaders = new HttpHeaders();
		
		String respuesta=serviceComprador.updateCompradores(Compradores);
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		
		return new ResponseEntity <String> (respuesta, httpHeaders, HttpStatus.OK);	
    } 
	@ResponseBody //NOS PERMITE RETORNAR UNICAMENTE DATOS, Y NO UNA VISTA
    @RequestMapping(value="/deleteComprador", method = RequestMethod.DELETE, produces = "application/json") //= select * from Aspirantes
	ResponseEntity <  String > deleteAspirante(@RequestBody Comprador Compradores){
		final HttpHeaders httpHeaders = new HttpHeaders();
		
		String respuesta= serviceComprador.deleteCompradores(Compradores);
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		
		return new ResponseEntity <String> (respuesta, httpHeaders, HttpStatus.OK);	
    } 
}
