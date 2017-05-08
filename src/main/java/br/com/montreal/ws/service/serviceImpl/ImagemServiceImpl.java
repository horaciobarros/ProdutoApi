package br.com.montreal.ws.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.montreal.ws.dao.ImagemDao;
import br.com.montreal.ws.model.Imagem;
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

}
