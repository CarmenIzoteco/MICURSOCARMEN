package com.mx.proyecto.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.proyecto.Dto.PersonaDTO;
import com.mx.proyecto.Dto.Response;
import com.mx.proyecto.Entities.Persona;
import com.mx.proyecto.Repositories.PersonaDAO;

@Service
public class PersonaServiceImpl  implements PersonaService{
	
	@Autowired
	private PersonaDAO personaDAO;

	@Override 
	public String getPersona(PersonaDTO idPersona){// select+ from tabla where  id_persona=1
		String respuesta = null;
		
		//T READ (FINAL) PK ID);
		Persona objeto = personaDAO.read(idPersona.getIdPersona());//select+ from tabla where  id_persona=1
		
		System.out.println("propiedades del objeto"+ objeto);
		//System.out.println("propiedades del objeto"+ objeto.getIdPersona()+ objeto.getNombres());
		
		
		if(objeto == null) {
			respuesta = "El registro NO existe";
		}else {
			respuesta = "Si existe el registro en la base de datos";
		}
		return respuesta;
	}
	
	@Override
	public String guardarPersona(PersonaDTO datos) {
		Persona obj = new Persona();
		obj.setNombres(datos.getNombres());
		obj.setEdad(datos.getEdad());
		obj.setSexo(datos.getSexo());
		
		Long addPersona =personaDAO.create(obj);//esta linea se inserto a la tabla
		
		if(addPersona != 0) {
			return "Datos registrados"; //
		}else {
			return "Error al registrar";
		}
	}
	@Override
	public String eliminarPersona(PersonaDTO idPersona) {
		personaDAO.delete(idPersona.getIdPersona()); //eliminar registro
		return "si elimino";
	}
	//verificar si el id que se manda desde postman no sea null o cero(incorrecto)-- no se cumple
	//verifica/consulta si existe la persona con este id
	//Evaluar si existe el estado consultado por el id == preguntar si va juntos
	
	@Override
	public Response eliminarPersonaId(PersonaDTO idPersona){
		Response response = new Response();
		
		try {
		if(idPersona.getIdPersona() !=null || idPersona.getIdPersona()!=0 || validaNumerico(idPersona.getIdPersona())) {//regla 1
			Persona existeReg = personaDAO.read(idPersona.getIdPersona());
			
			if(existeReg !=null) { //regla 2
				personaDAO.delete(idPersona.getIdPersona()); //Elimina Regla
				response.setMessage("Persona eliminada correctamente");	
				response.setCode(200);//codigos de respuesta de http
				
			}else {
				response.setMessage("La informacion no existe");	
				response.setCode(100);//codigos de respuesta de http
			}
			
		}else {
		response.setMessage("Los datos enviados son incorrectos");	
		response.setCode(500);//codigos de respuesta de http
		}
		
	}catch(Exception e) {
	response.setMessage("Ocurrio un error al intentar eliminar  la persona");
	}
	
		return response;
}

	private boolean validaNumerico(Long idPersona) {
	
		return false;
	}
	}

