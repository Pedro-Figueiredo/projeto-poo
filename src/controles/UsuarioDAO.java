package controles;

import user.Usuario;
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
		}catch(SQLException e){
			System.out.println("Erro:"+ e.getMessage());			
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
			int idUsuario = resultado.getInt("id_usuario");
			u.setId(idUsuario);
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
				int idUsuario = resultado.getInt("id_usuario");
				usuarios.add(new Usuario(nickName1,nomeUsuario,emailUsuario, idadeUsuario,idUsuario));
			}
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		} finally {
			conexao.desconectar();
		}
		return usuarios;
	}

}
