package controllers;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.inject.Named;

import Service.EnderecoService;
import dao.EnderecoDAO;
import dominio.Endereco;
@ManagedBean
public class EnderecoMB {

	private Endereco endereco;

	@EJB
	EnderecoService enderecoService;
	
	private List<Endereco> listaEnderecos;

	public EnderecoMB() {
		endereco = new Endereco();
		listaEnderecos = new ArrayList<Endereco>();
	}

	public String inserir(){
		enderecoService.cadastrarEndereco(endereco);;
		return "Cadastrado com sucesso";
	}


	public Endereco getEndereco() {
		return endereco;
	}


	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}


	public List<Endereco> getListaEnderecos() {
		setListaEnderecos(enderecoService.listar());
		return listaEnderecos;
	}

	public void setListaEnderecos(List<Endereco> listaEnderecos) {
		this.listaEnderecos = listaEnderecos;
	}
	
}
