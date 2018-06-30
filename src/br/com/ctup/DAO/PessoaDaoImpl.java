package br.com.ctup.DAO;//classe para o banco de dados

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.ctup.model.Pessoa;

public class PessoaDaoImpl extends DAO implements PessoaDao {
	Pessoa pessoa = new  Pessoa();
	
	public Pessoa autenticar(String login, String senha) {
		try {
			EntityManager em = getEntityManager();
			Query query = em.createQuery("from Pessoa where nome=:login and senha=:senha");
			query.setParameter("login", login);
			query.setParameter("senha", senha);
			return (Pessoa) query.getSingleResult();
			
		} catch (Exception e) {
			Pessoa p = null;
			return p;
		}
		
		
		
	}

	@Override
	public void salvar(Pessoa p) {
		EntityManager em = getEntityManager();
		Pessoa pessoa = p;
		
		try{
			if(pessoa.getId()== null){
				//inicia o processo de transacao
				em.getTransaction().begin();
				//faz a persistencia
				 em.persist(pessoa);
				//manda bala para o BD
				em.getTransaction().commit();

			}else{
				em.getTransaction().begin();
				em.merge(p);
				em.getTransaction().commit();
			}
			
						
		}catch (Exception e) {
			//se der algo de errado vem parar aqui, onde eh cancelado
			em.getTransaction().rollback();
		}

	}

	@Override
	public void excluir(Integer id) {
EntityManager em = getEntityManager();
		
		try{
		
			//inicia o processo de transacao
			em.getTransaction().begin();
			//faz a persistencia
			Pessoa pessoa = em.find(Pessoa.class, id);
			em.remove(pessoa);
			
			//manda bala para o BD
			em.getTransaction().commit();
		}catch (Exception e) {
			//se der algo de errado vem parar aqui, onde eh cancelado
			em.getTransaction().rollback();
		}

	}
	
	
  
	//localiza uma pessoa passando um id
	@Override
	public Pessoa selecionarPorId(Integer id) {
		 EntityManager em = getEntityManager();
		
		    if (id != null) {
		      pessoa = getEntityManager().find(Pessoa.class, id);
		    }

		    
		    return pessoa;
	}

	//retorna uma coleção de pessoas
	@Override
	public List<Pessoa> listarTodos() {
		EntityManager em = getEntityManager();
		try{
			Query q = em.createQuery("select object(p) from Pessoa as p");
 
		return q.getResultList();
		}
		finally{
			em.close();
		}
		
	}
	
	

}
