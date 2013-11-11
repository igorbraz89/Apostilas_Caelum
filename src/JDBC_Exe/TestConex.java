package JDBC_Exe;

import java.sql.SQLException;
import java.util.Calendar;

import javax.swing.JOptionPane;

public class TestConex {
	public static void main(String[] args){

		TabContatos tc = new TabContatos();
		Contato contato= new Contato();
		
		String nome = JOptionPane.showInputDialog(null, "Nome contato");
		contato.setNome(nome);

		String email = JOptionPane.showInputDialog(null, "E-mail");
		contato.setEmail(email);
		String endereco = JOptionPane.showInputDialog(null, "Endereço");
		contato.setEndereco(endereco);
		contato.setDataNascimento(Calendar.getInstance());
		
		try {
			tc.adciona(contato);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erro ao tentar gravar as informações no banco");
			System.out.println(e.getErrorCode());
		}
		System.out.println("Dados contato: " + nome + " | " + email + " | "
				+ endereco);
	}
}