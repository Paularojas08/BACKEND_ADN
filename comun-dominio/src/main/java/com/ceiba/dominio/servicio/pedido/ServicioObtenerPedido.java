package com.ceiba.dominio.servicio.pedido;

import com.ceiba.dominio.repositorio.RepositorioPedido;
import com.ceiba.dominio.servicio.Pedido;

public class ServicioObtenerPedido {
	private RepositorioPedido repositorioPedido;

	public ServicioObtenerPedido(RepositorioPedido repositorioPedido) {
		this.repositorioPedido = repositorioPedido;
	}

	public Long ejecutar(String identificadorSeguimiento) {
		return this.repositorioPedido.obtenerPedidoPorIdentificadorSeguimiento(identificadorSeguimiento);
	}
}
