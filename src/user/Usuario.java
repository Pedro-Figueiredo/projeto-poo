package user;

public class Usuario {
	private String nickName, nome, email, senha;
	private int idade,id;
	

	public Usuario() {
		
	}
	
	public Usuario(String nickName, String nome, String email, String senha, int idade ) {
		this.nickName = nickName;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.idade = idade;
	}
	public Usuario(String nickName, String nome, String email, String senha, int idade, int id ) {
		this.nickName = nickName;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.idade = idade;
		this.id = id;
	}
	
	public Usuario(String nickName, String nome, String email, int idade, int id ) {
		this.nickName = nickName;
		this.nome = nome;
		this.email = email;
		this.idade = idade;
		this.id = id;
	}
		
	
	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome=nome;
		}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public int getIdade() {
		return idade;
	}
	
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String toString() {
		return " id usuario:"+ id + " nome:" + nome + " idade:" + idade +" email: "+ email + " NickName:"+ nickName ;
	}
}
