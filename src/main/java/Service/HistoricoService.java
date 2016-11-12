package Service;

import java.util.List;

import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import dao.HistoricoDAO;
import dominio.Historico;

@Stateful
public class HistoricoService {

	@Inject
	private HistoricoDAO historicoDAO;
	
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void cadastrarHistorico(Historico historico){
		historicoDAO.salvar(historico);		
	}
	
	public List<Historico> listar(){
		return historicoDAO.listar();
	}
	
}
