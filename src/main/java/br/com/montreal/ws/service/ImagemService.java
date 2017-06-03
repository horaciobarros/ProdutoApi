package br.com.montreal.ws.service;

import java.util.List;

import br.com.montreal.ws.model.Imagem;
import br.com.montreal.ws.model.Produto;

public interface ImagemService {

	/**
	 * Intermedia todo acesso ao repositório de imagens
	 * @param idProduto
	 * @return
	 */
	public List<Imagem> listImageByIdProduto(Long idProduto);

	Imagem create(Imagem imagem);

	Imagem update(Imagem imagem);

	Imagem delete(Imagem imagem);

	public void createMockWithProduto(Produto p);
	
	public Imagem byId(Long id);

}
