package com.ceiba.dominio.servicio.producto;

import com.ceiba.dominio.repositorio.RepositorioProducto;
import com.ceiba.dominio.servicio.Producto;

public class ServicioObtenerProducto {
	private RepositorioProducto repositorioProducto;

	public ServicioObtenerProducto(RepositorioProducto repositorioProducto) {
		super();
		this.repositorioProducto = repositorioProducto;
	}

	public Producto ejecutar(String codigo) {
		return this.repositorioProducto.obtener(codigo);
	}
}
