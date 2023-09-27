package view;

import java.util.Date;

//import java.lang.runtime.SwitchBootstraps;
import java.util.Scanner;

import controller.ClienteDAO;
import controller.DepartamentoDAO;
import controller.DestinoDAO;
import controller.AgenciaDAO;
import controller.PassagemDAO;
import controller.PedidoDAO;
import br.com.crud.model.Cliente;
import br.com.crud.model.Departamento;
import br.com.crud.model.Destino;
import br.com.crud.model.Agencia;
import br.com.crud.model.Passagem;
import br.com.crud.model.Pedido;


public class main {

	
	public static void main(String[] args) {
		
		// CLASSES DAO
		AgenciaDAO agenciaDAO = new AgenciaDAO();
		DepartamentoDAO departamentoDAO = new DepartamentoDAO();
		DestinoDAO destinoDAO = new DestinoDAO();
		PassagemDAO passagemDAO = new PassagemDAO();
		PedidoDAO pedidoDAO = new PedidoDAO();
		ClienteDAO clienteDAO = new ClienteDAO();
		
		
		
		// CLASSES PARA CRIAR UM NOVO REGISTRO NO BD
		Agencia agencia = new Agencia();
		Departamento departamento = new Departamento();
		Destino destino = new Destino();
		Passagem passagem = new Passagem();
		Pedido pedido = new Pedido();
		Cliente cliente = new Cliente();
		
	

		
		
		// VARIÁVEIS PARA AGENCIA
	    String unidade = "", endereco = "", telefoneUnid = "", emailUnid = "", cnpj = "" ;
	    
		
	    // VARIÁVEIS DEPARTAMENTO - codUnid ACIMA TAMBÉM FOI UTILIZADO PARA DEPARTAMENTO
	    int codDepartamento;
	    String nomeDepartamento;
	    
		
		
	    // VARIÁVEIS DESTINO
	    String nomeDestino, categoriaDestino, condicao;
	    float precoDestino;
	    int qtdDisponivel;
	    
	    
	    
		// VARIÁVEIS PARA CLIENTE
		String cpf = "", nome = "", email = "", telefone = "";
		
		
		// VARIÁVEIS PEDIDO
		float total;
		String formaPagamento, status;
		
				
		// VARIÁVEIS PARA PASSAGEM
		int qtd, idPassagem;
		
		
		
		// VARIÁVLE ID GLOGAL
		int id;

		// VARIÁVEL PARA O LOOP CADASTRO
		int opcao = 0;
				
		// VARIÁVEL PARA O MENU PRINCIPAL
		int menu = 0;
		
		
		
		
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("=== INFORME ABAIXO ONDE DESEJA REALIZAR UM CADASTRO: \n");

		System.out.println("=> 1 - AGENCIA");
		System.out.println("=> 2 - DEPARTAMENTO");
		System.out.println("=> 3 - DESTINO");
		System.out.println("=> 4 - PASSAGEM");
		System.out.println("=> 5 - PEDIDO");
		System.out.println("=> 6 - CLIENTE");
		
		menu = entrada.nextInt();
		
		
switch (menu) {
		
		
		
		case 1: {
					
			do {

				System.out.println("===== Agencia =====");
				System.out.println("1 - Cadastrar unidade");
				System.out.println("2 - Excluir unidade");
				System.out.println("3 - Atualizar unidade");
				System.out.println("4 - Mostrar informações de unidade");
				System.out.println("5 - Sair");
				opcao = entrada.nextInt();

				switch (opcao) {
				
				case 1: {
															
					System.out.println("Digite o NOME da unidade:");
					unidade = entrada.next();
					agencia.setUnidade(unidade);
							
					System.out.println("Digite o TELEFONE da unidade:");
					telefoneUnid = entrada.next();
					agencia.setTelefone(telefoneUnid);
					
					System.out.println("Digite o E-MAIL da unidade:");
					emailUnid = entrada.next();
					agencia.setEmail(emailUnid);
					System.out.println("Digite o ENDEREÇO da unidade:");
					endereco = entrada.next();
					agencia.setEndereco(endereco);
					
					agenciaDAO.save(agencia);
					
					break;
				}
				case 2: {
					
					System.out.println("Digite o CNPJ da Agencia para exclusao: ");
					try {
						
						cnpj = entrada.next();
						agenciaDAO.removeByCnpj(cnpj);
						
					} catch (Exception e) {
						// e.getMessage();
						 
						System.out.println("Nenhuma unidade para excluir ");
					}

					break;
				}
				
				case 3: {

					System.out.println("Digite o CÓDIGO da unidade para atualizar: ");
					cnpj = entrada.next();

					System.out.println("Digite o novo NOME da unidade: ");
					unidade = entrada.next();
					agencia.setUnidade(unidade);
					
					System.out.println("Digite o novo TELEFONE da unidade: ");
					telefoneUnid = entrada.next();
					agencia.setTelefone(telefoneUnid);
					
					System.out.println("Digite o novo E-MAIL da unidade: ");
					emailUnid = entrada.next();
					agencia.setEmail(emailUnid);
					
					System.out.println("Digite o novo ENDEREÇO da unidade: ");
					endereco = entrada.next();
					agencia.setEndereco(endereco);

					agencia.setCnpj(cnpj);
					agenciaDAO.update(agencia);
				}
				
				case 4: {
									
					for (Agencia und : agenciaDAO.getAgencias()){

						System.out.println("CNPJ: " + und.getCnpj());
						System.out.println("UNIDADE: " + und.getUnidade());
						System.out.println("TELEFONE: " + und.getTelefone());
						System.out.println("E-MAIL: " + und.getEmail());
						System.out.println("ENDEREÇO: " + und.getEndereco());
						
						System.out.println("----------------------------------- ");
					}
					
					break;
				}
				case 5: {
					System.out.println(" === Agradecemos pela preferência! === ");
					break;
				}
				default:
					System.out.println("Opcao invalida: ");

				};

			} while (opcao != 5);

			
			break;
			
			}
		
		// DEPARTAMENTO
			case 2: {
					
					do {

						System.out.println("===== DEPARTAMENTO =====");
						System.out.println("1 - Cadastro de departamento");
						System.out.println("2 - Excluir departamento");
						System.out.println("3 - Atualizar departamento");
						System.out.println("4 - Mostrar departamento");
						System.out.println("5 - Sair");
						opcao = entrada.nextInt();

						switch (opcao) {
						
						case 1: {
												
							System.out.println("Digite o NOME do departamento:");
							nomeDepartamento = entrada.next();
							departamento.setNomeDepartamento(nomeDepartamento);

							System.out.println("Digite o CNPJ da unidade:");
							cnpj = entrada.next();
							departamento.setCnpj(cnpj);
									
							departamentoDAO.save(departamento);
							break;
						}
						
						case 2: {
							
							System.out.println("Digite o CÓDIGO do departamento para exclusao: ");
							try {
								
								codDepartamento = entrada.nextInt();
								
								departamentoDAO.removeByCod(codDepartamento);
								
							} catch (Exception e) {
								// e.getMessage();
								 
								System.out.println("Nenhum contato para excluir ");
							}

							break;
						}
						
						case 3: {

							System.out.println("Digite o CÓDIGO do departamento para atualizar: ");
							codDepartamento = entrada.nextInt();

							System.out.println("Digite o novo NOME do departamento: ");
							nomeDepartamento = entrada.next();
							departamento.setNomeDepartamento(nomeDepartamento);
							
							System.out.println("Digite o CÓDIGO da nova UNIDADE: ");
							cnpj = entrada.next();
							departamento.setCnpj(cnpj);
							
							departamento.setCodDepartamento(codDepartamento);
							departamentoDAO.update(departamento);
						}
						
						case 4: {
							for (Departamento dep : departamentoDAO.getDepartamento()) {

								System.out.println("CÓDIGO DO DEPARTAMENTO: " + dep.getCodDepartamento());
								System.out.println("NOME: " + dep.getNomeDepartamento());
								System.out.println("UNIDADE: " + dep.getCnpj());
								
								System.out.println("----------------------------------- ");

							}
							break;
						}

						case 5: {
							System.out.println(" === Até logo! === ");
							break;
						}
						default:
							System.out.println("Opcao invalida: ");

						};

					} while (opcao != 5);


					
					break;

					}
				
			// DESTINO
			case 3: {
					
					do {

						System.out.println("===== DESTINO =====");
						System.out.println("1 - Cadastro de destino");
						System.out.println("2 - Excluir cadastro");
						System.out.println("3 - Atualizar cadastro");
						System.out.println("4 - Mostrar cadastro");
						System.out.println("5 - Sair");
						opcao = entrada.nextInt();

						switch (opcao) {
						
						case 1: {
							
							System.out.println("Digite o NOME do destino:");
							nomeDestino = entrada.next();
							destino.setNomeDestino(nomeDestino);
							
							System.out.println("Digite o PREÇO do destino:");
							precoDestino = entrada.nextFloat();
							destino.setPrecoUnit(precoDestino);

							System.out.println("Digite a CATEGORIA do destino:");
							categoriaDestino = entrada.next();
							destino.setCategoriaDestino(categoriaDestino);
							
							System.out.println("Digite a QUANTIDADE:");
							qtdDisponivel = entrada.nextInt();
							destino.setQtdDisponivel(qtdDisponivel);
							
							System.out.println("Digite a CONDIÇÃO:");
							condicao = entrada.next();
							destino.setCondicao(condicao);
							
							destinoDAO.save(destino);
							break;
						}
						case 2: {
							
							System.out.println("Digite o id do destino para exclusao: ");
							try {
								
								id = entrada.nextInt();
								
								destinoDAO.removeById(id);
								
							} catch (Exception e) {
								// e.getMessage();
								 
								System.out.println("Nenhum destino para excluir ");
							}

							break;
						}
					
						case 3: {

							System.out.println("Digite o id do destino para atualizar: ");
							id = entrada.nextInt();

							System.out.println("Digite o novo NOME do destino: ");
							nomeDestino = entrada.next();
							destino.setNomeDestino(nomeDestino);
							
							System.out.println("Digite o novo PREÇO: ");
							precoDestino = entrada.nextFloat();
							destino.setPrecoUnit(precoDestino);;
							
							System.out.println("Digite a nova CATEGORIA do destino: ");
							categoriaDestino = entrada.next();
							 destino.setCategoriaDestino(categoriaDestino);
							
							System.out.println("Digite a nova QUANTIDADE DISPONÍVEL para destino: ");
							qtdDisponivel = entrada.nextInt();
							destino.setQtdDisponivel(qtdDisponivel);
							
							System.out.println("Digite a nova CONDIÇÃO para o destino: ");
							condicao = entrada.next();
							destino.setCondicao(condicao);
							

							destino.setIdDestino(id);
							destinoDAO.update(destino);
						}
						
						case 4: {
							for (Destino des : destinoDAO.getDestinos()) {

								System.out.println("NOME DESTINO: " + des.getNomeDestino());
								System.out.println("PRECO R$: " + des.getPrecoUnit());
								System.out.println("CATEGORIA: " + des.getCategoriaDestino());
								System.out.println("QUANTIDADE DISPONÍVEL: " + des.getQtdDisponivel());			
								System.out.println("CONDIÇÃO: " + des.getCondicao());
								
								System.out.println("----------------------------------- ");

							}
							break;
						}
						
						case 5: {
							System.out.println(" === Até logo! === ");
							break;
						}
						default:
							System.out.println("Opcao invalida: ");

						};

					} while (opcao != 5);
					
					break;

					}
				
				
			// PASSAGEM
			case 4: {
					
					do {

						System.out.println("===== PASSAGEM =====");
						System.out.println("1 - Cadastro de passagem com base em um DESTINO");
						System.out.println("2 - Excluir passagem");
						System.out.println("3 - Atualizar passagem");
						System.out.println("4 - Mostrar passagem");
						System.out.println("5 - Sair");
						opcao = entrada.nextInt();

						switch (opcao) {
						
						case 1: {
							System.out.println("Digite a QUANTIDADE de passagens:");
							qtd = entrada.nextInt();
							passagem.setQuantidade(qtd);
							
							System.out.println("Digite o id do destino:");
							id = entrada.nextInt();
							passagem.setIdDestino(id);
						
							passagemDAO.save(passagem);
							break;
						}
						case 2: {
							
							System.out.println("Digite o id da passagem para exclusao: ");
							try {
								
								id = entrada.nextInt();
								
								passagemDAO.removeById(id);
								
							} catch (Exception e) {
								// e.getMessage();
								 
								System.out.println("Nenhuma passagem para excluir ");
							}

							break;
						}
						case 3: {

							System.out.println("Digite o id da passagem para atualizar: ");
							idPassagem = entrada.nextInt();

							System.out.println("Digite a QUANTIDADE de passagens: ");
							qtd = entrada.nextInt();
							passagem.setQuantidade(qtd);
							
							System.out.println("Digite o novo id do destino: ");
							id = entrada.nextInt();
							passagem.setIdDestino(id);


							passagem.setIdPassagem(idPassagem);
							passagemDAO.update(passagem);
						}
						
						case 4: {
							for (Passagem pas : passagemDAO.getPassagens()) {

								System.out.println("QUANTIDADE: " + pas.getQuantidade());
								System.out.println("ID DESTINO: " + pas.getIdDestino());
														
								System.out.println("----------------------------------- ");

							}
							break;
						}
						
						case 5: {
							System.out.println(" === Agradecemos pela preferência! === ");
							break;
						}
						default:
							System.out.println("Opcao invalida: ");

						};

					} while (opcao != 5);

					
					break;

					}
			
			// PEDIDO
			case 5: {
				
				do {

					System.out.println("===== PEDIDO =====");
					System.out.println("1 - Cadastro de pedido");
					System.out.println("2 - Excluir pedido");
					System.out.println("3 - Atualizar pedido");
					System.out.println("4 - Mostrar pedido");
					System.out.println("5 - Sair");
					opcao = entrada.nextInt();

					switch (opcao) {
					
					case 1: {
						
						pedido.setDataPedido(new Date());
						
						
						System.out.println("Digite a codigo departamento: ");
						codDepartamento = entrada.nextInt();
						pedido.setCodDepartamento(codDepartamento);
						
						System.out.println("Digite o CPF do cLiente:");
						cpf = entrada.next();
						pedido.setCpfCli(cpf);
						
						System.out.println("Digite o PREÇO TOTAL do pedido:");
						total = entrada.nextFloat();
						pedido.setPrecoTotal(total);
						
						System.out.println("Digite a FORMA DE PAGAMENTO:");
						formaPagamento = entrada.next();
						pedido.setPagamento(formaPagamento);
								
						
						pedidoDAO.save(pedido);
						break;
					}
					case 2: {
						
						System.out.println("Digite o NÚMERO DO PEDIDO para exclusao: ");
						try {
							
							id = entrada.nextInt();
							
							pedidoDAO.removeById(id);
							
						} catch (Exception e) {
							// e.getMessage();
							 
							System.out.println("Nenhum pedido para excluir ");
						}

						break;
					}
					case 3: {

						System.out.println("Digite o NÚMERO DO PEDIDO para atualizar: ");
						id = entrada.nextInt();

						System.out.println("Digite o novo PREÇO do pedido: ");
						total = entrada.nextFloat();
						pedido.setPrecoTotal(total);
						
						System.out.println("Digite a nova FORMA DE PAGAMENTO: ");
						formaPagamento = entrada.next();
						pedido.setPagamento(formaPagamento);
						
						System.out.println("Digite o novo STATUS do pedido: ");
						status = entrada.next();
						pedido.setStatusPedido(status);
								
											
						pedido.setIdPedido(id);
						pedidoDAO.update(pedido);
					}
					case 4: {
						for (Pedido ped : pedidoDAO.getPedidos()) {

							System.out.println("PREÇO TOTAL R$: " + ped.getPrecoTotal());
							System.out.println("FORMA DE PAGAMENTO: " + ped.getPagamento());
							System.out.println("COD. DEPARTAMENTO: " + ped.getCodDepartamento());

							System.out.println("DATA DO PEDIDO: " + ped.getDataPedido());
							
							System.out.println("----------------------------------- ");

						}
						break;
					}
					case 5: {
						System.out.println(" === Agradecemos pela preferência! === ");
						break;
					}
					default:
						System.out.println("Opcao invalida: ");

					};

				} while (opcao != 5);
				
				
				break;

				}
			
			// CLIENTE
			case 6: {
				
				do {

					System.out.println("===== CLIENTE =====");
					System.out.println("1 - Cadastro de cliente");
					System.out.println("2 - Excluir cadastro");
					System.out.println("3 - Atualizar cadastro");
					System.out.println("4 - Mostrar cadastro");
					System.out.println("5 - Sair");
					opcao = entrada.nextInt();

					switch (opcao) {
					
					case 1: {
						System.out.println("Digite o CPF do cliente:");
						cpf = entrada.next();
						cliente.setCpf(cpf);
						
						System.out.println("Digite o NOME do cliente:");
						nome = entrada.next();
						cliente.setNome(nome);

						System.out.println("Digite o E-MAIL do cliente:");
						email = entrada.next();
						cliente.setEmail(email);
						
						System.out.println("Digite o TELEFONE do cliente:");
						telefone = entrada.next();
						cliente.setTelefone(telefone);
						
						clienteDAO.save(cliente);
						break;
					}
					case 2: {
						
						System.out.println("Digite o CPF do cliente para exclusao: ");
						try {
							
							cpf = entrada.next();
							
							clienteDAO.removeByCpf(cpf);
							
						} catch (Exception e) {
							// e.getMessage();
							 
							System.out.println("Nenhum contato para excluir ");
						}

						break;
					}
					case 3: {

						System.out.println("Digite o CPF do contato para atualizar: ");
						cpf = entrada.next();

						System.out.println("Digite o novo NOME do cliente: ");
						nome = entrada.next();
						cliente.setNome(nome);
						
						System.out.println("Digite o novo E-MAIL do cliente: ");
						email = entrada.next();
						cliente.setEmail(email);
						
						System.out.println("Digite o novo TELEFONE do cliente: ");
						telefone = entrada.next();
						cliente.setTelefone(telefone);
						

						cliente.setCpf(cpf);
						clienteDAO.update(cliente);
					}
					case 4: {
						for (Cliente cli : clienteDAO.getClientes()) {

							System.out.println("NOME: " + cli.getNome());
							System.out.println("EMAIL: " + cli.getEmail());
							System.out.println("TELEFONE: " + cli.getTelefone());
							
							System.out.println("----------------------------------- ");

						}
						break;
					}
					case 5: {
						System.out.println(" === Agradecemos pela preferência! === ");
						break;
					}
					default:
						System.out.println("Opcao invalida: ");

					};

				} while (opcao != 5);
				
				
				
				break;

				}
		}
	
	entrada.close();
	
	}
	
}
		

		
	
