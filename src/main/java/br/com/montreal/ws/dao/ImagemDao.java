package br.com.montreal.ws.dao;

import java.util.List;

import br.com.montreal.ws.model.Imagem;

/**
 * Acesso ao repositório de imagens
 * @author Horacio
 *
 */
public interface ImagemDao {
	
	public List<Imagem> listImageByIdProduto(Long idProduto);
	
	Imagem create(Imagem imagem);

	Imagem update(Imagem imagem);

	Imagem delete(Imagem imagem);

}
