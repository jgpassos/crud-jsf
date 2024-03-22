package cadastroCRUD.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import cadastroCRUD.dao.PessoaDAO;
import cadastroCRUD.model.Pessoa;
import jakarta.faces.view.ViewScoped;

@Named
@ViewScoped
public class PessoaCtr implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private PessoaDAO pessoaDAO;
	private List<Pessoa> pessoas;
	private Pessoa pessoa;
	
	@PostConstruct
	public void init() {
		pessoaDAO = new PessoaDAO();
		setPessoas(pessoaDAO.listarPessoas());
		pessoa = new Pessoa();
	}
	
	public void salvar() {
		pessoaDAO.salvar(pessoa);
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}
}