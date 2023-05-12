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

import com.mx.proyecto.Dto.Alumnos;
import com.mx.proyecto.Services.ServicePrincipal;

//ADMINISTRAR LAS PETICONES DEL USUARIO

@Controller
@RequestMapping("PrincipalController")
public class Principal {
	
	
	//INYECCION DE DEPENDENCIAS
	//INSTANCIAR, LLAMAR O HACER USO DE UNA CLASE QUE TENGA UNA ANOTACIÓN DE SPRING, EJEMPLO:
	//@Service, @Repository, @Bean
	@Autowired
	private ServicePrincipal servicePrincipal;
	
	//SERVICIOS
	@RequestMapping("/Inicio") //NOMBRE DEL SERVICIO
    public String inicio() {//NOMBRE DEL METODO
	//	String a = new BCryptPasswordEncoder().encode("Arturo10");
	//	System.out.println(a);
	System.out.println("LLEGANDO AL SERVICIO /Inicio");
	System.out.println("IMPRIMIENDO: "+servicePrincipal.contarAlumnosNuevos());
	
	List<Alumnos> alumnos = servicePrincipal.getAlumnos();
	System.out.println("Alumnos: ");
	for(Alumnos alumno : alumnos) {
		System.out.println(alumno.getNombre());
	}
	
		return "Inicio";// NOMBRE DE LA VISTA .JSP A LA QUE NOS REDIRECCIONA ESTE SERVICIO
	}
	
	@RequestMapping("/Salida") //NOMBRE DEL SERVICIO
    public String salida() {//NOMBRE DEL METODO
		return "Inicio";// NOMBRE DE LA VISTA .JSP A LA QUE NOS REDIRECCIONA ESTE SERVICIO
	}
	@RequestMapping("/Entrada") //NOMBRE DEL SERVICIO
    public String entrada() {//NOMBRE DEL METODO
		return "Inicio";// NOMBRE DE LA VISTA .JSP A LA QUE NOS REDIRECCIONA ESTE SERVICIO
	}
	@RequestMapping("/Afuera") //NOMBRE DEL SERVICIO
    public String afuera() {//NOMBRE DEL METODO
		return "Inicio";// NOMBRE DE LA VISTA .JSP A LA QUE NOS REDIRECCIONA ESTE SERVICIO
	}
	
	@ResponseBody //NOS PERMITE RETORNAR UNICAMENTE DATOS, Y NO UNA VISTA
    @RequestMapping(value="/getAlumnos", method = RequestMethod.GET, produces = "application/json") //= select * from Aspirantes
	ResponseEntity <  List<Alumnos> > getAlumnos(){
		final HttpHeaders httpHeaders = new HttpHeaders();
		List<Alumnos> lista = servicePrincipal.getAlumnos();
		
		
//		for(Aspirantes run : lista) {
//			System.out.println("Nombre: "+run.getIdAlumno());
//	    	System.out.println("Edad: "+run.getNombreAlumno());
//	    	System.out.println("Direccion: "+run.getEdad());
//	    	System.out.println("Nombre: "+run.getFechaInscripcion());
//	    	System.out.println("Edad: "+run.getCurso());
//	    	System.out.println("Direccion: "+run.getMaestro());
//		}
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		
		return new ResponseEntity <List<Alumnos>> (lista, httpHeaders, HttpStatus.OK);	
    } 
	
	@ResponseBody //NOS PERMITE RETORNAR UNICAMENTE DATOS, Y NO UNA VISTA
    @RequestMapping(value="/insertAlumnos", method = RequestMethod.POST, produces = "application/json") //= select * from Aspirantes
	ResponseEntity <  String >  insertAspirantes(@RequestBody Alumnos nuevoAlumno){
		final HttpHeaders httpHeaders = new HttpHeaders();
		
		String respuesta = servicePrincipal.insertAlumno(nuevoAlumno);
		
		
//		for(Aspirantes run : lista) {
//			System.out.println("Nombre: "+run.getIdAlumno());
//	    	System.out.println("Edad: "+run.getNombreAlumno());
//	    	System.out.println("Direccion: "+run.getEdad());
//	    	System.out.println("Nombre: "+run.getFechaInscripcion());
//	    	System.out.println("Edad: "+run.getCurso());
//	    	System.out.println("Direccion: "+run.getMaestro());
//		}
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		
		return new ResponseEntity <String> (respuesta, httpHeaders, HttpStatus.OK);	
    } 
}
