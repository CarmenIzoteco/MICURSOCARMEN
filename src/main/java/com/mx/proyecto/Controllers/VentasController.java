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

import com.mx.proyecto.Dto.Ventas;
import com.mx.proyecto.Services.ServiceVentas;


//ADMINISTRAR LAS PETICONES DEL USUARIO

@Controller
@RequestMapping("VentasController")
public class VentasController {
	
	
	//INYECCION DE DEPENDENCIAS
	//INSTANCIAR, LLAMAR O HACER USO DE UNA CLASE QUE TENGA UNA ANOTACIÓN DE SPRING, EJEMPLO:
	//@Service, @Repository, @Bean
	@Autowired
	private ServiceVentas serviceVentas;
	

	@ResponseBody //NOS PERMITE RETORNAR UNICAMENTE DATOS, Y NO UNA VISTA
    @RequestMapping(value="/getVentas", method = RequestMethod.GET, produces = "application/json") //= select * from Aspirantes
	ResponseEntity <  List<Ventas> > getVentas(){
		final HttpHeaders httpHeaders = new HttpHeaders();
		List<Ventas> lista = serviceVentas.getVentas();
		
//		for(Aspirantes run : lista) {
//			System.out.println("Nombre: "+run.getIdAlumno());
//	    	System.out.println("Edad: "+run.getNombreAlumno());
//	    	System.out.println("Direccion: "+run.getEdad());
//	    	System.out.println("Nombre: "+run.getFechaInscripcion());
//	    	System.out.println("Edad: "+run.getCurso());
//	    	System.out.println("Direccion: "+run.getMaestro());
//		}
              httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		
		return new ResponseEntity <List<Ventas>> (lista, httpHeaders, HttpStatus.OK);	
    } 
	
	@ResponseBody //NOS PERMITE RETORNAR UNICAMENTE DATOS, Y NO UNA VISTA
    @RequestMapping(value="/insertVentas", method = RequestMethod.POST, produces = "application/json") //= select * from Aspirantes
	ResponseEntity <  String >  insertAspirant(@RequestBody Ventas nuevoVenta){
		final HttpHeaders httpHeaders = new HttpHeaders();
		
		String respuesta=serviceVentas.insertVentas(nuevoVenta);
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		
		return new ResponseEntity <String> (respuesta, httpHeaders, HttpStatus.OK);	
    } 
	@ResponseBody //NOS PERMITE RETORNAR UNICAMENTE DATOS, Y NO UNA VISTA
    @RequestMapping(value="/updateVentas", method = RequestMethod.PUT, produces = "application/json") //= select * from Aspirantes
	ResponseEntity <  String >  updateAspirant(@RequestBody Ventas Venta){
		final HttpHeaders httpHeaders = new HttpHeaders();
		
		String respuesta=serviceVentas.updateVentas(Venta);
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		
		return new ResponseEntity <String> (respuesta, httpHeaders, HttpStatus.OK);	
    } 
	@ResponseBody //NOS PERMITE RETORNAR UNICAMENTE DATOS, Y NO UNA VISTA
    @RequestMapping(value="/deleteVentas", method = RequestMethod.DELETE, produces = "application/json") //= select * from Aspirantes
	ResponseEntity <  String > deleteAspirant(@RequestBody Ventas Venta){
		final HttpHeaders httpHeaders = new HttpHeaders();
		
		String respuesta= serviceVentas.deleteVentas(Venta);
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		
		return new ResponseEntity <String> (respuesta, httpHeaders, HttpStatus.OK);	
    } 
}
