package br.com.montreal.ws.dao;

import java.util.List;

import br.com.montreal.ws.model.Produto;

/**
 * Acesso ao repositório de produtos
 * @author Horacio
 *
 */
public interface ProdutoDao {
	
	List<Produto> listAll();
	
	List<Produto> listAllWithProdutoPai();
	
	List<Produto> listAllWithProdutoPai(Long id);
	
	Produto byId(Long id);
	
	List<Produto> listFilhos(Long idPai);
	
	Produto create(Produto produto);

	Produto update(Produto produto);

	void delete(Produto produto);

}
