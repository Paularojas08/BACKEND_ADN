package com.ceiba.infraestructura.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ceiba.infraestructura.model.ProductoModelo;

public interface ProductoDao extends CrudRepository<ProductoModelo, Long>{
	
	@Query("SELECT SUM(p.precio) FROM ProductoModelo p WHERE p.codigo IN ?1")
	Double obtenerPrecioTotalProductos(List<String> identificadoresProducto);
	
	@Query("SELECT p FROM ProductoModelo p WHERE p.codigo = ?1")
	ProductoModelo obtenerProductoPorCodigo(String codigo);
}
