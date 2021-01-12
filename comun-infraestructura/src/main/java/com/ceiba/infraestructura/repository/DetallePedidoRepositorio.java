package com.ceiba.infraestructura.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ceiba.dominio.repositorio.RepositorioDetallePedido;
import com.ceiba.dominio.servicio.Cliente;
import com.ceiba.dominio.servicio.DetallePedido;
import com.ceiba.dominio.servicio.Pedido;
import com.ceiba.infraestructura.repository.query.QueryConstant;

@Repository
public class DetallePedidoRepositorio extends BaseRepositorio implements RepositorioDetallePedido {

	@Override
	public void crearDetallesPedido(List<DetallePedido> detallesPedido) {
		for (DetallePedido detallePedido : detallesPedido) {
			this.customNamedParameterJdbcTemplate.crear(detallePedido, QueryConstant.QUERY_CREAR_DETALLE_PEDIDO);
		}
		
	}

	@Override
	public Pedido obtenerPedido(String idPedido) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente obtenerCliente(String idCliente) {
		// TODO Auto-generated method stub
		return null;
	}

}
