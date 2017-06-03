package br.com.montreal.ws.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import br.com.montreal.ws.dao.ProdutoDao;
import br.com.montreal.ws.model.Produto;
import br.com.montreal.ws.service.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService {

	@Autowired
	ProdutoDao dao;

	@Override
	public List<Produto> listAll() {
		return dao.listAll();
	}

	@Override
	public List<Produto> listAllWithProdutoPai() {
		return dao.listAllWithProdutoPai();
	}

	@Override
	public Produto byId(Long id) {
		return dao.byId(id);
	}

	@Override
	public List<Produto> listFilhos(Long idPai) {
		return dao.listFilhos(idPai);
	}

	@Override
	public Produto create(Produto produto) {
		return dao.create(produto);

	}

	@Override
	public Produto update(Produto produto) {
		return dao.update(produto);

	}

	@Override
	public void delete(Produto produto) {
		dao.delete(produto);
	}

	@Override
	public List<Produto> getMock() {
		List<Produto> produtos = new ArrayList<Produto>();
		Produto p = new Produto();
		p.setDescricao("Arroz tipo 1 Riachuelo");
		p.setId(Long.valueOf(1));
		p.setNome("Arroz");
		produtos.add(p);
		p = new Produto();
		p.setDescricao("Feijão Carioquinha");
		p.setId(Long.valueOf(2));
		p.setNome("Carioquinha");
		produtos.add(p);
		return produtos;
	}

	@Override
	public Produto createProduto() {
		Produto produto = new Produto();
		produto.setDescricao("Arroz tipo 1 Riachuelo");
		produto.setNome("Arroz");
		produto = create(produto);
		return produto;
	}

}
