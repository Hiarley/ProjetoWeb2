package Service;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import dao.UsuarioDAO;
import dominio.Usuario;

@Stateless
public class LoginService {

	@Inject
	private UsuarioDAO usuarioDAO;
	
	
	public int login(String l, String s){
		Usuario u = usuarioDAO.buscarLogin(l);
		if(u != null){
			if(u.getSenha().equals(s)){
				if(u.getTipoUsuario() == 1){
					return 1;
				}
				else if(u.getTipoUsuario() == 2){
					return 2;
				}
				else if(u.getTipoUsuario() == 3){
					return 3;
				}
				else{
					return 4;
				}
			}
			else
				return 0;
		}
		else return -1;
	}
	
	
	
}
