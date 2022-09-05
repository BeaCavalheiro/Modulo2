package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import classes.Destino;
import Dao.Conexao;

public class DestinoDAO {

	Connection conn = null;
	PreparedStatement pstm = null;

	public void save(Destino d) {

		String sql = "INSERT INTO destino(nome_local,localizacao,valor_passeios)" + " VALUE(?,?,?)";

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, d.getNome());
			pstm.setString(2, d.getLocal());
			pstm.setDouble(3, d.getValor());

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

		String sql = "DELETE FROM destino WHERE id_local=?";

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
	public void update(Destino d) {

		String sql = "UPDATE destino SET nome_local = ?,localizacao=?, valor_passeios=?"
				+ "WHERE id_local=?";

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, d.getNome());
			pstm.setString(2, d.getLocal());
			pstm.setDouble(3, d.getValor());
			pstm.setInt(4, d.getId());

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

	public List<Destino> getDestino() {

		String sql = "SELECT * FROM destino";

		List<Destino> loc = new ArrayList<Destino>();
		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();

			while (rset.next()) {
				Destino d = new Destino();

				d.setId(rset.getInt("id_local"));
				d.setNome(rset.getString("nome_local"));
				d.setLocal(rset.getString("localização"));
				d.setValor(rset.getDouble("valor_hos"));

				loc.add(d);
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
		return loc;
	}

	public Destino locById(int id) {
		String sql = "SELECT * FROM destino WHERE id_local=?";

		ResultSet rset = null;
		Destino d = new Destino();

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1,id);
			rset = pstm.executeQuery();
			rset.next();

			d.setId(rset.getInt("id_local"));
			d.setNome(rset.getString("nome_local"));
			d.setLocal(rset.getString("localizacao"));
			d.setValor(rset.getDouble("valor_passeios"));
			
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
		return d;
	}
}