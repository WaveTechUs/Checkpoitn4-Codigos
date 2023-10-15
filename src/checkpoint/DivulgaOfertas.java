package checkpoint;

import java.util.Scanner;


public class DivulgaOfertas {
	/*
	Erik Giuseppe Kato Bandeira 92988
	João Tancredi Dela Rocca 93527
	Matheus Stelutti Sepulveda 96272
	Rafael Ioshi Imamura Pereira 93102 
	Luis Gustavo Profiro da Silva 96258
	*/
	public static void main(String[] args) {
	Scanner le = new Scanner(System.in);
	/*
	* Cria a uma árvore de busca binária para cada tipo de conta
	* (pessoa física ou jurídica)
	*/
	int opcao, op, numeroConta;
	String nome, cpfCnpj;
	String tipoConta = null;
	double saldo;
	
	FisicaABB fisicaABB = new FisicaABB();
	JuridicaABB juridicaABB = new JuridicaABB();
	
	do {
		System.out.println(" 0 - Encerrar o programa");
		System.out.println(" 1 - Inscrição cliente");
		System.out.println(" 2 - Oferta de novo serviço e/ou aplicação");
		System.out.println(" 3 – Entrar no Submenu ");
		opcao = le.nextInt();
		switch (opcao) {
			case 1:
				System.out.print("Digite nome: "); // Limpa o buffer de entrada
				nome = le.next();
				System.out.print("Digite cpf: ");
				cpfCnpj = le.next();
				System.out.print("Digite número da conta: ");
				numeroConta = le.nextInt();
				do {
					 System.out.print("Digite 1- Pessoa Física 2- Pessoa Jurídica: ");
					 op = le.nextInt();
					 switch (op) {
					 case 1:
						 tipoConta = "Física";
						 break;
					case 2:
						tipoConta = "Jurídica";
						break;
					default:
						System.out.println("Opção inválida ");
						op = -1;
					}
				} while (op == -1);
				System.out.print("Informe saldo em aplicações R$: ");
				saldo = le.nextDouble();
				/*
				* Intancia um objeto da classe Cliente e insere na ABB correspondente
				* a tipo de conta
				*/
				Cliente c = new Cliente(nome, cpfCnpj, numeroConta, tipoConta, saldo);
				if(tipoConta == "Física")
					fisicaABB.inserir(c);
				else
					juridicaABB.inserir(c);
				break;
				
			case 2:
				System.out.print("Qual tipo de conta a oferta se destina? ");
				do {
					System.out.print("Digite 1- Pessoa Física 2- Pessoa Jurídica: ");
					op = le.nextInt();
					switch (op) {
						case 1:
							tipoConta = "Física";
							break;
						case 2:
							tipoConta = "Jurídica";
							break;
						default:
							System.out.println("Opção inválida ");
							op = -1;
					}
				} while (op == -1);
				System.out.print("Qual o valor de saldo mínimo exigido: R$ ");
				saldo = le.nextDouble();
				/*
				* Fazendo uso de um método da classe ABB, desenvolvido para este
				* problema, uma lista de clientes aptos para a oferta é gerada.
				* Nesse trecho de programa que tentar fazer o contato com todos os
				* clientes presente na lista.
				*/
				System.out.println("\n\n====================================");
				System.out.println("Lista de Clientes: ");
				if(tipoConta == "Física")
					fisicaABB.mostraCliente(saldo);
				else
					juridicaABB.mostraCliente(saldo);
				
				System.out.println("====================================\n\n");
				break;
			case 3:
				/*
				* Implemente o submenu descrito no texto
				*/
				System.out.print("Qual tipo de conta a oferta se destina? ");
				do {
					System.out.print("Digite 1- Pessoa Física 2- Pessoa Jurídica: ");
					op = le.nextInt();
					switch (op) {
						case 1:
							tipoConta = "Física";
							break;
						case 2:
							tipoConta = "Jurídica";
							break;
						default:
							System.out.println("Opção inválida ");
							op = -1;
					}
				} while (op == -1);
				
				do {
					System.out.println("TIPO CONTA: " + tipoConta);
					System.out.println(" 1 - Consultar Cliente");
					System.out.println(" 2 - Atualizar Saldo");
					System.out.println(" 3 - Quantidade Clientes");
					System.out.println(" 4 – Quantidade Clientes Com Saldo Maior ");
					System.out.println(" 5 – Voltar Menu Principal ");
					op = le.nextInt();
					switch (op) {
					case 1:
						if(tipoConta == "Física"){
							System.out.println("\n\n====================================");
							System.out.print("Digite um CPF: ");
							cpfCnpj = le.next();
							fisicaABB.consultaCliente(cpfCnpj);
							System.out.println("====================================\n\n");
						}
						else {
							System.out.println("\n\n====================================");
							System.out.print("Digite um CPF: ");
							cpfCnpj = le.next();
							juridicaABB.consultaCliente(cpfCnpj);
							System.out.println("====================================\n\n");
						}
						break;
					case 2:
						if(tipoConta == "Física") {
							System.out.print("Digite o Numero da Conta: ");
							numeroConta = le.nextInt();
							fisicaABB.atualizaSaldo(numeroConta);
						}
						else {
							System.out.print("Digite o Numero da Conta: ");
							numeroConta = le.nextInt();
							juridicaABB.atualizaSaldo(numeroConta);
						}
						
						break;
					case 3:
						if(tipoConta.equals("Física"))
							fisicaABB.QtdClientes();
						else
							juridicaABB.QtdClientes();
						break;
					case 4:
						if(tipoConta.equals("Física")) {
							System.out.print("Digite o valor minimo: ");
							saldo = le.nextDouble();
							fisicaABB.QtdClientesSaldo(saldo);	
						}
						else {
							System.out.print("Digite o valor minimo: ");
							saldo = le.nextDouble();
							juridicaABB.QtdClientesSaldo(saldo);	
						}
						break;
					case 5:
						break;
					default:
						System.out.println("Opção inválida ");
						op = -1;
					}
				}while(op == -1);
				break;
		}
	} while (opcao != 0);
	System.out.println("Clientes que não aceitaram ou não estavam adequados para a oferta");
	/*
	* Esvazia as ABBs apresentando todos os clientes que aguardam nova portunidade
	*/
	le.close();
	}
}
