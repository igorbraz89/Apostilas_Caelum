package Composicao_java;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class FolhaHoraFuncionarios {
	private Connection connection;
	private Calendar dia_Referencia;

	public FolhaHoraFuncionarios() {
		// Estabelece a conex‹o com o DataBase
		this.dia_Referencia = Calendar.getInstance();
		System.out.println("Conex‹o estabelecida");

	}

	public Date getDia_Referencia() {
		return new Date(this.dia_Referencia.getTimeInMillis());
	}

	public void setDia_Referencia(Calendar dia_Referencia) {
		this.dia_Referencia = dia_Referencia;
	}


	public void adciona(Contato funcionario, TabeladeHoras periodoTrabalho)
			throws SQLException {
		this.connection = new ConnectionFactory().getConnection();

		// cria um preparedStatement
		String sql_insertIntoContatos = "insert into TabelaHoraFuncionario"
				+ " (nome,email,endereco,horasTrabalhadas, horasAtraso, dia_Referencia)"
				+ " values (?,?,?,?,?,?)";

		PreparedStatement stmt_insert = this.connection
				.prepareStatement(sql_insertIntoContatos);
		// preenche os valores

		stmt_insert.setString(1, funcionario.getNome());
		stmt_insert.setString(2, funcionario.getEmail());
		stmt_insert.setString(3, funcionario.getEndereco());
		stmt_insert.setDouble(4, periodoTrabalho.horasTrabalhadas());
		stmt_insert.setDouble(5, periodoTrabalho.tempoAtraso());
		stmt_insert.setDate(6, this.getDia_Referencia());
		// executa
		stmt_insert.execute();

		stmt_insert.close();
		System.out.println("Gravado!");

		this.connection.close();
		System.out.println("conex‹o encerrada");
	}

	public void delete() throws SQLException{
		  this.connection = new ConnectionFactory().getConnection();
		
		PreparedStatement stmt_Delete = this.connection.prepareStatement("delete from  TabelaHoraFuncionario");
		stmt_Delete.execute();
		stmt_Delete.close();
		this.connection.close();
	}
	public void altera(Contato funcionario, TabeladeHoras periodoTrabalho) {
		this.connection = new ConnectionFactory().getConnection();
	     String sql = "update TabelaHoraFuncionario set email=? , "+
	             "endereco=?"+
	    		 " where nome=?";
	     System.out.println(funcionario.getNome()+" "+funcionario.getEmail()+" "+funcionario.getEndereco());
	     
	     try {
	         PreparedStatement stmt = connection
	                 .prepareStatement(sql);
	         
	 		stmt.setString(1, funcionario.getEmail());
	 		stmt.setString(2, funcionario.getEndereco());
	 		stmt.setString(3, funcionario.getNome());
	         stmt.execute();
	         stmt.close();
	         this.connection.close();
	         
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	 }
}
