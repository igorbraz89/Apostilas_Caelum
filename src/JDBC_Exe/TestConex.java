package JDBC_Exe;

import java.sql.SQLException;
import java.util.Calendar;

import javax.swing.JOptionPane;

public class TestConex {
	public static void main(String[] args) throws SQLException {

		TabContatos tc = new TabContatos();
		Contato contato = new Contato();
		
		//Escolha da ação desejada
		String aux = JOptionPane.showInputDialog(null,
				"1-Adicionar contato\n2-Show contatos\n3-Sair");
		int choice = Integer.parseInt(aux);
		
		switch (choice) {

		case 1:
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

				System.out
						.println("Erro ao tentar gravar as informações no banco");
				System.out.println(e.getErrorCode());
			}
			break;
		case 2:
			System.out.println("Tabela contatos");

			tc.showContatos();
			break;
		case 3:
			System.out.println("Good bye");
			tc.closeCon();
			break;
			default:
				System.out.println("Invalid choice");
				tc.closeCon();
			
		}
	}
}