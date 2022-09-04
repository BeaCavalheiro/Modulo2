package Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import classes.Cliente;

public class ClienteDAO {

	Connection conn = null;
	PreparedStatement pstm = null;

	public void save(Cliente cliente) {

		String sql = "INSERT INTO cliente (CPF_cli,nome_cli,endereco_cli,telefone_cli,email_cli)" + " VALUE(?,?,?,?,?)";

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, cliente.getCpf());
			pstm.setString(2, cliente.getNome());
			pstm.setString(3, cliente.getEndereco());
			pstm.setString(4, cliente.getTel());
			pstm.setString(5, cliente.getEmail());

			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void removeByCpf(String cpf) {

		String sql = "DELETE FROM cliente WHERE CPF_cli=?";

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, cpf);
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void update(Cliente cliente) {

		String sql = "UPDATE cliente SET CPF_cli=?,nome_cli = ?,endereco_cli=?, telefone_cli = ?, email_cli =?"
				+ "WHERE cpf_cli=?";

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, cliente.getCpf());
			pstm.setString(2, cliente.getNome());
			pstm.setString(3, cliente.getEndereco());
			pstm.setString(4, cliente.getTel());
			pstm.setString(5, cliente.getEmail());

			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public List<Cliente> getCliente() {

		String sql = "SELECT * FROM cliente";

		List<Cliente> cli = new ArrayList<Cliente>();
		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();

			while (rset.next()) {
				Cliente c = new Cliente();

				c.setCpf(rset.getString("CPF_cli"));
				c.setNome(rset.getString("nome_cli"));
				c.setEndereco(rset.getString("endereco_cli"));
				c.setTel(rset.getString("telefone_cli"));
				c.setEmail(rset.getString("email_cli"));

				cli.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rset != null) {
					rset.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return cli;
	}

	public Cliente cliByCpf(String cpf) {
		String sql = "SELECT * FROM cliente WHERE CPF_cli=?";

		ResultSet rset = null;
		Cliente cliente = new Cliente();

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1,cpf);
			rset = pstm.executeQuery();
			rset.next();

			cliente.setCpf(rset.getString("CPF_cli"));
			cliente.setNome(rset.getString("nome_cli"));
			cliente.setEndereco(rset.getString("endereco_cli"));
			cliente.setTel(rset.getString("telefone_cli"));
			cliente.setEmail(rset.getString("email_cli"));
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return cliente;
	}
}