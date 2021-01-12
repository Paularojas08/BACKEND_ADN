package com.ceiba.infraestructura.dao;

import org.springframework.data.repository.CrudRepository;

import com.ceiba.infraestructura.model.PedidoModelo;

public interface PedidoDao extends CrudRepository<PedidoModelo, Long>{
	
}
