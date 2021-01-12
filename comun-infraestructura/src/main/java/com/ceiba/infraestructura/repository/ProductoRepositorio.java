package com.ceiba.infraestructura.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ceiba.dominio.repositorio.RepositorioProducto;
import com.ceiba.dominio.servicio.Producto;
import com.ceiba.infraestructura.repository.query.QueryConstant;

@Repository
public class ProductoRepositorio extends BaseRepositorio implements RepositorioProducto{

	@Override
	public Producto obtener(String codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double obtenerPrecioTotalProductos(List<String> identificadoresProductos) {
		return this.customNamedParameterJdbcTemplate.obtenerDoubleValue("test", identificadoresProductos, QueryConstant.QUERY_OBTENER_PRECIO_TOTAL_PRODUCTOS);
	}
}
