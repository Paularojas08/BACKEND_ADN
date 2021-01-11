package dominio.test;

import static org.mockito.Mockito.mock;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.ceiba.dominio.repositorio.RepositorioDetallePedido;
import com.ceiba.dominio.repositorio.RepositorioPedido;
import com.ceiba.dominio.repositorio.RepositorioProducto;
import com.ceiba.dominio.repositorio.RepositorioTarifa;
import com.ceiba.dominio.servicio.Pedido;
import com.ceiba.dominio.servicio.SolicitudPedido;
import com.ceiba.dominio.servicio.SolicitudPedidoProducto;
import com.ceiba.dominio.servicio.builder.SolicitudPedidoBuilder;
import com.ceiba.dominio.servicio.builder.SolicitudPedidoProductoBuilder;
import com.ceiba.dominio.servicio.pedido.ServicioCrearPedido;

public class ServicioCrearPedidoTest {
	private static final String CEDULA = "1094956843";
	private static final String NOMBRE_COMPLETO = "Juanito Perez";
	private static final String DIRECCION = "Carrera 12 #13-12";
	private static final Long ID_MUNICIPIO = 8l;
	private static final String CODIGO_PRODUCTO_1 = "354";
	private static final int CANTIDAD_1 = 2;
	private static final String CODIGO_PRODUCTO_2 = "56";
	private static final int CANTIDAD_2 = 1;
	private static final double PRECIO_PEDIDO = 525000;

	@Test
	public void crearPedidoTest() {
		SolicitudPedidoProducto solicitudPedidoProducto1 = new SolicitudPedidoProductoBuilder()
				.conCodigoProducto(CODIGO_PRODUCTO_1).conCantidad(CANTIDAD_1).toSolicitudPedidoProducto();

		SolicitudPedidoProducto solicitudPedidoProducto2 = new SolicitudPedidoProductoBuilder()
				.conCodigoProducto(CODIGO_PRODUCTO_2).conCantidad(CANTIDAD_2).toSolicitudPedidoProducto();

		List<SolicitudPedidoProducto> listaSolicitudPedidoProductos = Arrays.asList(solicitudPedidoProducto1,
				solicitudPedidoProducto2);

		SolicitudPedido solicitudPedido = new SolicitudPedidoBuilder().conCedula(CEDULA).conDireccion(DIRECCION)
				.conIdMunicipio(ID_MUNICIPIO).conNombreCompleto(CEDULA)
				.conSolicitudPedidoProductos(listaSolicitudPedidoProductos).toSolicitudPedido();

         RepositorioPedido repositorioPedido=mock(RepositorioPedido.class);
         RepositorioDetallePedido repositorioDetallePedido=mock(RepositorioDetallePedido.class);
         RepositorioProducto repositorioProducto=mock(RepositorioProducto.class);
         RepositorioTarifa repositorioTarifa=mock(RepositorioTarifa.class);
         
		ServicioCrearPedido servicioCrearPedido=new ServicioCrearPedido(repositorioPedido, repositorioDetallePedido, repositorioProducto, repositorioTarifa);
		
		servicioCrearPedido.crearPedido(solicitudPedido);
	}
}
