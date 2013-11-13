package Colletions_Framework;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Cria_Lista {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> lista = new ArrayList<String>();
		lista.add("Eugenio");
		lista.add("Kamilla");
		lista.add("Maxwell");
		lista.add("Makoto");
		lista.add("Gabriel");
		lista.add("Peruggia");
		lista.add("Andressa");
		lista.add(0, "Igor");
		System.out.println(lista.size()+" elementos na lista");
	
		System.out.println(lista);
		Collections.sort(lista);
		System.out.println(lista);
		
	}

}
