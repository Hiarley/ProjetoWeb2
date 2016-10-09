package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dominio.Pedido;

@Stateless
public class PedidoDAO {
	@PersistenceContext
	private EntityManager em;
	
	public void salvar(Pedido pedido) {
		em.persist(pedido);
		}
	
	public void atualizar(Pedido pedido){
		em.merge(pedido);
	}
	
	public void remover(Pedido pedido){
		pedido = em.find(Pedido.class, pedido.getId());
	}
	
	@SuppressWarnings("unchecked")
	public List<Pedido> listar() {
		String qs = "select p from Pedido p";
		Query q = em.createQuery(qs);
		return (List<Pedido>) q.getResultList();
	}
	
	public Pedido buscarUsuarioSolicitanteNome(String nome) {
		String qs = "select u.nome from Usuario u, Pedido p where p.id_usuario = u.id_usuario";
		Query q = em.createQuery(qs);
		q.setParameter("nome", nome);
		try {
			return (Pedido) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	
}
