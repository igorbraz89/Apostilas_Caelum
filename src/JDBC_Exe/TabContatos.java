package JDBC_Exe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TabContatos {
	private Connection connection;

	public TabContatos() {
		// Estabelece a conex‹o com o DataBase
		this.connection = new ConnectionFactory().getConnection();
		System.out.println("Conex‹o estabelecida");

	}

	public void adciona(Contato contato) throws SQLException {

		// cria um preparedStatement
		String sql_insertIntoContatos = "insert into contatos"
				+ " (nome,email,endereco,dataNascimento)" + " values (?,?,?,?)";

		PreparedStatement stmt_insert = this.connection.prepareStatement(sql_insertIntoContatos);
		// preenche os valores

		stmt_insert.setString(1, contato.getNome());
		stmt_insert.setString(2, contato.getEmail());
		stmt_insert.setString(3, contato.getEndereco());
		stmt_insert.setDate(4, contato.getDataNascimento());

		// executa
		stmt_insert.execute();

		stmt_insert.close();
		System.out.println("Gravado!");

		this.connection.close();
		System.out.println("conex‹o encerrada");
	}

	public void showContatos() throws SQLException {
		// pega a conex‹o e o Statement
		Connection con = new ConnectionFactory().getConnection();
		PreparedStatement stmt_selectAllContatos = con
				.prepareStatement("select * from contatos");

		// executa um select
		ResultSet rs_querySelect = stmt_selectAllContatos.executeQuery();

		// itera no ResultSet
		while (rs_querySelect.next()) {
			String nome = rs_querySelect.getString("nome");
			String email = rs_querySelect.getString("email");
			String endereco = rs_querySelect.getString("endereco");
			
			
			System.out.println("< "+nome + " >------< "+ email+" >------< "+endereco+" >");
			
		}
	
		rs_querySelect.close();
		stmt_selectAllContatos.close();
		con.close();
	}

	void closeCon() {
		try {
			this.connection.close();
			System.out.println("Conex‹o fechada");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
