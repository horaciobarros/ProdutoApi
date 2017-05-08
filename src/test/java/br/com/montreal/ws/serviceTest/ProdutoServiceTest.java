package br.com.montreal.ws.serviceTest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.montreal.ws.model.Produto;
import br.com.montreal.ws.service.ProdutoService;
import junit.framework.TestCase;

/**
 * Teste da service de produto
 * @author Horacio
 * 
 */
public class ProdutoServiceTest extends TestCase {

	@Autowired
	ProdutoService service;

	List<Produto> produtos;

	public void testListAll() {
		produtos = service.listAll();
		assertTrue(produtos != null);

	}

	public void testCreate() {

		for (Produto produto : service.getMock()) {

			service.create(produto);
		}

	}

	public void testUpdate() {

		for (Produto produto : service.getMock()) {

			service.update(produto);
		}

	}
	
	public void testDelete() {

		for (Produto produto : service.getMock()) {

			service.delete(produto);
		}

	}


}
