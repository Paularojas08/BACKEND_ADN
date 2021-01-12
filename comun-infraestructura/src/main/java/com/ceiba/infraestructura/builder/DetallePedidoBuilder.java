package com.ceiba.infraestructura.builder;

import java.util.Optional;

import com.ceiba.dominio.servicio.DetallePedido;
import com.ceiba.infraestructura.model.DetallePedidoModelo;

public class DetallePedidoBuilder {
	private DetallePedidoBuilder() {

	}

	public static DetallePedido convertirADominio(DetallePedidoModelo detallePedidoModelo) {
		if (Optional.ofNullable(detallePedidoModelo).isPresent()) {
			return new DetallePedido();
		}
		return null;
	}

	public static DetallePedidoModelo convertirAModelo(DetallePedido detallePedido) {
		DetallePedidoModelo detallePedidoModelo = new DetallePedidoModelo();
		detallePedidoModelo.setPedido(PedidoBuilder.convertirAModelo(detallePedido.getPedido()));
		detallePedidoModelo.setProducto(ProductoBuilder.convertirAModelo(detallePedido.getProducto()));
		detallePedidoModelo.setCantidadPedida(detallePedido.getCantidadPedida());
		return detallePedidoModelo;
	}
}
