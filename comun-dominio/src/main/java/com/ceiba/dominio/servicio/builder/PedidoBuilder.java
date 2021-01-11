package com.ceiba.dominio.servicio.builder;

import java.time.LocalDate;

import com.ceiba.dominio.servicio.Pedido;
import com.ceiba.dominio.utils.EstadoPedido;

public final class PedidoBuilder {
	private Pedido pedido;
	
	public PedidoBuilder build() {
		pedido = new Pedido();
		return this;
	}
	
	public PedidoBuilder conId(Long id) {
		pedido.setId(id);
		return this;
	}
	
	public PedidoBuilder conFechaPedido(LocalDate fechaPedido) {
		pedido.setFechaPedido(fechaPedido);
		return this;
	}
	public PedidoBuilder conFechaEnvio(LocalDate fechaEnvio) {
		pedido.setFechaEnvio(fechaEnvio);
		return this;
	}
	public PedidoBuilder conPrecioTotal(Double precioTotal) {
		pedido.setPrecioTotal(precioTotal);
		return this;
	}
	
	public PedidoBuilder conEstado(EstadoPedido estadoPedido) {
		pedido.setEstado(estadoPedido);
		return this;
	}
	
	public Pedido toPedido() {
		return pedido;
	}
}
