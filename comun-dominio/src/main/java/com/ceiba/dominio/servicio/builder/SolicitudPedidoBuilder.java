package com.ceiba.dominio.servicio.builder;

import java.util.List;

import com.ceiba.dominio.servicio.SolicitudPedido;
import com.ceiba.dominio.servicio.SolicitudPedidoProducto;

public class SolicitudPedidoBuilder {
	private SolicitudPedido solicitudPedido;

	public SolicitudPedidoBuilder build() {
		solicitudPedido = new SolicitudPedido();
		return this;
	}

	public SolicitudPedidoBuilder conIdMunicipio(Long idMunicipio) {
		solicitudPedido.setIdMunicipio(idMunicipio);
		return this;
	}

	public SolicitudPedidoBuilder conCedula(String cedula) {
		solicitudPedido.setCedula(cedula);
		return this;
	}

	public SolicitudPedidoBuilder conNombreCompleto(String nombreCompleto) {
		solicitudPedido.setNombreCompleto(nombreCompleto);
		return this;
	}

	public SolicitudPedidoBuilder conDireccion(String direccion) {
		solicitudPedido.setDireccion(direccion);
		return this;
	}
	public SolicitudPedidoBuilder conSolicitudPedidoProductos(List<SolicitudPedidoProducto> solicitudPedidoProductos) {
		solicitudPedido.setSolicitudPedidoProductos(solicitudPedidoProductos);
		return this;
	}

	public SolicitudPedido toSolicitudPedido() {
		return solicitudPedido;
	}
}
