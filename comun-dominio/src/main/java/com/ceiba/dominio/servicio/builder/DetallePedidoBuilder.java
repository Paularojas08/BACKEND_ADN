package com.ceiba.dominio.servicio.builder;

import com.ceiba.dominio.servicio.DetallePedido;
import com.ceiba.dominio.servicio.Pedido;
import com.ceiba.dominio.servicio.Producto;

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
	
	public DetallePedidoBuilder conPedido(Pedido pedido) {
		detallePedido.setPedido(pedido);
		return this;
	}
	
	public DetallePedidoBuilder conProducto(Producto producto) {
		detallePedido.setProducto(producto);
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
