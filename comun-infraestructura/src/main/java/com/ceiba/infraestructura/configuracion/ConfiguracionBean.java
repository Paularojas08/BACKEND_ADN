package com.ceiba.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ceiba.dominio.repositorio.RepositorioDetallePedido;
import com.ceiba.dominio.repositorio.RepositorioPedido;
import com.ceiba.dominio.repositorio.RepositorioProducto;
import com.ceiba.dominio.repositorio.RepositorioTarifa;
import com.ceiba.dominio.servicio.pedido.ServicioCrearPedido;
import com.ceiba.dominio.servicio.pedido.interfaces.ServicioSolicitudCrearPedido;

@Configuration
public class ConfiguracionBean {
	
	@Bean
    public ServicioSolicitudCrearPedido servicioCrearPedidoService(RepositorioPedido repositorioPedido, RepositorioDetallePedido repositorioDetallePedido, RepositorioProducto repositorioProducto, RepositorioTarifa repositorioTarifa) {
        return new ServicioCrearPedido(repositorioPedido, repositorioDetallePedido, repositorioProducto, repositorioTarifa);
    }
}
