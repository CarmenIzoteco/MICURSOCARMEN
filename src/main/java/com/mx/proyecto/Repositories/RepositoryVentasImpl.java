package com.mx.proyecto.Repositories;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import com.mx.proyecto.Dto.Ventas;
import com.mx.proyecto.Mapper.VentasMapper;


//CONSULTAS A BASE DE DATOS
//IMPLEMENTACIÓN DEL REPOSITORIO

@Repository
public class RepositoryVentasImpl implements RepositoryVentas{
	
	
	
	@Autowired
	private DataSource dataSource;  //PARA LA CONEXIÓN A LA BASE DE DATOS
	
	JdbcTemplate jdbcTemplate = new JdbcTemplate(); // ES EL QUE NOS VA A PERMITIR HACER CONSULTAS A LA BASE DE DATOS MEDIANTE UNA CONEXIÓN A BASE DE DATOS
	
	public List<Ventas> getVenta() {
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate.query("SELECT * FROM VENTA", new VentasMapper<Ventas>());
	}
	public int contarVentasNuevos() {
		System.out.println("LLEGANDO AL METODO contarVentasNuevos DE LA CLASE IMPLEMENTACIÓN DEL REPOSITORIO");
		return 1245;
	}
	public int insertVentas(Ventas nuevoVenta){
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate.update("INSERT INTO VENTA(USUARIO,COMPRADOR) VALUES (?,?)", new Object[] {nuevoVenta.getUsuario(),nuevoVenta.getComprador()});
	}
	
	public int updateVentas(Ventas Venta){
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate.update("UPDATE VENTA SET USUARIO=?, COMPRADOR=? WHERE ID_VENTA= ?", new Object[] {Venta.getUsuario(),Venta.getComprador(),Venta.getIdVenta()});
	}
	public int deleteVentas(Ventas Venta){
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate.update("DELETE FROM VENTA WHERE ID_VENTA= ?", new Object[] {Venta.getIdVenta()});
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
