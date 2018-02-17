package controles;

import system.Usuario;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;

public class UsuarioDAO {
	private ConexaoBD conexao = new ConexaoBD();
	
	public void criaUsuario(Usuario u) {
		conexao.conectar();
		try {
			PreparedStatement pst = conexao.getConexao().prepareStatement("insert into \"user\".usuario(nickname,nome,idade,email,senha) values(?,?,?,?,?)");
			pst.setString(1,u.getNickName());
			pst.setString(2,u.getNome());
			pst.setInt(3,u.getIdade());
			pst.setString(4,u.getEmail());
			pst.setString(5,u.getSenha());

			pst.execute();
			System.out.println("usuario cadastrado com sucesso.");
		}catch(SQLException e){
			System.out.println("usuario ja cadastrado tente efetuar login.");			
		}finally {
			conexao.desconectar();
		}
	}
	public void excluirUsuario(int id) {
		conexao.conectar();
		
		try {
			PreparedStatement stm = conexao.getConexao().prepareStatement("delete from \"user\".usuario where id_usuario = \'" + id + "\'");
			stm.execute();
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		} finally {
			conexao.desconectar();
		}
	}
	public void excluirUsuario(String nickName) {
		conexao.conectar();
		
		try {
			PreparedStatement stm = conexao.getConexao().prepareStatement("delete from \"user\".usuario where nickname = \'" + nickName + "\'");
			stm.execute();
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		} finally {
			conexao.desconectar();
		}
	}
	public Usuario buscarUsuario(String nickName) {
		conexao.conectar();
		ResultSet resultado = conexao.executarSQL("select * from \"user\".usuario where nickname like \'%"+ nickName +"%\'");
		Usuario u = new Usuario();
		
		try {
			resultado.next();
			String nickName1 = resultado.getString("nickname");
			String nomeUsuario = resultado.getString("nome");
			int idadeUsuario = resultado.getInt("idade");
			String emailUsuario = resultado.getString("email");
			u.setNome(nomeUsuario);
			u.setEmail(emailUsuario);
			u.setIdade(idadeUsuario);
			u.setNickName(nickName1);
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		} finally {
			conexao.desconectar();
		}
		return u;
	}
	public ArrayList<Usuario> verTodos() {
		ArrayList<Usuario> usuarios = new ArrayList<>();
		conexao.conectar();
		ResultSet resultado = conexao.executarSQL("select * from \"user\".usuario");
		
		try {
			while (resultado.next()) {
				String nickName1 = resultado.getString("nickname");
				String nomeUsuario = resultado.getString("nome");
				int idadeUsuario = resultado.getInt("idade");
				String emailUsuario = resultado.getString("email");
				usuarios.add(new Usuario(nickName1,nomeUsuario,emailUsuario, idadeUsuario));
			}
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		} finally {
			conexao.desconectar();
		}
		return usuarios;
	}
	public Usuario login(Usuario u) {
		conexao.conectar();
		ResultSet resultado = conexao.executarSQL("select * from \"user\".usuario where nickname like \'%"+ u.getNickName() +"%\'");
		
		try {
			resultado.next();
			String senha = resultado.getString("senha");
			if( senha.equals(u.getSenha())) {
				System.out.println("Usuario logado com sucesso, recuperando dados");
				String nomeUsuario = resultado.getString("nome");
				int idadeUsuario = resultado.getInt("idade");
				String emailUsuario = resultado.getString("email");
				u.setNome(nomeUsuario);
				u.setEmail(emailUsuario);
				u.setIdade(idadeUsuario);
				u.setLogin(true);
				System.out.println("dados recuperados");
				
			}
			else {
				System.out.println("senha invalida, tente novamente:");
			}
		}
		catch(Exception e) {
			System.out.println("Usuario não existe, tente novamente:");
		}finally {
			conexao.desconectar();
		}

		return u;
	}
	public void addAmigo(String nickAmigo,String nickUsuario){
		conexao.conectar();
		try {
			PreparedStatement pst = conexao.getConexao().prepareStatement("insert into \"user\".amigos(nickAmigo1,aceptAmigo1,nickAmigo2, aceptAmigo2) "
					+ "values(?,?,?,?)");
			pst.setString(1, nickUsuario);
			pst.setBoolean(2, true);
			pst.setString(3, nickAmigo);
			pst.setBoolean(4,false );
			pst.execute();
			System.out.println("solicitação enviada");
		} catch (SQLException e) {
			//System.out.println("Erro"+ e.getMessage());
			System.out.println("não foi possivel enviar solicitação tente novamente, verifique os dados");
			
		}finally {
			conexao.desconectar();
		}
	}
	public void aceitarAmigo(String nickUsuario, String nickAmigo){
		conexao.conectar();
		try {
			PreparedStatement pst = conexao.getConexao().prepareStatement("update \"user\".amigos set aceptamigo2 = TRUE where ((nickamigo2 = '"+nickUsuario+"') and (aceptamigo2 = FALSE) ) and (nickamigo1 = '"+nickAmigo+"')");
			pst.execute();
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
			
		}finally {
			conexao.desconectar();
		}
	}
	public ArrayList<Usuario> listarAmigos(String nick) {
		ArrayList<Usuario> usuarios = new ArrayList<>();
		Usuario u;
		conexao.conectar();
		ResultSet resultado = conexao.executarSQL("select nickamigo1, nickamigo2 from \"user\".amigos where ( ( (nickamigo1 like(\'"+nick+"\')) or (nickamigo2 like(\'"+nick+"\'))) and (aceptamigo1=aceptamigo2))");
		try {
			while (resultado.next()) {
				String nickAmigo1 = resultado.getString("nickamigo1");
				String nickAmigo2 = resultado.getString("nickamigo2");
				if (nick.equals(nickAmigo1)) {
					ResultSet resultado1 = conexao.executarSQL("select * from \"user\".usuario where (nickname like('"+nickAmigo2+"'))");
					resultado1.next();
					String nickName= resultado1.getString("nickname");
					String nome= resultado1.getString("nome");
					String email= resultado1.getString("email");
					int idade = resultado1.getInt("idade");
					usuarios.add( u= new Usuario(nickName,nome, email , idade));
				} else {
					ResultSet resultado1 = conexao.executarSQL("select * from \"user\".usuario where (nickname like('"+nickAmigo1+"'))");
					resultado1.next();
					String nickName= resultado1.getString("nickname");
					String nome= resultado1.getString("nome");
					String email= resultado1.getString("email");
					int idade = resultado1.getInt("idade");
					usuarios.add(u= new Usuario(nickName,nome, email , idade));
				}
			}
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		} finally {
			conexao.desconectar();
		}
		return usuarios;
	}
	public ArrayList<Usuario >listarsolicitações(String nick) {
		ArrayList<Usuario> usuarios = new ArrayList<>();
		conexao.conectar();
		ResultSet resultado = conexao.executarSQL("select nickname,nome,email,idade from \"user\".usuario, \"user\".amigos where ((\"amigos\".nickamigo2 like\'"+nick+"\') and  aceptamigo2 = FALSE) and \"usuario\".nickname = \"amigos\".nickamigo1 ");
		try {
			while(resultado.next()) {
				String nickName= resultado.getString("nickname");
				String nome = resultado.getString("nome");
				String email = resultado.getString("email");
				int idade= resultado.getInt("idade");
				usuarios.add(new Usuario(nickName,nome,email,idade));				
			}
		}catch(SQLException e){
			System.out.println("erro:"+ e.getMessage());
			
		}finally {
			conexao.desconectar();
		}
		return usuarios;
	}
	public void recusarAmigo(String nickUser, String nickRecusado) {
		conexao.conectar();
		try {
			PreparedStatement pst = conexao.getConexao().prepareStatement("delete from \"user\".amigos where (nickAmigo1 = \'"+nickRecusado+ "\') and (nickamigo2 =\'"+ nickUser+"\')");
			pst.execute();
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
			
		}finally {
			conexao.desconectar();
		}
		
	}
	public void removerAmigo(String nickUsuario, String nickAmigo) {
		conexao.conectar();
		try {
			PreparedStatement pst = conexao.getConexao().prepareStatement("delete from \"user\".amigos where (((nickAmigo1 = \'"+nickAmigo+ "\') and (nickamigo2 =\'"+ nickUsuario+"\') )or ((nickAmigo1 = \'"+nickUsuario+ "\') and (nickamigo2 = '"+nickAmigo+"')))");
			pst.execute();
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
			
		}finally {
			conexao.desconectar();
		}
		
	}

}
