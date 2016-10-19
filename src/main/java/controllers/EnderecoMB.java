package controllers;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dao.EnderecoDAO;
import dominio.Endereco;

public class EnderecoMB {

	private Endereco endereco;

	@Inject
	private EnderecoDAO enderecoDAO;
	private List<Endereco> listaEnderecos;

	public EnderecoMB() {
		endereco = new Endereco();
		listaEnderecos = new ArrayList<Endereco>();
	}

	public String inserir(){
		enderecoDAO.salvar(endereco);
		return "Cadastrado com sucesso";
	}


	public Endereco getEndereco() {
		return endereco;
	}


	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}


	public List<Endereco> getListaEnderecos() {
		setListaEnderecos(enderecoDAO.listar());
		return listaEnderecos;
	}

	public void setListaEnderecos(List<Endereco> listaEnderecos) {
		this.listaEnderecos = listaEnderecos;
	}
	
}
