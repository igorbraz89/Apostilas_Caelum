package Java.I.O.Exe;
import java.io.*;
public class Escritura_txt {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		OutputStream os = new FileOutputStream("/Users/igor/Downloads/Exercicios8.pdf");
		OutputStreamWriter osw = new OutputStreamWriter(os);
		BufferedWriter bw= new BufferedWriter(osw);
		bw.write("no fim");
		bw.close();

	}

}
