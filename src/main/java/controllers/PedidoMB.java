package controllers;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import dao.PedidoDAO;
import dominio.Pedido;


@ManagedBean
public class PedidoMB {

	
private Pedido pedido;
	
	@Inject
	private PedidoDAO pedidoDAO;
	private List<Pedido> listaPedidos;
	
	public PedidoMB(){
		pedido = new Pedido();
		listaPedidos = new ArrayList<Pedido>();
	}

	public Pedido getPedido(String usuarioSolicitante){
		return pedidoDAO.buscarUsuarioSolicitanteNome(usuarioSolicitante);
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public List<Pedido> getListaPedidos() {
		return listaPedidos;
	}

	public void setListaPedidos(List<Pedido> listaPedidos) {
		this.listaPedidos = listaPedidos;
	}
	
	
}
