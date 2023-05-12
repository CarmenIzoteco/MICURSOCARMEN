package com.mx.proyecto.Entities;

	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.Id;
	import javax.persistence.Table;

	@Entity
	//READY
	//CREATE

	//anotacion para indicarle que esta clase va a ser una entity/entidad
	@Table(name= "CAT_ESTADOS", schema="BDVENDEDOR")//ANotacion table   donde indicamos el nombrede la tabla y el esquema
	public class Estados {

		@Id // Es para indicarle el campo atributo va a ser un id
		@Column(name="ID_ESTADO", unique= true, nullable= false, precision= 11, scale=0 ) //Es par indicarle que es una columna de la tabla y se puede agregar pripiedades
		private Long idEstado;
		
		
		@Column(name="NOMBRE", length=100)
		private String nombre;
		
		
		@Column(name="ABREVIATURA", length=50)
		private String abreviatura;
		
		
		public Long getIdEstado() {
			return idEstado;
		}

		public void setIdEstado(Long idEstado) {
			this.idEstado = idEstado;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getAbreviatura() {
			return abreviatura;
		}

		public void setAbreviatura(String abreviatura) {
			this.abreviatura = abreviatura;
		}
		
	}
