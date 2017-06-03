package br.com.montreal.ws.serviceTest;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import br.com.montreal.ws.model.Produto;
import br.com.montreal.ws.service.ProdutoService;

/**
 * Teste da service de produto
 * @author Horacio
 * 
 */

public class ProdutoServiceTest extends ProdutoApiTest {

	@Autowired
	ProdutoService service;

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	List<Produto> produtos;
	
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void testListAll() {
		
		produtos = service.listAll();
		

	}

	@Test
	public void testCreate() {

		for (Produto produto : service.getMock()) {
			produto.setId(null);
			service.create(produto);
		}

	}

		
	@Test
	public void testDelete() {

		testCreate();
		Produto produto = service.byId(Long.valueOf(1));
		service.delete(produto);
		
	}
	
	@Test
	public void testUpdate() {

		for (Produto produto : service.getMock()) {

			service.update(produto);
		}

	}



}
