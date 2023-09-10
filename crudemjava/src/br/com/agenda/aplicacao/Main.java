package br.com.agenda.aplicacao;

import java.util.Date;
import br.com.agenda.dao.ContatoDAO;
import br.com.agenda.model.Contato;

public class Main {

	

	public static void main(String[] args){
		
		ContatoDAO contatoDao = new ContatoDAO();
		
		
		
		Contato contato = new Contato();
		contato.setNome("Maria Adriana");
		contato.setIdade(45);
		contato.setDataCadastro(new Date());
		
		// contatoDao.save(contato); Foi comentado para testar o Update
		
		
		// atualizar contato
		Contato c1 = new Contato();
		c1.setNome("Adriana Maria");
		c1.setId(46);
		c1.setDataCadastro(new Date());
		c1.setId(1); // o numero que esta no banco de dados da PK
		
		//contatoDao.update(c1); Foi comentado para poder testar o Delete
		
		
		// Delete contato
		
		contatoDao.deleteByID(1);
		
		
		
		
		
		//  visualizacao dos registro dos banco de dados ***TODOS***
		for(Contato c: contatoDao.getContatos()){
			System.out.printf("Contato: " + c.getNome(), c.getIdade());
			
		}
		
	}		
		
}

