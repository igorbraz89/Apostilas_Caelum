package Composicao_java;

public class Funcionario {
										
	public static double tempoAtraso(Hora horaChegada) {

		double horario_seg = horaChegada.getHour() * 60 * 60
				+ horaChegada.getMinute() * 60 + horaChegada.getSecond();
		// return 60*((horario_seg - (8*3600))/3600); para ver em minutos
		return (horario_seg - (8 * 3600)) / 3600;
	}

	public static double horasTrabalhadas(Hora horaChegada, Hora horaSaida) {
		double horario_minutos = (horaSaida.getHour() * 60 + horaSaida
				.getMinute())
				- (horaChegada.getHour() * 60 + horaChegada.getMinute());

		return horario_minutos / 60;
	}

	public static void main(String a[]) {

		Hora horaChegada = new Hora();
		Hora horaSaida = new Hora();
		horaChegada.setHour(8);
		horaChegada.setMinute(0);
		horaChegada.setSecond(0);
		horaSaida.setHour(18);
		horaSaida.setMinute(0);
		horaSaida.setSecond(0);
		System.out.println(tempoAtraso(horaChegada) + " horas");
		System.out.println(horasTrabalhadas(horaChegada, horaSaida) + " horas");
	}
}
