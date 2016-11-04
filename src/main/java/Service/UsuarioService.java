package Service;


import java.util.List;

import javax.ejb.Stateful;
import javax.inject.Inject;

import dao.UsuarioDAO;
import dominio.Usuario;

@Stateful
public class UsuarioService {

	@Inject
	private UsuarioDAO usuarioDAO;
	
	public void cadastrarUsuario(Usuario usuario){
		Usuario u = usuarioDAO.buscarLogin(usuario.getLogin());
		if(u == null)
			usuarioDAO.salvar(usuario);
		else
			usuarioDAO.atualizar(usuario);
	}
	
	public Usuario getLogin(String login){
		return usuarioDAO.buscarLogin(login);
	}
	
	public List<Usuario> listarUsuario(){
		return usuarioDAO.listar();
	}
	
}
