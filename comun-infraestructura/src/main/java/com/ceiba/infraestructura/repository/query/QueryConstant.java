package com.ceiba.infraestructura.repository.query;


public class QueryConstant {

	public static final String QUERY_SQL_CREAR_PEDIDO = "INSERT INTO pedidos(identificadorseguimiento, fechapedido, fechaenvio, preciototal, estado) VALUES (:identificadorSeguimiento, :fechaPedido, :fechaEnvio, :precioTotal, :estado)";
	
	public static final String QUERY_SQL_OBTENER_PEDIDO = "SELECT p.id FROM pedidos p Where p.identificadorseguimiento= :idSeguimiento";
	public static final String QUERY_SQL_ELIMINAR_PEDIDO = "DELETE FROM pedidos WHERE id= :id";
	
	public static final String QUERY_CREAR_DETALLE_PEDIDO = "INSERT INTO detallepedidos (cantidadpedida,producto_id, pedido_id) VALUES(:cantidadPedida, :productoId, :pedidoId) ";
	
	public static final String QUERY_OBTENER_PRECIO_TOTAL_PRODUCTOS = "SELECT SUM(p.precio) FROM productos p WHERE p.codigo IN (:test)";
	public static final String QUERY_OBTENER_PRECIO_TARIFA_MUNICIPIO = "SELECT t.precio FROM tarifas t WHERE t.idmunicipio = :idMunicipio";


	private QueryConstant() {}
}
