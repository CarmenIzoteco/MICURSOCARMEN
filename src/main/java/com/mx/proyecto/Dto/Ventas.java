package com.mx.proyecto.Dto;

import java.util.Date;

public class Ventas {

	private Long idVenta;
	private int usuario;
	private int descuento;
	private int total;
	private int subtotal;
	private int pago;
	private int cambio;
	private String estado;
	private Date fecha;
	private int comprador;

	
	public Long getIdVenta() {
		return idVenta;
	}
	public void setIdVenta(Long idVenta) {
		this.idVenta = idVenta;
	}
		public int getUsuario() {
			return usuario;
		}
		public void setUsuario(int usuario) {
			this.usuario = usuario;
		}
		public int getDescuento() {
			return descuento;
		}
		public void setDescuento(int descuento) {
			this.descuento = descuento;
		}
		public int getTotal() {
			return total;
		}
		public void setTotal(int total) {
			this.total = total;
		}
		public int getSubtotal() {
			return subtotal;
		}
		public void setSubtotal(int subtotal) {
			this.subtotal = subtotal;
		}
		public int getPago() {
			return pago;
		}
		public void setPago(int pago) {
			this.pago = pago;
		}
		public int getCambio() {
			return cambio;
		}
		public void setCambio(int cambio) {
			this.cambio = cambio;
		}
		public String getEstado() {
			return estado;
		}
		public void setEstado(String estado) {
			this.estado = estado;
		}
		public Date getFecha() {
			return fecha;
		}
		public void setFecha(Date fecha) {
			this.fecha = fecha;
		}
		public int getComprador() {
			return comprador;
		}
		public void setComprador(int comprador) {
			this.comprador = comprador;
		}
		
		
		
}
	
