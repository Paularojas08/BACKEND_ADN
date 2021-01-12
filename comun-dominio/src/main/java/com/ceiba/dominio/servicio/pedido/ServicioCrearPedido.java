package com.ceiba.dominio.servicio.pedido;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.ceiba.dominio.repositorio.RepositorioDetallePedido;
import com.ceiba.dominio.repositorio.RepositorioPedido;
import com.ceiba.dominio.repositorio.RepositorioProducto;
import com.ceiba.dominio.repositorio.RepositorioTarifa;
import com.ceiba.dominio.servicio.DetallePedido;
import com.ceiba.dominio.servicio.Pedido;
import com.ceiba.dominio.servicio.SolicitudPedido;
import com.ceiba.dominio.servicio.SolicitudPedidoProducto;
import com.ceiba.dominio.servicio.builder.DetallePedidoBuilder;
import com.ceiba.dominio.servicio.builder.PedidoBuilder;
import com.ceiba.dominio.servicio.pedido.interfaces.ServicioSolicitudCrearPedido;
import com.ceiba.dominio.utils.EstadoPedido;
import com.ceiba.dominio.utils.UUIDUtil;
import com.ceiba.dominio.utils.validation.ReglaValidarPrecioPedido;
import com.ceiba.dominio.utils.validation.ReglasDeNegocio;

public class ServicioCrearPedido implements ServicioSolicitudCrearPedido {

	private RepositorioPedido repositorioPedido;
	private RepositorioDetallePedido repositorioDetallePedido;
	private RepositorioProducto repositorioProducto;
	private RepositorioTarifa repositorioTarifa;
	private final PedidoBuilder pedidoBuilder = new PedidoBuilder();
	private final DetallePedidoBuilder detallePedidoBuilder = new DetallePedidoBuilder();
	private ArrayList<ReglasDeNegocio> reglasDeNegocios;

	public ServicioCrearPedido(RepositorioPedido repositorioPedido, RepositorioDetallePedido repositorioDetallePedido,
			RepositorioProducto repositorioProducto, RepositorioTarifa repositorioTarifa) {
		super();
		this.repositorioPedido = repositorioPedido;
		this.repositorioDetallePedido = repositorioDetallePedido;
		this.repositorioProducto = repositorioProducto;
		this.repositorioTarifa = repositorioTarifa;
		reglasDeNegocios = new ArrayList<>();
	}

	@Override
	public void crearPedido(SolicitudPedido solicitudPedido) {
		double precioPedido = calcularPrecioPedido(solicitudPedido.getSolicitudPedidoProductos(), solicitudPedido.getIdMunicipio());
		Pedido pedido = contruirPedidoInicial(precioPedido);
		validar(pedido);
		repositorioPedido.crearPedido(pedido);
		List<DetallePedido> detallePedidos = construirDetallesPedido(pedido, solicitudPedido.getSolicitudPedidoProductos());
		repositorioDetallePedido.crearDetallesPedido(detallePedidos);
	}

	public double calcularPrecioPedido(List<SolicitudPedidoProducto> pedidoInicialProducto, Long idMunicipio) {
		List<String> identificadoresProductos = pedidoInicialProducto.stream()
				.map(SolicitudPedidoProducto::getCodigoProducto).collect(Collectors.toList());
		Double precioPedido = repositorioProducto.obtenerPrecioTotalProductos(identificadoresProductos);
		Double tarifaMunicipio = repositorioTarifa.obtenerTarifaPorMunicipio(idMunicipio);
		return precioPedido + tarifaMunicipio;
	}

	private Pedido contruirPedidoInicial(Double precioPedido) {
		return pedidoBuilder.build().conEstado(EstadoPedido.CREADO).conFechaPedido(LocalDate.now())
				.conPrecioTotal(precioPedido).conIdDeSeguimiento(UUIDUtil.generarUUID()).toPedido();	
	}

	private List<DetallePedido> construirDetallesPedido(Pedido pedido, List<SolicitudPedidoProducto> solicitudPedidoProductos) {
		return solicitudPedidoProductos.stream().map(solicitudProducto -> {
			return detallePedidoBuilder.build().conPedido(pedido)
					.conCantidadPedida(solicitudProducto.getCantidad())
					.conProducto(repositorioProducto.obtener(solicitudProducto.getCodigoProducto())).toDetallePedido();
		}).collect(Collectors.toList());
	}

	private void validar(Pedido pedido) {
		reglasDeNegocios.add(new ReglaValidarPrecioPedido());
		for (ReglasDeNegocio reglasDeNegocio : reglasDeNegocios) {
			reglasDeNegocio.validar(pedido);
		}
	}
}
