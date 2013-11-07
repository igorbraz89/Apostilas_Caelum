package Development;

import java.util.Comparator;

public class ContaCorrenteComparator implements Comparator<ContaCorrente> {

	@Override
	public int compare(ContaCorrente o1, ContaCorrente o2) {
		// Ordem crescente
		
		if (o1.getSaldo() > o2.getSaldo()) {
			return -1;
		} else if (o1.getSaldo() < o2.getSaldo()) {
			return 1;
		} else {
			return 0;
		}
	}
}
