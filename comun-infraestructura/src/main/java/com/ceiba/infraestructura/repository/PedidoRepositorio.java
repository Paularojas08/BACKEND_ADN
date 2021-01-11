package com.ceiba.infraestructura.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ceiba.dominio.repositorio.RepositorioPedido;
import com.ceiba.dominio.servicio.DetallePedido;
import com.ceiba.dominio.servicio.Pedido;
import com.ceiba.infraestructura.repository.query.QueryConstant;

@Repository
public class PedidoRepositorio extends BaseRepositorio implements RepositorioPedido {

	@Override
	public void crearPedido(Pedido pedido) {
		this.customNamedParameterJdbcTemplate.crear(pedido, QueryConstant.QUERY_SQL_CREAR_PEDIDO);
	}

	@Override
	public Pedido actualizarPedido(Pedido pedido) {
		this.customNamedParameterJdbcTemplate.actualizar(pedido, QueryConstant.QUERY_SQL_ACTUALIZAR_PEDIDO);
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
