package faxada;

import controles.UsuarioDAO;
import system.Usuario;
import java.util.Scanner;

public class Faxada {
	Usuario login(Usuario u) {
		UsuarioDAO d = new UsuarioDAO();
		return d.login(u);
	}
	void cadastrarUsuario(Usuario u){
		UsuarioDAO d = new UsuarioDAO();
		d.criaUsuario(u);
	}
	void deletarUsuario(String nick) {
		UsuarioDAO d = new UsuarioDAO();
		d.excluirUsuario(nick);
	}
	Usuario buscarUsuario(String nick) {
		UsuarioDAO d = new UsuarioDAO();
		return(d.buscarUsuario(nick));
	}
	void listarUsuario() {
		UsuarioDAO d = new UsuarioDAO();
		System.out.println(d.verTodos());
	}	
	
	public void addAmigo(String nick, String nickUs) {
		UsuarioDAO d = new UsuarioDAO();
		d.addAmigo(nick, nickUs);
		
	}
	public void listarAmigos(String nick) {
		UsuarioDAO d = new UsuarioDAO();
		System.out.println(d.listarAmigos(nick));
	}
	public void listarSolicitacoes(String nick) {
		UsuarioDAO d = new UsuarioDAO();
		System.out.println( d.listarsolicitações(nick));
		
		
	}
	public void aceitarSolicitacao(String nickUser) {
		Scanner s = new Scanner(System.in);
		UsuarioDAO d = new UsuarioDAO();
		System.out.println("informe o nick do usuario que voce deseja aceitar");
		String nickAceito= s.nextLine();
		d.aceitarAmigo(nickUser, nickAceito);
		
		
	}
	public void recusarSolicitacao(String nickUser) {
		Scanner s = new Scanner(System.in);
		UsuarioDAO d = new UsuarioDAO();
		System.out.println("informe o nick do usuario que voce deseja aceitar");
		String nickRecusado= s.nextLine();
		d.recusarAmigo(nickUser,nickRecusado);
	}
	public void removerAmigo(String nickUsuario, String nickAmigo) {
		UsuarioDAO d = new UsuarioDAO();
		d.removerAmigo(nickUsuario, nickAmigo);
		
	}
	

}
