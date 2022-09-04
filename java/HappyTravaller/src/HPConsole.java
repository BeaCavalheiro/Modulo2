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
import Dao.Conexao;


public class HPConsole {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ClienteDAO clienteDAO = new ClienteDAO();
		HospedagemDAO hospedagemDAO = new HospedagemDAO();
		ReservaDAO reservaDAO = new ReservaDAO();
		TransporteDAO passagemDAO = new TransporteDAO();
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
					System.out.println("0 - Sair");
					cli = entrada.nextInt();
					switch (cli) {
					case 1:
						System.out.println("Digite o CPF:");
						cliente.setCpf(entrada.next());
						System.out.println("Digite o Nome:");
						cliente.setNome(entrada.next());
						System.out.println("Digite a Endereço:");
						cliente.setEndereco(entrada.next());
						System.out.println("Digite um Telefone:");
						cliente.setTel(entrada.next());
						System.out.println("Digite o E-mail:");
						cliente.setEmail(entrada.next());
						
						clienteDAO.save(cliente);

						break;
					case 2:
						System.out.println("Digite o CPF que sera deletado:");
						clienteDAO.removeByCpf(entrada.next());
						break;
					case 3:
						System.out.println("Digite o CPF:");
						cliente.setCpf(entrada.next());
						System.out.println("Digite o Nome:");
						cliente.setNome(entrada.next());
						System.out.println("Digite a Endereço:");
						cliente.setEndereco(entrada.next());
						System.out.println("Digite um Telefone:");
						cliente.setTel(entrada.next());
						System.out.println("Digite o E-mail:");
						cliente.setEmail(entrada.next());

						clienteDAO.update(cliente);
						break;

					case 4:
						for (Cliente c : clienteDAO.getCliente()) {
							System.out.println("CPF: " + c.getCpf());
							System.out.println("NOME: " + c.getNome());
							System.out.println("ENDEREÇO: " + c.getDataCadastro());
							System.out.println("TEL: " + c.getNome());
							System.out.println("EMAIL: " + c.getIdade());
							System.out.println("----------------------------------- ");
						}
						break;
					case 5:
						System.out.println("Digite o ID:");
						int id = entrada.nextInt();
						
						Contato c = contatoDAO.contatoById(id);
						
						System.out.println("NOME: " + c.getNome());
						System.out.println("IDADE: " + c.getIdade());
						System.out.println("DATA CADASTRO: " + c.getDataCadastro());
						System.out.println("----------------------------------- ");
						break;
					case 0:
						System.out.println("Ate logo!");
						break;
					default:
						System.out.println("Opcao invalida!");
						break;
					}
				} while (agenda != 0);

				break;
			case 2:
				do {
					System.out.println("========== Clientes ==========");
					System.out.println("1 - Adicionar ");
					System.out.println("2 - Remover ");
					System.out.println("3 - Atualizar ");
					System.out.println("4 - Mostrar ");
					System.out.println("5 - Buscar Cliente");
					System.out.println("0 - Sair");
					agenda = entrada.nextInt();
					switch (cli) {
					case 1:
						System.out.println("Digite o nome:");
						contato.setNome(entrada.next());
						System.out.println("Digite a idade:");
						contato.setIdade(entrada.nextInt());
						contato.setDataCadastro(new Date());

						contatoDAO.save(contato);

						break;
					case 2:
						System.out.println("Digite o ID que sera deletado:");
						contatoDAO.removeById(entrada.nextInt());
						break;
					case 3:
						System.out.println("Digite o ID do contato:");
						contato.setId(entrada.nextInt());
						System.out.println("Digite o nome:");
						contato.setNome(entrada.next());
						System.out.println("Digite a idade:");
						contato.setIdade(entrada.nextInt());
						contato.setDataCadastro(new Date());

						contatoDAO.update(contato);
						break;

					case 4:
						for (Contato c : contatoDAO.getContatos()) {
							System.out.println("NOME: " + c.getNome());
							System.out.println("IDADE: " + c.getIdade());
							System.out.println("DATA CADASTRO: " + c.getDataCadastro());
							System.out.println("----------------------------------- ");
						}
						break;
					case 5:
						System.out.println("Digite o ID:");
						int id = entrada.nextInt();
						
						Contato c = contatoDAO.contatoById(id);
						
						System.out.println("NOME: " + c.getNome());
						System.out.println("IDADE: " + c.getIdade());
						System.out.println("DATA CADASTRO: " + c.getDataCadastro());
						System.out.println("----------------------------------- ");
						break;
					case 0:
						System.out.println("Ate logo!");
						break;
					default:
						System.out.println("Opcao invalida!");
						break;
					}
				} while (agenda != 0);

				break;
			case 3:
				do {
					System.out.println("========== Clientes ==========");
					System.out.println("1 - Adicionar ");
					System.out.println("2 - Remover ");
					System.out.println("3 - Atualizar ");
					System.out.println("4 - Mostrar ");
					System.out.println("5 - Buscar Cliente");
					System.out.println("0 - Sair");
					agenda = entrada.nextInt();
					switch (cli) {
					case 1:
						System.out.println("Digite o nome:");
						contato.setNome(entrada.next());
						System.out.println("Digite a idade:");
						contato.setIdade(entrada.nextInt());
						contato.setDataCadastro(new Date());

						contatoDAO.save(contato);

						break;
					case 2:
						System.out.println("Digite o ID que sera deletado:");
						contatoDAO.removeById(entrada.nextInt());
						break;
					case 3:
						System.out.println("Digite o ID do contato:");
						contato.setId(entrada.nextInt());
						System.out.println("Digite o nome:");
						contato.setNome(entrada.next());
						System.out.println("Digite a idade:");
						contato.setIdade(entrada.nextInt());
						contato.setDataCadastro(new Date());

						contatoDAO.update(contato);
						break;

					case 4:
						for (Contato c : contatoDAO.getContatos()) {
							System.out.println("NOME: " + c.getNome());
							System.out.println("IDADE: " + c.getIdade());
							System.out.println("DATA CADASTRO: " + c.getDataCadastro());
							System.out.println("----------------------------------- ");
						}
						break;
					case 5:
						System.out.println("Digite o ID:");
						int id = entrada.nextInt();
						
						Contato c = contatoDAO.contatoById(id);
						
						System.out.println("NOME: " + c.getNome());
						System.out.println("IDADE: " + c.getIdade());
						System.out.println("DATA CADASTRO: " + c.getDataCadastro());
						System.out.println("----------------------------------- ");
						break;
					case 0:
						System.out.println("Ate logo!");
						break;
					default:
						System.out.println("Opcao invalida!");
						break;
					}
				} while (agenda != 0);

				break;
			case 4:
				do {
					System.out.println("========== Clientes ==========");
					System.out.println("1 - Adicionar ");
					System.out.println("2 - Remover ");
					System.out.println("3 - Atualizar ");
					System.out.println("4 - Mostrar ");
					System.out.println("5 - Buscar Cliente");
					System.out.println("0 - Sair");
					agenda = entrada.nextInt();
					switch (cli) {
					case 1:
						System.out.println("Digite o nome:");
						contato.setNome(entrada.next());
						System.out.println("Digite a idade:");
						contato.setIdade(entrada.nextInt());
						contato.setDataCadastro(new Date());

						contatoDAO.save(contato);

						break;
					case 2:
						System.out.println("Digite o ID que sera deletado:");
						contatoDAO.removeById(entrada.nextInt());
						break;
					case 3:
						System.out.println("Digite o ID do contato:");
						contato.setId(entrada.nextInt());
						System.out.println("Digite o nome:");
						contato.setNome(entrada.next());
						System.out.println("Digite a idade:");
						contato.setIdade(entrada.nextInt());
						contato.setDataCadastro(new Date());

						contatoDAO.update(contato);
						break;

					case 4:
						for (Contato c : contatoDAO.getContatos()) {
							System.out.println("NOME: " + c.getNome());
							System.out.println("IDADE: " + c.getIdade());
							System.out.println("DATA CADASTRO: " + c.getDataCadastro());
							System.out.println("----------------------------------- ");
						}
						break;
					case 5:
						System.out.println("Digite o ID:");
						int id = entrada.nextInt();
						
						Contato c = contatoDAO.contatoById(id);
						
						System.out.println("NOME: " + c.getNome());
						System.out.println("IDADE: " + c.getIdade());
						System.out.println("DATA CADASTRO: " + c.getDataCadastro());
						System.out.println("----------------------------------- ");
						break;
					case 0:
						System.out.println("Ate logo!");
						break;
					default:
						System.out.println("Opcao invalida!");
						break;
					}
				} while (agenda != 0);

				break;
			case 5:
				do {
					System.out.println("========== Clientes ==========");
					System.out.println("1 - Adicionar ");
					System.out.println("2 - Remover ");
					System.out.println("3 - Atualizar ");
					System.out.println("4 - Mostrar ");
					System.out.println("5 - Buscar Cliente");
					System.out.println("0 - Sair");
					agenda = entrada.nextInt();
					switch (cli) {
					case 1:
						System.out.println("Digite o nome:");
						contato.setNome(entrada.next());
						System.out.println("Digite a idade:");
						contato.setIdade(entrada.nextInt());
						contato.setDataCadastro(new Date());

						contatoDAO.save(contato);

						break;
					case 2:
						System.out.println("Digite o ID que sera deletado:");
						contatoDAO.removeById(entrada.nextInt());
						break;
					case 3:
						System.out.println("Digite o ID do contato:");
						contato.setId(entrada.nextInt());
						System.out.println("Digite o nome:");
						contato.setNome(entrada.next());
						System.out.println("Digite a idade:");
						contato.setIdade(entrada.nextInt());
						contato.setDataCadastro(new Date());

						contatoDAO.update(contato);
						break;

					case 4:
						for (Contato c : contatoDAO.getContatos()) {
							System.out.println("NOME: " + c.getNome());
							System.out.println("IDADE: " + c.getIdade());
							System.out.println("DATA CADASTRO: " + c.getDataCadastro());
							System.out.println("----------------------------------- ");
						}
						break;
					case 5:
						System.out.println("Digite o ID:");
						int id = entrada.nextInt();
						
						Contato c = contatoDAO.contatoById(id);
						
						System.out.println("NOME: " + c.getNome());
						System.out.println("IDADE: " + c.getIdade());
						System.out.println("DATA CADASTRO: " + c.getDataCadastro());
						System.out.println("----------------------------------- ");
						break;
					case 0:
						System.out.println("Ate logo!");
						break;
					default:
						System.out.println("Opcao invalida!");
						break;
					}
				} while (agenda != 0);

				break;
			default:
				System.out.println("Opcao invalida!");
				break;
			}
		} while (agenda != 0);
		
		
		
		
	}

}
