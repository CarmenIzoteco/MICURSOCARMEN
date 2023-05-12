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

import com.mx.proyecto.Dto.Vendedor;
import com.mx.proyecto.Services.ServiceVendedor;

//ADMINISTRAR LAS PETICONES DEL USUARIO

@Controller
@RequestMapping("NuevoVendedorController")
public class NuevoVendedor {
	
	
	//INYECCION DE DEPENDENCIAS
	//INSTANCIAR, LLAMAR O HACER USO DE UNA CLASE QUE TENGA UNA ANOTACIÓN DE SPRING, EJEMPLO:
	//@Service, @Repository, @Bean
	@Autowired
	private ServiceVendedor serviceVendedor;
	

	@ResponseBody //NOS PERMITE RETORNAR UNICAMENTE DATOS, Y NO UNA VISTA
    @RequestMapping(value="/getVendedor", method = RequestMethod.GET, produces = "application/json") //= select * from Aspirantes
	ResponseEntity <  List<Vendedor> > getVendedor(){
		final HttpHeaders httpHeaders = new HttpHeaders();
		List<Vendedor> lista = serviceVendedor.getVendedor();
		
		
//		for(Aspirantes run : lista) {
//			System.out.println("Nombre: "+run.getIdAlumno());
//	    	System.out.println("Edad: "+run.getNombreAlumno());
//	    	System.out.println("Direccion: "+run.getEdad());
//	    	System.out.println("Nombre: "+run.getFechaInscripcion());
//	    	System.out.println("Edad: "+run.getCurso());
//	    	System.out.println("Direccion: "+run.getMaestro());
//		}
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		
		return new ResponseEntity <List<Vendedor>> (lista, httpHeaders, HttpStatus.OK);	
    } 
	
	@ResponseBody //NOS PERMITE RETORNAR UNICAMENTE DATOS, Y NO UNA VISTA
    @RequestMapping(value="/insertVendedor", method = RequestMethod.POST, produces = "application/json") //= select * from Aspirantes
	ResponseEntity <  String >  insertAspirantes(@RequestBody Vendedor nuevoVendedorr){
		final HttpHeaders httpHeaders = new HttpHeaders();
		
		String respuesta=serviceVendedor.insertVendedorr(nuevoVendedorr);
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		
		return new ResponseEntity <String> (respuesta, httpHeaders, HttpStatus.OK);	
    } 
	@ResponseBody //NOS PERMITE RETORNAR UNICAMENTE DATOS, Y NO UNA VISTA
    @RequestMapping(value="/updateVendedor", method = RequestMethod.PUT, produces = "application/json") //= select * from Aspirantes
	ResponseEntity <  String >  updateAspirantes(@RequestBody Vendedor Vendedorr){
		final HttpHeaders httpHeaders = new HttpHeaders();
		
		String respuesta=serviceVendedor.updateVendedorr(Vendedorr);
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		
		return new ResponseEntity <String> (respuesta, httpHeaders, HttpStatus.OK);	
    } 
	@ResponseBody //NOS PERMITE RETORNAR UNICAMENTE DATOS, Y NO UNA VISTA
    @RequestMapping(value="/deleteVendedor", method = RequestMethod.DELETE, produces = "application/json") //= select * from Aspirantes
	ResponseEntity <  String > deleteAspirantes(@RequestBody Vendedor Vendedorr){
		final HttpHeaders httpHeaders = new HttpHeaders();
		
		String respuesta= serviceVendedor.deleteVendedorr(Vendedorr);
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		
		return new ResponseEntity <String> (respuesta, httpHeaders, HttpStatus.OK);	
    } 
}
