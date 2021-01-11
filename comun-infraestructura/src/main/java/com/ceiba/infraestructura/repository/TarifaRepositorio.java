package com.ceiba.infraestructura.repository;

import org.springframework.stereotype.Repository;

import com.ceiba.dominio.repositorio.RepositorioTarifa;

@Repository
public class TarifaRepositorio extends BaseRepositorio implements RepositorioTarifa{

	@Override
	public Double obtenerTarifaPorMunicipio(Long idMunicipio) {
		// TODO Auto-generated method stub
		return null;
	}

}
