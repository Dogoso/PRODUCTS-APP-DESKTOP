package com.doglab.controller;

import java.util.List;

import com.doglab.dao.CategoriasDAO;
import com.doglab.factory.ConnectionFactory;
import com.doglab.model.Categoria;

public class CategoryController {

	private CategoriasDAO dao;
	
	public CategoryController() {
		dao = new CategoriasDAO(new ConnectionFactory().getConnection());
	}
	
	public List<Categoria> list() {
		return dao.read();
	}
	
}
