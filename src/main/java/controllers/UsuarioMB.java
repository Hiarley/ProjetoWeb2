package controllers;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import dao.UsuarioDAO;
import dominio.Usuario;

@ManagedBean
@RequestScoped
public class UsuarioMB {
	private Usuario usuario;
	
	@Inject
	private UsuarioDAO usuarioDAO;
	private List<Usuario> listaUsuarios;
	
	
	public UsuarioMB() {
		usuario = new Usuario();
		listaUsuarios = new ArrayList<Usuario>();
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public Usuario getUsuario(String login){
		return usuarioDAO.buscarLogin(login);
	}
	
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	

	public List<Usuario> getListaUsuarios(){
		setListaUsuarios(usuarioDAO.listar());
		return listaUsuarios;
	}
	
	public void setListaUsuarios(List<Usuario> listaUsuarios){
		this.listaUsuarios = listaUsuarios;
	}
	
	
	public String login() {
		if (usuario.getLogin().equals("admin") && 
			usuario.getSenha().equals("admin")) {
			return "/interna/cadastra.jsf";
		} else {
			FacesMessage msg = new FacesMessage("Usuario e/ou senha incorretos");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage("", msg);
			return null;
		}
	}
}