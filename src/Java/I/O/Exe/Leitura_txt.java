package Java.I.O.Exe;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Leitura_txt {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStream is= new FileInputStream("/Users/igor/Downloads/Exercicios8.pdf");
		InputStreamReader isr= new InputStreamReader(is);
		BufferedReader br= new BufferedReader(isr);
		String line=br.readLine();
		
		while(line != null){
			System.out.println(line);
			line= br.readLine();
		}
		br.close();
	}

}
