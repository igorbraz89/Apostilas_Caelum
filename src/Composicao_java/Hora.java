package Composicao_java;

public class Hora {
	Hora horaChegada;
	Hora horaSaida;
	int hour, minute, second;
	
	
	
	public void setHour(int hour) {
		this.hour = hour;
	}
	public void setMinute(int minute) {
		this.minute = minute;
	}
	public void setSecond(int second) {
		this.second = second;
	}
	public int getHour(){
		return this.hour;
	}
	public int getMinute(){
		return this.minute;
	}
	public int getSecond(){
		return this.second;
	}
	

}
