package com.ceiba.infraestructura.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ceiba.dominio.repositorio.RepositorioTarifa;
import com.ceiba.infraestructura.dao.TarifaDao;

@Repository
public class TarifaRepositorio  implements RepositorioTarifa{

	@Autowired
	private TarifaDao tarifaDao;
	
	@Override
	public Double obtenerTarifaPorMunicipio(Long idMunicipio) {
		return tarifaDao.obtenerTarifaPorIdMunicipio(idMunicipio);
	}

}
