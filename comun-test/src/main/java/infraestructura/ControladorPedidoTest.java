package infraestructura;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.ceiba.comando.ComandoPedido;
import com.fasterxml.jackson.databind.ObjectMapper;

import testdatabuilder.PedidoTestDataBuilder;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(classes = ControladorPedidoTest.class)
public class ControladorPedidoTest {

	@Autowired
	private MockMvc mvc;

	@Test
	public void generarPedido() throws Exception {
		ComandoPedido comandoPedido = new PedidoTestDataBuilder().buildComando();

		mvc.perform(MockMvcRequestBuilders.post("/pedido").content(asJsonString(comandoPedido))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}
}
