package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import classes.Reserva;
import classes.Cliente;
import classes.Destino;
import classes.Hospedagem;
import classes.Transporte;
import Dao.Conexao;

public class ReservaDAO {

	Connection conn = null;
	PreparedStatement pstm = null;

	public void save(Reserva r) {

		String sql = "INSERT INTO reserva (cod_res,inicio_res,final_res,preco_res,CPF_cli,id_hos,id_local,id)" + " VALUE(?,?,?,?,?,?,?,?)";

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, r.getCod());
			pstm.setInt(2, r.getEntrada());
			pstm.setInt(3, r.getSaida());
			pstm.setDouble(4, r.getTotal());
			pstm.setString(5, r.getCliente().getCpf());
			pstm.setInt(6, r.getHospedagem().getId());
			pstm.setInt(7, r.getDestino().getId());
			pstm.setInt(8, r.getTransporte().getId());
			
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

	public void removeByCod(int cod) {

		String sql = "DELETE FROM reserva WHERE cod_res=?";

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, cod);
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

	public void update(Reserva r) {

		String sql = "UPDATE reserva SET inicio_res =? ,final_res=?,preco_res=?,CPF_cli=?,id_hos=?,id_local=?,id=?"
				+ "WHERE cod_res=?";

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setInt(2, r.getEntrada());
			pstm.setInt(3, r.getSaida());
			pstm.setDouble(4, r.getTotal());
			pstm.setString(5, r.getCliente().getCpf());
			pstm.setInt(6, r.getHospedagem().getId());
			pstm.setInt(7, r.getDestino().getId());
			pstm.setInt(8, r.getTransporte().getId());

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

	public List<Reserva> getReserva() {

		String sql = "SELECT * FROM reserva";

		List<Reserva> res= new ArrayList<Reserva>();
		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();

			while (rset.next()) {
				Reserva r = new Reserva();
				Cliente c = new Cliente();
				Hospedagem h = new Hospedagem();
				Destino l = new Destino();
				Transporte t = new Transporte();

				r.setCod(rset.getInt("cod_res"));
				r.setEntrada(rset.getInt("inicio_res"));
				r.setSaida(rset.getInt("final_res"));
				r.setTotal(rset.getDouble("preco_res"));
				c.setCpf(rset.getString("CPF_cli"));
				h.setId(rset.getInt("id_hos"));
				l.setId(rset.getInt("id_local"));
				t.setId(rset.getInt("id"));
			r.setCliente(c);
			r.setDestino(l);
			r.setHospedagem(h);
			r.setTransporte(t);
			
				res.add(r);
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
		return res;
	}

	public Reserva resById(int cod) {
		String sql = "SELECT * FROM reserva WHERE cod_res=?";

		ResultSet rset = null;
		Reserva r = new Reserva();
		Cliente c = new Cliente();
		Hospedagem h = new Hospedagem();
		Destino l = new Destino();
		Transporte t = new Transporte();

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1,cod);
			rset = pstm.executeQuery();
			rset.next();

			r.setCod(rset.getInt("cod_res"));
			r.setEntrada(rset.getInt("inicio_res"));
			r.setSaida(rset.getInt("final_res"));
			r.setTotal(rset.getDouble("preco_res"));
			c.setCpf(rset.getString("CPF_cli"));
			h.setId(rset.getInt("id_hos"));
			l.setId(rset.getInt("id_local"));
			t.setId(rset.getInt("id"));
		r.setCliente(c);
		r.setDestino(l);
		r.setHospedagem(h);
		r.setTransporte(t);
			
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
		return r;
	}
}