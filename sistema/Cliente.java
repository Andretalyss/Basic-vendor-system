package sistema;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Cliente {
	private int cod_cliente;
	private int cpf_cnpj;
	private int rg;
	private String nome;
	private String endereco;
	private String pf;
	private String cidade;
	private String estado;
	private String seg;
	
	public Cliente() {
		
	}
	
	public void SalvandoDados() throws IOException {
		FileWriter arq = new FileWriter("C:\\Users\\andre\\Documents\\clientes.txt", true);
		try (PrintWriter gravarArq = new PrintWriter(arq)) {
			gravarArq.println(cod_cliente);
			gravarArq.println(nome);
			gravarArq.println(rg);
			gravarArq.println(cpf_cnpj);
			gravarArq.println(endereco);
			gravarArq.println(cidade);
			gravarArq.println(estado);
			gravarArq.println(pf);
			gravarArq.println(seg);
		}
		
		System.out.println("Dados salvos no banco.\n");
		
	}
	//Métodos Get's
	public int getCpf_Cnpj() {
		return cpf_cnpj;
	}
	
	public int getCod() {
		return cod_cliente;
	}
	
	public int getRg() {
		return rg;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public String getPf() {
		return pf;
	}
	
	public String getCidade() {
		return cidade;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public String getSegmento() {
		return seg;
	}


	//Métodos Set's
	public void setCpf_Cnpj(int cpf_cnpj) {
		this.cpf_cnpj = cpf_cnpj;
	}
	public void setCod(int cod) {
		cod_cliente = cod;
	}
	
	public void setRg(int rg) {
		this.rg = rg;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public void setPf(String pf) {
		this.pf = pf;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public void setSegmento(String seg) {
		this.seg = seg;
	}
}
