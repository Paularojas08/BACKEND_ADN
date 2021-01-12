package com.ceiba.infraestructura.repository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ceiba.dominio.repositorio.RepositorioDetallePedido;
import com.ceiba.dominio.servicio.Cliente;
import com.ceiba.dominio.servicio.DetallePedido;
import com.ceiba.dominio.servicio.Pedido;
import com.ceiba.infraestructura.builder.DetallePedidoBuilder;
import com.ceiba.infraestructura.dao.DetallePedidoDao;
import com.ceiba.infraestructura.model.DetallePedidoModelo;

@Repository
public class DetallePedidoRepositorio  implements RepositorioDetallePedido{

	@Autowired
	DetallePedidoDao detallePedidoDao;
	
	@Override
	public void crearDetallesPedido(List<DetallePedido> detallesPedido) {
		List<DetallePedidoModelo> detallesPedidoModelo = detallesPedido.stream().map(DetallePedidoBuilder::convertirAModelo).collect(Collectors.toList());
		detallePedidoDao.saveAll(detallesPedidoModelo);
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
