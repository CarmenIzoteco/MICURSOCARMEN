package com.mx.proyecto.Services;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

import com.mx.proyecto.Dto.EmpleadosDTO;
import com.mx.proyecto.Dto.Response;
import com.mx.proyecto.Entities.Empleados;
import com.mx.proyecto.Repositories.EmpleadosDAO;


	@Service
	public class EmpleadosServiceImpl  implements EmpleadosService{
		
		@Autowired
		private EmpleadosDAO empleadosDAO;

		
		@Override
		public Response agregarEmpleado(EmpleadosDTO curp) {
			Response response = new Response();
			try {
				
				Empleados existeCurp=empleadosDAO.buscarPorCurp(curp.getCurp());
				//existe registro -->
				// no existe registro-- > null o vacio
				System.out.print("MI RESPUESTA" + existeCurp );
		
				
				if(existeCurp != null){ //existe registro
				response.setMessage("El usuario ya se encuentra registrado");
				response.setCode(100);
	
				}else { //si no existe registro biene vacio
					Empleados ob= new Empleados();
					ob.setIdEmpleado(curp.getIdEmpleado());
					ob.setNombreCompleto(curp.getNombreCompleto());
					ob.setCurp(curp.getCurp());
					ob.setDireccion(curp.getDireccion());
					ob.setEdad(curp.getEdad());
					ob.setSexo(curp.getSexo());
					ob.setDireccion(curp.getDireccion());
					ob.setTelefono(curp.getTelefono());
					ob.setActivo(curp.getActivo());
					
					empleadosDAO.create(ob);
					response.setMessage("Registro completo");
					response.setCode(200);
				}	
			} catch(Exception e){
				response.setMessage("Ocurrio un error al registrar un nuevo empleado, en la clase:Empleados ");
			}
			return response;
		}
		
		
		@Override
		public String eliminarEmpleado(EmpleadosDTO idEmpleado){
			String res=null;
			
			try {
				
				Empleados existeActivo=empleadosDAO.read(idEmpleado.getIdEmpleado());
				System.out.print("MI RESPUESTA" + existeActivo );
			
				
				if(existeActivo.getActivo() != 0){ //existe registro
					res= "Imposible eliminar Empleado, Sigue Laborando (Activo)";
					
					}else { //si no existe registro biene vacio
						res="Empleado eliminado correctamente";
					}
			} catch(Exception e){
				res="Ocurrio un error al intentar eliminar  la persona";
				
			}
			return res;
		}
		
		
		
		}//  llave de la clase principal
		
			