package Composicao_java;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Periodo {
	private Date horaChegada;
	private Date horaSaida;

	public Periodo(Date horaChegada, Date horaSaida){
		this.horaChegada= horaChegada;
		this.horaSaida= horaSaida;
		
	}
	public Periodo (String horaChegada, String horaSaida) throws ParseException{
		SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		this.horaChegada=sdf.parse(horaChegada);
		this.horaSaida=sdf.parse(horaSaida); 
	}
	public Date getHoraChegada() {
		return horaChegada;
	}

	public void setHoraChegada(Date horaChegada) {
		this.horaChegada = horaChegada;
	}

	public Date getHoraSaida() {
		return horaSaida;
	}

	public void setHoraSaida(Date horaSaida) {
		this.horaSaida = horaSaida;
	}

	public long getTempotrabalhadoMileseg() {
		return this.getHoraSaida().getTime() - this.getHoraChegada().getTime();
	}

	public long getTempoAtraso() {
		Calendar dataChegadareferencia = Calendar.getInstance();
		Calendar dataChegada = Calendar.getInstance();
		dataChegada.setTime(this.horaChegada);
		dataChegadareferencia.setTime(this.horaChegada);
		dataChegadareferencia.set(Calendar.HOUR_OF_DAY, 9);
		dataChegadareferencia.set(Calendar.MINUTE, 0);
		dataChegadareferencia.set(Calendar.SECOND, 0);
		return dataChegada.getTimeInMillis()
				- dataChegadareferencia.getTimeInMillis();
	}

}
