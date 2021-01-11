package com.ceiba.dominio.utils.validation;

import com.ceiba.dominio.servicio.Pedido;

@FunctionalInterface
public interface ReglasDeNegocio {
	void validar(Pedido pedido);
}
