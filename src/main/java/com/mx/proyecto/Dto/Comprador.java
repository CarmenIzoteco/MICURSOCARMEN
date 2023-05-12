package com.mx.proyecto.Dto;

public class Comprador {
	
		private Long idComprador;
		private String nombre;
		private int edad;
		private String sexo;
		private String domicilio;
		
		
		
		public Long getIdComprador() {
			return idComprador;
		}
		public void setIdComprador(Long idComprador) {
			this.idComprador = idComprador;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public int getEdad() {
			return edad;
		}
		public void setEdad(int edad) {
		this.edad =edad;
		}
		public String getSexo() {
			return sexo;
		}
		public void setSexo(String sexo) {
			this.sexo = sexo;
		}
		
		public String getDomicilio() {
			return domicilio;
		}
		public void setDomicilio(String domicilio) {
			this.domicilio = domicilio;
		}
		
		
	}

