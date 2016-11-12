package controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import Service.ProdutoService;
import dao.ProdutoDAO;
import dominio.Produto;

@ManagedBean
@RequestScoped
public class ProdutoMB {
	
	
	private Produto produto;
	
	@EJB
	private ProdutoService produtoService;
	
	
	private List<Produto> listaProdutos;
	
	
	public  ProdutoMB() {
		produto = new Produto();
		listaProdutos = new ArrayList<Produto>(); 
	}
	
	public String inserir(){
		produto.setPrazo(new Date());
		produtoService.cadastrarProduto(produto);
		return "/interna/cadastro_sucesso.jsf";
	}
	
	public Produto getProduto() {
		return produto;
	}
	
	public Produto getProduto(String nome) {
		return produtoService.buscarProdutoNome(nome);
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public List<Produto> getListaProdutos() {
		setListaProdutos(produtoService.listar());
		return listaProdutos;
	}

	public void setListaProdutos(List<Produto> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}

}
