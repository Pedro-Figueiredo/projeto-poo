package faxada;

import controles.UsuarioDAO;
import user.Usuario;
import java.util.Scanner;

public class Faxada {
	int menu() {
		Scanner s = new Scanner(System.in);
		System.out.println("Cadastrar um novo Usuario(1);");
		System.out.println("deletar um usuario existente atravez do nick(2);");
		System.out.println("deletar um usuario existente atraves do id(3);");
		System.out.println("buscar usuario atraves do NickName(4);");
		System.out.println("listar usuarios cadastrados(5).");
		int e = s.nextInt();
		return e;
	}
	void cadastrarUsuario(){
		UsuarioDAO d = new UsuarioDAO();
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
		d.criaUsuario(u);
	}
	void deletarUsuarioNick() {
		UsuarioDAO d = new UsuarioDAO();
		Scanner s= new Scanner(System.in);
		System.out.print("informe o NickName do usuario que voce deseja remover:");
		String nick= s.nextLine();
		d.excluirUsuario(nick);
		System.out.print("usuario deletado");
	}
	void deletarUsuarioId(){
		UsuarioDAO d = new UsuarioDAO();
		Scanner s= new Scanner(System.in);
		System.out.print("informe o id do usuario que voce deseja remover:");
		int id= s.nextInt();
		d.excluirUsuario(id);
		System.out.print("usuario deletado");
	}
	void buscarUsuario() {
		UsuarioDAO d = new UsuarioDAO();
		Scanner s= new Scanner(System.in);
		System.out.print("informe o nick do usuario que voce deseja buscar:");
		String nick= s.nextLine();
		System.out.println(d.buscarUsuario(nick));
	}
	void listarUsuario() {
		UsuarioDAO d = new UsuarioDAO();
		System.out.println(d.verTodos());
	}
	void armazenarDados(){
		// vai mandar os dados para a class usuario o qual ira salvar no banco de dados
	}
	void consultarDadoDeLogin() {
		//consultar os dados de login informados pelo user no menu		
	}
	

}
