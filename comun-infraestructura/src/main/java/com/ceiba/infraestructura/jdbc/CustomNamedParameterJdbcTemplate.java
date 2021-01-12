package com.ceiba.infraestructura.jdbc;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ceiba.dominio.servicio.Pedido;
import com.ceiba.infraestructura.excepcion.ExcepcionTecnica;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class CustomNamedParameterJdbcTemplate {

	private static final String ERROR_OBTENIENDO_EL_NOMBRE_Y_VALOR_DE_OBJETO = "Error obteniendo el nombre y valor de objeto";
	
	private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	public CustomNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}
	
	public Long crear(Object object,String sql) {
		MapSqlParameterSource paramSource = crearParametros(object);
		KeyHolder keyHolder = new GeneratedKeyHolder();
		this.namedParameterJdbcTemplate.update(sql, paramSource,keyHolder,new String[] { "id" });
		return keyHolder.getKey().longValue();
	}
	
	public void actualizar(Object object,String sql) {
		MapSqlParameterSource paramSource = crearParametros(object);
		this.namedParameterJdbcTemplate.update(sql, paramSource);
	}
	
	public Double obtenerDoubleValue(String paramName, Object object,String sql) {
		MapSqlParameterSource paramSource = crearParametroUnico(paramName, object);
	    return namedParameterJdbcTemplate.queryForObject(sql, paramSource, Double.class);
	}
	
	//List<Pedido> pedidos = namedParameterJdbcTemplate.query(sql, new BeanPropertyRowMapper<Pedido>(Pedido.class));
		
	private MapSqlParameterSource crearParametros(Object object) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		Field[] fields = object.getClass().getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			try {
				Field field = fields[i];
				if (!Modifier.isStatic(field.getModifiers()) && !Modifier.isFinal(field.getModifiers())) {
					field.setAccessible(true);
					paramSource.addValue(field.getName(), field.isEnumConstant() ? field.get(object) + "" : field.get(object));
					field.setAccessible(false);
				}
			} catch (Exception e) {
				throw new ExcepcionTecnica(ERROR_OBTENIENDO_EL_NOMBRE_Y_VALOR_DE_OBJETO, e);
			} 
		}
		return paramSource;
	}
	
	private MapSqlParameterSource crearParametroUnico(String paramName, Object value) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue(paramName, value);
		return paramSource;
	}
	
	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
		return this.namedParameterJdbcTemplate;
	}
}
