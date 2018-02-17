package faxada;

import faxada.Faxada;
import system.Obra;
import system.Usuario;
import java.util.Scanner;

import controles.ObraDAO;
import controles.UsuarioDAO;
public class Teste {
	public static void main(String[] args) {
		Obra o;
		ObraDAO oD = new ObraDAO();
		Scanner s= new Scanner(System.in);
		Faxada f = new Faxada();
		System.out.print("titulo:");
		String titulo = s.nextLine();
		System.out.print("autor:");
		String autor=s.nextLine();
		System.out.print("descrição:");
		String descrição=s.nextLine();
		System.out.print("genero:");
		String genero=s.nextLine();
		System.out.print("formato:");
		String formato=s.nextLine();
		System.out.print("ano:");
		int ano=s.nextInt();
		oD.criaObra(o=new Obra(titulo,autor,descrição,genero,formato,ano));
//		Usuario u = new Usuario();
//		int x=0,operador = 0,executor = 0;
//		while (operador == 0) {
//			
//
//				
//			if (u.getLogin() == false) {
//				System.out.println("voce deseja:");
//				executor = menuInicial();
//				while (executor < 1 || executor > 3) {
//					System.out.println("comando invalido,tente novamente:");
//				}
//				
//				switch (executor) {
//				case 1:
//					cadastrarUsuario();
//					break;
//				case 2:
//					u = new Usuario(login());
//					break;
//				case 3:
//					operador=1;
//					break;
//				}
//			}
//			else {
//				System.out.println("voce deseja:");
//				executor = menuLogado();
//				while (executor < 1 || executor > 6) {
//					System.out.println("comando invalido,tente novamente:");
//				}
//				switch (executor) {
//				case 1:
//					addAmigo(u.getNickName());
//					break;
//				case 2:
//					removerAmigo(u.getNickName());
//					break;
//				case 3:
//					listarAmigos(u.getNickName());
//					break;
//				case 4 :
//					listarSolicitacoes(u.getNickName());
//					break;
//				case 5:
//					f.deletarUsuario(u.getNickName());
//					x=1;
//					break;
//				case 6:
//					x = 1;
//					break;
//					}
//				if (x == 1) {
//					u = new Usuario();
//					}
//				}
//			for (int i = 0; i < 30; ++i)
//			    System.out.println ();
//			}
		}

	private static void removerAmigo(String nickUsuario) {
		Scanner s = new Scanner(System.in);
		Faxada f = new Faxada();
		System.out.print("informe o nick do amigo que deseja remover:");
		String nickAmigo= s.nextLine();
		f.removerAmigo( nickUsuario, nickAmigo);
	}

	private static void listarSolicitacoes(String nick) {
		Scanner s = new Scanner(System.in);
		Faxada f = new Faxada();
		int operador=0; 
		while (operador == 0) {
			f.listarSolicitacoes(nick);
			System.out.println("voce Deseja:");
			System.out.println("aceitar solicitação(1)");
			System.out.println("recusar solicitação(2)");
			System.out.println("voltar ao menu(3)");
			int x = s.nextInt();
			while (x < 1 || x > 3) {
				System.out.println("comando invalido,tente novamente:");
				x= s.nextInt();
					}
			switch (x) {
			case 1:
				f.aceitarSolicitacao(nick);
				break;
			case 2:
				f.recusarSolicitacao(nick);
				break;
			case 3:
				operador=1;
			break;
			}
		}
		}

	private static void listarAmigos(String nick) {
		Faxada f = new Faxada();
		f.listarAmigos(nick);
		
	}

	private static void addAmigo(String nickUs) {
		Faxada f = new Faxada();
		Scanner s= new Scanner(System.in);
		System.out.println("informe o nick do usuario que voce deseja adicionar:");
		String nick = s.nextLine();
		f.addAmigo(nick, nickUs);
		
		
	}

	private static void exibirFeed() {
		// TODO Auto-generated method stub
		
	}
	private static void cadastrarObra() {
		// TODO Auto-generated method stub
		
	}
	static int menuInicial() {
		Scanner s= new Scanner(System.in);
		System.out.println("Cadastrar um novo Usuario(1);");
		System.out.println("Efetuar login(2);");
		System.out.print("encerrar aplicação(3);");

		int e = s.nextInt();
		return e;
	}
	static int menuLogado(){
		Scanner s= new Scanner(System.in);
		System.out.println("add amigo(1):");
		System.out.println("remover amigo(2):");
		System.out.println("listar amigos(3):");
		System.out.println("listar solicitações(4):");
		System.out.println("deletar usuario atual(5)");
		System.out.println("fazer logout(6)");
		int e = s.nextInt();
		return e;
	}
	static Usuario login() {
		Scanner s=new Scanner(System.in);
		System.out.print("informe o NickName do usuario:");
		String nick = s.next();
		System.out.print("informe a senha do usuario:");
		String senha = s.next();
		Usuario u = new Usuario(nick, senha);
		Faxada f = new Faxada();
		return f.login(u);
		
	}
	static void cadastrarUsuario(){
		Faxada f = new Faxada();
		Scanner s= new Scanner(System.in);
		System.out.print("informe o nome do usuario:");
		String nome = s.nextLine();
		System.out.print("informe a idade do usuario:");
		int idade = s.nextInt();
		System.out.print("informe o NickName do usuario:");
		String nick = s.next();
		System.out.print("informe o email do usuario:");
		String email = s.next();
		System.out.print("informe a senha do usuario:");
		String senha = s.next();
		Usuario u = new Usuario(nick, nome, email, senha , idade );
		f.cadastrarUsuario(u);
	}
	void buscarUsuario() {
		Faxada f = new Faxada();
		Scanner s= new Scanner(System.in);
		System.out.print("informe o nick do usuario que voce deseja buscar:");
		String nick= s.nextLine();
		System.out.println(f.buscarUsuario(nick));
	}
	void listarUsuario() {
		UsuarioDAO d = new UsuarioDAO();
		System.out.println(d.verTodos());
	}
}