package sistema;

import java.io.FileWriter;
import java.util.Random;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.BufferedReader;

public class Vendedor {
	private int codigo;
	private String nome;
	private String cpf;
	private int rg;
	private int NumberOfSellers=0;
	private String endereco;
	private String cidade;
	private String estado;
	private String pais;
	ArrayList<Vendedor> Sellers = new ArrayList<Vendedor>();
	
	
	public Vendedor() {
		
	}
	
	public Vendedor(int cod, String n, String c, int r, String ad, String ci, String est, String p) {
		codigo = cod;
		nome = n;
		cpf = c;
		rg = r;
		endereco = ad;
		cidade = ci;
		estado = est;
		pais = p;
	}
	
	
	public void cadastroVendendor() throws IOException {
		Scanner ler = new Scanner(System.in);
		System.out.println("Muito bem, para isso preciso de algumas informa��es, vamos l�. \n");
		System.out.println("Primeiramente, informe o nome do vendendor: ");
		nome = ler.nextLine();
		System.out.println("Ok, agora informe o cpf: ");
		cpf = ler.nextLine();
		System.out.println("Muito bem, informe agora o rg: ");
		rg = ler.nextInt();
		ler.nextLine();
		System.out.println("Ok, vamos para o endere�o, informe o nome da rua + num�ro: ");
		endereco = ler.nextLine();
		System.out.println("Cidade: ");
		cidade = ler.nextLine();
		System.out.println("Estado: ");
		estado = ler.nextLine();
		System.out.println("Pa�s: ");
		pais = ler.nextLine();
		
		Random alet = new Random();
		codigo = alet.nextInt(1029302);
		System.out.printf("Ok, tudo pronto, o c�digo do seu vendedor �: %d \n", codigo);
		
		Vendedor save = new Vendedor(codigo,nome,cpf,rg,endereco,cidade,estado,pais);
		Sellers.add(save);
		NumberOfSellers++;

		SalvandoDados();
		
	}
	
	public void MostrarTodosOsVendedores(){
		for(int i=0;i<NumberOfSellers;i++) {
			System.out.println("Código: " + Sellers.get(i).getCodigo());
			System.out.println("Nome: " + Sellers.get(i).getNome());
			System.out.println("CPF: " + Sellers.get(i).getCPF());
			System.out.println("RG: " + Sellers.get(i).getRG());
			System.out.println("Rua: " + Sellers.get(i).getEndereco());
			System.out.println("Cidade: " + Sellers.get(i).getCidade());
			System.out.println("Estado: " + Sellers.get(i).getEstado());
			System.out.println("Pais: " + Sellers.get(i).getPais());
		}
	}

	public void PesquisarVendedor(int cod, String cpf){
		System.out.printf("CPF: %s \n", cpf);
		System.out.printf("cod: %d \n", cod);
		System.out.printf("Número de vendedores = %d \n", NumberOfSellers);

		int flag = 0;
		for( int i=0; i<NumberOfSellers;i++){
			System.out.printf("cod no vetor[%d] = %d \n",i, cod);
			System.out.printf("cpf no vetor[%d] = %s \n",i, cpf);

			if(cod == Sellers.get(i).getCodigo()){
				if(cpf.equals(Sellers.get(i).getCPF())){
					System.out.println("\t Vendedor encontrado:  \n\n");
					System.out.println("Código: " + Sellers.get(i).getCodigo());
					System.out.println("Nome: " + Sellers.get(i).getNome());
					System.out.println("CPF: " + Sellers.get(i).getCPF());
					System.out.println("RG: " + Sellers.get(i).getRG());
					System.out.println("Rua: " + Sellers.get(i).getEndereco());
					System.out.println("Cidade: " + Sellers.get(i).getCidade());
					System.out.println("Estado: " + Sellers.get(i).getEstado());
					System.out.println("Pais: " + Sellers.get(i).getPais());
					flag++;
					break;
				}
			}
		}

		if(flag == 0)
			System.out.println("Vendedor não encontrado, verifique se informou tudo corretamente. \n");


	}


	public void SalvandoDados() throws IOException {
		FileWriter arq = new FileWriter("C:\\Users\\andre\\Documents\\vendedores.txt", true);
		try (PrintWriter gravarArq = new PrintWriter(arq)) {
			gravarArq.println("Codigo: "+ codigo);
			gravarArq.println("Nome: " + nome);
			gravarArq.println("RG: " + rg);
			gravarArq.println("CPF: "+ cpf);
			gravarArq.println("Endereco: " + endereco);
			gravarArq.println("Cidade: " + cidade);
			gravarArq.println("UF: " + estado);
			gravarArq.println("Pais: " + pais);
		}
		
		System.out.println("Dados salvos no banco.\n");
		
	}

	public void LendoDados() {
		String name = "C:\\Users\\andre\\Documents\\vendedores.txt";
		try {
			FileReader arq = new FileReader(name);
			BufferedReader lerArq = new BufferedReader(arq);

			int cod, rg;
			String nome, cpf, endereco, cidade, estado, pais;

			String leitor = lerArq.readLine();
			while(leitor != null){
				cod = Integer.parseInt(leitor);
				leitor = lerArq.readLine();
				nome = leitor;
				leitor =lerArq.readLine();
				rg = Integer.parseInt(leitor);
				leitor = lerArq.readLine();
				cpf = leitor;
				leitor = lerArq.readLine();
				endereco = leitor;
				leitor = lerArq.readLine();
				cidade = leitor;
				leitor = lerArq.readLine();
				estado = leitor;
				leitor = lerArq.readLine();
				pais = leitor;

				Vendedor save = new Vendedor(cod,nome,cpf,rg,endereco,cidade,estado,pais);
				Sellers.add(save);
				NumberOfSellers++;

				leitor = lerArq.readLine();
			}

		}catch(IOException e) {
			System.out.printf("Erro de abertura");
		}
	}

	// M�todos Get's
	public int getCodigo() {
		return codigo;
	}
	
	public String getCPF() {
		return cpf;
	}
	
	public int getRG() {
		return rg;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public String getCidade() {
		return cidade;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public String getPais() {
		return pais;
	}

	//M�todos Set's
	public void setCodigo(int cod) {
		codigo = cod;
	}
	
	public void setCPF(String c) {
		cpf = c;
	}
	
	public void setRG(int r) {
		rg = r;
	}
	
	public void setNome(String n) {
		nome = n;
	}
	
	public void setEndereco(String e) {
		endereco = e;
	}
	
	public void setEstado(String est) {
		estado = est;
	}
	
	public void setCidade(String ci) {
		cidade = ci;
	}
	
	public void setPais(String p) {
		pais = p;
	}


}
