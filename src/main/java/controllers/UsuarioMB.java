package controllers;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

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
	
	@Inject
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
		if (res == 1) {
			return "/interna/painel.jsf";
		}
		else if(res == 2){
			return "/interna/painel.jsf";
		}
		else if(res == 3){
			return "/interna/painel.jsf";
		} 
		else if(res == 4){
			return "/interna/painel.jsf";
		}
		else if (res == -1){
			FacesMessage msg = new FacesMessage("Usuario e/ou senha incorretos");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage("", msg);
			return null;
		}
		else{
			FacesMessage msg = new FacesMessage("Usuario inexistente");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage("", msg);
			return null;
		}
	}
}