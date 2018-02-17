package system;
import java.sql.Timestamp;
public class Obra {
	private String titulo, autor = "N�o informado/desconhecido" ,descri��o ,genero ,formato ;
	private int ano, id;
	Timestamp publica��o;
	private boolean publish;
	
	public Timestamp getPublica��o() {
		return publica��o;
	}
	
	public Obra() {
	}
	
	public Obra(String titulo, String autor , String descri��o, String genero, String formato , int ano) {
		this.titulo=titulo;
		setAutor(autor);
		this.descri��o=descri��o;
		this.genero=genero;
		this.formato=formato;
		this.ano=ano;
		publica��o = new Timestamp(System.currentTimeMillis());
	}
	public Obra(String titulo, String descri��o, String genero, String formato) {
		this.titulo=titulo;
		this.descri��o=descri��o;
		this.genero=genero;
		this.formato=formato;
		publica��o = new Timestamp(System.currentTimeMillis());
	}
	public Obra(String titulo, String descri��o, String formato) {
		this.titulo=titulo;
		this.descri��o=descri��o;
		this.formato=formato;
		publica��o = new Timestamp(System.currentTimeMillis());
	}
	public Obra(String titulo, String descri��o, String genero, String formato , int ano) {
		this.titulo=titulo;
		this.descri��o=descri��o;
		this.genero=genero;
		this.formato=formato;
		this.ano=ano;
		publica��o = new Timestamp(System.currentTimeMillis());
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
			this.autor="N�o informado/desconhecido";
		}
		else {
			this.autor = autor;
		}
	}
	
	public String getDescri��o() {
		return descri��o;
	}
	
	public void setDescri��o(String descri��o) {
		this.descri��o = descri��o;
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
		return "Formato:"+formato+"  Autor:"+ autor+ "  Genero:"+genero+"  Titulo:"+titulo+"  Descri��o:"+descri��o+"  Ano:"+ano ;
	 }
	
	
}
