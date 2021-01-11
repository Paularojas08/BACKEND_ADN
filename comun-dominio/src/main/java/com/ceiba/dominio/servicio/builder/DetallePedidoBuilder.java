package com.ceiba.dominio.servicio.builder;

import com.ceiba.dominio.servicio.DetallePedido;

public class DetallePedidoBuilder {
	private DetallePedido detallePedido;

	public DetallePedidoBuilder build() {
		detallePedido = new DetallePedido();
		return this;
	}

	public DetallePedidoBuilder conId(Long id) {
		detallePedido.setId(null);
		return this;
	}
	
	public DetallePedidoBuilder conPedidoId(Long pedidoId) {
		detallePedido.setPedidoId(pedidoId);
		return this;
	}
	
	public DetallePedidoBuilder conProductoId(String productoId) {
		detallePedido.setProductoId(productoId);
		return this;
	}
	public DetallePedidoBuilder conCantidadPedida(int cantidadPedida) {
		detallePedido.setCantidadPedida(cantidadPedida);
		return this;
	}
	
	public DetallePedido toDetallePedido() {
		return detallePedido;
	}
}
