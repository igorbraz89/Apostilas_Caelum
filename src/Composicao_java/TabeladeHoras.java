package Composicao_java;

import java.util.ArrayList;
import java.util.List;

public class TabeladeHoras {

	private static final int FATOR_CONVERSAO_MILESEGUNDOS_HORAS = 1000 * 60 * 60;
	private List<Periodo> periodos = new ArrayList<Periodo>();

	public void adcionaPeriod(Periodo periodo) {
		if (null == periodo) {
			throw new IllegalArgumentException("O periodo n‹o pode ser nulo");
		}
		this.periodos.add(periodo);

	}

	public  double tempoAtraso() {
		
		double horaAtraso=0;
		for (Periodo periodo : periodos) {
			horaAtraso += periodo.getTempoAtraso();
			
		}

		return horaAtraso / FATOR_CONVERSAO_MILESEGUNDOS_HORAS;

	}
	

	public double horasTrabalhadas() {
		double horasTrabalhadas = 0;
		for (Periodo periodo : periodos) {
			horasTrabalhadas += periodo.getTempotrabalhadoMileseg();

		}

		return horasTrabalhadas / FATOR_CONVERSAO_MILESEGUNDOS_HORAS;

	}

}
