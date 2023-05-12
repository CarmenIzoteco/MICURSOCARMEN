package com.mx.proyecto.Controllers;

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

import com.mx.proyecto.Dto.EmpleadosDTO;
import com.mx.proyecto.Dto.Response;
import com.mx.proyecto.Dto.UsuariosAdminDTO;
import com.mx.proyecto.Services.EmpleadosService;


@Controller
@RequestMapping("Empleados")
public class EmpleadosController {

	@Autowired
	private EmpleadosService empleadosService;
	
	
	//AGREGAR EMPLEADO
	@ResponseBody 
	@RequestMapping(value="/agregarEmpleados", method = RequestMethod.POST, produces = "application/json") 
	public Response agregarNuevoEmpleados(@RequestBody EmpleadosDTO curp){
		System.out.println("Control-->"+ curp);
		System.out.println("Control-->"+ curp.getCurp());
		
		return empleadosService.agregarEmpleado(curp);	
	}
	
	
	//ELIMINAR REGISTRO
			@ResponseBody //NOS PERMITE RETORNAR UNICAMENTE DATOS, Y NO UNA VISTA
		    @RequestMapping(value="/eliminarEmpleado", method = RequestMethod.POST, produces = "application/json") //= select * from Aspirantes
			public String eliminarEmpleados(@RequestBody EmpleadosDTO idEmpleado){
			
				String respuesta = empleadosService.eliminarEmpleado(idEmpleado);
				
				
				return respuesta;	
		    } 
			
			
	// CONSULTAR TODOS LOS EMPLEADOS SEXO MASCULINO
			@ResponseBody //NOS PERMITE RETORNAR UNICAMENTE DATOS, Y NO UNA VISTA
		    @RequestMapping(value="/consultarEmpleado", method = RequestMethod.POST, produces = "application/json") //= select * from Aspirantes
			public String consultarEmpleados(@RequestBody EmpleadosDTO idEmpleado){
			
				String respuesta = empleadosService.eliminarEmpleado(idEmpleado);
				
				
				return respuesta;	
		    } 
			
			
}