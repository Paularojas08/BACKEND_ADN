package com.ceiba.infraestructura.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.dominio.servicio.SolicitudPedido;
import com.ceiba.manejador.ManejadorComando;

@RestController
@RequestMapping("/pedido")
@CrossOrigin
public class ControladorPedido {
	
	private final ManejadorComando<SolicitudPedido> manejadorCrearPedido;

	public ControladorPedido(ManejadorComando<SolicitudPedido> manejadorCrearPedido) {
		this.manejadorCrearPedido = manejadorCrearPedido;
	}

	@PostMapping
	public void crear(@RequestBody SolicitudPedido solicitudPedido) {
		this.manejadorCrearPedido.ejecutar(solicitudPedido);
	}
}
