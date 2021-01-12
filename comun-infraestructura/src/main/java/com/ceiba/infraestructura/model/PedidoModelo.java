package com.ceiba.infraestructura.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.ceiba.dominio.utils.EstadoPedido;

@Entity
@Table(name = "pedidos")
public class PedidoModelo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "identificadorseguimiento")
	private String identificadorSeguimiento;
	
	@Column(name = "fechapedido")
	private LocalDate fechaPedido;
	
	@Column(name = "fechaenvio")
	private LocalDate fechaEnvio;
	
	@Column(name = "preciototal")
	private Double precioTotal;
	
	@Enumerated(EnumType.STRING)
	private EstadoPedido estado;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIdentificadorSeguimiento() {
		return identificadorSeguimiento;
	}

	public void setIdentificadorSeguimiento(String identificadorSeguimiento) {
		this.identificadorSeguimiento = identificadorSeguimiento;
	}

	public LocalDate getFechaPedido() {
		return fechaPedido;
	}

	public void setFechaPedido(LocalDate fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

	public LocalDate getFechaEnvio() {
		return fechaEnvio;
	}

	public void setFechaEnvio(LocalDate fechaEnvio) {
		this.fechaEnvio = fechaEnvio;
	}

	public Double getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(Double precioTotal) {
		this.precioTotal = precioTotal;
	}

	public EstadoPedido getEstado() {
		return estado;
	}

	public void setEstado(EstadoPedido estado) {
		this.estado = estado;
	}
}
