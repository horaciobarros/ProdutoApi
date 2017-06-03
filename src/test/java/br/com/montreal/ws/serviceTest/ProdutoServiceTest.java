package br.com.montreal.ws.serviceTest;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import br.com.montreal.ws.model.Imagem;
import br.com.montreal.ws.model.Produto;
import br.com.montreal.ws.service.ImagemService;
import br.com.montreal.ws.service.ProdutoService;

/**
 * Teste da service de produto
 * 
 * @author Horacio
 * 
 */

public class ProdutoServiceTest extends ProdutoApiTests {

	@Autowired
	ProdutoService service;

	@Autowired
	ImagemService imagemService;

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

		Produto produto = createProduto();
		
		for (Imagem imagem : imagemService.listImageByIdProduto(produto.getId())) {
			imagemService.delete(imagem);
		}

		service.delete(produto);

	}

	private Produto createProduto() {
		Produto p = new Produto();
		p.setDescricao("Arroz tipo 1 Riachuelo");
		p.setNome("Arroz");
		return service.create(p);
	}

	@Test
	public void testUpdate() {

		for (Produto produto : service.getMock()) {

			service.update(produto);
		}

	}

}
