import classes.Hospedagem;
import classes.Cliente;
import classes.Destino;
import classes.Reserva;
import classes.Transporte;
import Dao.HospedagemDAO;
import java.util.Scanner;
import Dao.ClienteDAO;
import Dao.DestinoDAO;
import Dao.ReservaDAO;
import Dao.TransporteDAO;



public class HPConsole {

	public static void main(String[] args) {
			
		ClienteDAO clienteDAO = new ClienteDAO();
		HospedagemDAO hospedagemDAO = new HospedagemDAO();
		ReservaDAO reservaDAO = new ReservaDAO();
		TransporteDAO transporteDAO = new TransporteDAO();
		DestinoDAO destinoDAO = new DestinoDAO();
		Scanner entrada = new Scanner(System.in);
		Cliente cliente = new Cliente();
		Destino destino = new Destino();
		Hospedagem hospedagem = new Hospedagem();
		Transporte transporte = new Transporte();
		Reserva reserva = new Reserva();
		
		int menu;
		int cli;
		int hos;
		int tran;
		int des;
		int res;
		
		
		do {
			System.out.println("========== Happy Traveller ==========");
			System.out.println("SELECIONE:");
			System.out.println("1 - Acesso a Clientes");
			System.out.println("2 - Acesso a Hospedagem");
			System.out.println("3 - Acesso a Transportes");
			System.out.println("4 - Acesso a Destinos");
			System.out.println("5 - Acesso a Reservas");
			System.out.println("0 - Sair");
			menu = entrada.nextInt();
			
			switch (menu) {
			case 1:
				do {
					System.out.println("========== Clientes ==========");
					System.out.println("1 - Adicionar ");
					System.out.println("2 - Remover ");
					System.out.println("3 - Atualizar ");
					System.out.println("4 - Mostrar ");
					System.out.println("5 - Buscar Cliente");
					System.out.println("0 - Voltar");
					cli = entrada.nextInt();
					entrada.nextLine();				
					switch (cli) {
					
					
					case 1:
						System.out.println("Digite o CPF:");
						cliente.setCpf(entrada.nextLine());
						System.out.println("Digite o Nome:");
						cliente.setNome(entrada.nextLine());
						System.out.println("Digite a Endereço:");
						cliente.setEndereco(entrada.nextLine());
						System.out.println("Digite um Telefone:");
						cliente.setTel(entrada.nextLine());
						System.out.println("Digite o E-mail:");
						cliente.setEmail(entrada.nextLine());
						
						clienteDAO.save(cliente);

						break;
					case 2:
						System.out.println("Digite o CPF que sera deletado:");
						clienteDAO.removeByCpf(entrada.next());
						break;
					case 3:
						
						System.out.println("Digite o Nome:");
						cliente.setNome(entrada.next());
						System.out.println("Digite a Endereço:");
						cliente.setEndereco(entrada.next());
						System.out.println("Digite um Telefone:");
						cliente.setTel(entrada.next());
						System.out.println("Digite o E-mail:");
						cliente.setEmail(entrada.next());
						System.out.println("Digite o CPF:");
						cliente.setCpf(entrada.next());
						
						clienteDAO.update(cliente);
						break;

					case 4:
						for (Cliente c : clienteDAO.getCliente()) {
							System.out.println("CPF: " + c.getCpf());
							System.out.println("NOME: " + c.getNome());
							System.out.println("ENDEREÇO: " + c.getEndereco());
							System.out.println("TEL: " + c.getTel());
							System.out.println("EMAIL: " + c.getEmail());
							System.out.println("----------------------------------- ");
						}
						break;
					case 5:
						System.out.println("Digite o CPF:");
						String cpf = entrada.next();
						
						Cliente c = clienteDAO.cliByCpf(cpf);
						
						System.out.println("CPF: " + c.getCpf());
						System.out.println("NOME: " + c.getNome());
						System.out.println("ENDEREÇO: " + c.getEndereco());
						System.out.println("TEL: " + c.getTel());
						System.out.println("EMAIL: " + c.getEmail());
						System.out.println("----------------------------------- ");
						break;
					case 0:
						System.out.println("Ate logo!");
						break;
					default:
						System.out.println("Opcao invalida!");
						break;
					}
				} while (cli != 0);

				break;
			case 2:
				do {
				System.out.println("========== Hospedagem ==========");
				System.out.println("1 - Adicionar ");
				System.out.println("2 - Remover ");
				System.out.println("3 - Atualizar ");
				System.out.println("4 - Mostrar ");
				System.out.println("5 - Buscar Hospedagens");
				System.out.println("0 - Sair");
				hos = entrada.nextInt();
				switch (hos) {
				case 1:

					System.out.println("Digite o Nome:");
					hospedagem.setNome(entrada.next());
					System.out.println("Digite a Endereço:");
					hospedagem.setEndereco(entrada.next());
					System.out.println("Digite um Telefone:");
					hospedagem.setTel(entrada.next());
					System.out.println("Digite o Valor da Diaria");
					hospedagem.setValor(entrada.nextDouble());
					
					hospedagemDAO.save(hospedagem);

					break;
				case 2:
					System.out.println("Digite o ID que sera deletado:");
					hospedagemDAO.removeById(entrada.nextInt());
					break;
				case 3:
					
					System.out.println("Digite o Nome:");
					hospedagem.setNome(entrada.next());
					System.out.println("Digite a Endereço:");
					hospedagem.setEndereco(entrada.next());
					System.out.println("Digite um Telefone:");
					hospedagem.setTel(entrada.next());
					System.out.println("Digite o Valor da Diaria:");
					hospedagem.setValor(entrada.nextDouble());
					System.out.println("Digite o id:");
					hospedagem.setId(entrada.nextInt());
					
					hospedagemDAO.update(hospedagem);
					break;

				case 4:
					for (Hospedagem h : hospedagemDAO.getHospedagem()) {
						System.out.println("ID: " + h.getId());
						System.out.println("NOME: " + h.getNome());
						System.out.println("ENDEREÇO: " + h.getEndereco());
						System.out.println("TEL: " + h.getTel());
						System.out.println("Diaria: " + h.getValor());
						System.out.println("----------------------------------- ");
					}
					break;
				case 5:
					System.out.println("Digite o Id:");
					int id = entrada.nextInt();
					
					Hospedagem h = hospedagemDAO.hosById(id);
					
					System.out.println("ID: " + h.getId());
					System.out.println("NOME: " + h.getNome());
					System.out.println("ENDEREÇO: " + h.getEndereco());
					System.out.println("TEL: " + h.getTel());
					System.out.println("Diaria: " + h.getValor());
					System.out.println("----------------------------------- ");
					break;
				case 0:
					System.out.println("Ate logo!");
					break;
				default:
					System.out.println("Opcao invalida!");
					break;
				}
			} while (hos != 0);

			break;
			case 3:
				do {
				System.out.println("========== Transportes ==========");
				System.out.println("1 - Adicionar ");
				System.out.println("2 - Remover ");
				System.out.println("3 - Atualizar ");
				System.out.println("4 - Mostrar ");
				System.out.println("5 - Buscar Transporte");
				System.out.println("0 - Voltar");
				tran = entrada.nextInt();
				switch (tran) {
				case 1:
					System.out.println("Digite o Nome da Companhia:");
					transporte.setNomeComp(entrada.next());
					System.out.println("Qual o Aeroporto/Rodoviaria?");
					transporte.setAerRod(entrada.next());
					System.out.println("NUM voo/embarque:");
					transporte.setNumEmb(entrada.next());
					System.out.println("Digite o Valor:");
					transporte.setValor(entrada.nextDouble());
					
					transporteDAO.save(transporte);

					break;
				case 2:
					System.out.println("Digite o ID que sera deletado:");
					transporteDAO.removeById(entrada.nextInt());
					break;
				case 3:
					
					System.out.println("Digite o Nome da companhia:");
					transporte.setNomeComp(entrada.next());
					System.out.println("Digite Aeroporto / Rodoviaria:");
					transporte.setAerRod(entrada.next());
					System.out.println("Digite o N de Embarque:");
					transporte.setNumEmb(entrada.next());
					System.out.println("Digite o Valor:");
					transporte.setValor(entrada.nextDouble());
					System.out.println("Qual ID de cadatro?");
					transporte.setId(entrada.nextInt());
					
					hospedagemDAO.update(hospedagem);
					break;

				case 4:
					for (Transporte t : transporteDAO.getTransporte()) {
						System.out.println("ID: " + t.getId());
						System.out.println("COMPANHIA: " + t.getNomeComp());
						System.out.println("Aeroporto / Rodoviaria: " + t.getAerRod());
						System.out.println("N.Embarque: " + t.getNumEmb());
						System.out.println("VALOR: " + t.getValor());
						
						System.out.println("----------------------------------- ");
					}
					break;
				case 5:
					System.out.println("Digite o ID desejado:");
					int id = entrada.nextInt();
					
					Transporte t = transporteDAO.transById(id);
					
					System.out.println("ID: " + t.getId());
					System.out.println("COMPANHIA: " + t.getNomeComp());
					System.out.println("Aeroporto / Rodoviaria: " + t.getAerRod());
					System.out.println("N.Embarque: " + t.getNumEmb());
					System.out.println("VALOR: " + t.getValor());
					
					System.out.println("----------------------------------- ");
					break;
				case 0:
					System.out.println("Ate logo!");
					break;
				default:
					System.out.println("Opcao invalida!");
					break;
				}
			} while (tran != 0);

			break;
			case 4:
				do {
					System.out.println("========== Destino ==========");
					System.out.println("1 - Adicionar ");
					System.out.println("2 - Remover ");
					System.out.println("3 - Atualizar ");
					System.out.println("4 - Mostrar ");
					System.out.println("5 - Buscar Cliente");
					System.out.println("0 - Sair");
					des = entrada.nextInt();
					switch (des) {
					case 1:
						System.out.println("Digite o Nome:");
						destino.setNome(entrada.next());
						System.out.println("Digite a Endereço:");
						destino.setLocal(entrada.next());
						System.out.println("Digite um Telefone:");
						destino.setValor(entrada.nextDouble());
						
						hospedagemDAO.save(hospedagem);

						break;
					case 2:
						System.out.println("Digite o ID que sera deletado:");
						destinoDAO.removeById(entrada.nextInt());
						break;
					case 3:
						
						System.out.println("Digite o Nome:");
						destino.setNome(entrada.next());
						System.out.println("Digite a Endereço:");
						destino.setLocal(entrada.next());
						System.out.println("Digite um Telefone:");
						destino.setValor(entrada.nextDouble());
						System.out.println("Digite o id:");
						destino.setId(entrada.nextInt());
						
						hospedagemDAO.update(hospedagem);
						break;

					case 4:
						for (Destino d : destinoDAO.getDestino()) {
							System.out.println("ID: " + d.getId());
							System.out.println("Destino: " + d.getNome());
							System.out.println("País/Estado: " + d.getLocal());
							System.out.println("Valor dos Passeios: " + d.getValor());
							
							System.out.println("----------------------------------- ");
						}
						break;
					case 5:
						System.out.println("Digite o CPF:");
						int id = entrada.nextInt();
						
						Destino d = destinoDAO.locById(id);
						
						System.out.println("ID: " + d.getId());
						System.out.println("Destino: " + d.getNome());
						System.out.println("País/Estado: " + d.getLocal());
						System.out.println("Valor dos Passeios: " + d.getValor());
						System.out.println("----------------------------------- ");
						break;
					case 0:
						System.out.println("Ate logo!");
						break;
					default:
						System.out.println("Opcao invalida!");
						break;
					}
				} while (des != 0);

				break;
			case 5:
					do {
				System.out.println("========== Reserva ==========");
				System.out.println("1 - Adicionar ");
				System.out.println("2 - Remover ");
				System.out.println("3 - Atualizar ");
				System.out.println("4 - Mostrar ");
				System.out.println("5 - Buscar Reserva");
				System.out.println("0 - Sair");
				res = entrada.nextInt();
				switch (res) {
				case 1:
					
					System.out.println("Inicio da Viagem:");
					reserva.setEntrada(entrada.nextInt());
					System.out.println("Final da Viagem:");
					reserva.setSaida(entrada.nextInt());
					reserva.setTotal(reserva.getTotal());
					System.out.println("Digite o CPF do cliente:");
					cliente.setCpf(entrada.next());
					System.out.println("Digite o codigo do hotel:");
					hospedagem.setId(entrada.nextInt());
					System.out.println("Digite o cod de destino:");
					destino.setId(entrada.nextInt());
					System.out.println("Digite o cod do transporte:");
					transporte.setId(entrada.nextInt());
					
					reservaDAO.save(reserva);

					break;
				case 2:
					System.out.println("Digite o ID que sera deletado:");
					reservaDAO.removeByCod(entrada.nextInt());
					break;
				case 3:
					
					System.out.println("Inicio da Viagem:");
					reserva.setEntrada(entrada.nextInt());
					System.out.println("Final da Viagem:");
					reserva.setSaida(entrada.nextInt());
					System.out.println("Digite o CPF do cliente:");
					cliente.setCpf(entrada.next());
					System.out.println("Digite o codigo do hotel:");
					hospedagem.setId(entrada.nextInt());
					System.out.println("Digite o cod de destino:");
					destino.setId(entrada.nextInt());
					System.out.println("Digite o cod do transporte:");
					transporte.setId(entrada.nextInt());
					System.out.println("Digite o cod da reserva a atualizar:");
					reserva.setCod(entrada.nextInt());
					reserva.setTotal(reserva.getTotal());
					
					reservaDAO.update(reserva);
					break;

//				case 4:
//					for (Reserva r: reservaDAO.getReserva()) {
//						System.out.println("CPF: " + reserva.getCliente(cliente.getCpf()));
//						System.out.println("NOME: " + h.getNome());
//						System.out.println("ENDEREÇO: " + h.getEndereco());
//						System.out.println("TEL: " + h.getTel());
//						System.out.println("EMAIL: " + h.getEmail());
//						System.out.println("----------------------------------- ");
//					}
//					break;
//				case 5:
//					System.out.println("Digite o CPF:");
//					int id = entrada.nextInt();
//					
//					Hospedagem h = hospedagemDAO.hosById(id);
//					
//					System.out.println("CPF: " + h.getCpf());
//					System.out.println("NOME: " + h.getNome());
//					System.out.println("ENDEREÇO: " + h.getEndereco());
//					System.out.println("TEL: " + h.getTel());
//					System.out.println("EMAIL: " + h.getEmail());
//					System.out.println("----------------------------------- ");
//					break;
//				case 0:
//					System.out.println("Ate logo!");
//					break;
				default:
					System.out.println("Opcao invalida!");
					break;
				}
			} while (res != 0);

			break;
			default:
				System.out.println("Opcao invalida!");
				break;
			}
		} while (menu != 0);
		}
}
