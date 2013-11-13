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

public class TabHoraFuncionarios {
	private Connection connection;
	private Calendar dia_Referencia;

	public Date getDia_Referencia() {
		return new Date(this.dia_Referencia.getTimeInMillis());
	}

	public void setDia_Referencia(Calendar dia_Referencia) {
		this.dia_Referencia = dia_Referencia;
	}

	public TabHoraFuncionarios() {
		// Estabelece a conexão com o DataBase
		this.connection = new ConnectionFactory().getConnection();
		this.dia_Referencia = Calendar.getInstance();
		System.out.println("Conexão estabelecida");

	}

	public void adciona(Contato funcionario, TabeladeHoras periodoTrabalho)
			throws SQLException {

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
		System.out.println("conexão encerrada");
	}

	public void delete() throws SQLException{
		 Connection con = new ConnectionFactory().getConnection();
		
		PreparedStatement stmt_Delete = con.prepareStatement("delete from  TabelaHoraFuncionario");
		stmt_Delete.execute();
		stmt_Delete.close();
		con.close();
	}
	/*
	 * public void showTabelaContatos() throws SQLException { // pega a conexão
	 * e o Statement Connection con = new ConnectionFactory().getConnection();
	 * PreparedStatement stmt_selectAllContatos = con
	 * .prepareStatement("select * from contatos");
	 * 
	 * // executa um select ResultSet rs_querySelect =
	 * stmt_selectAllContatos.executeQuery();
	 * 
	 * // itera no ResultSet while (rs_querySelect.next()) { String nome =
	 * rs_querySelect.getString("nome"); String email =
	 * rs_querySelect.getString("email"); String endereco =
	 * rs_querySelect.getString("endereco");
	 * 
	 * System.out.println("Nome= "+nome + "\nEmail= " + email+ "\nEndereço= " +
	 * endereco); System.out.println(""); }
	 * 
	 * rs_querySelect.close(); stmt_selectAllContatos.close(); con.close(); }
	 */
	/*
	 * public List<Contato> getLista() { try { List<Contato> contatos = new
	 * ArrayList<Contato>(); PreparedStatement stmt = this.connection
	 * .prepareStatement("select * from contatos"); ResultSet rs =
	 * stmt.executeQuery();
	 * 
	 * while (rs.next()) { // criando o objeto Contato Contato contato = new
	 * Contato(); contato.setId(rs.getLong("id"));
	 * contato.setNome(rs.getString("nome"));
	 * contato.setEmail(rs.getString("email"));
	 * contato.setEndereco(rs.getString("endereco"));
	 * 
	 * // montando a data através do Calendar Calendar data =
	 * Calendar.getInstance(); data.setTime(rs.getDate("dataNascimento"));
	 * contato.setDataNascimento(data);
	 * 
	 * // adicionando o objeto à lista contatos.add(contato); } rs.close();
	 * stmt.close(); return contatos; } catch (SQLException e) { throw new
	 * RuntimeException(e); } }
	 */
	/*
	 * void closeCon() { try { this.connection.close();
	 * System.out.println("Conexão fechada"); } catch (SQLException e) {
	 * e.printStackTrace(); } }
	 */
}
