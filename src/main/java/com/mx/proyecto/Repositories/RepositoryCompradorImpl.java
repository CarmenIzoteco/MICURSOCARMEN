package com.mx.proyecto.Repositories;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mx.proyecto.Dto.Comprador;
import com.mx.proyecto.Mapper.CompradoresMapper;


//CONSULTAS A BASE DE DATOS
//IMPLEMENTACIÓN DEL REPOSITORIO

@Repository
public class RepositoryCompradorImpl implements RepositoryComprador{
	
	
	
	@Autowired
	private DataSource dataSource;  //PARA LA CONEXIÓN A LA BASE DE DATOS
	
	JdbcTemplate jdbcTemplate = new JdbcTemplate(); // ES EL QUE NOS VA A PERMITIR HACER CONSULTAS A LA BASE DE DATOS MEDIANTE UNA CONEXIÓN A BASE DE DATOS
	
	public List<Comprador> getCompradores() {
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate.query("SELECT * FROM COMPRADORES", new CompradoresMapper<Comprador>());
	}
	public int contarCompradorNuevos() {
		System.out.println("LLEGANDO AL METODO contarCompradorNuevos DE LA CLASE IMPLEMENTACIÓN DEL REPOSITORIO");
		return 1245;
	}
	public int insertComprador(Comprador nuevoCompradores){
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate.update("INSERT INTO COMPRADORES(NOMBRE,EDAD) VALUES (?,?)", new Object[] {nuevoCompradores.getNombre(),nuevoCompradores.getEdad()});
	}
	
	public int updateComprador(Comprador Compradores){
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate.update("UPDATE COMPRADORES SET NOMBRE=?, EDAD=? WHERE ID_COMPRADOR= ?", new Object[] {Compradores.getNombre(),Compradores.getEdad(),Compradores.getIdComprador()});
	}
	public int deleteComprador(Comprador Compradores){
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate.update("DELETE FROM COMPRADORES WHERE ID_COMPRADOR= ?", new Object[] {Compradores.getIdComprador()});
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
