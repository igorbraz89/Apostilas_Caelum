package Development;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Banco_ListaContas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//cria contas
		ContaCorrente c1= new ContaCorrente ();
		ContaCorrente c2= new ContaCorrente ();
		ContaCorrente c3= new ContaCorrente ();
		ContaCorrente c4= new ContaCorrente ();
		List<ContaCorrente> contas= new ArrayList<ContaCorrente>();
		//Atualiza saldo
		c1.deposita(10000.45);
		c2.deposita(2500.56);
		c3.deposita(700.04);
		c4.deposita(5400.12);
		//Adiciona contas a lista
		contas.add(c1);
		contas.add(c2);
		contas.add(c3);
		contas.add(c4);
		//ordena contas em modo crescente
		Collections.sort(contas, new ContaCorrenteComparator());
		
		System.out.println(contas.toString());
		
		
	}
}
