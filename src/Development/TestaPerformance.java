package Development;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class TestaPerformance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Iniciando...");
		long inicio = System.currentTimeMillis();
		//Collection<Integer> teste = new ArrayList<Integer>();
		Collection<Integer> teste = new HashSet<Integer>();
		int total = 1000000;

		for (int i = 0; i < total; i++) {
			teste.add(i);
		}

		for (int i = 0; i < total; i++) {
			teste.contains(i);

		}

		long fim = System.currentTimeMillis();
		double tempo = (fim - inicio) / 1000.0;
		System.out.println("O tempo gasto foi: "+tempo);
	}

}
