package controllers;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.inject.Named;

import Service.PedidoService;
import dominio.Pedido;

@ManagedBean
public class PedidoMB {

	private Pedido pedido;
	
	@EJB
	private PedidoService pedidoService;

	
	private List<Pedido> listaPedidos;

	public PedidoMB() {
		pedido = new Pedido();
		listaPedidos = new ArrayList<Pedido>();
	}

	public Pedido getPedido(String usuarioSolicitante) {
		return pedidoService.getUsuarioSolicitante(usuarioSolicitante);
	}

	public String inserir() {
		pedidoService.cadastrarPedido(pedido);;
		return "Cadastrado com sucesso";
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public List<Pedido> getListaPedidos() {
		setListaPedidos(pedidoService.listar());
		return listaPedidos;
	}

	public void setListaPedidos(List<Pedido> listaPedidos) {
		this.listaPedidos = listaPedidos;
	}

}
