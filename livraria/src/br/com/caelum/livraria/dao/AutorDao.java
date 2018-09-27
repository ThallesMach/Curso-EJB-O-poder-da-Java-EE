package br.com.caelum.livraria.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

import br.com.caelum.livraria.modelo.Autor;

@Stateless  // para tronspofrma uma Class Dao em um Class JB usa anotações @Stateless
			/*Stateless Session Bean é o primeiro tipo de Session Bean.
			 *  Os Stateless Session Bean não mantém estado de conversação com o cliente,
			 *   não têm compromisso de manter uma sessão,
			 *    são intercambiáveis e podem ser alocados de um pool e são EJBs econômicos;
			 * */
public class AutorDao {

	private Banco banco = new Banco();
	
	@PostConstruct  // tbm é conhecido Callback 
	void aposCriacao() {
		System.out.println("AutorDao foi criado");
	}

	public void salva(Autor autor) {
		System.out.println("Salvado Autor "+ autor.getNome() );
		
//		try {
//			Thread.sleep(20000); // Sleep 20s
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		} 
		
		banco.save(autor);
		
		System.out.println("Salvou Autor "+ autor.getNome() );
	}
	
	public List<Autor> todosAutores() {
		return banco.listaAutores();
	}

	public Autor buscaPelaId(Integer autorId) {
		Autor autor = this.banco.buscaPelaId(autorId);
		return autor;
	}
	
}
