package com.ceiba.comando;

import java.util.List;

import com.ceiba.dominio.servicio.SolicitudPedidoProducto;

public class ComandoPedido {
	private String cedula;
	private String nombreCompleto;
	private String direccion;
	private Long idMunicipio;
	private List<SolicitudPedidoProducto> solicitudPedidoProductos;

	public ComandoPedido() {
		super();
	}


	public ComandoPedido(String cedula, String nombreCompleto, String direccion, Long idMunicipio,
			List<SolicitudPedidoProducto> listaSolicitudPedidoProductos) {

	this.cedula=cedula;
	this.nombreCompleto=nombreCompleto;
	this.direccion=direccion;
	this.idMunicipio=idMunicipio;
	this.solicitudPedidoProductos=listaSolicitudPedidoProductos;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Long getIdMunicipio() {
		return idMunicipio;
	}

	public void setIdMunicipio(Long idMunicipio) {
		this.idMunicipio = idMunicipio;
	}

	public List<SolicitudPedidoProducto> getSolicitudPedidoProductos() {
		return solicitudPedidoProductos;
	}

	public void setSolicitudPedidoProductos(List<SolicitudPedidoProducto> solicitudPedidoProductos) {
		this.solicitudPedidoProductos = solicitudPedidoProductos;
	}

	

}
