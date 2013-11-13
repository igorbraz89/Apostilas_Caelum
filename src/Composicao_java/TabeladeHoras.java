package Composicao_java;

public class TabeladeHoras {
	private Periodo horaChegada = new Periodo();
	private Periodo horaSaida = new Periodo();
	
	public Periodo getHoraChegada() {
		return horaChegada;
	}

	public void setHoraChegada(int hora, int minutos, int segundos) {
		this.horaChegada.setHour(hora);
		this.horaChegada.setMinute(minutos);
		this.horaChegada.setSecond(segundos);
	}

	public Periodo getHoraSaida() {
		return horaSaida;
	}

	public void setHoraSaida(int hora, int minutos, int segundos) {
		this.horaSaida.setHour(hora);
		this.horaSaida.setMinute(minutos);
		this.horaSaida.setSecond(segundos);
		
	}

	
	public static double tempoAtraso(Periodo horaChegada) {

		double horario_seg = horaChegada.getHour() * 60 * 60
				+ horaChegada.getMinute() * 60 + horaChegada.getSecond();
		// return 60*((horario_seg - (8*3600))/3600); para ver em minutos
		return (horario_seg - (8 * 3600)) / 3600;
	}

	public double horasTrabalhadas(Periodo horaChegada, Periodo horaSaida) {
		double horario_minutos = (horaSaida.getHour() * 60 + horaSaida
				.getMinute())
				- (horaChegada.getHour() * 60 + horaChegada.getMinute());

		return horario_minutos / 60;
	}

}
