package Composicao_java;

import java.sql.Date;
import java.util.Calendar;

public class Contato {

	private Long id;
	private String nome;
	private String email;
	private String endereco;
	

	// métodos get e set para id, nome, email, endereço e dataNascimento
	public void criaContato(String nome, String email, String endereco) {
			this.nome=nome;
			this.email=email;
			this.endereco=endereco;
	
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String novo) {
		this.nome = novo;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String novo) {
		this.email = novo;
	}

	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String novo) {
		this.endereco = novo;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long novo) {
		this.id = novo;
	}



	

	public String toString() {
		return this.nome;
	}
}
