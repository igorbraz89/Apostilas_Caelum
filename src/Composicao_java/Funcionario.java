package Composicao_java;

import java.sql.SQLException;
import java.text.ParseException;

public class Funcionario {
	private static boolean is_Alterado = false;
	private static final boolean PRONTO_PARA_SALVAR = true;
	private static final boolean IS_VAZIO = false;
	private boolean isReadytoSave = false;
	private String nome;
	private String email;
	private String endereco;

	private Contato contato;// possui

	TabeladeHoras planilhaHoras = new TabeladeHoras();// consulta

	FolhaHoraFuncionarios folhadehora = new FolhaHoraFuncionarios();// cria

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

	public void salvaContato() {
		if (this.nome.equalsIgnoreCase(null) == IS_VAZIO) {
			contato=new Contato(this.nome, this.email, this.endereco);
			isReadytoSave = PRONTO_PARA_SALVAR;

		}
	}

	public void salvaFolhaHoras(String diaChegada, String horaChegada,
			String diaSaida, String horaSaida) throws SQLException,
			ParseException {

		planilhaHoras.adcionaPeriod(new Periodo(diaChegada + " " + horaChegada,
				diaSaida + " " + horaSaida));

		folhadehora.adciona(contato, planilhaHoras);

	}

	public void deleteFolhaHoras() throws SQLException {
		folhadehora.delete();
	}

	public void alteraFolha() {
		if (this.isReady()) {
			 contato.setNome(this.nome);
			 contato.setEmail(this.email);
			 contato.setEndereco(this.endereco);
			folhadehora.altera(this.contato, planilhaHoras);
		}
		
	}

	public boolean isReady() {
		return isReadytoSave;
	}
}
