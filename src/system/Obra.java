package system;
import java.sql.Timestamp;
public class Obra {
	private String titulo, autor = "Não informado/desconhecido" ,descrição ,genero ,formato ;
	private int ano, id;
	Timestamp publicação;
	private boolean publish;
	
	public Timestamp getPublicação() {
		return publicação;
	}
	
	public Obra() {
	}
	
	public Obra(String titulo, String autor , String descrição, String genero, String formato , int ano) {
		this.titulo=titulo;
		setAutor(autor);
		this.descrição=descrição;
		this.genero=genero;
		this.formato=formato;
		this.ano=ano;
		publicação = new Timestamp(System.currentTimeMillis());
	}
	public Obra(String titulo, String descrição, String genero, String formato) {
		this.titulo=titulo;
		this.descrição=descrição;
		this.genero=genero;
		this.formato=formato;
		publicação = new Timestamp(System.currentTimeMillis());
	}
	public Obra(String titulo, String descrição, String formato) {
		this.titulo=titulo;
		this.descrição=descrição;
		this.formato=formato;
		publicação = new Timestamp(System.currentTimeMillis());
	}
	public Obra(String titulo, String descrição, String genero, String formato , int ano) {
		this.titulo=titulo;
		this.descrição=descrição;
		this.genero=genero;
		this.formato=formato;
		this.ano=ano;
		publicação = new Timestamp(System.currentTimeMillis());
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getAutor() {
		return autor;
	}
	
	public void setAutor(String autor) {
		if (autor.equals("")) {
			this.autor="Não informado/desconhecido";
		}
		else {
			this.autor = autor;
		}
	}
	
	public String getDescrição() {
		return descrição;
	}
	
	public void setDescrição(String descrição) {
		this.descrição = descrição;
	}
	
	public String getGenero() {
		return genero;
	}
	
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	public String getFormato() {
		return formato;
	}
	
	public void setFormato(String formato) {
		this.formato = formato;
	}
	
	public int getAno() {
		return ano;
	}
	
	public void setAno(int ano) {
		this.ano = ano;
	}
	
	 public boolean getPublish() {
		return publish;
	}

	public void setPublish(boolean publish) {
		this.publish = publish;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String toString(){
		return "Formato:"+formato+"  Autor:"+ autor+ "  Genero:"+genero+"  Titulo:"+titulo+"  Descrição:"+descrição+"  Ano:"+ano ;
	 }
	
	
}
