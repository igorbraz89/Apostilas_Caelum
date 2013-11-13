package Colletions_Framework;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
		List<String> linesOf_File = new ArrayList<String>();
		Scanner scan = new Scanner(System.in);
		
		// add line to list
		while (line != null) {
			linesOf_File.add(line);
			line = br.readLine();
		}
		br.close();

		// visualizando lista
		for (int i = 0; i < linesOf_File.size(); i++) {
			System.out.println(i + " " + linesOf_File.get(i));

		}
		//Imprime uma linha do arquivo contido na lista
		int indexOfLine;
		do {
			System.out.print("Show Line: ");
			 indexOfLine = scan.nextInt();
			try {

				System.out.println("\n"+linesOf_File.get(indexOfLine)+"\n");

			} catch (IndexOutOfBoundsException e) {
				System.out.println("invalid index");
			}

		} while (indexOfLine >= 0 && indexOfLine < linesOf_File.size());

	}

}
