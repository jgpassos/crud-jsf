package cadastroCRUD.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import cadastroCRUD.dao.EnderecoDAO;
import cadastroCRUD.model.Endereco;
import jakarta.faces.view.ViewScoped;

public class EnderecoCtr {
	
	@Named
	@ViewScoped
	public class EnderecoController implements Serializable {

	    private static final long serialVersionUID = 1L;

		@Inject
	    private EnderecoDAO enderecoDAO;

	    private List<Endereco> enderecos;
	    private Endereco endereco;

	    @PostConstruct
	    public void init() {
	        enderecos = enderecoDAO.listar();
	        endereco = new Endereco();
	    }

	    public void salvar() {
	        enderecoDAO.salvar(endereco);
	        enderecos = enderecoDAO.listar();
	        endereco = new Endereco(); 
	    }

	    public void excluir(Endereco endereco) {
	        enderecoDAO.remover(endereco);
	        enderecos = enderecoDAO.listar();
	    }

	    public List<Endereco> getEnderecos() {
	        return enderecos;
	    }

	    public Endereco getEndereco() {
	        return endereco;
	    }

	    public void setEndereco(Endereco endereco) {
	        this.endereco = endereco;
	    }
	}
}
