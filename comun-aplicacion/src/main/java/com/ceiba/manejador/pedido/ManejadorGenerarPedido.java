package com.ceiba.manejador.pedido;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ceiba.dominio.servicio.SolicitudPedido;
import com.ceiba.dominio.servicio.pedido.interfaces.ServicioSolicitudCrearPedido;
import com.ceiba.manejador.ManejadorComando;

@Component
public class ManejadorGenerarPedido implements ManejadorComando<SolicitudPedido> {

	private final ServicioSolicitudCrearPedido servicioCrearPedido;

	public ManejadorGenerarPedido(ServicioSolicitudCrearPedido servicioCrearPedido) {
		this.servicioCrearPedido = servicioCrearPedido;
	}

	@Transactional
	public void ejecutar(SolicitudPedido solicitudPedido) {
		this.servicioCrearPedido.crearPedido(solicitudPedido);
	}
}
