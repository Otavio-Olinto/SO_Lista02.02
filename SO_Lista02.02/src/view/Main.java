package view;

import controller.KillController;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		// Instanciando os metodos da classe KillController
		KillController metodoKill = new KillController();
		
		int opc = 0;
		String comando;
		
		do {
			opc = Integer.parseInt(JOptionPane.showInputDialog("Digite a opção desejada:\n"+
																"1 - Listar processos ativos\n"+
																"2 - Matar processos por PID\n"+
																"3 - Matar processos por nome\n"+
																"9 - Sair"));
			
			switch(opc) {
				
				case 1:
					metodoKill.listarProcessos();
					break;
				
				case 2:
					comando = JOptionPane.showInputDialog("Digite o código PID do processo que deseja matar");
					metodoKill.mataPid(comando);
					break;
					
				case 3:
					comando = JOptionPane.showInputDialog("Digite o nome do processo que deseja matar");
					metodoKill.mataPid(comando.toLowerCase());
					
				case 9:
					System.out.println("Fim da aplicação");
					break;
					
				default:
					System.out.println("ERRO! Opção Inválida");
			
			}
		}while(opc!=9);

	}

}
