package br.com.montreal.ws.controller;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import br.com.montreal.ws.model.Imagem;
import br.com.montreal.ws.service.ImagemService;

@RestController
public class ImagemRestController {
	
	private Gson gson = new Gson();
	
	@Autowired
	private ImagemService service;

	/**
	 * Consulta de todas as imagens
	 * @param idProduto
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "imagens")
	String listImagens(@PathParam("idProduto") String idProduto) {

		List<Imagem> imagens = new ArrayList<Imagem>();

		for (Imagem imagem : service.listImageByIdProduto(Long.valueOf(idProduto))) {
			imagens.add(imagem);
		}
		return gson.toJson(imagens);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "createImagem", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Imagem> update(@RequestBody Imagem imagem) {

		try {
			imagem = service.update(imagem);

			return new ResponseEntity<Imagem>(imagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Imagem>(imagem, HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(method = RequestMethod.PUT, value = "updateImagem", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Imagem> create(@RequestBody Imagem imagem) {

		try {
			imagem = service.create(imagem);

			return new ResponseEntity<Imagem>(imagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Imagem>(imagem, HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "deleteImagem", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Imagem> delete(@RequestBody Imagem imagem) {

		try {
			imagem = service.delete(imagem);

			return new ResponseEntity<Imagem>(imagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Imagem>(imagem, HttpStatus.BAD_REQUEST);
		}
	}

	
}
