package com.ceiba.dominio.servicio;

import java.time.LocalDate;
import java.util.List;

import com.ceiba.dominio.utils.EstadoPedido;

public class Pedido {
	private Long id;
	private String identificadorSeguimiento;
	private LocalDate fechaPedido;
	private LocalDate fechaEnvio;
	private Double precioTotal;
	private List<DetallePedido> detallePedido;
	private EstadoPedido estado;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getIdentificadorSeguimiento() {
		return identificadorSeguimiento;
	}
	public void setIdentificadorSeguimiento(String identificadorSeguimiento) {
		this.identificadorSeguimiento = identificadorSeguimiento;
	}
	public LocalDate getFechaPedido() {
		return fechaPedido;
	}
	public void setFechaPedido(LocalDate fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

	public LocalDate getFechaEnvio() {
		return fechaEnvio;
	}
	public void setFechaEnvio(LocalDate fechaEnvio) {
		this.fechaEnvio = fechaEnvio;
	}
	public Double getPrecioTotal() {
		return precioTotal;
	}
	public void setPrecioTotal(Double precioTotal) {
		this.precioTotal = precioTotal;
	}
	public List<DetallePedido> getDetallePedido() {
		return detallePedido;
	}
	public void setDetallePedido(List<DetallePedido> detallePedido) {
		this.detallePedido = detallePedido;
	}
	public EstadoPedido getEstado() {
		return estado;
	}
	public void setEstado(EstadoPedido estado) {
		this.estado = estado;
	}
}
