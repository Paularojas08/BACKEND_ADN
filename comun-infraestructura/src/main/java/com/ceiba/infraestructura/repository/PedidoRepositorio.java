package com.ceiba.infraestructura.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ceiba.dominio.repositorio.RepositorioPedido;
import com.ceiba.dominio.servicio.DetallePedido;
import com.ceiba.dominio.servicio.Pedido;
import com.ceiba.infraestructura.builder.PedidoBuilder;
import com.ceiba.infraestructura.dao.PedidoDao;
import com.ceiba.infraestructura.model.PedidoModelo;

@Repository
public class PedidoRepositorio  implements RepositorioPedido {

	@Autowired
	private PedidoDao pedidoDao;

	private PedidoModelo buildPedidoModelo(Pedido pedido) {
		return PedidoBuilder.convertirAModelo(pedido);
	}

	@Override
	public void crearPedido(Pedido pedido) {
		PedidoModelo pedidoCreado = pedidoDao.save(buildPedidoModelo(pedido));
		pedido.setId(pedidoCreado.getId());
	}

	@Override
	public Pedido actualizarPedido(Pedido pedido) {
		return pedido;
	}

	@Override
	public boolean eliminarPedido(Long idPedido) {
		return false;
	}

	@Override
	public Pedido obtenerPedidoPorIdentificadorSeguimiento(String identificadorSeguimiento) {
		return null;
	}

	@Override
	public List<DetallePedido> obtenerDetallePedido(Long idPedido) {
		return null;
	}

}
