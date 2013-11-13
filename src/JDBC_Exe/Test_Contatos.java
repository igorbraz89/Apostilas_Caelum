package JDBC_Exe;

import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;

public class Test_Contatos {
	public static void main(String[] args) throws SQLException {

		TabContatos tab_Contatos = new TabContatos();
		Contato contato = new Contato();
		
				// Inicialzação dos atributos do Contato
				String nome = JOptionPane.showInputDialog(null, "Nome contato");
				contato.setNome(nome);
				String email = JOptionPane.showInputDialog(null, "E-mail");
				contato.setEmail(email);
				String endereco = JOptionPane.showInputDialog(null, "Endereço");
				contato.setEndereco(endereco);
				contato.setDataNascimento(Calendar.getInstance());

				try {
					tab_Contatos.adciona(contato);// Tenta gravar o contato no
													// database
				} catch (SQLException e) {

					System.out
							.println("Erro ao tentar gravar as informações no banco");
					System.out.println(e.getErrorCode());
				}
		
		

	}

	public static void visualizaLista(List<Contato> lista) {
		for (Contato contato : lista) {
			System.out.println("Id: " + contato.getId());
			System.out.println("Nome:" + contato.getNome());
			System.out.println("E-mail: " + contato.getEmail());
			System.out.println("Endereço:" + contato.getEndereco());
			System.out.println("Data nascimento: "
					+ DateFormat.getInstance().format(
							contato.getDataNascimento()));
			System.out.println("");

		}
	}
}