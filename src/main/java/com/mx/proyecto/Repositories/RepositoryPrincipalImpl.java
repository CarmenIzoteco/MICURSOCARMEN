package com.mx.proyecto.Repositories;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mx.proyecto.Dto.Alumnos;
import com.mx.proyecto.Mapper.AlumnosMapper;

//CONSULTAS A BASE DE DATOS
//IMPLEMENTACIÓN DEL REPOSITORIO

@Repository
public class RepositoryPrincipalImpl implements RepositoryPrincipal{
	
	
	
	@Autowired
	private DataSource dataSource;  //PARA LA CONEXIÓN A LA BASE DE DATOS
	
	JdbcTemplate jdbcTemplate = new JdbcTemplate(); // ES EL QUE NOS VA A PERMITIR HACER CONSULTAS A LA BASE DE DATOS MEDIANTE UNA CONEXIÓN A BASE DE DATOS
	
	public List<Alumnos> getAlumno() {
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate.query("SELECT NOMBRE FROM ALUMNOS", new AlumnosMapper<Alumnos>());
	}

	public int insertAlumno(Alumnos nuevoAlumno) {
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate.update("INSERT INTO ALUMNOS(NOMBRE,EDAD) VALUES (?,?)", new Object[] {nuevoAlumno.getNombre(),nuevoAlumno.getEdad()});
	}
	public int contarAlumnosNuevos() {
		System.out.println("LLEGANDO AL METODO contarAlumnosNuevos DE LA CLASE IMPLEMENTACIÓN DEL REPOSITORIO");
		return 1245;
	}
	

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	
	

}
