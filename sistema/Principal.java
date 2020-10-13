package sistema;

import java.io.IOException;
import java.util.Scanner;

public class Principal {
	
	static Vendedor lendoDado = new Vendedor();

	public static void main(String args[]) throws IOException, InterruptedException {

		LendoArquivos();
		
		while(true){
			System.out.println("\t Sistema de acesso \n");
			System.out.println("\t [1] Acesso como administrador \n");
			System.out.println("\t [2] Acesso como vendendor \n");
			System.out.println("\t [3] Acesso como cliente \n");
			
			int escolha;
			String login, password;
			Scanner ler = new Scanner(System.in);
			escolha = ler.nextInt();
			Clearing();
			
			
			if(escolha == 1) {
				ler.nextLine();
				System.out.println("\t Menu acesso ADM \n");
				System.out.println("\t Login: ");
				login = ler.nextLine();
				System.out.println("\t Password: ");
				password = ler.nextLine();
				Clearing();
					
				Cadastro acesso = new Cadastro();
				boolean retorno = acesso.Acesso(login, password);
				System.out.println(retorno);
				if(retorno) {
					while(true){
						System.out.println("Bem-vindo Sr. \n");
						System.out.println("\t Menu ADM \n");
						System.out.println("\t [1] Cadastrar vendedor \n");
						System.out.println("\t [2] Acessar informações de vendendores \n");
						System.out.println("\t [3] Sair do menu ADM \n");
						
						escolha = ler.nextInt();
						Vendedor cad = new Vendedor();
						if(escolha == 1) {
							lendoDado.cadastroVendendor();
							continue;
						}else if(escolha == 2){
							String cpf;
							int codigo;
							System.out.println("Preciso de algumas informações para a pesquisa.\n");
							System.out.println("Informe o código e o cpf do vendedor: ");
							codigo = ler.nextInt();
							ler.nextLine();
							cpf = ler.nextLine();

							lendoDado.PesquisarVendedor(codigo, cpf);
							continue;
						}else if(escolha == 3){
							break;
						}
					}}
			}}
	}


	public static void Clearing() throws InterruptedException, IOException{
		 if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            Runtime.getRuntime().exec("clear");
	}

	public static void LendoArquivos(){
		lendoDado.LendoDados();
		lendoDado.MostrarTodosOsVendedores();
	}
}
