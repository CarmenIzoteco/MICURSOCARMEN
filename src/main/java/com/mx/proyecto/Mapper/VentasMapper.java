package com.mx.proyecto.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mx.proyecto.Dto.Ventas;



public class VentasMapper<T> implements RowMapper<Ventas>{

	public Ventas mapRow(ResultSet rs, int rowNum) throws SQLException {
		Ventas objeto = new Ventas();
		
		objeto.setIdVenta(rs.getLong("ID_VENTA"));
		objeto.setUsuario(rs.getInt("USUARIO"));
		objeto.setDescuento(rs.getInt("DESCUENTO"));
		objeto.setTotal(rs.getInt("TOTAL"));
		objeto.setSubtotal(rs.getInt("SUBTOTAL"));
		objeto.setPago(rs.getInt("Pago"));
		objeto.setCambio(rs.getInt("CAMBIO"));
		objeto.setEstado(rs.getString("ESTADO"));
		objeto.setFecha(rs.getDate("FECHA"));
		objeto.setComprador(rs.getInt("COMPRADOR"));
		return objeto;
	
	}

}

