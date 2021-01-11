package com.ceiba.infraestructura.repository;

import org.springframework.beans.factory.annotation.Autowired;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;

public abstract class BaseRepositorio {
	
	@Autowired
	protected CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

}
