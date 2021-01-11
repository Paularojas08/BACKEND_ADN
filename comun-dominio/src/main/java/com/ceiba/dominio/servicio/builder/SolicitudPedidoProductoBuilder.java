package com.ceiba.dominio.servicio.builder;

import com.ceiba.dominio.servicio.SolicitudPedidoProducto;

public class SolicitudPedidoProductoBuilder {
	private SolicitudPedidoProducto solicitudPedidoProducto;

	public SolicitudPedidoProductoBuilder build() {
		solicitudPedidoProducto = new SolicitudPedidoProducto();
		return this;
	}

	public SolicitudPedidoProductoBuilder conCodigoProducto(String codigoProducto) {
		solicitudPedidoProducto.setCodigoProducto(codigoProducto);
		return this;
	}

	public SolicitudPedidoProductoBuilder conCantidad(int cantidad) {
		solicitudPedidoProducto.setCantidad(cantidad);
		return this;
	}

	public SolicitudPedidoProducto toSolicitudPedidoProducto() {
		return solicitudPedidoProducto;
	}
}
