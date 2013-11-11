package JDBC_Exe;

import java.sql.SQLException;
import java.util.Calendar;

import javax.swing.JOptionPane;

public class TestConex {
	public static void main(String[] args) throws SQLException {

		TabContatos tc = new TabContatos();
		Contato contato= new Contato();
		
		String nome = JOptionPane.showInputDialog(null, "Nome contato");
		contato.setNome(nome);

		String email = JOptionPane.showInputDialog(null, "E-mail");
		contato.setEmail(email);
		String endereco = JOptionPane.showInputDialog(null, "Endereço");
		contato.setEndereco(endereco);
		contato.setDataNascimento(Calendar.getInstance());
		tc.adciona(contato);
		System.out.println("Dados contato: " + nome + " | " + email + " | "
				+ endereco);
	}
}