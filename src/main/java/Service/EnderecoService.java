package Service;

import java.util.List;

import javax.ejb.Stateful;
import javax.inject.Inject;

import dao.EnderecoDAO;
import dominio.Endereco;

@Stateful
public class EnderecoService {

	
	@Inject
	private EnderecoDAO enderecoDAO;
	
	public void cadastrarEndereco(Endereco endereco){
		enderecoDAO.salvar(endereco);
	}
	
	public List<Endereco> listar(){
		return enderecoDAO.listar();
	}
}
