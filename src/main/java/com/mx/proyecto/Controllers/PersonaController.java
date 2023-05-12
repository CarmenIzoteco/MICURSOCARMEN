package com.mx.proyecto.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mx.proyecto.Dto.PersonaDTO;
import com.mx.proyecto.Dto.Response;
import com.mx.proyecto.Services.PersonaService;


@Controller
@RequestMapping("Persona")
public class PersonaController {

	@Autowired
	private PersonaService personaService;
	
	//consultar una persona por su  identificador
	@ResponseBody //NOS PERMITE RETORNAR UNICAMENTE DATOS, Y NO UNA VISTA
    @RequestMapping(value="/getPersona", method = RequestMethod.GET, produces = "application/json") //= select * from Aspirantes
    public String getPersona(@RequestBody PersonaDTO idPersona) { 

	String respuesta = personaService.getPersona(idPersona);
		
          
		return respuesta;	
    } 
	
	//Guardar persona
	@ResponseBody //NOS PERMITE RETORNAR UNICAMENTE DATOS, Y NO UNA VISTA
    @RequestMapping(value="/guardarPersona", method = RequestMethod.POST, produces = "application/json") //= select * from Aspirantes
    public String guardarPersona(@RequestBody PersonaDTO datos) { 

	String respuesta = personaService.guardarPersona(datos);
		
 
		return respuesta;	
    } 
	
	//elimina persona
	@ResponseBody //NOS PERMITE RETORNAR UNICAMENTE DATOS, Y NO UNA VISTA
    @RequestMapping(value="/eliminarPersona", method = RequestMethod.POST, produces = "application/json") //= select * from Aspirantes
    public String eliminarPersona(@RequestBody PersonaDTO idPersona) { 

	String respuesta = personaService.eliminarPersona(idPersona);
		
 
		return respuesta;	
    } 
	
	//elimina persona con clase response
		@ResponseBody //NOS PERMITE RETORNAR UNICAMENTE DATOS, Y NO UNA VISTA
	    @RequestMapping(value="/eliminarPersonaId", method = RequestMethod.POST, produces = "application/json") //= select * from Aspirantes
	    public Response eliminarPersonaId(@RequestBody PersonaDTO idPersona) { 

		return personaService.eliminarPersonaId(idPersona);
	
	    } 
}

