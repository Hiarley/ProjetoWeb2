package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dominio.Produto;

@Stateless
public class ProdutoDAO {

	
	@PersistenceContext
	private EntityManager em;
	
	public void salvar(Produto produto) {
		em.persist(produto);
		}
	
	public void atualizar(Produto produto){
		em.merge(produto);
	}
	
	public void remover(Produto produto){
		produto = em.find(Produto.class, produto.getIdProduto());
	}
	
	@SuppressWarnings("unchecked")
	public List<Produto> listar() {
		String qs = "select p from Produto p";
		Query q = em.createQuery(qs);
		return (List<Produto>) q.getResultList();
	}
	
	public Produto buscarProdutoNome(String nome) {
		String qs = "select p.nome from Produto p";
		Query q = em.createQuery(qs);
		q.setParameter("nome", nome);
		try {
			return (Produto) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
}
