package cadastroCRUD.dao;
import java.util.ArrayList;
import java.util.List;

import cadastroCRUD.model.Pessoa;
import cadastroCRUD.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

public class PessoaDAO {
	
	/* Persistência de dados */
	
	public void salvar(Pessoa pessoa) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		
		transaction.begin();
		entityManager.persist(pessoa);
		transaction.commit();
		JPAUtil.closeEntityManagerFactory(); // Encerra a conexão
	}
	
	public void editar(Pessoa pessoa) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		
		transaction.begin();
		entityManager.merge(pessoa);
		transaction.commit();
		JPAUtil.closeEntityManagerFactory();
	}
	
	public Pessoa buscar(int id) {
		EntityManager entityManager = JPAUtil.getEntityManager();

		Pessoa pessoa = new Pessoa();
		pessoa = entityManager.find(Pessoa.class, id);
		JPAUtil.closeEntityManagerFactory();
		return pessoa;
	}

	@SuppressWarnings("unchecked")
	public List<Pessoa> listarPessoas() {
		EntityManager entityManager = JPAUtil.getEntityManager();

		List<Pessoa> listaPessoas = new ArrayList<>();
		Query query = entityManager.createQuery("SELECT FROM PESSOA pessoa");
		listaPessoas = query.getResultList();
		JPAUtil.closeEntityManagerFactory();
		return listaPessoas;
	}
	
	public void remover(Pessoa pessoa) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		
		transaction.begin();
		pessoa = entityManager.find(Pessoa.class, pessoa.getId());
		entityManager.remove(pessoa);
		transaction.commit();
		JPAUtil.closeEntityManagerFactory();
	}
}