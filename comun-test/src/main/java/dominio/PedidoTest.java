package dominio;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import com.ceiba.dominio.repositorio.RepositorioDetallePedido;
import com.ceiba.dominio.repositorio.RepositorioPedido;
import com.ceiba.dominio.repositorio.RepositorioProducto;
import com.ceiba.dominio.repositorio.RepositorioTarifa;
import com.ceiba.dominio.servicio.SolicitudPedido;
import com.ceiba.dominio.servicio.pedido.ServicioCrearPedido;

import testdatabuilder.PedidoTestDataBuilder;

public class PedidoTest {
	private static final double PRECIO_SOBRE_COSTO_TARIFA = 1015500;

	@Test
	public void calcularPrecioPedidoTest() {

		SolicitudPedido solicitudPedido = new PedidoTestDataBuilder().build();

		RepositorioPedido repositorioPedido = mock(RepositorioPedido.class);
		RepositorioDetallePedido repositorioDetallePedido = mock(RepositorioDetallePedido.class);
		RepositorioProducto repositorioProducto = mock(RepositorioProducto.class);
		RepositorioTarifa repositorioTarifa = mock(RepositorioTarifa.class);

		ServicioCrearPedido servicioCrearPedido = new ServicioCrearPedido(repositorioPedido, repositorioDetallePedido,
				repositorioProducto, repositorioTarifa);
		double precioPedido = servicioCrearPedido.calcularPrecioPedido(solicitudPedido.getSolicitudPedidoProductos(),
				solicitudPedido.getIdMunicipio());

		assertEquals(PRECIO_SOBRE_COSTO_TARIFA, precioPedido, 0);
	}
}
