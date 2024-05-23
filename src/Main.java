import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		ArrayList<Cliente> clientes = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		Agencia agencia1 = new Agencia(1, "FLN");
		int idCliente = 0; // id interno do sistema
		int numeroConta = 1000; // valores identificadores que serão incrementados

		while (true) {
			System.out.println("============MENU============");
			mostraMenu();
			String opt = sc.nextLine();
			if (validaOpt(opt)) {
				if (opt.equals("1")) {
					String nome = null;
					String telefone = null;
					try {
						System.out.println("Nome: ");
						nome = sc.nextLine();
						System.out.println("Telefone: ");
						telefone = sc.nextLine();
					} catch (Exception e) {
						System.out.println("Entrada inválida. Por favor, tente novamente.");
					}
					clientes.add(new Cliente(idCliente, nome, telefone));
					System.out.println("Id cliente: " + idCliente);
					idCliente++;
				} else if (opt.equals("2")) {
					int clienteId ;
					Cliente cliente = null;
					boolean achouCliente = false;
					try {
						System.out.println("Informe o ID do cliente: ");
						clienteId = Integer.parseInt(sc.nextLine());
						for (Cliente c : clientes) {
							if (c.getId() == clienteId) {
								cliente = c;
								achouCliente = true;
								break;
							}
						}
						if (!achouCliente) {
							System.out.println("Não encontramos nenhum cliente com esse ID");
						} else {
							String tipoConta = "";
							while (!tipoConta.equals("P") && !tipoConta.equals("C")) {
								System.out.println("Qual seria o tipo da conta: 'P' para Poupança e 'C' para Corrente");
								tipoConta = sc.nextLine().toUpperCase();
							}
							double paramExtra = 0.0;
							if (tipoConta.equals("P")) {
								try {
									System.out.println("Informe o mínimo do saldo: ");
									paramExtra = Double.parseDouble(sc.nextLine());
									if (agencia1.addConta(numeroConta, true, paramExtra, cliente)) {
										System.out.println("Número de conta: " + numeroConta);
										numeroConta++;
									}
								} catch (Exception e) {
									System.out.println("Entrada inválida. Por favor, informe um número válido para o saldo mínimo.");
								}
							} else {
								try {
									System.out.println("Informe a taxa de juro: ");
									paramExtra = Double.parseDouble(sc.nextLine());
									if (agencia1.addConta(numeroConta, false, paramExtra, cliente)) {
										System.out.println("Número de conta: " + numeroConta);
										numeroConta++;
									}
								} catch (Exception e) {
									System.out.println("Entrada inválida. Por favor, informe um número válido para a taxa de juro.");
								}
							}
						}
					} catch (NumberFormatException e) {
						System.out.println("Entrada inválida. Por favor, informe um ID de cliente válido.");
					}
				} else if (opt.equals("3")) {
					int numConta;
					try {
						System.out.println("Informe o número da conta");
						numConta = Integer.parseInt(sc.nextLine());
						if (agencia1.getConta(numConta) != null) {
							try {
								System.out.println("Informe o valor que você deseja debitar da conta: ");
								float valor = Float.parseFloat(sc.nextLine());
								agencia1.getConta(numConta).debitar(valor);
							} catch (NumberFormatException e) {
								System.out.println("Entrada inválida. Por favor, informe um valor numérico para debitar.");
							}
						} else {
							System.out.println("Conta não encontrada.");
						}
					} catch (NumberFormatException e) {
						System.out.println("Entrada inválida. Por favor, informe um número de conta válido.");
					}
				} else if (opt.equals("4")) {
					int numConta;
					try {
						System.out.println("Informe o número da conta");
						numConta = Integer.parseInt(sc.nextLine());
						if (agencia1.getConta(numConta) != null) {
							try {
								System.out.println("Informe o valor que você deseja depositar na conta: ");
								float valor = Float.parseFloat(sc.nextLine());
								agencia1.getConta(numConta).creditar(valor);
							} catch (NumberFormatException e) {
								System.out.println("Entrada inválida. Por favor, informe um valor numérico para depositar.");
							}
						} else {
							System.out.println("Conta não encontrada.");
						}
					} catch (NumberFormatException e) {
						System.out.println("Entrada inválida. Por favor, informe um número de conta válido.");
					}
				} else if (opt.equals("5")) {
					int numConta;
					try {
						System.out.println("Informe o número da conta");
						numConta = Integer.parseInt(sc.nextLine());
						if (agencia1.getConta(numConta) != null) {
							System.out.println("O saldo da conta é: R$" + agencia1.getConta(numConta).getSaldo());
						} else {
							System.out.println("Conta não encontrada.");
						}
					} catch (NumberFormatException e) {
						System.out.println("Entrada inválida. Por favor, informe um número de conta válido.");
					}
				} else if (opt.equals("6")) {
					int clienteId;
					Cliente cliente = null;
					boolean achouCliente = false;
					try {
						System.out.println("Informe o ID do cliente: ");
						clienteId = Integer.parseInt(sc.nextLine());
						for (Cliente c : clientes) {
							if (c.getId() == clienteId) {
								cliente = c;
								achouCliente = true;
								break;
							}
						}
						if (achouCliente) {
							System.out.println(cliente);
						} else {
							System.out.println("Não encontramos nenhum cliente com esse ID");
						}
					} catch (NumberFormatException e) {
						System.out.println("Entrada inválida. Por favor, informe um ID de cliente válido.");
					}
				} else if (opt.equals("7")) {
					int numConta;
					try {
						System.out.println("Informe o número da conta");
						numConta = Integer.parseInt(sc.nextLine());
						if (agencia1.getConta(numConta) != null) {
							agencia1.removeConta(numConta);
							System.out.println("Conta Removida com sucesso!");
						}
					} catch (NumberFormatException e) {
						System.out.println("Entrada inválida. Por favor, informe um número de conta válido.");
					}
				} else if (opt.equals("8")) {
					Collections.sort(agencia1.getContas());
					for (Conta conta : agencia1.getContas()) {
						System.out.println(conta);
					}
				} else if (opt.equals("9")) {
					Collections.sort(clientes);
					for (Cliente cliente : clientes) {
						System.out.println(cliente);
					}
				}else if(opt.equals("10")) {
					int clienteId = 0;
					boolean achouCliente = false;
					Conta cc = null,cp = null;
					try {
						System.out.println("Informe o ID do cliente: ");
						clienteId = Integer.parseInt(sc.nextLine());
					}catch(Exception e) {
						System.out.println("Informe um numero inteiro como ID!");
					}
						for (Cliente c : clientes) {
							System.out.println("entrou no loop de clientes");
							if (c.getId() == clienteId) {
								clientes.remove(c);
								cc = c.getContaCorrente();
								cp= c.getContaPoupanca();
								System.out.println("achou o cliente");
								achouCliente = true;
								break;
							}
						}
						if(cc != null) {
							System.out.println("removendo conta corrente");
							agencia1.removeConta(cc.getNumeroConta());
						}else if(cp != null) {
							System.out.println("removendo conta poupanca");
							agencia1.removeConta(cp.getNumeroConta());
						}
						if(!achouCliente) {
							System.out.println("Esse cliente não foi encontrado");
						}else {
							System.out.println("Cliente removido junto com suas contas");
						}
					
				}else if (opt.equals("0")) {
					System.out.println("Programa encerrado!");
					break;
				}
			}
		}
		sc.close();
	}

	public static void mostraMenu() {
		System.out.print("Informe a operação desejada:\n"
				+ "1 - Adicionar cliente \n"
				+ "2 - Adicionar conta \n"
				+ "3 - Debitar conta \n"
				+ "4 - Depositar em conta \n"
				+ "5 - Consultar saldo em conta \n"
				+ "6 - Consultar informações do cliente \n"
				+ "7 - Remover conta \n"
				+ "8 - Gerar relatório de contas \n"
				+ "9 - Gerar relatório de clientes \n"
				+ "10 - Remover Cliente \n"
				+ "0 - Encerrar programa \n"
				+ ">> ");
	}

	public static boolean validaOpt(String opt) {
		try {
			int option = Integer.parseInt(opt); // tentando coverter string para inteiro, se falhar é porque a entrada é inválida
			if (option >= 0 && option <= 10) {
				return true;
			} else {
				System.out.println("Opção inválida. Por favor, escolha um número entre 0 e 10.");
				return false;
			}
		} catch (NumberFormatException e) {
			System.out.println("Entrada inválida. Por favor, digite um número.");
			return false;
		}
	}
}
