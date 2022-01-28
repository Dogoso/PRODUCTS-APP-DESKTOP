package com.doglab.controller;

import java.util.List;

import com.doglab.dao.ProdutosDAO;
import com.doglab.factory.ConnectionFactory;
import com.doglab.model.Produto;

public class ProductController {

	private ProdutosDAO dao;
	
	public ProductController() {
		dao = new ProdutosDAO(new ConnectionFactory().getConnection());
	}
	
	public void save(Produto prod) {
		dao.create(prod);
	}
	
	public void delete(int id) {
		Produto produto = new Produto();
		produto.setId(id);
		dao.delete(produto);
	}
	
	public List<Produto> list() {
		return dao.read();
	}
	
	public void update(String name, String description, int id) {
		Produto produto = new Produto();
		produto.setId(id);
		produto.setName(name);
		produto.setDescription(description);
		dao.update(produto);
	}
	
}
