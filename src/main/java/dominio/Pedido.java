package dominio;

import java.util.ArrayList;
import java.util.Date;

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
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "idPedido", nullable = false)
    private long idPedido;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario", nullable = false)
	private long idUsuarioSolicitante;
	
	@Column(name = "dataAbertura", nullable = false)
	private Date dataAbertura;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario", nullable = false)
    private long idUsuarioDemandando;
	
	@Column(name= "descricao", nullable = false)
    private String descricao;
	
	@Column(name= "status", nullable = false)
    private char status;
	
	@OneToMany
	@JoinTable(name = "produto")
    private ArrayList<Produto> listaProdutos;

    public Pedido() {
    }

    public Pedido(long idUsuarioSolicitante, Date dataAbertura,
             String descricao, char status,
            ArrayList<Produto> listaProdutos) {

        this.idUsuarioSolicitante = idUsuarioSolicitante;
        this.dataAbertura = dataAbertura;
        this.descricao = descricao;
        this.status = status;
        this.listaProdutos = listaProdutos;
    }

    /**
     * @return the idUsuarioSolicitante
     */
    public long getIdUsuarioSolicitante() {
        return idUsuarioSolicitante;
    }

    /**
     * @param idUsuarioSolicitante the idUsuarioSolicitante to set
     */
    public void setIdUsuarioSolicitante(long idUsuarioSolicitante) {
        this.idUsuarioSolicitante = idUsuarioSolicitante;
    }

    /**
     * @return the idServico
     */
    public long getIdServico() {
        return idPedido;
    }

    /**
     * @param idServico the idServico to set
     */
    public void setIdServico(long idPedido) {
        this.idPedido = idPedido;
    }

    /**
     * @return the dataAbertura
     */
    public Date getDataAbertura() {
        return dataAbertura;
    }

    /**
     * @param dataAbertura the dataAbertura to set
     */
    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    /**
     * @return the idUsuarioServicondo
     */
    public long getIdUsuarioDemandando() {
        return idUsuarioDemandando;
    }

    /**
     * @param idUsuarioServicondo the idUsuarioServicondo to set
     */
    public void setIdUsuarioDemandando(long idUsuarioDemandando) {
        this.idUsuarioDemandando = idUsuarioDemandando;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
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
     * @param status the status to set
     */
    public void setStatus(char status) {

        this.status = status;
    }

    /**
     * @return the listaProdutos
     */
    public ArrayList<Produto> getListaProdutos() {
        return listaProdutos;
    }

    /**
     * @param listaProdutos the listaProdutos to set
     */
    public void setListaProdutos(ArrayList<Produto> listaProdutos){

        this.listaProdutos = listaProdutos;
    }

}