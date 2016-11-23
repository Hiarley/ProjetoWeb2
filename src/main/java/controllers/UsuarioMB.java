package controllers;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import Service.UsuarioService;
import dominio.Usuario;

@ManagedBean
@RequestScoped
public class UsuarioMB {
	private Usuario usuario;

	@EJB
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
		int res = usuarioService.login(usuario.getLogin(), usuario.getSenha());
		System.out.println(res);
		if (res == 0 || res == 1 || res == 2 || res == 3 ) {
			return "/interna/painel"+res+".jsf";
		} else if (res == -1) {
			FacesMessage msg = new FacesMessage("Usuário e/ou senha incorretos.");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage("", msg);
			return null;
		} else {
			FacesMessage msg = new FacesMessage("Usuário não existe na base de dados.");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage("", msg);
			FacesContext.getCurrentInstance().getAttributes();
			return null;
		}
	}


}