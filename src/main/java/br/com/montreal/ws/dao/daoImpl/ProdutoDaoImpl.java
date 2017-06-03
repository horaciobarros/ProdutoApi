package br.com.montreal.ws.dao.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.montreal.ws.dao.ProdutoDao;
import br.com.montreal.ws.model.Produto;

@Repository
public class ProdutoDaoImpl implements ProdutoDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Produto> listAll() {
		StringBuilder jpql = new StringBuilder().append("SELECT p ").append("FROM Produto p  ");
		Query query = em.createQuery(jpql.toString(),Produto.class);

		return query.getResultList();
	}

	@Override
	public List<Produto> listFilhos(Long idPai) {
		StringBuilder jpql = new StringBuilder().append("SELECT p ").append("FROM Produto p  ") //
				.append("INNER JOIN p.produtoPai pai  ").append("WHERE pai.id = :idPai ");
		Query query = em.createQuery(jpql.toString(),Produto.class);
		query.setParameter("idPai", idPai);

		return (List<Produto>) query.getResultList();
	}

	@Override
	public Produto byId(Long id) {
		StringBuilder jpql = new StringBuilder().append("SELECT p ").append("FROM Produto p  ") //
				.append("WHERE p.id = :id ");
		Query query = em.createQuery(jpql.toString(),Produto.class);
		query.setParameter("id", id);

		return (Produto) query.getSingleResult();
	}

	@Override
	@Transactional
	public Produto create(Produto produto) {
		em.persist(produto);
		return produto;
	}

	@Override
	@Transactional
	public Produto update(Produto produto) {
		em.merge(produto);
		return produto;

	}

	@Override
	@Transactional
	public void delete(Produto produto) {
		em.remove(em.getReference(Produto.class, produto.getId()));

	}

	@Override
	public List<Produto> listAllWithProdutoPai() {
		StringBuilder jpql = new StringBuilder().append("SELECT p ").append("FROM Produto p  ") //
				.append("INNER JOIN p.produtoPai pai  ");
		Query query = em.createQuery(jpql.toString(),Produto.class);

		return (List<Produto>) query.getResultList();

	}

	@Override
	public List<Produto> listAllWithProdutoPai(Long id) {
		StringBuilder jpql = new StringBuilder().append("SELECT p ").append("FROM Produto p  ") //
				.append("INNER JOIN p.produtoPai pai  ").append("WHERE p.id = :id ");
		Query query = em.createQuery(jpql.toString(),Produto.class);
		query.setParameter("id", id);

		return (List<Produto>) query.getResultList();

	}

}
