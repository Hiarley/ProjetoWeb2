package controllers;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import Service.LoginService;
import Service.UsuarioService;
import dao.UsuarioDAO;
import dominio.Usuario;

@ManagedBean
@RequestScoped
public class UsuarioMB {
	private Usuario usuario;

	@EJB
	private LoginService loginService;
	private UsuarioService usuarioService;

	
	private List<Usuario> listaUsuarios;

	public UsuarioMB() {
		usuario = new Usuario();
		listaUsuarios = new ArrayList<Usuario>();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public Usuario getUsuario(String login) {
		return usuarioService.getLogin(login);
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getListaUsuarios() {
		setListaUsuarios(usuarioService.listarUsuario());
		return listaUsuarios;
	}

	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public String cadastrarUsuario() {
		usuario.setTipoUsuario(1);
		usuarioService.cadastrarUsuario(usuario);
		return "/interna/cadastro_sucesso.jsf";
	}

	public String login() {
		int res = loginService.login(usuario.getLogin(), usuario.getSenha());
		/*if (res == 0) {
			return "0";
		}
		else if(res == 1){
			return "1";
		}
		else if(res == 2){
			return "2";
		} 
		else if(res == 3){
			return "3";
		}
		else*/ if (res == -1){
			FacesMessage msg = new FacesMessage("Usuário e/ou senha incorretos.");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage("", msg);
			return null;
		}
		else{
			FacesMessage msg = new FacesMessage("Usuário não existe na base de dados.");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage("", msg);
			return null;
		}
	}
}