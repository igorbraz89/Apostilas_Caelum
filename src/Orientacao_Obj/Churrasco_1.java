package Orientacao_Obj;

public class Churrasco_1 {
	double qtdeCarne, qtdecarneH, qtdeCarneM;
	String sexo;

	void defineConsumo(String sexo, double qtdeCarne) throws IllegalValorOfConsumoException {

		if (qtdeCarne > 0) {

			if (sexo.equalsIgnoreCase("Masculino")) {
				this.qtdecarneH = qtdeCarne;
			} else {
				this.qtdeCarneM = qtdeCarne;
			}

			// lana execption

		} else {
			throw new IllegalValorOfConsumoException("O valor do consumo nao  valido");
		}
	}

	// Metodo que adiciona uma pessoa ao churrasco.

	void adiciona(Pessoa_1 p) {

		if (p.getIdade() > 3.0 && p.isVegetariana() == false) {

			if (p.getIdade() < 13) {
				// entre 4 e 12 anos
				if (p.getSexo().equalsIgnoreCase("Masculino")) {

					this.qtdeCarne += qtdecarneH * 0.5;
				} else {

					this.qtdeCarne += qtdeCarneM * 0.5;
				}
			} else {
				// maior de 13 anos
				if (p.getSexo().equalsIgnoreCase("Masculino")) {

					this.qtdeCarne += qtdecarneH;
				} else {

					this.qtdeCarne += qtdeCarneM;
				}
			}// fim else
		}
	}

	double qtdeCarne() {
		return this.qtdeCarne;
	}

	public static void main(String args[]) throws IllegalValorOfConsumoException {

		Churrasco_1 c = new Churrasco_1();
		Pessoa_1 people = new Pessoa_1();
	
		people.idade = 24;
		people.nome = "ìgor";
		people.sexo = "Masculino";
		people.vegetariana = false;

		// definindo o consumo
		
		try {
			c.defineConsumo("Masculino", -500);
			
			
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		c.defineConsumo("Masculino", 500);
		c.defineConsumo("Feminino", 300);
		// adicionando pessoas ao churrasco

		c.adiciona(people);
		
		people.sexo = "Feminino";
		people.nome = "Andreia";
		
		c.adiciona(people); 
		people.idade = 12;
		c.adiciona(people);
		people.idade = 3;
		c.adiciona(people); 

		// Total de carne para fazer o churrasco

		System.out.println("Ser‡ preciso comprar " + c.qtdeCarne()
				+ "g de carne");
	}
}
