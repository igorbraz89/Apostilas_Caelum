package Composicao_java;

public class Funcionario {
	
	public static void main(String a[]) {

	TabeladeHoras planilhaHoras= new TabeladeHoras();
	planilhaHoras.setHoraChegada(8, 30, 34);
	planilhaHoras.setHoraSaida(18, 0, 23);
	
	System.out.println(planilhaHoras.horasTrabalhadas(planilhaHoras.getHoraChegada(), planilhaHoras.getHoraSaida()));

	
	}
}
