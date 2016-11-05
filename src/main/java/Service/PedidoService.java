package Service;

import java.util.List;

import javax.ejb.Stateful;
import javax.inject.Inject;

import dao.PedidoDAO;
import dominio.Pedido;


@Stateful
public class PedidoService {

	
	@Inject
	private PedidoDAO pedidoDAO;
	
	
	public Pedido getUsuarioSolicitante(String nome){
		return pedidoDAO.buscarUsuarioSolicitanteNome(nome);
	}
	
	
	public void cadastrarPedido(Pedido pedido){
		pedidoDAO.salvar(pedido);
	}
	
	public List<Pedido> listar(){
		return pedidoDAO.listar();
	}
}
