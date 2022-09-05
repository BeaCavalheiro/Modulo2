package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import classes.Transporte;
import Dao.Conexao;

public class TransporteDAO {

	Connection conn = null;
	PreparedStatement pstm = null;

	public void save(Transporte t) {

		String sql = "INSERT INTO transporte (nome_comp,aeroporto_rodoviaria,num_embarque,valor)" + " VALUE(?,?,?,?)";

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, t.getNomeComp());
			pstm.setString(2, t.getAerRod());
			pstm.setString(3, t.getNumEmb());
			pstm.setDouble(4, t.getValor());

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

	public void removeById(int id) {

		String sql = "DELETE FROM transporte WHERE id=?";

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

	public void update(Transporte t) {

		String sql = "UPDATE transporte SET nome_comp = ?,aeroporto_rodoviaria = ?, localizacao = ?, valor =?"
				+ "WHERE id_hos=?";

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, t.getNomeComp());
			pstm.setString(2, t.getAerRod());
			pstm.setString(3, t.getNumEmb());
			pstm.setDouble(4, t.getValor());
			pstm.setInt(5, t.getId());

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

	public List<Transporte> getTransporte() {

		String sql = "SELECT * FROM transporte";

		List<Transporte> trans= new ArrayList<Transporte>();
		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();

			while (rset.next()) {
				Transporte t = new Transporte();

				t.setId(rset.getInt("id"));
				t.setNomeComp(rset.getString("nome_comp"));
				t.setAerRod(rset.getString("aeroporto_rodoviaria"));
				t.setNumEmb(rset.getString("num_embarque"));
				t.setValor(rset.getDouble("valor"));

				trans.add(t);
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
		return trans;
	}

	public Transporte transById(int id) {
		String sql = "SELECT * FROM transporte WHERE id=?";

		ResultSet rset = null;
		Transporte t = new Transporte();

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1,id);
			rset = pstm.executeQuery();
			rset.next();

			t.setId(rset.getInt("id"));
			t.setNomeComp(rset.getString("nome_comp"));
			t.setAerRod(rset.getString("aeroporto_rodoviaria"));
			t.setNumEmb(rset.getString("num_embarque"));
			t.setValor(rset.getDouble("valor"));
			
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
		return t;
	}
}