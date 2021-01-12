package com.ceiba.dominio.repositorio;

import java.util.List;

import com.ceiba.dominio.servicio.DetallePedido;
import com.ceiba.dominio.servicio.Pedido;

public interface RepositorioPedido {

	void crearPedido(Pedido pedido);

	Pedido actualizarPedido(Pedido pedido);

	boolean eliminarPedido(Long idPedido);

	Long obtenerPedidoPorIdentificadorSeguimiento(String identificadorSeguimiento);

	List<DetallePedido> obtenerDetallePedido(Long idPedido);	
}
