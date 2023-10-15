package checkpoint;

public class Cliente {
	public String nome;
	public String cpfCnpj;
	public int numConta;
	public String tipoConta;
	public double saldo;
	
	
	public Cliente(String nome, String cpfCnpj, int numConta, String tipoConta, double saldo) {
		this.nome = nome;
		this.cpfCnpj = cpfCnpj;
		this.numConta = numConta;
		this.tipoConta = tipoConta;
		this.saldo = saldo;
	}
	
}
