package com.ceiba.infraestructura.builder;

import java.util.Optional;

import com.ceiba.dominio.servicio.Producto;
import com.ceiba.infraestructura.model.ProductoModelo;

public class ProductoBuilder {

	private ProductoBuilder() {

	}

	public static Producto convertirADominio(ProductoModelo productoModelo) {
		if (Optional.ofNullable(productoModelo).isPresent()) {
			Producto producto = new Producto();
			producto.setId(productoModelo.getId());
			producto.setCodigo(productoModelo.getCodigo());
			producto.setNombre(productoModelo.getNombre());
			producto.setPrecio(productoModelo.getPrecio());
			return producto;
		}
		return null;
	}

	public static ProductoModelo convertirAModelo(Producto producto) {
		ProductoModelo productoModelo = new ProductoModelo();
		productoModelo.setId(producto.getId());
		productoModelo.setCodigo(producto.getCodigo());
		productoModelo.setNombre(producto.getNombre());
		productoModelo.setPrecio(producto.getPrecio());
		return productoModelo;
	}
}
