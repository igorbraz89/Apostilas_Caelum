package JDBC_Exe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TabContatos {
	private Connection con;
	 
	public TabContatos(){
		this.con = new ConnectionFactory().getConnection();
		System.out.println("Conex‹o estabelecida");
		
	}

	public void adciona(Contato contato) throws SQLException {
		
	

		// cria um preparedStatement
		String sql = "insert into contatos"
				+ " (nome,email,endereco,dataNascimento)" + " values (?,?,?,?)";

		PreparedStatement stmt = this.con.prepareStatement(sql);
		// preenche os valores

		stmt.setString(1, contato.getNome());
		stmt.setString(2, contato.getEmail());
		stmt.setString(3, contato.getEndereco());
		 stmt.setDate(4, contato.getDataNascimento());

		// executa
		stmt.execute();

		stmt.close();
		System.out.println("Gravado!");

		this.con.close();
		System.out.println("conex‹o encerrada");
	}
	
	public void showContatos() throws SQLException{
		// pega a conex‹o e o Statement
		Connection con = new ConnectionFactory().getConnection();
		PreparedStatement stmt = con.prepareStatement("select * from contatos");

		// executa um select
		ResultSet rs = stmt.executeQuery();

		// itera no ResultSet
		while (rs.next()) {
			String nome = rs.getString("nome");
			  String email = rs.getString("email");

			  System.out.println(nome + " :: " + email);
		}

		rs.close();
		stmt.close();
		con.close();
	}
	void closeCon(){
		try {
			this.con.close();
			System.out.println("conex‹o fechada");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
