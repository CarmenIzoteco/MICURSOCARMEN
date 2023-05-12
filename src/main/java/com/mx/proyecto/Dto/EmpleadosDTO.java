package com.mx.proyecto.Dto;

public class EmpleadosDTO {
		
		private Long idEmpleado;
		private String nombreCompleto;
		private String rfc;
		private String curp;
		private int edad;
		private String sexo;
		private String direccion;
		private String nss;
		private int telefono;
		private int activo;
		
		
		public Long getIdEmpleado() {
			return idEmpleado;
		}
		public void setIdEmpleado(Long idEmpleado) {
			this.idEmpleado = idEmpleado;
		}
		public String getNombreCompleto() {
			return nombreCompleto;
		}
		public void setNombreCompleto(String nombreCompleto) {
			this.nombreCompleto = nombreCompleto;
		}
		public String getRfc() {
			return rfc;
		}
		public void setRfc(String rfc) {
			this.rfc = rfc;
		}
		public String getCurp() {
			return curp;
		}
		public void setCurp(String curp) {
			this.curp = curp;
		}
		public int getEdad() {
			return edad;
		}
		public void setEdad(int edad) {
			this.edad = edad;
		}
		public String getSexo() {
			return sexo;
		}
		public void setSexo(String sexo) {
			this.sexo = sexo;
		}
		public String getDireccion() {
			return direccion;
		}
		public void setDireccion(String direccion) {
			this.direccion = direccion;
		}
		public String getNss() {
			return nss;
		}
		public void setNss(String nss) {
			this.nss = nss;
		}
		public int getTelefono() {
			return telefono;
		}
		public void setTelefono(int telefono) {
			this.telefono = telefono;
		}
		public int getActivo() {
			return activo;
		}
		public void setActivo(int activo) {
			this.activo = activo;
		}
	}

