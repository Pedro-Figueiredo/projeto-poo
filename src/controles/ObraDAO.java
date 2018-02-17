package controles;

import system.Obra;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;

public class ObraDAO {
private ConexaoBD conexao = new ConexaoBD();
	
	public void criaObra(Obra o) {
		conexao.conectar();
		try {
			PreparedStatement pst = conexao.getConexao().prepareStatement("insert into \"feed\".obra(titulo,descrição,autor,formato,ano,publicação) values(?,?,?,?,?,?)");
			pst.setString(1,o.getTitulo());
			pst.setString(2,o.getDescrição());
			pst.setString(3,o.getAutor());
			pst.setString(4,o.getFormato());
			pst.setInt(5,o.getAno());
			pst.setTimestamp(6,o.getPublicação());

			pst.execute();
			System.out.println("obra cadastrado com sucesso.");
		}catch(SQLException e ){
			System.out.println("Erro:" +e.getMessage());			
		}finally {
			conexao.desconectar();
		}
	}
}
