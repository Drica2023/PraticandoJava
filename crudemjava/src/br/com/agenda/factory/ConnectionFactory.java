package br.com.agenda.factory;

import java.sql.Connection;
import java.sql.DriverManager;



public class ConnectionFactory {
	// Nome do usuario do banco de dados que esta utilizando
	private static final String USERNAME = "root";
	
	// Nome da senha do bando de dados que esta utilizando
	private static final String PASSWORD = "";
	
	// caminho do banco de dados, porta e o nome do banco de dados
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/agenda";
	
	/*
	 * Conexao com o banco de dados
	 */
	
	public static Connection createConnectionToMySQL() throws Exception {
		//Faz com que a classe seja carregada pela JVM
		Class.forName("com.mysql.jdbc.Driver");
		
		// Cria a conexao com o banco de dados
		
		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		
		return connection;
				
	}
	
	public static void main (String[] args) throws Exception {
	
	// Recuperar uma conexao com o banco de dados
	Connection con = createConnectionToMySQL();
	
	// Testar se a conexao é nula
	if (con!=null) {
		System.out.println("Conexao estabelecida com sucesso");
		con.close();
		
		
		
	}
	
	
}
	
	
}
