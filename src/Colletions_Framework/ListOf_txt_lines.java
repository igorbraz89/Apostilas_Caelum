package Colletions_Framework;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListOf_txt_lines {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStream is = new FileInputStream(
				"/Users/igor/Downloads/eclipse/plugins/org.apache.ant_1.8.4.v201303080030/about_files/ASL-LICENSE-2.0.txt");
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line = br.readLine();
		List lista = new ArrayList();
		Scanner scan = new Scanner(System.in);

		while (line != null) {
			lista.add(line);
			line = br.readLine();
		}
		br.close();
		// visualizando lista

		for (int i = 0; i < lista.size(); i++) {
			System.out.println(1 + i + " " + lista.get(i));

		}
		int i;
		System.out.println("escolha uma linha para visualizar (-1 para sair)");
		do {

			i = scan.nextInt();
			try {
				System.out.println(lista.get(i));
			} catch (IndexOutOfBoundsException e) {
				System.out.println("invalid index");
			}

		} while (i >= 0 && i < lista.size());

	}

}
