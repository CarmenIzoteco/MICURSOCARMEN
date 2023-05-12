package com.mx.proyecto.Repositories;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mx.proyecto.Dto.Vendedor;
import com.mx.proyecto.Mapper.VendedorMapper;

//CONSULTAS A BASE DE DATOS
//IMPLEMENTACIÓN DEL REPOSITORIO

@Repository
public class RepositoryVendedorImpl implements RepositoryVendedor{
	
	
	
	@Autowired
	private DataSource dataSource;  //PARA LA CONEXIÓN A LA BASE DE DATOS
	
	JdbcTemplate jdbcTemplate = new JdbcTemplate(); // ES EL QUE NOS VA A PERMITIR HACER CONSULTAS A LA BASE DE DATOS MEDIANTE UNA CONEXIÓN A BASE DE DATOS
	
	public List<Vendedor> getVendedorr() {
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate.query("SELECT * FROM VENDEDORES", new VendedorMapper<Vendedor>());
	}
	public int contarVendedorNuevos() {
		System.out.println("LLEGANDO AL METODO contarVendedorNuevos DE LA CLASE IMPLEMENTACIÓN DEL REPOSITORIO");
		return 1245;
	}
	public int insertVendedor(Vendedor nuevoVendedorr){
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate.update("INSERT INTO VENDEDORES(NOMBRE,EDAD) VALUES (?,?)", new Object[] {nuevoVendedorr.getNombre(),nuevoVendedorr.getEdad()});
	}
	
	public int updateVendedor(Vendedor Vendedorr){
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate.update("UPDATE VENDEDORES SET NOMBRE=?, EDAD=? WHERE ID_VENDEDOR= ?", new Object[] {Vendedorr.getNombre(),Vendedorr.getEdad(),Vendedorr.getIdVendedor()});
	}
	public int deleteVendedor(Vendedor Vendedorr){
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate.update("DELETE FROM VENDEDORES WHERE ID_VENDEDOR= ?", new Object[] {Vendedorr.getIdVendedor()});
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
