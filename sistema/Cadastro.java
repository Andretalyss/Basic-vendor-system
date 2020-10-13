package sistema;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
public class Cadastro {
	
	public Cadastro() {
		
	}
	
	public Cadastro(String login, String password) throws IOException {	
		FileWriter arq = new FileWriter("C:\\Users\\andre\\Documents\\bancodedados.txt", true);
		try (PrintWriter gravarArq = new PrintWriter(arq)) {
			gravarArq.println(login);
			gravarArq.println(password);
		}
		
		System.out.println("Dados salvos no banco.\n");
	}
	
	public boolean Acesso(String login, String password) {
			String nome = "C:\\Users\\andre\\Documents\\bancodedados.txt";
			
			try {
				FileReader arq = new FileReader(nome);
				BufferedReader lerArq = new BufferedReader(arq);
				
				String login_, password_;
				String line = lerArq.readLine();
				while(line != null) {
					login_ = line;
					line = lerArq.readLine();
					password_ = line;
					
					
					if(login.equals(login_)) {
						if(password.equals(password_)) {
							arq.close();
							return true;
						}
					}
				}
							
				arq.close();
				
			}catch(IOException e) {
				System.out.printf("Erro no banco de dados, desculpe o transtorno!\n");
			}
			
			return false;
		}
}

