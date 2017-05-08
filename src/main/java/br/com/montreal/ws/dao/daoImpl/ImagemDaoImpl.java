package br.com.montreal.ws.dao.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.montreal.ws.dao.ImagemDao;
import br.com.montreal.ws.model.Imagem;

@Repository
public class ImagemDaoImpl implements ImagemDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Imagem> listImageByIdProduto(final Long idProduto) {
		final StringBuilder jpql = new StringBuilder().append("SELECT imagem ")
				.append("FROM Imagem i  ")
				//
		.append("INNER JOIN i.produto p  ")
		.append("WHERE p.id = :idProduto ");
		final Query query = em.createQuery(jpql.toString());
		query.setParameter("idProduto", idProduto);
		return query.getResultList();

	}

	@Override
	public Imagem create(final Imagem imagem) {
		em.persist(imagem);

		return imagem;

	}

	@Override
	public Imagem update(final Imagem imagem) {
		em.merge(imagem);
		return imagem;
	}

	@Override
	public Imagem delete(final Imagem imagem) {
		em.remove(imagem);

		return imagem;

	}

}
