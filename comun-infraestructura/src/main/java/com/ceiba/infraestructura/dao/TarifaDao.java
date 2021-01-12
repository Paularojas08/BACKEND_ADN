package com.ceiba.infraestructura.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ceiba.infraestructura.model.TarifaModelo;

public interface TarifaDao extends CrudRepository<TarifaModelo, Long>{
	
	@Query("SELECT t.precio FROM TarifaModelo t WHERE t.idMunicipio = ?1")
	Double obtenerTarifaPorIdMunicipio(Long idMunicipio);
}
