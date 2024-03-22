package cadastroCRUD.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import cadastroCRUD.dao.PessoaDAO;
import cadastroCRUD.model.Pessoa;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;

@Named
@ViewScoped
public class PessoaBean implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Inject
    private PessoaDAO pessoaDAO;

    private List<Pessoa> pessoas;
    private Pessoa pessoa;

    @PostConstruct
    public void init() {
        pessoas = pessoaDAO.listarPessoas();
        pessoa = new Pessoa();
    }

    public void salvar() {
        pessoaDAO.salvar(pessoa);
        pessoas = pessoaDAO.listarPessoas(); 
        pessoa = new Pessoa(); // Limpa para um novo cadastro
        
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Cadastro realizado com sucesso.");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void excluir(Pessoa pessoa) {
        pessoaDAO.remover(pessoa);
        pessoas = pessoaDAO.listarPessoas(); 
        
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Cadastro excluído com sucesso.");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}
