package com.mx.proyecto.Entities;
	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.Id;
	import javax.persistence.Table;

	
	//READY
	//CREATE
    @Entity//anotacion para indicarle que esta clase va a ser una entity/entidad
	@Table(name= "CAT_ROLES", schema=  "BDVENDEDOR")//ANotacion table   donde indicamos el nombrede la tabla y el esquema
	public class Roles {

		@Id // Es para indicarle el campo atributo va a ser un id
		@Column(name="ID_ROL", unique= true, nullable= false, precision= 11, scale=0 ) //Es par indicarle que es una columna de la tabla y se puede agregar pripiedades
		private Long idRol;
		
		
		@Column(name="NOMBRE", length=100)
		private String nombre;
		
		@Column(name="Descripcion", length=100)
		private String descripcion;
		
		
		public Long getIdRol() {
			return idRol;
		}

		public void setIdRol(Long idRol) {
			this.idRol = idRol;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getDescripcion() {
			return descripcion;
		}

		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}
    }
    

	
		
