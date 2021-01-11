package com.ceiba.dominio.repositorio;

import com.ceiba.dominio.servicio.Tarifa;

public interface RepositorioTarifa {
	/**
	 * Permite obtener la tarifa de envio de un municipio dado un idMunicipio
	 * @param idMunicipio
	 * @return tarifa
	 */
	Double obtenerTarifaPorMunicipio(Long idMunicipio);
}
