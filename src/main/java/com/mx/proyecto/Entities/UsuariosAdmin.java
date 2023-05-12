package com.mx.proyecto.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//READY
//CREATE

@Entity//anotacion para indicarle que esta clase va a ser una entity/entidad
@Table(name= "USUARIOS_ADMIN", schema=  "BDVENDEDOR")//ANotacion table   donde indicamos el nombrede la tabla y el esquema
public class UsuariosAdmin {

	@Id // Es para indicarle el campo atributo va a ser un id
	@Column(name="ID_USER", unique= true, nullable= false, precision= 11, scale=0 ) //Es par indicarle que es una columna de la tabla y se puede agregar pripiedades
	private Long idUser;
	
	@Column(name="NOMBRE_COMPLETO", length=100)
	private String nombreCompleto;
	
	@Column(name="EDAD", length=50)
	private String edad;
	
	@Column(name="DIRECCION", length=100)
	private String direccion;
	
	@Column(name="ESTADO")
	private int estado;
	
	@Column(name="ROL")
	private int rol;
	
	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public int getRol() {
		return rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}

	
}
