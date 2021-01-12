package com.ceiba.infraestructura.repository;

import java.util.List;

import org.postgresql.util.PGobject;
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
	    pedido.setId(obtenerPedidoPorIdentificadorSeguimiento(pedido.getIdentificadorSeguimiento()));
	}

	@Override
	public Pedido actualizarPedido(Pedido pedido) {
		return null;
	}

	@Override
	public boolean eliminarPedido(Long idPedido) {
		return false;
	}

	@Override
	public Long obtenerPedidoPorIdentificadorSeguimiento(String identificadorSeguimiento) {
		return this.customNamedParameterJdbcTemplate.obtenerPedido("idSeguimiento",identificadorSeguimiento, QueryConstant.QUERY_SQL_OBTENER_PEDIDO);
		
	}

	@Override
	public List<DetallePedido> obtenerDetallePedido(Long idPedido) {
		return null;
	}

}
