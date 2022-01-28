package com.doglab.model;

import java.util.ArrayList;
import java.util.List;

public class Categoria {

	private int id;
	private String categoria;
	private List<Produto> products;
	
	public Categoria() {
		products = new ArrayList<Produto>();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public List<Produto> getProducts() {
		return products;
	}
	public void setProducts(List<Produto> products) {
		this.products = products;
	}
	
	public void addProduct(Produto p) {
		this.products.add(p);
	}
	
	@Override
	public String toString() {
		return this.categoria;
	}
	
}
