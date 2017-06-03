package br.com.montreal.ws.service;

import java.util.List;

import br.com.montreal.ws.model.Produto;

/**
 * Intermedia todo o acesso ao repositório de produtos
 * @author Horacio
 *
 */
public interface ProdutoService {

	List<Produto> listAll();

	List<Produto> listAllWithProdutoPai();

	Produto byId(Long id);

	List<Produto> listFilhos(Long idPai);

	Produto create(Produto produto);

	Produto update(Produto produto);

	void delete(Produto produto);

	List<Produto> getMock();

	Produto createProduto();

}
