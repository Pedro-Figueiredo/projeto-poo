package system;

public class Usuario {
	private String nickName, nome, email, senha;
	private int idade;
	private boolean login = false;
	

	public Usuario() {
		
	}
	
	public Usuario(String nickName, String nome, String email, String senha, int idade ) {
		this.nickName = nickName;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.idade = idade;
	}
	
	public Usuario(String nickName, String nome, String email, int idade ) {
		this.nickName = nickName;
		this.nome = nome;
		this.email = email;
		this.idade = idade;
	}
	public Usuario(String nick, String senha) {
		this.nickName = nick;
		this.senha = senha;
	}
	public Usuario(Usuario u) {
		this.nickName = u.getNickName();
		this.nome = u.getNome();
		this.email = u.getEmail();
		this.senha = u.getSenha();
		this.idade = u.getIdade();
		this.login= u.getLogin();
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
	

	public boolean getLogin() {
		return login;
	}

	public void setLogin(boolean login) {
		this.login = login;
	}

	public String toString() {
		return " nome:" + nome + " idade:" + idade +" email: "+ email + " NickName:"+ nickName ;
	}
}
