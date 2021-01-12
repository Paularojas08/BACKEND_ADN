package com.ceiba.infraestructura.repository;

import org.springframework.stereotype.Repository;

import com.ceiba.dominio.repositorio.RepositorioTarifa;
import com.ceiba.infraestructura.repository.query.QueryConstant;

@Repository
public class TarifaRepositorio extends BaseRepositorio implements RepositorioTarifa{

	@Override
	public Double obtenerTarifaPorMunicipio(Long idMunicipio) {
		return this.customNamedParameterJdbcTemplate.obtenerDoubleValue("idMunicipio", idMunicipio, QueryConstant.QUERY_OBTENER_PRECIO_TARIFA_MUNICIPIO);
	}

}
