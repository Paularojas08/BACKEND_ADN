package com.ceiba.dominio.repositorio;

import java.util.List;

import com.ceiba.dominio.servicio.Producto;

public interface RepositorioProducto {

	Producto obtener(String codigo);
	
	Double obtenerPrecioTotalProductos(List<String> identificadoresProductos);
}
