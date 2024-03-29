package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import classes.Hospedagem;

public class HospedagemDAO {

	Connection conn = null;
	PreparedStatement pstm = null;

	public void save(Hospedagem h) {

		String sql = "INSERT INTO hospedagem(nome_hos,endereco_hos,telefone_hos,valor_hos)" + " VALUE(?,?,?,?)";

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, h.getNome());
			pstm.setString(2, h.getEndereco());
			pstm.setString(3, h.getTel());
			pstm.setDouble(4, h.getValor());

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

	public void removeById(Integer id) {

		String sql = "DELETE FROM hospedagem WHERE id_hos=?";

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);
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

	public void update(Hospedagem h) {

		String sql = "UPDATE hospedagem SET "
				+ "nome_hos = ?,endereco_hos=?, telefone_hos = ?, valor_hos =?"
				+ "WHERE id_hos=?";

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, h.getNome());
			pstm.setString(2, h.getEndereco());
			pstm.setString(3, h.getTel());
			pstm.setDouble(4, h.getValor());
			pstm.setInt(5, h.getId());

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

	public List<Hospedagem> getHospedagem() {

		String sql = "SELECT * FROM hospedagem";

		List<Hospedagem> hos = new ArrayList<Hospedagem>();
		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();

			while (rset.next()) {
				Hospedagem h = new Hospedagem();

				h.setId(rset.getInt("id_hos"));
				h.setNome(rset.getString("nome_hos"));
				h.setEndereco(rset.getString("endereco_hos"));
				h.setTel(rset.getString("telefone_hos"));
				h.setValor(rset.getDouble("valor_hos"));

				hos.add(h);
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
		return hos;
	}

	public Hospedagem hosById(Integer id) {
		String sql = "SELECT * FROM hospedagem WHERE id_hos=?";

		ResultSet rset = null;
		Hospedagem h = new Hospedagem();

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1,id);
			rset = pstm.executeQuery();
			rset.next();

			h.setId(rset.getInt("id_hos"));
			h.setNome(rset.getString("nome_hos"));
			h.setEndereco(rset.getString("endereco_hos"));
			h.setTel(rset.getString("telefone_hos"));
			h.setValor(rset.getDouble("valor_hos"));
			
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
		return h;
	}
}