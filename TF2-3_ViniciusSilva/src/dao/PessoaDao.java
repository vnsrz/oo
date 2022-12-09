package dao;

import java.sql.*;

import java.util.ArrayList;

import conector.Conexao;

import dados.*;

public class PessoaDao {
	private Connection con = Conexao.getConnection();

	public void cadastrar(Pessoa pessoa) {

		String sql = "INSERT INTO pandemia.pessoa(idPessoa,nome,saude,gestante,idade)VALUES(?,?,?,?,?)";
		
		if(pessoa.getSexo().equals("masculino")) {
			try {
				PreparedStatement preparador = con.prepareStatement(sql);
				preparador.setInt(1, pessoa.getNumero());
				preparador.setString(2, pessoa.getNome());
				preparador.setString(3, Character.toString(pessoa.getSituacaoSaude()));
				preparador.setString(4, null);
				preparador.setInt(5, pessoa.getIdade());
				preparador.execute(); 
				preparador.close();
		
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (con != null)
					try {
						con.close();
					} catch (SQLException e) {
						System.out.print("Falha ao fechar a conexão.");
						System.out.println("Causa:" + e.getMessage());
					}
			}
		}else {
			try {
				PreparedStatement preparador = con.prepareStatement(sql);
				preparador.setInt(1, pessoa.getNumero());
				preparador.setString(2, pessoa.getNome().toString());
				preparador.setString(3, Character.toString(pessoa.getSituacaoSaude()));
				preparador.setString(4, Character.toString(pessoa.getGestacao()));
				preparador.setString(5, null);
				preparador.execute(); 
				preparador.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (con != null)
					try {
						con.close();
					} catch (SQLException e) {
						System.out.print("Falha ao fechar a conexão.");
						System.out.println("Causa:" + e.getMessage());
					}
			}
		}
		
	}

	public ArrayList<Pessoa> carregar(){
		
		String sql = "SELECT * FROM PESSOA";
		ArrayList<Pessoa> listaPessoas = new ArrayList<>();
		
		try {
			
			PreparedStatement preparador = con.prepareStatement(sql);
		    
			ResultSet rst;
		    rst = preparador.executeQuery();

		    while (rst.next()) {
		        if(rst.getString("gestante") == null) {
		        	Homem homem = new Homem(rst.getString("nome"), rst.getInt("idPessoa"), rst.getString("saude").charAt(0), rst.getInt("idade"));
		        	listaPessoas.add(homem);
		        }else {
		        	Mulher mulher = new Mulher(rst.getString("nome"), rst.getInt("idPessoa"), rst.getString("saude").charAt(0), rst.getString("gestante").charAt(0));
		        	listaPessoas.add(mulher);
		        }    	
		    }
			
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					System.out.print("Falha ao fechar a conexão.");
					System.out.println("Causa:" + e.getMessage());
				}

		}

	    return listaPessoas;
	}
}
