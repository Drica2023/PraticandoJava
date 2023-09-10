package br.com.agenda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.agenda.factory.ConnectionFactory;
import br.com.agenda.model.Contato;

public class ContatoDAO {

	/*
	 * CRUD
	 * C:CREATE	ok
	 * R:READ ok
	 * U:UPDATE ok
	 * D:DELETE
	 */
	
	public void save(Contato contato) {
		
		String sql = "INSERT INTO contatos(nome, idade, datacadastro) VALUES (?, ?,?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			// criar uma conexao com o banco de dados 
			conn = ConnectionFactory.createConnectionToMySQL();
			
			//Criamos uma PreparedStatement, para executar uma query
			pstm =  (PreparedStatement) conn.prepareStatement(sql);
		
			pstm.setString(1, contato.getNome());
			pstm.setInt(2, contato.getId());
			pstm.setDate(3, (java.sql.Date) new Date(contato.getDataCadastro().getTime()));
		
			//Executar a query
			pstm.execute();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//Fechar as conexoes
			try {
				if(pstm!=null) {
					pstm.close();
				}
				if(conn!=null) {
					conn.close();
					
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
			
		}
			
	}
	
	public void update(Contato contato) {
	
		String sql = "UPDATE contatos SET nome = ?, idad e= ?, dataCadastro = ? " + "WHERE id = ? ";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			// Criar conexao com o banco 
			conn = ConnectionFactory.createConnectionToMySQL();
			
			// Criar a classe para executar a query
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			// Adicionar os valores para atualizar 
			pstm.setNString(1, contato.getNome());
			pstm.setInt(2, contato.getId());
			pstm.setDate(3, (java.sql.Date) new Date(contato.getDataCadastro().getTime()));
		
			//Qual o ID do registro deseja atualizar?
			pstm.setInt(4, contato.getId());		
		
			// executat a query
			
			pstm.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm!=null) {
					pstm.close();
				}
				if(conn!=null) {
					conn.close();
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void deleteByID(int id) {
		String sql = "DELETE FROM contatos WHERE id = ? "; 
	
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			pstm.setInt(1, id);
			
			pstm.execute();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm!=null) {
					pstm.close();

					}
				if(conn!=null) {
					conn.close();
					}
					
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	
	
	
	
	
	}
	
	public List<Contato> getContatos() {
	
		String sql = "SELECT * FROM contatos";
		
		List<Contato> contatos = new ArrayList<Contato>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		// Classe que vai recuperar os dados do Banco ***SELECT***
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			while(rset.next()) {
				Contato contato = new Contato();
				
				// recuperar o Id
				contato.setId(rset.getInt("Id"));
				// recuperar o nome
				contato.setNome(rset.getString("nome"));
				// recuperar a idade
				contato.setIdade(rset.getInt("idade"));
				//recuperar a data de cadastro
				contato.setDataCadastro(rset.getDate("dataCadastro"));
				
				contatos.add(contato);
			}
			}catch(Exception e) {
				e.printStackTrace();
				
			}finally {
				try {
				if (rset!=null) {
					rset.close();	
					}
				if(pstm!=null) {
					pstm.close();
					}
				if(conn!=null) {
					conn.close();
					}
						
				
			}catch (Exception e) {
				e.printStackTrace();
				}
	
			}
			
		return contatos;
		
	}
		
}
  

