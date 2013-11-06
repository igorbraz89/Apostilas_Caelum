package Colletions_Framework;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Exe_List {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List lista = new ArrayList();
		lista.add("Eugenio");
		lista.add("Kamilla");
		lista.add("Maxwell");
		lista.add("Makoto");
		lista.add("Gabriel");
		lista.add("Peruggia");
		lista.add("Andressa");
		lista.add(0, "Igor");
		System.out.println(lista.size()+" elementos na lista");
		
		for (int i = 0; i < lista.size(); i++) {
			System.out.println(lista.get(i));
			
			
		}
		System.out.println("now");
		for (int i = 0; i < lista.size(); i++) {
			lista.remove(lista.size()-1);
			System.out.println(lista.get(i));
			
		}
		
	}

}
