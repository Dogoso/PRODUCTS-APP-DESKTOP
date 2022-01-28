package com.doglab.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.doglab.model.Categoria;
import com.doglab.model.Produto;

public class CategoriasDAO {

	private Connection conn;
	
	public CategoriasDAO(Connection conn) {
		this.conn = conn;
	}
	
	public List<Categoria> read() {
		try {
			List<Categoria> categorias = new ArrayList<Categoria>();
			String QUERY = "SELECT * FROM categorias;";
			try(Statement pstm = conn.createStatement()) {
				try(ResultSet rset = pstm.executeQuery(QUERY)){
					while(rset.next()) {
						Categoria categoria = new Categoria();
						categoria.setId(rset.getInt(1));
						categoria.setCategoria(rset.getString(2));
						categorias.add(categoria);
					}
				}
			}
			return categorias;
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Categoria> innerJoinProducts() throws SQLException {
		List<Categoria> categorias = new ArrayList<Categoria>();
		Categoria last = new Categoria();
		last.setCategoria("Categoria");
		String QUERY = "SELECT * FROM categorias c "
				+ "INNER JOIN produtos p "
				+ "ON c.id = p.categoria;";
		try(Statement pstm = conn.createStatement()) {
			try(ResultSet rset = pstm.executeQuery(QUERY)){
				while(rset.next()) {
					
					if(!last.getCategoria().equals(rset.getString(2))) {
						Categoria categoria = new Categoria();
						categoria.setId(rset.getInt(1));
						categoria.setCategoria(rset.getString(2));
						last = categoria;
						categorias.add(categoria);
					}
					
					Produto product = new Produto();
					product.setId(rset.getInt(3));
					product.setName(rset.getString(4));
					product.setDescription(rset.getString(5));
					product.setCategory(last.getId());
					
					last.addProduct(product);
				}
			}
		}
		return categorias;
	}
	
}
