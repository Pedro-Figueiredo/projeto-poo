package faxada;

import faxada.Faxada;
import java.util.Scanner;
public class Teste {
	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		Faxada f = new Faxada();
		int operador = 0;
		int executor = 0;
		while (operador == 0) {
			System.out.println("voce deseja:");
			executor = f.menu();
			
			while (executor < 1 || executor > 5) {
				System.out.println("comando invalido,tente novamente:");
				executor = f.menu();
			}
			
			switch (executor) {
			case 1:
				f.cadastrarUsuario();
				break;
			case 2:
				f.deletarUsuarioNick();
				break;
			case 3:
				f.deletarUsuarioId();
				break;
			case 4:
				f.buscarUsuario();
				break;
			default:
				f.listarUsuario();
				break;
			}
			System.out.print("deseja realizar outra operacao:sim(0) nao (1)");
			operador = s.nextInt();
			
			
		}
	}
	
}