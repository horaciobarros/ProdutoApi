package br.com.montreal.ws.serviceTest;

import java.util.List;

import junit.framework.TestCase;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.montreal.ws.model.Imagem;
import br.com.montreal.ws.service.ImagemService;

/**
 * Teste da service de imagens
 * @author Horacio
 *
 */
public class ImagemServiceTest extends TestCase {

	@Autowired
	ImagemService service;

	List<Imagem> imagens;

	public void testListAll() {
		imagens = service.listImageByIdProduto(Long.valueOf(1));
		assertTrue(imagens != null);

	}

	public void testCreate() {

	}

	public void testUpdate() {

	}

	public void testDelete() {

	}

}
