package JDBC_Exe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

public class TabContatos {
	
	public TabContatos(){
		
		
	}

	public void adciona(Contato contato) throws SQLException {
		
		Connection con = new ConnectionFactory().getConnection();

		// cria um preparedStatement
		String sql = "insert into contatos"
				+ " (nome,email,endereco,dataNascimento)" + " values (?,?,?,?)";

		PreparedStatement stmt = con.prepareStatement(sql);
		// preenche os valores

		stmt.setString(1, contato.getNome());
		stmt.setString(2, contato.getEmail());
		stmt.setString(3, contato.getEndereco());
		 stmt.setDate(4, contato.getDataNascimento());

		// executa
		stmt.execute();

		stmt.close();
		System.out.println("Gravado!");

		con.close();
		System.out.println("conex‹o encerrada");
	}

}
