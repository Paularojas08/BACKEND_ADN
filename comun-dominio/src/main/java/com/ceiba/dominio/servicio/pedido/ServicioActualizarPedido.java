package com.ceiba.dominio.servicio.pedido;

import com.ceiba.dominio.repositorio.RepositorioPedido;
import com.ceiba.dominio.servicio.Pedido;

public class ServicioActualizarPedido {
	private RepositorioPedido repositorioPedido;

	public ServicioActualizarPedido(RepositorioPedido repositorioPedido) {
		super();
		this.repositorioPedido = repositorioPedido;
	}

	public Pedido ejecutar(Pedido pedido) {
		return this.repositorioPedido.actualizarPedido(pedido);
	}
}
