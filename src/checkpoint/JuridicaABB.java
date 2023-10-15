package checkpoint;

import java.util.Scanner;

public class JuridicaABB {
		Scanner sc = new Scanner(System.in);
		public Cliente cliente;
		public JuridicaABB esq;	
		public JuridicaABB dir;
		public JuridicaABB raiz = null;
		

		public void inserir(Cliente c) {
			raiz = inserir(raiz, c);
		}
		
		public JuridicaABB inserir(JuridicaABB a, Cliente c) {
			double saldo = c.saldo;
			if(a == null) {
				a = new JuridicaABB();
				a.cliente = c;
				a.dir = null;
				a.esq = null;
			}else if (saldo < a.cliente.saldo) 
				a.esq = inserir(a.esq, c);
			else
				a.dir = inserir(a.dir, c);
			return a;
		}
		
		public void mostraCliente(double minSaldo) {
			mostraCliente(raiz, minSaldo);
		}
		public void mostraCliente(JuridicaABB a, double minSaldo) {
			if(a != null) {
				mostraCliente(a.dir, minSaldo);
				if(minSaldo <= a.cliente.saldo)
					System.out.println("Nome: " + a.cliente.nome +  "  | CPF: "+ a.cliente.cpfCnpj+ "  | Saldo: " + a.cliente.saldo);
				mostraCliente(a.esq, minSaldo);
			}
		}
		
		public void consultaCliente(String cpf) {
			consultaCliente(raiz, cpf);
		}
		public void consultaCliente(JuridicaABB a, String cpf) {
		    if (a != null) {
		        int comparacao = cpf.compareTo(a.cliente.cpfCnpj);
		        
		        if (comparacao == 0) {
		            System.out.println("Nome: " + a.cliente.nome);
		            System.out.println("CPF: " + a.cliente.cpfCnpj);
		            System.out.println("Número da Conta: " + a.cliente.numConta);
		            System.out.println("Tipo de Conta: " + a.cliente.tipoConta);
		            System.out.println("Saldo: " + a.cliente.saldo);
		        } else if (comparacao < 0) {
		            consultaCliente(a.esq, cpf);
		        } else {
		            consultaCliente(a.dir, cpf);
		        }
		    } else {
		        System.out.println("Cliente com CPF " + cpf + " não encontrado.");
		    }
		}
		
		
		public void atualizaSaldo(int numConta) {
			JuridicaABB clienteABB = atualizaSaldo(raiz, numConta);
			System.out.print("Digite o valor do Saldo novo: ");
			clienteABB.cliente.saldo = sc.nextDouble();
			System.out.println("\n\n====================================");
            System.out.println("Nome: " + clienteABB.cliente.nome);
            System.out.println("CPF: " + clienteABB.cliente.cpfCnpj);
            System.out.println("Número da Conta: " + clienteABB.cliente.numConta);
            System.out.println("Tipo de Conta: " + clienteABB.cliente.tipoConta);
            System.out.println("Saldo: " + clienteABB.cliente.saldo);
            System.out.println("====================================\n\n");
		}
		public JuridicaABB atualizaSaldo(JuridicaABB a, int numConta) {
		    if (a != null) {
		        if (numConta == a.cliente.numConta) {
		        	System.out.println("\n\n====================================");
		            System.out.println("Nome: " + a.cliente.nome);
		            System.out.println("CPF: " + a.cliente.cpfCnpj);
		            System.out.println("Número da Conta: " + a.cliente.numConta);
		            System.out.println("Tipo de Conta: " + a.cliente.tipoConta);
		            System.out.println("Saldo: " + a.cliente.saldo);
		            System.out.println("====================================\n\n");
		            return a;
		        } else if (numConta < a.cliente.numConta) {
		        	atualizaSaldo(a.esq, numConta);
		        } else {
		        	atualizaSaldo(a.dir, numConta);
		        }
		    } else {
		        System.out.println("Cliente com Numero da Conta " + numConta + " não encontrado.");
		    }
		    return null;
		}
		
		
		
		public void QtdClientes() {
			int qtd = 0;
			qtd = QtdClientes(raiz, qtd);
			System.out.println("Quantidade de Clientes: " + qtd);
		}
		public int QtdClientes(JuridicaABB a, int qtd) {
			if(a != null) {
				QtdClientes(a.esq, qtd);
				qtd++;
				QtdClientes(a.dir, qtd);
			}
			return qtd;
		}
		
		
		public void QtdClientesSaldo(double saldo) {
			int qtd = 0;
			qtd = QtdClientesSaldo(raiz, qtd, saldo);
			System.out.println("Quantidade de Clientes: " + qtd);
		}
		public int QtdClientesSaldo(JuridicaABB a, int qtd, double saldo) {
			if(a != null) {
				QtdClientesSaldo(a.esq, qtd, saldo);
				if(saldo <= a.cliente.saldo)
					qtd++;
				QtdClientesSaldo(a.dir, qtd, saldo);
			}
			return qtd;
		}
}
