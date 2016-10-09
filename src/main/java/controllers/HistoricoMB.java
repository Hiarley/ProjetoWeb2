package controllers;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dao.HistoricoDAO;
import dominio.Historico;

public class HistoricoMB {

	
private Historico historico;
	
	@Inject
	private HistoricoDAO historicoDAO;
	private List<Historico> listaHistoricos;
	
	
	public HistoricoMB() {
		historico = new Historico();
		listaHistoricos = new ArrayList<Historico>(); 
	}
	
	public Historico getHistorico() {
		return historico;
	}
	

	public void setHistorico(Historico historico) {
		this.historico = historico;
	}
	
	public List<Historico> getListaHistoricos() {
		setListaHistoricos(historicoDAO.listar());
		return listaHistoricos;
	}

	public void setListaHistoricos(List<Historico> listaHistoricos) {
		this.listaHistoricos = listaHistoricos;
	}
	
}
