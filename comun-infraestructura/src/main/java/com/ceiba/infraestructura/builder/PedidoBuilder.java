package com.ceiba.infraestructura.builder;

import java.util.Optional;

import com.ceiba.dominio.servicio.Pedido;
import com.ceiba.infraestructura.model.PedidoModelo;

public class PedidoBuilder {
	private PedidoBuilder() {

	}

	public static Pedido convertirADominio(PedidoModelo pedidoModelo) {
		if (Optional.ofNullable(pedidoModelo).isPresent()) {
			return new Pedido();
		}
		return null;
	}

	public static PedidoModelo convertirAModelo(Pedido pedido) {
		PedidoModelo pedidoModelo = new PedidoModelo();
		pedidoModelo.setId(pedido.getId());
		pedidoModelo.setEstado(pedido.getEstado());
		pedidoModelo.setFechaPedido(pedido.getFechaPedido());
		pedidoModelo.setPrecioTotal(pedido.getPrecioTotal());
		pedidoModelo.setIdentificadorSeguimiento(pedido.getIdentificadorSeguimiento());
		return pedidoModelo;
	}
}
