package dominio;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pedido")
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_Pedido", nullable = false)
	private long id;

	@ManyToOne
	@JoinColumn(name = "id_usuarioSolicitante", referencedColumnName = "id_usuario")
	private Usuario usuarioSolicitante;

	@ManyToOne
	@JoinColumn(name = "id_usuarioDemandado", referencedColumnName = "id_usuario")
	private Usuario usuarioDemandado;
	
	@Column(name = "dataAbertura", nullable = false)
	private Date dataAbertura;

	@Column(name = "descricao", nullable = false)
	private String descricao;

	@Column(name = "status", nullable = false)
	private char status;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "produto_edido", joinColumns = {@JoinColumn(name = "id_pedido")}, inverseJoinColumns = {@JoinColumn(name = "id_produto")})
	private Collection<Produto> listaProdutos;
	
	@OneToMany(cascade = CascadeType.ALL)
	private Collection<Historico> listaHistoricos;

	@OneToOne
	@JoinColumn(name = "id_Endereco")
	private Endereco endereco;
	
	public Pedido() {
	}

	public Pedido(Usuario usuarioSolicitante, Date dataAbertura, String descricao, char status,
			ArrayList<Produto> listaProdutos) {

		this.dataAbertura = dataAbertura;
		this.descricao = descricao;
		this.status = status;
		this.listaProdutos = listaProdutos;
	}

	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the dataAbertura
	 */
	public Date getDataAbertura() {
		return dataAbertura;
	}

	/**
	 * @param dataAbertura
	 *            the dataAbertura to set
	 */
	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao
	 *            the descricao to set
	 */
	public void setDescricao(String descricao) {

		this.descricao = descricao;
	}

	/**
	 * @return the status
	 */
	public char getStatus() {

		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(char status) {

		this.status = status;
	}

	/**
	 * @return the listaProdutos
	 */
	public Collection<Produto> getListaProdutos() {
		return listaProdutos;
	}

	/**
	 * @param listaProdutos
	 *            the listaProdutos to set
	 */
	public void setListaProdutos(ArrayList<Produto> listaProdutos) {

		this.listaProdutos = listaProdutos;
	}

}