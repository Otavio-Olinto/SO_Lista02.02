package controller;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class KillController {

	public KillController() {
		super();
	}
	
	private String so() {
		
		String nome = System.getProperty("os.name");
		
		return nome;
	}
	
	public void listarProcessos() {
		
		String sistema = so();
		String comando;
		
		if(sistema.toLowerCase().contains("linux")) {
			comando = "ps -ef";
		}else {
			comando = "TASKLIST /FO TABLE";
		}
		
		String[] comandoArr = comando.split(" ");
		
		try {
			// Criando a variável do Tipo Processo
			Process proc = Runtime.getRuntime().exec(comandoArr);
			
			// Criando o fluxo de bits
			InputStream fluxo = proc.getInputStream();
			
			// Convertendo o fluxo para String e passando para o buffer de leitura
			InputStreamReader leitorFluxo = new InputStreamReader(fluxo);
			BufferedReader bufferFluxo = new BufferedReader(leitorFluxo);
			
			String linha = bufferFluxo.readLine();
			
			while(linha!=null) {
				System.out.println(linha);
				linha = bufferFluxo.readLine();
			}
			
		}catch(Exception exc) {
			System.err.println(exc.getMessage());
		}
		
	}
	
	public void mataPid(String pid) {
		
		String sistema = so();
		String comando;
		
		if(sistema.toLowerCase().contains("linux")) {
			comando = "kill -9";
		}else {
			comando = "TASKKILL /PID";
		}
		
		StringBuffer buffer = new StringBuffer();
		buffer.append(comando);
		buffer.append(" ");
		buffer.append(pid);
		
		String[] comandoArr = buffer.toString().split(" ");
		
		try {
			Runtime.getRuntime().exec(comandoArr);
		}catch(Exception exc) {
			System.err.println(exc.getMessage());
		}
	}
	
	public void mataNome(String nome) {
		
		String sistema = so();
		String comando;
		
		if(sistema.toLowerCase().contains("linux")) {
			comando = "pkill -f";
		}else {
			comando = "TASKKILL /IM";
		}
		
		StringBuffer buffer = new StringBuffer();
		buffer.append(comando);
		buffer.append(" ");
		buffer.append(nome);
		
		String[] comandoArr = buffer.toString().split(" ");
		
		try {
			Runtime.getRuntime().exec(comandoArr);
		}catch(Exception exc) {
			System.err.println(exc.getMessage());
		}
	}

}
