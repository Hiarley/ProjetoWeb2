package dominio;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pedido")
public class Pedido {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id_Pedido", nullable = false)
    private long id;
	
	@Column(name = "dataAbertura", nullable = false)
	private Date dataAbertura;
	

	
	@Column(name= "descricao", nullable = false)
    private String descricao;
	
	@Column(name= "status", nullable = false)
    private char status;
	
	
    private ArrayList<Produto> listaProdutos;

    public Pedido() {
    }

    public Pedido(Usuario usuarioSolicitante, Date dataAbertura,
             String descricao, char status,
            ArrayList<Produto> listaProdutos) {

        this.dataAbertura = dataAbertura;
        this.descricao = descricao;
        this.status = status;
        this.listaProdutos = listaProdutos;
    }




    /**
     * @return the idServico
     */
    public long getIdServico() {
        return id;
    }

    /**
     * @param idServico the idServico to set
     */
    public void setIdServico(long idPedido) {
        this.id = idPedido;
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