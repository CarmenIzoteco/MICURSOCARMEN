package com.mx.proyecto.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mx.proyecto.Dto.Vendedor;


public class VendedorMapper<T> implements RowMapper<Vendedor>{

	public Vendedor mapRow(ResultSet rs, int rowNum) throws SQLException {
		Vendedor objeto = new Vendedor();
		
		objeto.setIdVendedor(rs.getLong("ID_VENDEDOR"));
		objeto.setNombre(rs.getString("NOMBRE"));
		objeto.setEdad(rs.getInt("EDAD"));
		objeto.setSexo(rs.getString("SEXO"));
		objeto.setSalario(rs.getInt("SALARIO"));
		objeto.setArea(rs.getString("AREA"));
		return objeto;
	
	}

}
