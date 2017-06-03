package br.com.montreal.ws.serviceTest;

import java.util.List;

import junit.framework.TestCase;

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
 * Teste da service de imagens
 * 
 * @author Horacio
 *
 */
public class ImagemServiceTest extends ProdutoApiSuiteTest {

	@Autowired
	ImagemService service;

	@Autowired
	ProdutoService produtoService;

	List<Imagem> imagens;

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

		createRecords();

		imagens = service.listImageByIdProduto(Long.valueOf(1));

	}

	private void createRecords() {

		service.createMockWithProduto(createProdutoAux());

	}

	private Produto createProdutoAux() {
		Produto produto = new Produto();
		produto.setDescricao("Arroz tipo 1 Riachuelo");
		produto.setNome("Arroz");
		produto = produtoService.create(produto);
		return produto;
	}

	@Test
	public void testCreate() {
		
		Imagem im = new Imagem();
		im.setProduto(createProdutoAux());
		im.setFoto(new byte[]{121, 21, 10, 1, 12, 74, 11, 39, 55, 91, 45, 78, 14, 11, 22, 62});
		im.setTipo("PNG");
		service.create(im);

	}

	@Test
	public void testUpdate() {
		Imagem imagem = createImagem();
		imagem.setTipo("YYY");
		service.update(imagem);
	}

	@Test
	public void testDelete() {
		Imagem imagem = createImagem();

		service.delete(imagem);
	}
	
	private Imagem createImagem() {
		byte[] foto = new byte[]{121, 21, 10, 1, 12, 74, 11, 39, 55, 91, 45, 78, 14, 11, 22, 62};
		Imagem imagem = new Imagem();
		imagem.setFoto(foto);
		imagem.setTipo("GIF");
		imagem.setProduto(createProdutoAux());
		imagem = service.create(imagem);
		return imagem;
	}
}


