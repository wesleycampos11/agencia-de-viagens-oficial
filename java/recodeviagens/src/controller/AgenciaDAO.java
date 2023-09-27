package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.crud.model.Agencia;
import factory.ConnectionFactory;

public class AgenciaDAO {


	Connection conn = null;
	PreparedStatement pstm = null;

	
	public void save(Agencia agencia) {


		String sql = "INSERT INTO AGENCIA (UNIDADE, TELEFONE, EMAIL, ENDERECO)"
		+ " VALUES(?,?,?,?)";
		
		

		try {

			conn = ConnectionFactory.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, agencia.getUnidade());
			pstm.setString(2, agencia.getTelefone());
			pstm.setString(3, agencia.getEmail());
			pstm.setString(4, agencia.getEndereco());
			
			pstm.execute();
			System.out.println("Unidade cadastrada com sucesso!");

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


	public void removeByCnpj(String cnpj) {

		String sql = "DELETE FROM agencia WHERE CNPJ = ?";

		try {
			conn = ConnectionFactory.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, cnpj);

			pstm.execute();
			System.out.println("Unidade excluída com sucesso!");

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


	public void update(Agencia agencia) {
		
		String sql = "UPDATE AGENCIA SET TELEFONE = ?, EMAIL = ?, ENDERECO = ?"
		+ " WHERE CNPJ = ?";

		try {
			
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, agencia.getUnidade());
			pstm.setString(2, agencia.getTelefone());
			pstm.setString(3, agencia.getEmail());
			pstm.setString(4, agencia.getEndereco());

			// CAMPO QUE SERÁ UTILIZADO PARA BUSCAR O CADASTRO
			pstm.setString(5, agencia.getCnpj());
			
			pstm.execute();
			System.out.println("Unidade atualizada com sucesso!");

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
	

	public List<Agencia> getAgencias() {

		String sql = "SELECT * FROM agencia";

		List<Agencia> agencias = new ArrayList<Agencia>();

		ResultSet rset = null;

		try {
			conn = ConnectionFactory.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			
			while (rset.next()) {

				Agencia agencia = new Agencia();

				agencia.setCnpj(rset.getString("CNPJ"));
				agencia.setUnidade(rset.getString("UNIDADE"));
				agencia.setTelefone(rset.getString("TELEFONE"));
				agencia.setEmail(rset.getString("EMAIL"));
				agencia.setEndereco(rset.getString("ENDERECO"));


				agencias.add(agencia);
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

		return agencias;
	}

	
	public Agencia getUnidadesByCod(String Cnpj) {

		String sql = "SELECT * FROM Agencia where CNPJ = ?";
		Agencia agencia = new Agencia();

		ResultSet rset = null;

		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, Cnpj);
			rset = pstm.executeQuery();

			rset.next();

			agencia.setUnidade(rset.getString("UNIDADE"));
			agencia.setTelefone(rset.getString("TELEFONE"));
			agencia.setEmail(rset.getString("EMAIL"));
			agencia.setEndereco(rset.getString("ENDERECO"));
			

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
		return agencia;
  
    }
}
