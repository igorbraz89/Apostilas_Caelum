package JDBC_Exe;

import java.sql.SQLException;
import java.util.Calendar;

import javax.swing.JOptionPane;

public class Test_Contatos {
	public static void main(String[] args) throws SQLException {

		TabContatos tab_Contatos = new TabContatos();
		Contato contato = new Contato();

		// Escolha da ação desejada
		String aux = JOptionPane.showInputDialog(null,
				"1-Adicionar contato\n2-Show contatos\n3-Sair");
		int choice = Integer.parseInt(aux);

		switch (choice) {

		case 1: // Adicionando um contato ao database

			// Inicialzação dos atributos do Contato
			String nome = JOptionPane.showInputDialog(null, "Nome contato");
			contato.setNome(nome);
			String email = JOptionPane.showInputDialog(null, "E-mail");
			contato.setEmail(email);
			String endereco = JOptionPane.showInputDialog(null, "Endereço");
			contato.setEndereco(endereco);
			contato.setDataNascimento(Calendar.getInstance());

			try {
				tab_Contatos.adciona(contato);// Tenta gravar o contato no database
			} catch (SQLException e) {

				System.out
						.println("Erro ao tentar gravar as informações no banco");
				System.out.println(e.getErrorCode());
			}
			break;

		case 2: // Visualiza a tabela contatos

			System.out.println("Tabela contatos");
			tab_Contatos.showContatos();
			break;

		case 3: // Sair do programa e fechar a conexão com o DB
			System.out.println("Good bye");
			tab_Contatos.closeCon();
			break;
		default:// Nenhuma opção válida escolhida
			System.out.println("Invalid choice");
			tab_Contatos.closeCon();

		}
	}
}