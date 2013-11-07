package Development;

public class ContaCorrente {
	private double saldo;
	
	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	void deposita(double saldo){
		
		if(saldo>0){
			this.saldo = saldo;
		}else{
			System.out.println("valor invalido");
		}
	}//fim deposita
	
	public String toString(){
		String output=String.valueOf(this.saldo);
		return output;
	}
}
