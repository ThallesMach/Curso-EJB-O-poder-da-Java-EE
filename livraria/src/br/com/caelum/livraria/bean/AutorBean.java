package br.com.caelum.livraria.bean;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.caelum.livraria.dao.AutorDao;
import br.com.caelum.livraria.modelo.Autor;

@Model
@RequestScoped
public class AutorBean {
	
	private Autor autor = new Autor();
	
	@Inject  // é conhecida como " Ijeção de independências ".
	private AutorDao dao;  // = new AutorDao(); 
	
	public Autor getAutor() {
		return autor;
	}
	
	public void cadastra() {
		this.dao.salva(autor);
		this.autor = new Autor();
	}
	
	public List<Autor> getAutores() {
		return this.dao.todosAutores();
	}
}
