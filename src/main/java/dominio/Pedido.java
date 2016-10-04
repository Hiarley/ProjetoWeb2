package dominio;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pedido {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
	private long idUsuarioSolicitante;
	private Date dataAbertura;
    private long idUsuarioDemandando;
    private String descricao;
    private char status;
    private ArrayList<Demanda> listaProdutos;

    public Pedido() {
    }

    public Pedido(long idUsuarioSolicitante, Date dataAbertura,
             String descricao, char status,
            ArrayList<Demanda> listaProdutos) {

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
    public ArrayList<Demanda> getListaProdutos() {
        return listaProdutos;
    }

    /**
     * @param listaProdutos the listaProdutos to set
     */
    public void setListaProdutos(ArrayList<Demanda> listaProdutos){

        this.listaProdutos = listaProdutos;
    }

}