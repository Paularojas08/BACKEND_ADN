package com.ceiba.dominio.repositorio;

import java.util.List;

import com.ceiba.dominio.servicio.Cliente;
import com.ceiba.dominio.servicio.DetallePedido;
import com.ceiba.dominio.servicio.Pedido;

public interface RepositorioDetallePedido {
	
	void crearDetallesPedido(List<DetallePedido> detallesPedido);
	
	Pedido obtenerPedido(String idPedido);
	
	Cliente obtenerCliente(String idCliente);
}
