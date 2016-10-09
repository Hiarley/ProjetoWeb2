package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dominio.Historico;

public class HistoricoDAO {
	
	
	@PersistenceContext
	private EntityManager em;
	
	public void salvar(Historico historico) {
		em.persist(historico);
		}
	
	public void atualizar(Historico historico){
		em.merge(historico);
	}
	
	public void remover(Historico historico){
		historico = em.find(Historico.class, historico.getId());
	}
	
	@SuppressWarnings("unchecked")
	public List<Historico> listar() {
		String qs = "select h from Historico h";
		Query q = em.createQuery(qs);
		return (List<Historico>) q.getResultList();
	}
}
