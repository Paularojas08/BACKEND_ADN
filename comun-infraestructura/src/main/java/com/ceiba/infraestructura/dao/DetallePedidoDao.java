package com.ceiba.infraestructura.dao;

import org.springframework.data.repository.CrudRepository;

import com.ceiba.infraestructura.model.DetallePedidoModelo;

public interface DetallePedidoDao extends CrudRepository<DetallePedidoModelo, Long>{
	
}
