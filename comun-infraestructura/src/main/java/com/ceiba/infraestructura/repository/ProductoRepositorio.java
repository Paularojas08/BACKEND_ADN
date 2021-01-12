package com.ceiba.infraestructura.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ceiba.dominio.repositorio.RepositorioProducto;
import com.ceiba.dominio.servicio.Producto;
import com.ceiba.infraestructura.builder.ProductoBuilder;
import com.ceiba.infraestructura.dao.ProductoDao;

@Repository
public class ProductoRepositorio  implements RepositorioProducto {

	@Autowired
	private ProductoDao productoDao; 
	
	@Override
	public Producto obtener(String codigo) {
		return ProductoBuilder.convertirADominio(productoDao.obtenerProductoPorCodigo(codigo));
		
	}

	@Override
	public Double obtenerPrecioTotalProductos(List<String> identificadoresProductos) {
		return productoDao.obtenerPrecioTotalProductos(identificadoresProductos);
	}
}
