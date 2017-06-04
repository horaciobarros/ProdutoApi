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

import br.com.montreal.ws.model.Produto;
import br.com.montreal.ws.service.ProdutoService;

/**
 * Trata todas as requisições 
 * @author Horacio
 *
 */
@RestController
public class ProdutoRestController {

	@Autowired
	private ProdutoService service;

	private Gson gson = new Gson();

	@RequestMapping(method = RequestMethod.GET, value = "produtos")
	String listAll() {

		List<Produto> produtos = new ArrayList<Produto>();
		
		produtos = service.getMock();

		for (Produto produto : service.listAll()) {
			produtos.add(produto);
		}
		return gson.toJson(produtos);
	}

	@RequestMapping(method = RequestMethod.GET, value = "produtosComPais")
	String listAllWithProdutoPai() {

		List<Produto> produtos = new ArrayList<Produto>();

		for (Produto produto : service.listAllWithProdutoPai()) {
			produtos.add(produto);
		}
		return gson.toJson(produtos);
	}

	@RequestMapping(method = RequestMethod.GET, value = "produto")
	String byId(@PathParam("id") String id) {

		Produto produto = service.byId(Long.valueOf(id));

		return gson.toJson(produto);
	}

	@RequestMapping(method = RequestMethod.GET, value = "produtosFilhos")
	String listFilhos(@PathParam("idPai") String idPai) {

		List<Produto> produtos = new ArrayList<Produto>();

		for (Produto produto : service.listFilhos(Long.valueOf(idPai))) {
			produtos.add(produto);
		}
		return gson.toJson(produtos);
	}

	@RequestMapping(method = RequestMethod.POST, value = "create", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Produto> update(@RequestBody Produto produto) {

		try {
			produto = service.update(produto);

			return new ResponseEntity<Produto>(produto, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Produto>(produto, HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(method = RequestMethod.PUT, value = "update", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Produto> create(@RequestBody Produto produto) {

		try {
			produto = service.create(produto);

			return new ResponseEntity<Produto>(produto, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Produto>(produto, HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "delete", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Produto> delete(@RequestBody Produto produto) {

		try {
			service.delete(produto);

			return new ResponseEntity<Produto>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Produto>(produto, HttpStatus.BAD_REQUEST);
		}
	}

}