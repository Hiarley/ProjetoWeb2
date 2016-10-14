package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dominio.Usuario;


@Stateless
public class UsuarioDAO {

	
	@PersistenceContext
	private EntityManager em;
	
	public void salvar(Usuario usuario) {
		em.persist(usuario);
		}
	
	public void atualizar(Usuario usuario){
		em.merge(usuario);
	}
	
	public void remover(Usuario usuario){
		usuario = em.find(Usuario.class, usuario.getId());
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> listar() {
		String qs = "select u from Usuario u";
		Query q = em.createQuery(qs);
		return (List<Usuario>) q.getResultList();
	}
	
	public Usuario buscarUsuarioNome(String nome) {
		String qs = "select u.nome from Usuario u";
		Query q = em.createQuery(qs);
		q.setParameter("nome", nome);
		try {
			return (Usuario) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	public Usuario buscarLogin(String login) {
		return (Usuario) em.find(Usuario.class, login);
	}
	
}
