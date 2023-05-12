package com.mx.proyecto.Entities;

	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.Id;
	import javax.persistence.Table;

	//READY
	//CREATE

	@Entity//anotacion para indicarle que esta clase va a ser una entity/entidad
	@Table(name= "EMPLEADOS", schema=  "BDVENDEDOR")//ANotacion table   donde indicamos el nombrede la tabla y el esquema
	public class Empleados {

		@Id // Es para indicarle el campo atributo va a ser un id
		@Column(name="ID_EMPLEADO", unique= true, nullable= false, precision= 11, scale=0 ) //Es par indicarle que es una columna de la tabla y se puede agregar pripiedades
		private Long idEmpleado;
		
		@Column(name="NOMBRE_COMPLETO", length=100)
		private String nombreCompleto;
		
		@Column(name="RFC", length=15)
		private String rfc;
		
		@Column(name="CURP", length=15)
		private String curp;
		

		@Column(name="Edad", length=4)
		private int edad;
		
		@Column(name="SEXO", length=2)
		private String sexo;
		
		@Column(name="DIRECCION", length=100)
		private String direccion;
		
		@Column(name="NSS", length=10)
		private String nss;
		
		@Column(name="TELEFONO")
		private int telefono;
		
		@Column(name="ACTIVO")
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
