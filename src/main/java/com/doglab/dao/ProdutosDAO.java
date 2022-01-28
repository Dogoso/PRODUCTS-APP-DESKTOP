package com.doglab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.doglab.model.Produto;

// CRUD
public class ProdutosDAO {

	private static Connection conn;
	
	public ProdutosDAO(Connection conn) {
		ProdutosDAO.conn = conn;
	}
	
	public void create(Produto p) {
		String QUERY = "INSERT INTO produtos (nome, descricao) VALUES (?, ?)";
		// Try with resources!
		try (PreparedStatement pstm = conn.prepareStatement(QUERY)) {
			pstm.setString(1, p.getName());
			pstm.setString(2, p.getDescription());
			pstm.execute();
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Produto> read() {
		try {
			List<Produto> produtos = new ArrayList<Produto>();
			String QUERY = "SELECT * FROM produtos";
			Statement stm = conn.createStatement();
			ResultSet rslt = stm.executeQuery(QUERY);
			while(rslt.next()) {
				Produto produto = new Produto();
				produto.setId(rslt.getInt("id"));
				produto.setName(rslt.getString("nome"));
				produto.setDescription(rslt.getString("descricao"));
				produto.setCategory(rslt.getInt("categoria"));
				produtos.add(produto);
			}
			rslt.close();
			stm.close();
			return produtos;
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void update(Produto p) {
		try {
			String QUERY = "UPDATE produtos SET nome = ?, descricao = ? WHERE id = ?";
			PreparedStatement pstm = conn.prepareStatement(QUERY);
			pstm.setString(1, p.getName());
			pstm.setString(2, p.getDescription());
			pstm.setInt(3, p.getId());
			pstm.execute();
			pstm.close();
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void delete(Produto p) {
		try {
			String QUERY = "DELETE FROM produtos WHERE id = ?";
			PreparedStatement pstm = conn.prepareStatement(QUERY);
			pstm.setInt(1, p.getId());
			pstm.execute();
			pstm.close();
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}
