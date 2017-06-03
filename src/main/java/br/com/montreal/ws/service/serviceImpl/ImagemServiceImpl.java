package br.com.montreal.ws.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.montreal.ws.dao.ImagemDao;
import br.com.montreal.ws.model.Imagem;
import br.com.montreal.ws.model.Produto;
import br.com.montreal.ws.service.ImagemService;

@Service
public class ImagemServiceImpl implements ImagemService{
	
	@Autowired
	private ImagemDao dao;

	@Override
	public List<Imagem> listImageByIdProduto(Long idProduto) {
		return dao.listImageByIdProduto(idProduto);
	}

	@Override
	public Imagem create(Imagem imagem) {
		return dao.create(imagem);
		
	}

	@Override
	public Imagem update(Imagem imagem) {
		return dao.update(imagem);
	}

	@Override
	public Imagem delete(Imagem imagem) {
		return dao.delete(imagem);
		
	}

	@Override
	public void createMockWithProduto(Produto produto) {
		Imagem imagem = new Imagem();
		imagem.setProduto(produto);
		byte[] foto = new byte[]{121, 21, 10, 1, 12, 74, 11, 39, 55, 91, 45, 78, 14, 11, 22, 62};
		imagem.setFoto(foto);
		imagem.setTipo("GIF");
		imagem = dao.create(imagem);

		imagem = new Imagem();
		imagem.setProduto(produto);
		imagem.setFoto(foto);
		imagem.setTipo("PNG");
		imagem = dao.create(imagem);
		
		imagem = new Imagem();
		imagem.setProduto(produto);
		imagem.setFoto(foto);
		imagem.setTipo("peg");
		imagem = dao.create(imagem);
		
	}

	@Override
	public Imagem byId(Long id) {
		return dao.byId(id);
	}

}
