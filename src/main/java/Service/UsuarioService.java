package Service;


import java.util.List;

import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import dao.UsuarioDAO;
import dominio.Usuario;

@Stateful
public class UsuarioService {

	@Inject
	private UsuarioDAO usuarioDAO;
	
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void cadastrarUsuario(Usuario usuario){
		Usuario u = usuarioDAO.buscarLogin(usuario.getLogin());
		if(u == null)
			usuarioDAO.salvar(usuario);
		else
			usuarioDAO.atualizar(usuario);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Usuario getLogin(String login){
		return usuarioDAO.buscarLogin(login);
	}
	
	public List<Usuario> listarUsuario(){
		return usuarioDAO.listar();
	}
	
}
