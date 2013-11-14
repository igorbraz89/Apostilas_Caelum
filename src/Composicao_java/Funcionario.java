package Composicao_java;

import java.sql.SQLException;
import java.text.ParseException;

public class Funcionario {
	private boolean isReadytoSave=false;
	private String nome;
	private String email;
	private String endereco;

	private Contato contato = new Contato();//possui
	
	TabeladeHoras planilhaHoras = new TabeladeHoras();//consulta
	
	FolhaHoraFuncionarios folhadehora = new FolhaHoraFuncionarios();//cria

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public void salvaContato(){
		isReadytoSave=true;
		contato.criaContato(nome, email, endereco);
	}
	public void salvaFolhaHoras(String diaChegada, String horaChegada,
			String diaSaida, String horaSaida) throws SQLException,
			ParseException {
		if(isReadytoSave){
		planilhaHoras.adcionaPeriod(new Periodo(diaChegada + " " + horaChegada,
				diaSaida + " " + horaSaida));

		folhadehora.adciona(contato, planilhaHoras);
		}else{
			throw new IllegalArgumentException();
		}
	}
	public void deleteFolhaHoras() throws SQLException{
		folhadehora.delete();
	}
}
