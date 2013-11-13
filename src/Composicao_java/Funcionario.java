package Composicao_java;

import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.JOptionPane;

public class Funcionario {

	public static void main(String a[]) throws ParseException, SQLException {

		TabeladeHoras planilhaHoras = new TabeladeHoras();
		TabHoraFuncionarios th = new TabHoraFuncionarios();
		
		Contato contato = new Contato("Igor", "igor@giran.com.br",
				"Rua da Ladeira");
		
		
		
		String aux= JOptionPane.showInputDialog(null, "1-Salvar na tabela de horas\n2-Limpar tabela");
		int choice= Integer.parseInt(aux);
		switch (choice) {
		
		case 1: // Salva funcionario
			String diaChegada;
			String horaChegada;
			String diaSaida;
			String horaSaida;
			
			diaChegada=JOptionPane.showInputDialog(null, "Data chegada dd/MM/yyyy");
			horaChegada=JOptionPane.showInputDialog(null, "Hora chegada HH:mm:ss");
			diaSaida=diaChegada;
			horaSaida=JOptionPane.showInputDialog(null, "Data chegada HH:mm:ss");
			
			//"13/11/2013 16:00:00"
			
			planilhaHoras.adcionaPeriod(new Periodo(diaChegada +" "+horaChegada, diaSaida +" "+horaSaida));
			
			th.adciona(contato, planilhaHoras);

			System.out.println("Horas trabalhadas: "
					+ planilhaHoras.horasTrabalhadas());
			System.out.println("Horas de Atraso: "
					+ planilhaHoras.tempoAtraso());
			
			break;
		case 2: //Delete records
			th.delete();
			System.out.println("table empty");
			break;

		}

	

	}

}
