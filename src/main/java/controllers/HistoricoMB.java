package controllers;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import Service.HistoricoService;
import dominio.Historico;

@ManagedBean
public class HistoricoMB {

	private Historico historico;

	@EJB
	private HistoricoService historicoService;
	
	@Inject
	private List<Historico> listaHistoricos;

	public HistoricoMB() {
		historico = new Historico();
		listaHistoricos = new ArrayList<Historico>();
	}

	public String inserir(){
		historicoService.cadastrarHistorico(historico);
		return "/interna/cadastro_sucesso.jsf";
	}
	
	public Historico getHistorico() {
		return historico;
	}

	public void setHistorico(Historico historico) {
		this.historico = historico;
	}

	public List<Historico> getListaHistoricos() {
		setListaHistoricos(historicoService.listar());
		return listaHistoricos;
	}

	public void setListaHistoricos(List<Historico> listaHistoricos) {
		this.listaHistoricos = listaHistoricos;
	}

}
