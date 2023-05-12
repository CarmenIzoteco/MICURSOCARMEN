package com.mx.proyecto.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mx.proyecto.Dto.Comprador;


public class CompradoresMapper<T> implements RowMapper<Comprador>{

	public Comprador mapRow(ResultSet rs, int rowNum) throws SQLException {
		Comprador objeto = new Comprador();
		
		objeto.setIdComprador(rs.getLong("ID_COMPRADOR"));
		objeto.setNombre(rs.getString("NOMBRE"));
		objeto.setEdad(rs.getInt("EDAD"));
		objeto.setSexo(rs.getString("SEXO"));
		objeto.setDomicilio(rs.getString("DOMICILIO"));
		return objeto;
	
	}

}
