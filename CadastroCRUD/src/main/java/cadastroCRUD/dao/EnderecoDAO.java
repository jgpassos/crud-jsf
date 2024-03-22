package cadastroCRUD.dao;

import java.util.List;

import cadastroCRUD.model.Endereco;
import cadastroCRUD.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

public class EnderecoDAO {
	
	/* Persistência de dados */
	
	public void salvar(Endereco endereco) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();

		transaction.begin();
		entityManager.persist(endereco);
		transaction.commit();
		JPAUtil.closeEntityManagerFactory(); // Encerra a conexão
	}

	public void atualizar(Endereco endereco) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();

		transaction.begin();
		entityManager.merge(endereco);
		transaction.commit();
		JPAUtil.closeEntityManagerFactory();
	}

	public void remover(Endereco endereco) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();

		transaction.begin();
		endereco = entityManager.merge(endereco);
		entityManager.remove(endereco);
		transaction.commit();
		JPAUtil.closeEntityManagerFactory();
	}

	public Endereco buscarPorId(Long id) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		try {
			return entityManager.find(Endereco.class, id);
		} finally {
			JPAUtil.closeEntityManagerFactory();
		}
	}

	public List<Endereco> listar() {
		EntityManager entityManager = JPAUtil.getEntityManager();
		TypedQuery<Endereco> query = entityManager.createQuery("SELECT e FROM Endereco e", Endereco.class);
		JPAUtil.closeEntityManagerFactory();
		return query.getResultList();
	}
}
