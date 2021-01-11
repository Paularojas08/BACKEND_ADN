package com.ceiba.infraestructura.repository.query;

public class QueryConstant {

	public static final String QUERY_SQL_CREAR_PEDIDO = "INSERT INTO pedidos VALUES (?, ?, ?, ?, ?)";
	public static final String QUERY_SQL_ACTUALIZAR_PEDIDO = "UPDATE pedidos SET identificadorseguimiento=?, fechapedido=?, fechaenvio=?, preciototal=?, estado=? WHERE id=?";
	public static final String QUERY_SQL_ELIMINAR_PEDIDO = "DELETE FROM pedidos WHERE id=?";
	public static final String QUERY_OBTENER_DETALLE_PEDIDO="SELECT * FROM detallepedidos WHERE idpedido = ?";
	
	public static final String QUERY_CREAR_DETALLE_PEDIDO = "INSERT INTO detallepedidos VALUES (?, ?, ?, ?, ?)";
	public static final String QUERY_OBTENER_PRECIO_TOTAL_PRODUCTOS = "SELECT SUM(p.precio) FROM productos p WHERE p.codigo IN (:test)";

	private QueryConstant() {}
}
