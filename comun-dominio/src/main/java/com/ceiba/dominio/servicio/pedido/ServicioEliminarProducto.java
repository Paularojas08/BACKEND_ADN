package com.ceiba.dominio.servicio.pedido;

import com.ceiba.dominio.repositorio.RepositorioPedido;

public class ServicioEliminarProducto {
	private RepositorioPedido repositorioPedido;

	public ServicioEliminarProducto(RepositorioPedido repositorioPedido) {
		super();
		this.repositorioPedido = repositorioPedido;
	}

	public boolean ejecutar(Long idPedido) {
		return this.repositorioPedido.eliminarPedido(idPedido);
	}
}
