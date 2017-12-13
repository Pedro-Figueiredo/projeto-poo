package controles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ConexaoBD {

	private Connection conexao;
	private String driver, caminho, user, password;
	
	public ConexaoBD() {
		this.driver = "org.postgresql.Driver";
		this.caminho = "jdbc:postgresql://localhost:5432/GeekBook";
		this.user = "postgres";
		this.password = "wolf";
		this.conexao = null;
	}
	
	public void conectar() {
		System.setProperty("jdbc.Drivers", driver);
		
		try {
			conexao = DriverManager.getConnection(caminho, user, password);
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public void desconectar() {
		try {
			conexao.close();
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public ResultSet executarSQL(String comando) {
		ResultSet resultado = null;
		
		try {
			PreparedStatement stm = conexao.prepareStatement(comando);
			stm.execute();
			resultado = stm.getResultSet();

		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		}
		return resultado;
	}

	public Connection getConexao() {
		return conexao;
	}

}
