package Service;

import java.util.List;

import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import dao.ProdutoDAO;
import dominio.Produto;

@Stateful
public class ProdutoService {

	@Inject
	private ProdutoDAO produtoDAO;
	
	public Produto buscarProdutoNome(String nome){
		return produtoDAO.buscarProdutoNome(nome);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void cadastrarProduto(Produto produto){
		produtoDAO.salvar(produto);
	}
	
	public List<Produto> listar(){
		return produtoDAO.listar();
	}
	
}
