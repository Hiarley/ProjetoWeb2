package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dominio.Endereco;

@Stateless
public class EnderecoDAO {

		@PersistenceContext
		private EntityManager em;
		
		public void salvar(Endereco endereco) {
			em.persist(endereco);
			}
		
		public void atualizar(Endereco endereco){
			em.merge(endereco);
		}
		
		public void remover(Endereco endereco){
			endereco = em.find(Endereco.class, endereco.getId());
		}
		
		@SuppressWarnings("unchecked")
		public List<Endereco> listar() {
			String qs = "select p from Endereco e";
			Query q = em.createQuery(qs);
			return (List<Endereco>) q.getResultList();
		}
	
}
