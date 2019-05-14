package produtopackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class ProdutoDAO {
	private Connection conn;
	public ProdutoDAO() {
		try {
			this.conn=new ConnectionFactory().getConnection();
			Statement statement = conn.createStatement();
			statement.execute("CREATE TABLE IF NOT EXISTS produto (Nome VARCHAR(30),Preço DOUBLE(10,2),Categoria VARCHAR(30),Usado BOOLEAN,ID_Prod INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT)");
		}
		catch(SQLException e) {
			e.printStackTrace();
		} 
	}
	
	
	public void insertProduto(Produto p) {
		String sql= "INSERT INTO produto (Nome,Preço,Categoria,Usado) VALUES (?,?,?,?)";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1,p.getNome());
			stmt.setDouble(2,p.getPreço());
			stmt.setString(3,p.getCategoria());
			stmt.setBoolean(4,p.isUsado());
			
			stmt.execute();
			stmt.close();
		}
		catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public Produto selectProduto(int ID_Prod) {
		String sql = "select * from produto WHERE ID_Prod = ?";
		Produto prodQUERY = new Produto();
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1,ID_Prod);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				prodQUERY.setNome(rs.getString("Nome"));
				prodQUERY.setPreço(rs.getDouble("Preço"));
				prodQUERY.setCategoria(rs.getString("Categoria"));
				prodQUERY.setUsado(rs.getBoolean("Usado"));
				prodQUERY.setID_Prod(rs.getInt("ID_Prod"));
			}
			return prodQUERY;
			
		}
		catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public void removeProduto(int ID_Prod) {
		String sql = "delete from produto where ID_Prod = ?";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1,ID_Prod);
			stmt.executeUpdate();
		}
		catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	
	public void updateProduto(int PK_ID_Prod,String Nome,String Categoria,double Preço, boolean Usado) {
		String sql = " update produto set Nome = ?,Categoria = ?, Preço = ?, Usado = ? where ID_Prod = ?";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1,Nome);
			stmt.setDouble(2,Preço);
			stmt.setString(3,Categoria);
			stmt.setBoolean(4,Usado);
			stmt.setInt(5,PK_ID_Prod);
		}
		catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
		
	
	public List<Produto> listProduto(){
		List<Produto> listaprod = new LinkedList<Produto>();
		String sql = "select * from produto";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs= stmt.executeQuery();
			while (rs.next()) {
				Produto prodQUERY = new Produto();
				prodQUERY.setNome(rs.getString("Nome"));
				prodQUERY.setID_Prod(rs.getInt("ID_Prod"));
				prodQUERY.setPreço(rs.getDouble("Preço"));
				prodQUERY.setCategoria(rs.getString("Categoria"));
				prodQUERY.setUsado(rs.getBoolean("Usado"));
				listaprod.add(prodQUERY);
			}
			stmt.close();
		}
		catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return listaprod;
	}

}
