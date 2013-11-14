package Composicao_java;

import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.JOptionPane;

public class TestFuncionario {
	private static boolean continua = true;

	public static void main(String[] args) throws SQLException, ParseException {
		// TODO Auto-generated method stub

		Funcionario funcionario = new Funcionario();
		int choice;
		do {
			String aux = JOptionPane.showInputDialog(null,
					"1-Salvar na tabela de horas\n2-Limpar tabela\n3-Dados Funcionario\n4-Sair");
			choice = Integer.parseInt(aux);
			showMenu(funcionario, choice);

		} while (continua);

	}

	public static int showMenu(Funcionario funcionario, int choice) {

		switch (choice) {

		case 1: // Salva funcionario
			String diaChegada;
			String horaChegada;
			String diaSaida;
			String horaSaida;

			diaChegada = JOptionPane.showInputDialog(null,
					"Data chegada dd/MM/yyyy");
			horaChegada = JOptionPane.showInputDialog(null,
					"Hora chegada HH:mm:ss");
			diaSaida = JOptionPane.showInputDialog(null,
					"Data Saida dd/MM/yyyy");
			horaSaida = JOptionPane
					.showInputDialog(null, "Hora Saida HH:mm:ss");

			// "13/11/2013 16:00:00"

			try {
				funcionario.salvaFolhaHoras(diaChegada, horaChegada, diaSaida, horaSaida);
						
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				System.out.println("Erro SQL");
				e1.printStackTrace();
			} catch (ParseException e2) {
				System.out.println("Erro de convers‹o");
				e2.printStackTrace();
			}catch (IllegalArgumentException e3){
				JOptionPane.showMessageDialog(null,"Insira os dados do funcionario antes de salvar a folha de horas");
			}

			break;
		case 2: // Delete records
			try {
				funcionario.deleteFolhaHoras();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Erro SQL");
			}
			System.out.println("table empty");
			break;
		case 3:// salva dados do funcionario
			String nome;
			String email;
			String endereco;
			nome=JOptionPane.showInputDialog("Nome");
			email=JOptionPane.showInputDialog("Email");
			endereco=JOptionPane.showInputDialog("Endereco");
			funcionario.setNome(nome);
			funcionario.setEmail(email);
			funcionario.setEndereco(endereco);
			funcionario.salvaContato();

			break;
		case 4:

			continua = false;
			System.out.println("Programa encerrado");
			break;
		}
		return choice;
	}

}
